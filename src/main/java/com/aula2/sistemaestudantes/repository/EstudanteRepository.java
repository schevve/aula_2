package com.aula2.sistemaestudantes.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aula2.sistemaestudantes.model.Estudante;

@Repository
public class EstudanteRepository {
    private Map<Integer, Estudante> estudantes = new HashMap<>(){{
        put(1, new Estudante(1, "João Silva", 1, 3));
        put(2, new Estudante(2, "Maria Oliveira", 2, 2));
        put(3, new Estudante(3, "Pedro Santos", 3, 4));
        put(4, new Estudante(4, "Ana Costa", 4, 1));
        put(5, new Estudante(5, "Lucas Pereira", 5, 2));
    }};

    public Map<Integer, Estudante> getAllEstudantes() {
        return estudantes;
    }

    public Estudante getEstudanteByMatricula(Integer matricula) {
        return estudantes.get(matricula);
    }
}
