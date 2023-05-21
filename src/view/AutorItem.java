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
public class AutorItem {
    
    private int fk_autor;
    private int fk_item;

    public AutorItem(int fk_autor, int fk_item) {
        this.fk_autor = fk_autor;
        this.fk_item = fk_item;
    }

    public int getFk_autor() {
        return fk_autor;
    }

    public void setFk_autor(int fk_autor) {
        this.fk_autor = fk_autor;
    }

    public int getFk_item() {
        return fk_item;
    }

    public void setFk_item(int fk_item) {
        this.fk_item = fk_item;
    }
    
    
    
}
