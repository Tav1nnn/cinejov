/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinejov.entities;

/**
 *
 * @author Otavio
 */
public class Sessao {
    
    private int id;
    private int idSala;
    private int idFilme;
    private String horario;

    public Sessao() {
    }

    public Sessao(int idSala, int idFilme, String horario) {
        this.idSala = idSala;
        this.idFilme = idFilme;
        this.horario = horario;
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
