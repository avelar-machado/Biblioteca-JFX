
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author hp
 */
public class CD extends Item {
    
    private int idCD;
    private String gravadora;
    private int faixas;
    private Time duracao;

    public CD(int id, String gravadora, int faixas, Time duracao) {
        this.idCD = id;
        this.gravadora = gravadora;
        this.faixas = faixas;
        this.duracao = duracao;
    }

    public CD(int id, String gravadora, int faixas, Time duracao, String titulo, LocalDate dataPublicacao, String tipo) {
        super(titulo, dataPublicacao, tipo);
        this.idCD = id;
        this.gravadora = gravadora;
        this.faixas = faixas;
        this.duracao = duracao;
    }

    public int getIdCD() {
        return idCD;
    }

    public void setIdCD(int idCD) {
        this.idCD = idCD;
    }
    
    

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    public int getFaixas() {
        return faixas;
    }

    public void setFaixas(int faixas) {
        this.faixas = faixas;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }    
    
}