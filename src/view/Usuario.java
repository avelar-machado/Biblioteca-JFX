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
public class Usuario {

    private int numeroMatricula;
    private String nome;
    private String apelido;
    private String endereco;
    private String username;
    private String senha;

    public void dadosUser(int numeroMatricula, String nome, String apelido, String endereco, String username, String senha) {
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.apelido = apelido;
        this.endereco = endereco;
        this.username = username;
        this.senha = senha;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "" + this.numeroMatricula +" - " + this.nome +" " + this.apelido;
    }

}
