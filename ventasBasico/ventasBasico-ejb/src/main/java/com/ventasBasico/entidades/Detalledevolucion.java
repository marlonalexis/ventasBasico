package com.ventasBasico.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalledevolucion")
public class Detalledevolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "motivo")
    private String motivo;
    @Id
    @ManyToOne
    @JoinColumn(name = "idDevolucion", referencedColumnName = "idDevolucion", insertable = false, updatable = false)
    private Devolucion devolucion;
    @Id
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    private Producto producto;

    public Detalledevolucion() {
    }

    public Detalledevolucion(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
