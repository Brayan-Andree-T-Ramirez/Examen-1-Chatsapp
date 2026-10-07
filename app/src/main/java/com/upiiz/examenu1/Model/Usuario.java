package com.upiiz.examenu1.Model;

public class Usuario {
    private String nombre;
    private String alias;

    private int foto;

    public Usuario(String nombre, String alias, int foto) {
        this.nombre = nombre;
        this.alias = alias;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
