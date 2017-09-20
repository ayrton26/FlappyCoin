package com.example.ayrton.flappycoin.engine.elements;

/**
 * Created by ayrton on 20/09/17.
 */

public class Score {

    private int id;
    private User usuario;
    private int pontos;

    public Score(int id, User usuario, int pontos) {
        this.id = id;
        this.usuario = usuario;
        this.pontos = pontos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
