package com.aula2.sistemaestudantes.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.aula2.sistemaestudantes.respository.CursoRepository;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public String[] getAllCursos() {
        Map<Integer, String> cursosMap =  cursoRepository.getAllCursos();
        String[] cursosArray = new String[cursosMap.size()];
        for (Map.Entry<Integer, String> entry : cursosMap.entrySet()) {
            Integer id = entry.getKey();
            String nome = entry.getValue();
            cursosArray[id - 1] = nome;
        }
        return cursosArray;
    }

    public String getCursoById(Integer id) {
        return cursoRepository.getCursoById(id);
    }
}
