package br.com.projetofiap.service;


import br.com.projetofiap.db.MaquinaDao;
import br.com.projetofiap.form.SolicitacaoFormulario;
import br.com.projetofiap.model.Maquina;
import br.com.projetofiap.model.Professor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SolicitacaoMaquinaService {

    public String solicitarMaquina(SolicitacaoFormulario solcitacaoForm) {
        Professor professor = new Professor(1L, "AAAAAAAAAAAAA", new Date());


        Maquina maquina = new Maquina();
        maquina.setMaquinaId(1L);
        maquina.setModelo(solcitacaoForm.getModeloMaquina());
        maquina.setNumeroSerial("123456789");

        MaquinaDao.salvar(maquina);

        Maquina maquinaRecuperada = MaquinaDao.buscarPorId(1L).orElse(null);


        return professor.solicitar(new Maquina()) + " " + maquinaRecuperada.getModelo();
    }
}
