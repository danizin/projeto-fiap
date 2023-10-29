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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static br.com.projetofiap.enums.StatusSolicitacaoEnum.*;

@Service
@RequiredArgsConstructor
public class SolicitacoesService {

    private final SolicitacoesMapper mapper;

    private final SolicitacoesRepository repository;
    private final UsuariosRepository usuariosRepository;

    @Transactional
    public Integer criarSolicitacao(AbreSolicitacaoDTO dto) {
        if (dto.codUsuarioSolicitante() <= 0) {
            throw new NegocioException("Código do usuário inválido");
        }

        Usuarios usuarios = this.usuariosRepository.findById(dto.codUsuarioSolicitante())
                                                .orElseThrow(() -> new NegocioException("Usuário informado inválido"));

        var solicitacao = new Solicitacoes();
        solicitacao.setId(null);
        solicitacao.setUsuarioSolicitante(usuarios);
        solicitacao.setDataSolicitacao(LocalDateTime.now());
        solicitacao.setDescricao(dto.descricao());
        solicitacao.setStatus(AGUARDANDO);
        return this.repository.save(solicitacao).getId();
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

        solicitacao.setUsuarioResponsavel(usuarioResponsavel);
        solicitacao.setStatus(CANCELADO);
        solicitacao.setResposta(dto.resposta());
        solicitacao.setDataResposta(LocalDateTime.now());

        this.mapper.mapToSolicitacaoDTO(this.repository.save(solicitacao));
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
    }

}
