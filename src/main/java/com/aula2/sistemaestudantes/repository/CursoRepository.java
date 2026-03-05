package com.aula2.sistemaestudantes.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CursoRepository {
    
    Map<Integer, String> cursos = Map.of(
        1, "Engenharia de Software",
        2, "Sistemas de Informação",
        3, "Ciência da Computação",
        4, "Análise e Desenvolvimento de Sistemas",
        5, "Redes de Computadores"
    );

    public Map<Integer, String> getAllCursos() {
        return cursos;
    }

    public String getCursoById(Integer id) {
        return cursos.get(id);
    }


}
