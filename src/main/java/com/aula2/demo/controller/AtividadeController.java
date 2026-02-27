package com.aula2.demo.controller;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aula2.demo.service.AtividadeService;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/info")
    public String info() {
        String appName = "Aula_2";
        String javaVersion = System.getProperty("java.version");
        LocalDateTime now = LocalDateTime.now();
        String msg = "O sistema está funcional.";
        return String.format(
                "Nome do sistema: %s   \nVersão do Java: %s   \nData e hora atuais: %s   \n%s",
                appName, javaVersion, now, msg);
    }

}
