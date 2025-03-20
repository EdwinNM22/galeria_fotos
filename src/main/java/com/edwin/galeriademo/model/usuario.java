package com.edwin.galeriademo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String tipo_usuario;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<foto> fotos;

    public usuario() {

    }

    public usuario(Integer id, String nombre, String tipo_usuario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_usuario = tipo_usuario;
        this.password = password;
    }

    public List<foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<foto> fotos) {
        this.fotos = fotos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo_usuario;
    }

    public void setTipo(String tipo) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo_usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
