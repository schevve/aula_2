package com.aula2.sistemaestudantes.model;


public class Estudante {
    public Estudante(Integer matricula, String nome, Integer cursoId, Integer semestre) {
        this.matricula = matricula;
        this.nome = nome;
        this.cursoId = cursoId;
        this.semestre = semestre;
    }
    public Integer matricula;
    public String nome;
    public Integer cursoId;
    public Integer semestre;
}
