package com.ventasBasico.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menurol")
public class Menurol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMenuRol")
    private int idMenuRol;
    @ManyToOne
    @JoinColumn(name = "idMenu", referencedColumnName = "idMenu", insertable = false, updatable = false)
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "idRol", referencedColumnName = "idRol", insertable = false, updatable = false)
    private Rol rol;

    public Menurol() {
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
