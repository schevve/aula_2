package com.aula2.sistemaestudantes.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aula2.sistemaestudantes.service.EstudanteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AlunoController {
    private final EstudanteService estudanteService;

    public AlunoController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping("/api/estudantes/{matricula}")
    public String getEstudante(@PathVariable Integer matricula) {
        return estudanteService.getEstudanteByMatricula(matricula);
    }

    @GetMapping("/api/estudantes/curso/{id}")
    public String getEstudantesByCursoId(@PathVariable Integer id) {
        return estudanteService.getEstudantesByCursoId(id);
    }

}
