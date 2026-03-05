package com.aula2.sistemaestudantes.controller;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SistemaController {
    // private final EstudanteRepository estudanteRepository;

    // public SistemaController(EstudanteRepository estudanteRepository) {
    //     this.estudanteRepository = estudanteRepository;
    // }

    @GetMapping("/api/sistema/info")
    public String getInfo() {
        return String.format("Sistema de Estudantes\n versao: 1.0.0\n hora: %s", LocalDateTime.now());
    }
}