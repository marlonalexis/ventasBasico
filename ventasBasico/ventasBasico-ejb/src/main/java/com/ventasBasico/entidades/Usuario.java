package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "ultimo_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoIngreso;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuariorol> usuariorolList;
    @MapsId
    @OneToOne(mappedBy = "usuario")
    private Persona persona;
    @Id
    @Column(name = "idPersona")
    private Integer idPersona;
    
    public Usuario() {
        this.usuariorolList = new ArrayList<>();
    }

    public Usuario(String username, String password, Date ultimoIngreso) {
        this.username = username;
        this.password = password;
        this.ultimoIngreso = ultimoIngreso;
    }
    
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUltimoIngreso() {
        return ultimoIngreso;
    }

    public void setUltimoIngreso(Date ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    public List<Usuariorol> getUsuariorolList() {
        return usuariorolList;
    }

    public void setUsuariorolList(List<Usuariorol> usuariorolList) {
        this.usuariorolList = usuariorolList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        if(this.persona.getUsuario()!= this){
            this.persona.setUsuario(this);
        }
    }
    
}
