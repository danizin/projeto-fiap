package br.com.projetofiap.service;


import br.com.projetofiap.db.MaquinaDao;
import br.com.projetofiap.dto.MaquinaTo;
import br.com.projetofiap.model.Maquina;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinaService {

    public List<MaquinaTo> obterMaquinas() {
        List<Maquina> maquinas = MaquinaDao.todasMaquinas();
        return maquinas.stream().map(maquina -> new MaquinaTo(maquina.getModelo(), maquina.getNumeroSerial())).toList();
    }
}
