package br.com.projetofiap.db;

import br.com.projetofiap.model.Maquina;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaquinaDao {

    private static List<Maquina> maquinas = new ArrayList<>();

    public static void salvar(Maquina maquina) {
        maquinas.add(maquina);
    }

    public static Optional<Maquina> buscarPorId(Long id) {
        return maquinas.stream().filter(m -> m.getMaquinaId().equals(id)).findFirst();
    }

    public static List<Maquina> todasMaquinas() {
        return maquinas;
    }

    public static void remover(Maquina maquina) {
        maquinas.remove(maquina);
    }

    public static void atualizar(Maquina maquinaAtualizada) {
        Optional<Maquina> maquinaExistenteOpt = buscarPorId(maquinaAtualizada.getMaquinaId());

        if (maquinaExistenteOpt.isPresent()) {
            Maquina maquinaExistente = maquinaExistenteOpt.get();

            maquinaExistente.setModelo(maquinaAtualizada.getModelo());
            maquinaExistente.setNumeroSerial(maquinaAtualizada.getNumeroSerial());
            maquinaExistente.setPessoasSolicitantes(maquinaAtualizada.getPessoasSolicitantes());
            maquinaExistente.setTecnicoResponsavel(maquinaAtualizada.getTecnicoResponsavel());

        } else {
            maquinas.add(maquinaAtualizada);
        }
    }


    static {
        Maquina modelo1 = new Maquina();
        modelo1.setMaquinaId(1L);
        modelo1.setModelo("Modelo A");
        modelo1.setNumeroSerial("A123456");
        maquinas.add(modelo1);

        Maquina modelo2 = new Maquina();
        modelo2.setMaquinaId(2L);
        modelo2.setModelo("Modelo B");
        modelo2.setNumeroSerial("B123456");
        maquinas.add(modelo2);
    }

}
