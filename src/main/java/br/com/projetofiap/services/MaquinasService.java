package br.com.projetofiap.services;


import br.com.projetofiap.dto.MaquinasDTO;
import br.com.projetofiap.exception.NegocioException;
import br.com.projetofiap.mapper.MaquinasMapper;
import br.com.projetofiap.model.Maquinas;
import br.com.projetofiap.repositories.MaquinasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static br.com.projetofiap.enums.SituacaoMaquinaEnum.ATIVA;

@Service
@RequiredArgsConstructor
public class MaquinasService {

    private final MaquinasRepository repository;
    private final MaquinasMapper mapper;

    public MaquinasDTO gravar(MaquinasDTO maquinasDTO) {
        Maquinas maquinaDb = this.repository.findByPatrimonio(maquinasDTO.patrimonio());

        if (Objects.nonNull(maquinaDb)) {
            throw new NegocioException("Máquina já cadastrada");
        }

        var maquina = this.mapper.mapToMaquina(maquinasDTO);

        maquina.setId(null);
        maquina.setSituacao(ATIVA);
        Maquinas maquinaSalva = this.repository.save(maquina);
        return this.mapper.mapToMaquinasDTO(maquinaSalva);
    }

    public MaquinasDTO obterMaquinaPorId(Integer id) {

        if (Objects.isNull(id) || id <= 0) {
            throw new NegocioException("ID inválido");
        }

        Optional<Maquinas> maquinaOptional = this.repository.findById(id);

        Maquinas maquina = maquinaOptional.orElseThrow(() -> new NegocioException("Máquina não localizada"));

        return this.mapper.mapToMaquinasDTO(maquina);
    }

    public MaquinasDTO atualizar(MaquinasDTO dto, Integer id) {
        if (Objects.isNull(id) || id <= 0) {
            throw new NegocioException("ID inválido");
        }

        Maquinas maquina = this.repository.findById(id).orElseThrow(() -> new NegocioException("Máquina não localizada"));

        maquina.setPatrimonio(dto.patrimonio());
        maquina.setMarca(dto.marca());
        maquina.setSituacao(dto.situacao());
        maquina.setModelo(dto.modelo());

        return this.mapper.mapToMaquinasDTO(this.repository.save(maquina));
    }

    public void deletar(Integer id) {

        if (Objects.isNull(id) || id <= 0) {
            throw new NegocioException("ID inválido");
        }

        var maquina = this.repository.findById(id).orElseThrow(() -> new NegocioException("Máquina não localizada"));

        this.repository.delete(maquina);
    }
}
