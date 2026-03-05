package com.aula2.sistemaestudantes.service;

import org.springframework.stereotype.Service;

import com.aula2.sistemaestudantes.repository.EstudanteRepository;
import com.aula2.sistemaestudantes.model.Estudante;

@Service
public class EstudanteService {
    private final EstudanteRepository estudanteRepository;
    private final CursoService cursoService;

    public EstudanteService(EstudanteRepository estudanteRepository, CursoService cursoService) {
        this.estudanteRepository = estudanteRepository;
        this.cursoService = cursoService;
    }

    public String getEstudanteByMatricula(Integer matricula) {
        Estudante estudante = estudanteRepository.getEstudanteByMatricula(matricula);
        return String.format("Matrícula: %d, Nome: %s, Curso Id: %d, Semestre: %d",
                estudante.matricula, estudante.nome, estudante.cursoId, estudante.semestre);
    }

    public String getEstudantesByCursoId(Integer id) {
        String cursoNome = cursoService.getCursoById(id);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Curso: %s\n", cursoNome));
        for (Estudante estudante : estudanteRepository.getAllEstudantes().values()) {
            if (estudante.cursoId.equals(id)) {
                sb.append(String.format("Matrícula: %d, Nome: %s, Semestre: %d\n",
                        estudante.matricula, estudante.nome, estudante.semestre));
            }
        }
        return sb.toString();
    }
}
