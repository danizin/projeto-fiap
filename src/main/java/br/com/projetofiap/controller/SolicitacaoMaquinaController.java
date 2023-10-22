package br.com.projetofiap.controller;

;
import br.com.projetofiap.form.SolicitacaoFormulario;
import br.com.projetofiap.service.SolicitacaoMaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solicitacoes-maquinas")
public class SolicitacaoMaquinaController {

    private SolicitacaoMaquinaService service;

    @Autowired
    public SolicitacaoMaquinaController(SolicitacaoMaquinaService service) {
        this.service = service;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<String> solicitar(@RequestBody SolicitacaoFormulario solcitacaoForm ){
        return ResponseEntity.ok(service.solicitarMaquina(solcitacaoForm));
    }
}
