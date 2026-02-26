package com.aula2.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtividadeController {
    @GetMapping("/saudacao/{nome}")
    public String saudacao(@PathVariable String nome) {
        return String.format("Olá, %s! Bem vindo(a) ao Spring Boot!", nome);
    }
}
