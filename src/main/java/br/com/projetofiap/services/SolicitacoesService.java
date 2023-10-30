package br.com.projetofiap.services;


import br.com.projetofiap.dto.AbreSolicitacaoDTO;
import br.com.projetofiap.dto.AtribuiSolicitacaoDTO;
import br.com.projetofiap.dto.CancelaSolicitacaoDTO;
import br.com.projetofiap.dto.SolicitacoesDTO;
import br.com.projetofiap.enums.PerfilEnum;
import br.com.projetofiap.exception.NegocioException;
import br.com.projetofiap.mapper.SolicitacoesMapper;
import br.com.projetofiap.model.Solicitacoes;
import br.com.projetofiap.model.Usuarios;
import br.com.projetofiap.repositories.SolicitacoesRepository;
import br.com.projetofiap.repositories.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static br.com.projetofiap.enums.StatusSolicitacaoEnum.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SolicitacoesService {

    private final SolicitacoesMapper mapper;

    private final EmailService emailService;

    private final SolicitacoesRepository repository;
    private final UsuariosRepository usuariosRepository;

    @Transactional
    public Integer criarSolicitacao(AbreSolicitacaoDTO dto) {
        if (dto.codUsuarioSolicitante() <= 0) {
            throw new NegocioException("Código do usuário inválido");
        }

        Usuarios usuario = this.usuariosRepository.findById(dto.codUsuarioSolicitante())
                                                .orElseThrow(() -> new NegocioException("Usuário informado inválido"));

        var solicitacao = new Solicitacoes();
        solicitacao.setId(null);
        solicitacao.setUsuarioSolicitante(usuario);
        solicitacao.setDataSolicitacao(LocalDateTime.now());
        solicitacao.setDescricao(dto.descricao());
        solicitacao.setStatus(AGUARDANDO);
        solicitacao.setTipoSolicitacao(dto.tipoSolicitacao());
        Integer codigoSolicitacao = this.repository.save(solicitacao).getId();

        try {
            this.emailService.enviarEmail(solicitacao.getUsuarioSolicitante().getEmail(), String.format("Abertura de chamado número %s", codigoSolicitacao.toString()), templateAberturaChamado(usuario.getNome()));
        } catch (MailException e) {
            log.error("Falha ao enviar o email de abertura de chamado", e);
        }

        return codigoSolicitacao;
    }

    public SolicitacoesDTO obterSolicitacaoPorId(Integer id) {

        if (id <= 0) {
            throw new NegocioException("Id da solicitacao é inválido ");
        }

        var solicitacao = this.repository.findById(id).orElseThrow(() -> new NegocioException("Solicitação não encontrada"));

        return this.mapper.mapToSolicitacaoDTO(solicitacao);
    }

    @Transactional
    public void cancelarSolicitacao(CancelaSolicitacaoDTO dto) {

        if (dto.codigoSolicitacao() <= 0) {
            throw new NegocioException("Código da solicitação inválido");
        }

        var solicitacao = this.repository.findById(dto.codigoSolicitacao())
                .orElseThrow(() -> new NegocioException("Código da solicitação inválido"));

        if (dto.codigoUsuarioResponsavel() <= 0) {
            throw new NegocioException("Código do usuário inválido");
        }

        var usuarioResponsavel = this.usuariosRepository
                .findById(dto.codigoUsuarioResponsavel())
                .orElseThrow(() -> new NegocioException("Usuário informado inválido"));

        if (usuarioResponsavel.getPerfil().equals(PerfilEnum.USUARIO)) {
            throw new NegocioException("Usuário sem as credenciais necessárias");
        }

        if (solicitacao.getStatus().equals(FINALIZADO)) {
            throw new NegocioException("Solicitação não pode ser cancelada");
        }

        solicitacao.setUsuarioResponsavel(usuarioResponsavel);
        solicitacao.setStatus(CANCELADO);
        solicitacao.setResposta(dto.resposta());
        solicitacao.setDataResposta(LocalDateTime.now());

        Solicitacoes solicitacaoCancelada = this.repository.save(solicitacao);

        try {
            this.emailService.enviarEmail(solicitacao.getUsuarioSolicitante().getEmail(), String.format("Cancelamento do chamado número %s", solicitacaoCancelada.getId().toString()), templateCancelamentoChamado(solicitacao.getUsuarioSolicitante().getNome(), dto.resposta()));
        } catch (MailException e) {
            log.error("Falha ao enviar o email de abertura de chamado", e);
        }
    }

    @Transactional
    public void atribuirSolicitacao(AtribuiSolicitacaoDTO dto) {

        if (dto.codigoSolicitacao() < 0) {
            throw new NegocioException("Código da solicitação inválido");
        }

        var solicitacao = this.repository.findById(dto.codigoSolicitacao())
                .orElseThrow(() -> new NegocioException("Código da solicitação inválido"));

        if (!solicitacao.getStatus().equals(AGUARDANDO)) {
            throw new NegocioException("O status da solicitação não confere com a ação do usuário");
        }

        if (dto.codigoResponsavel() <= 0) {
            throw new NegocioException("Código do usuário inválido");
        }

        var usuarioResponsavel = this.usuariosRepository
                .findById(dto.codigoResponsavel())
                .orElseThrow(() -> new NegocioException("Usuário informado inválido"));

        if (usuarioResponsavel.getPerfil().equals(PerfilEnum.USUARIO)) {
            throw new NegocioException("Usuário sem as credenciais necessárias");
        }

        solicitacao.setUsuarioResponsavel(usuarioResponsavel);
        solicitacao.setStatus(EM_ANALISE);

        this.mapper.mapToSolicitacaoDTO(this.repository.save(solicitacao));

        try {
            this.emailService.enviarEmail(solicitacao.getUsuarioSolicitante().getEmail(), String.format("O chamado número %s foi atribuído para você", solicitacao.getId().toString()), templateAtribuicaoChamado(solicitacao.getUsuarioSolicitante().getNome(), solicitacao.getId().toString()));
        } catch (MailException e) {
            log.error("Falha ao enviar o email de atribuição de chamado ", e);
        }
    }

    private String templateAberturaChamado(String nome) {
        return String.format("""
                                    Caro %s, informamos que foi aberto um chamado e enviado a equipe técnica. \n
                                    Qualquer dúvida entrar em contato com a equipe de suporte.
                                    """, nome);
    }

    private String templateCancelamentoChamado(String nome, String resposta) {
        return String.format("""
                                    Caro %s, informamos que foi cancelado o seu chamado. \n
                                    Segue a resposta da área técnica. \n
                                    %s
                                    """, nome, resposta);
    }

    private String templateAtribuicaoChamado(String nome, String numeroChamado) {
        return String.format("""
                                    Caro %s, foi atribuído o chamado %s para você. \n
                                    """, nome, numeroChamado);
    }

}
