package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
@DiscriminatorValue("PR")
public class Proveedor extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "razon_social")
    private String razonSocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<Producto> productoList;

    public Proveedor() {
        super();
        this.productoList = new ArrayList<>();
    }

    public Proveedor(Integer cedula, String nombres, String apellidos, Integer telefono, Date fechaNacimiento, String direccion, String correo, String estado, String razonSocial) {
        super(cedula, nombres, apellidos, telefono, fechaNacimiento, direccion, correo, estado);
        this.razonSocial = razonSocial;
        this.productoList = new ArrayList<>();
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
    
}
