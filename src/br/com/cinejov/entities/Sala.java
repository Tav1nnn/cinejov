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
public class Sala {
    private String nome;
    private int id;

    public Sala(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Sala() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
