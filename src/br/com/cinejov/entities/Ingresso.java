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
public class Ingresso {
    
    private int id;
    private int lugar;
    private int idSessao;
    private int idCliente;

    public Ingresso(int lugar, int idSessao, int idCliente) {
        this.lugar = lugar;
        this.idSessao = idSessao;
        this.idCliente = idCliente;
    }

    public Ingresso() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    
}
