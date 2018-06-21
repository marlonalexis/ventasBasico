package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<Menurol> menurolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<Usuariorol> usuariorolList;

    public Rol() {
        this.menurolList = new ArrayList<>();
        this.usuariorolList = new ArrayList<>();
    }

    public Rol(Integer idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.menurolList = new ArrayList<>();
        this.usuariorolList = new ArrayList<>();
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Menurol> getMenurolList() {
        return menurolList;
    }

    public void setMenurolList(List<Menurol> menurolList) {
        this.menurolList = menurolList;
    }

    public List<Usuariorol> getUsuariorolList() {
        return usuariorolList;
    }

    public void setUsuariorolList(List<Usuariorol> usuariorolList) {
        this.usuariorolList = usuariorolList;
    }
    
}
