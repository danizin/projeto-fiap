package br.com.projetofiap.controller;

import br.com.projetofiap.dto.SolicitacaoTo;
import br.com.projetofiap.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/manutencao")
public class ManutencaoController {

    private ManutencaoService service;

    @Autowired
    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    @GetMapping("/obter-solicitacoes")
    public List<SolicitacaoTo> obterSolicitacoes() {
        return service.obterSolicitacoes();
    }
    @PostMapping("/reparar")
    public ResponseEntity<String> reparar(){
        //TODO
        return ResponseEntity.ok("");
    }



}
