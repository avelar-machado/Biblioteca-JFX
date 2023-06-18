/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author hp
 */
public class Autor {
    
    private int code;
    private String nome;
    private String apelido;
    private String endereco;
    private int qtdItem;

    public Autor(int code, String nome, String apelido, String endereco, int qtdItem) {
        this.code = code;
        this.nome = nome;
        this.apelido = apelido;
        this.endereco = endereco;
        this.qtdItem = qtdItem;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }
    
    @Override
    public String toString() {
        return ""+this.code +" - "+this.nome+ " "+this.apelido;
    }
    
}
