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
public class Emprestimo {
  
    private int idEmp;
    private int fk_item;
    private int fk_usuario;
    private String descricao;
    private LocalDate dataDevolucao;

    public Emprestimo(int fk_item, int fk_usuario, String descricao, LocalDate dataDevolucao) {
        this.fk_item = fk_item;
        this.fk_usuario = fk_usuario;
        this.descricao = descricao;
        this.dataDevolucao = dataDevolucao;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public int getFk_item() {
        return fk_item;
    }

    public void setFk_item(int fk_item) {
        this.fk_item = fk_item;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }                
}
