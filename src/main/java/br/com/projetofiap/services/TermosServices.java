package br.com.projetofiap.services;

import br.com.projetofiap.dto.CriaTermoEmprestimoMaquinaDTO;
import br.com.projetofiap.dto.CriaTermoManutencaoMaquinaDTO;
import br.com.projetofiap.enums.StatusSolicitacaoEnum;
import br.com.projetofiap.exception.NegocioException;
import br.com.projetofiap.model.Maquinas;
import br.com.projetofiap.model.Solicitacoes;
import br.com.projetofiap.model.TermoMaquinas;
import br.com.projetofiap.model.Termos;
import br.com.projetofiap.repositories.MaquinasRepository;
import br.com.projetofiap.repositories.SolicitacoesRepository;
import br.com.projetofiap.repositories.TermoMaquinasRepository;
import br.com.projetofiap.repositories.TermosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static br.com.projetofiap.enums.SituacaoMaquinaEnum.BAIXADA;
import static br.com.projetofiap.enums.StatusSolicitacaoEnum.EM_MANUTENCAO;
import static br.com.projetofiap.enums.StatusSolicitacaoEnum.FINALIZADO;

@Service
@RequiredArgsConstructor
public class TermosServices {

    private final TermosRepository termosRepository;
    private final MaquinasRepository maquinasRepository;
    private final SolicitacoesRepository solicitacoesRepository;
    private final TermoMaquinasRepository termoMaquinasRepository;

    public void criarTermoManutencao(CriaTermoManutencaoMaquinaDTO dto) {

        var solicitacao = obterSolicitacao(dto.codigoSolicitacao());

        var termoMaquinas = this.termoMaquinasRepository.obterTermoMaquinaPorCodigoMaquina(dto.codMaquinas());

        validarSeMaquinasVinculadasAOutroTermo(termoMaquinas);

        var maquinas = obterMaquinas(dto.codMaquinas());

        Termos termo = criarTermoManutencao(dto, solicitacao);
        vincularMaquinasAoTermo(maquinas, termo);

    }

    public void criarTermoEmprestimoMaquina(CriaTermoEmprestimoMaquinaDTO dto) {
        Solicitacoes solicitacao = obterSolicitacao(dto.codigoSolicitacao());

        var termoMaquinas = this.termoMaquinasRepository.obterTermoMaquinaPorCodigoMaquina(dto.codMaquinas());

        validarSeMaquinasVinculadasAOutroTermo(termoMaquinas);

        var maquinas = obterMaquinas(dto.codMaquinas());

        var termo = criarTermoEmprestimoMaquina(dto, solicitacao);

        vincularMaquinasAoTermo(maquinas, termo);
    }

    private Solicitacoes obterSolicitacao(Integer codigoSolicitacao) {
        return this.solicitacoesRepository.findById(codigoSolicitacao)
                .orElseThrow(() -> new NegocioException("Código da solicitação inválido"));
    }

    private Termos criarTermoEmprestimoMaquina(CriaTermoEmprestimoMaquinaDTO dto, Solicitacoes solicitacao) {
        var termo = new Termos();

        Solicitacoes solicitacaoAtualizada = trocarStatusSolicitacao(solicitacao, FINALIZADO);
        termo.setDataTermo(LocalDateTime.now());
        termo.setSolicitacao(solicitacaoAtualizada);
        termo.setObservacao(dto.observacao());

        this.termosRepository.save(termo);
        return termo;
    }

    private List<Maquinas> obterMaquinas(List<Integer> codigoMaquinas) {
        return codigoMaquinas
                .stream().map(id -> {
                    Maquinas maquina = this.maquinasRepository.findById(id).orElseThrow(() -> new NegocioException("Máquina não localizada"));
                    if (maquina.getSituacao().equals(BAIXADA)) {
                        throw new NegocioException("Situação da máquina %s está baixada".formatted(maquina.getId()));
                    }
                    return maquina;
                })
                .toList();
    }

    private void validarSeMaquinasVinculadasAOutroTermo(List<TermoMaquinas> termoMaquinas) {
        if (!termoMaquinas.isEmpty()) {
            throw new NegocioException("Máquinas bloqueadas para uso %s".formatted(termoMaquinas.stream()
                                                                        .map(TermoMaquinas::getMaquina)
                                                                        .map(Maquinas::getId)));
        }
    }

    private void vincularMaquinasAoTermo(List<Maquinas> maquinas, Termos termo) {
        maquinas.forEach(maquina -> {
            var termoMaquinas = new TermoMaquinas();
            termoMaquinas.setTermo(termo);
            termoMaquinas.setMaquina(maquina);
            termoMaquinas.setBloqueada(Boolean.TRUE);
            this.termoMaquinasRepository.save(termoMaquinas);
        });
    }

    private Termos criarTermoManutencao(CriaTermoManutencaoMaquinaDTO dto, Solicitacoes solicitacao) {
        var termo = new Termos();

        Solicitacoes solicitacaoAtualizada = trocarStatusSolicitacao(solicitacao, EM_MANUTENCAO);
        termo.setDataTermo(LocalDateTime.now());
        termo.setDataPrazo(dto.dataPrazo());
        termo.setSolicitacao(solicitacaoAtualizada);
        termo.setObservacao(dto.observacao());

        return this.termosRepository.save(termo);
    }

    private Solicitacoes trocarStatusSolicitacao(Solicitacoes solicitacao, StatusSolicitacaoEnum status) {
        solicitacao.setStatus(status);
        return this.solicitacoesRepository.save(solicitacao);
    }

}
