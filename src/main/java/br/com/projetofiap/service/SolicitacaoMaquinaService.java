package br.com.projetofiap.service;


import br.com.projetofiap.form.SolicitacaoFormulario;
import br.com.projetofiap.model.Maquina;
import br.com.projetofiap.model.Professor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SolicitacaoMaquinaService {

    public String solicitarMaquina(SolicitacaoFormulario solcitacaoForm) {
        String modeloMaquina = solcitacaoForm.getModeloMaquina();
        Professor professor = new Professor(1L, "TESTE", new Date());
        return professor.solicitar(new Maquina());
    }
}
