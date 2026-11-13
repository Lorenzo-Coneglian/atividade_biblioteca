package Bilioteca.biblioteca.model;

import java.util.List;

public class Categoria {
    private String genero;
    private List<Livro> obras;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Livro> getObras() {
        return obras;
    }

    public void setObras(List<Livro> obras) {
        this.obras = obras;
    }
}
