package br.com.projetofiap.controller;

import br.com.projetofiap.dto.MaquinaTo;
import br.com.projetofiap.service.MaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

;

@RestController
@RequestMapping("/api/maquina")
public class MaquinaController {

    private MaquinaService service;

    @Autowired
    public MaquinaController(MaquinaService service) {
        this.service = service;
    }

    @GetMapping("/obter")
    public List<MaquinaTo> obter() {
        return service.obterMaquinas();
    }
}
