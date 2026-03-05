package com.aula2.sistemaestudantes.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aula2.sistemaestudantes.service.CursoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @GetMapping("/api/cursos")
    public String[] getAllCursos() {
        return cursoService.getAllCursos();
    }
    
    @GetMapping("/api/cursos/{id}")
    public String getCursoById(@PathVariable Integer id) {
        return cursoService.getCursoById(id);
    }
    
}
