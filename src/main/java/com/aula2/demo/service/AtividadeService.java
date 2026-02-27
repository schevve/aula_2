package com.aula2.demo.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AtividadeService {
    public int soma(int n1, int n2) {
        return n1 + n2;
    }
}
