/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDate;

/**
 *
 * @author hp
 */
public class ItensEmprestados {
    
    private int fk_item;
    private String tipo;
    private String titulo;
    private String descricao;
    private int fk_usuario;
    private LocalDate dataDevolucao;

    public ItensEmprestados(int fk_item, String tipo, String titulo, String descricao, int fk_usuario, LocalDate dataDevolucao) {
        this.fk_item = fk_item;
        this.tipo = tipo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.fk_usuario = fk_usuario;
        this.dataDevolucao = dataDevolucao;
    }

    public int getFk_item() {
        return fk_item;
    }

    public void setFk_item(int fk_item) {
        this.fk_item = fk_item;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
  
    
    
}
