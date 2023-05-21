
package view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Livro extends Item {
    
    private int isbn;
    private String editora;
    private String genero;
    private int numeroPaginas;

    public Livro(int isbn, String editora, String genero, int numeroPaginas, String titulo, String tipo, LocalDate dataPublicacao) {
        super (titulo, dataPublicacao, tipo);
        this.isbn = isbn;
        this.editora = editora;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
        this.tipo = tipo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }


    @Override
    public String toString() {
        return ""+this.isbn;
    }
    
    
    
}
