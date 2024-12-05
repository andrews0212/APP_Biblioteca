package com.example.app_bilioteca;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private boolean favorito;
    private String descricion;

    public Libro(String ISBN, String titulo, String autor, boolean favorito, String descricion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.favorito = favorito;
        this.descricion = descricion;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
}
