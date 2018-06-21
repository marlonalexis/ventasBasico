package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private int idProducto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Double precio;
    @ManyToOne
    @JoinColumn(name = "idProveedor", referencedColumnName = "idPersona", insertable = false, updatable = false)
    private Proveedor proveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detallefactura> detallefacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detalledevolucion> detalledevolucionList;

    public Producto() {
        this.detalledevolucionList = new ArrayList<>();
        this.detallefacturaList = new ArrayList<>();
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String descripcion, Double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.detalledevolucionList = new ArrayList<>();
        this.detallefacturaList = new ArrayList<>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }

    public List<Detalledevolucion> getDetalledevolucionList() {
        return detalledevolucionList;
    }

    public void setDetalledevolucionList(List<Detalledevolucion> detalledevolucionList) {
        this.detalledevolucionList = detalledevolucionList;
    }
    
}
