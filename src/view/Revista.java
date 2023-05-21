
package view;

import java.time.LocalDate;

/**
 *
 * @author hp
 */
public class Revista extends Item {
    
    private int issn;
    private String editora;
    private int edicao;
    private int numeroPaginas;

    public Revista(int issn, String editora, int edicao, int numeroPaginas) {
        this.issn = issn;
        this.editora = editora;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
    }

    public Revista(int issn, String editora, int edicao, int numeroPaginas, String titulo, LocalDate dataPublicacao, String tipo) {
        super(titulo, dataPublicacao, tipo);
        this.issn = issn;
        this.editora = editora;
        this.edicao = edicao;
        this.numeroPaginas = numeroPaginas;
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    

 
}
