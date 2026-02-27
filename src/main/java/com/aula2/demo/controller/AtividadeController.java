package com.aula2.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aula2.demo.service.AtividadeService;

@SpringBootApplication
@RestController
public class AtividadeController {
    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @GetMapping("/saudacao/{nome}")
    public String saudacao(@PathVariable String nome) {
        return String.format("Olá, %s! Bem vindo(a) ao Spring Boot!", nome);
    }

    @GetMapping("/soma/{n1}/{n2}")
    public String soma(@PathVariable int n1, @PathVariable int n2) {
        return String.format("%d", atividadeService.soma(n1, n2));
    }

}
