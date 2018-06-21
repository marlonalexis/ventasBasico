package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "devolucion")
public class Devolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDevolucion")
    private Integer idDevolucion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "devolucion")
    private List<Detalledevolucion> detalledevolucionList;

    public Devolucion() {
        this.detalledevolucionList = new ArrayList<>();
    }

    public Devolucion(String descripcion, Date fechaDevolucion) {
        this.descripcion = descripcion;
        this.fechaDevolucion = fechaDevolucion;
        this.detalledevolucionList = new ArrayList<>();
    }

    public Devolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public List<Detalledevolucion> getDetalledevolucionList() {
        return detalledevolucionList;
    }

    public void setDetalledevolucionList(List<Detalledevolucion> detalledevolucionList) {
        this.detalledevolucionList = detalledevolucionList;
    }
    
}
