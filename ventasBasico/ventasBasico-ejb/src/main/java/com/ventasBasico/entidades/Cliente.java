package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@DiscriminatorValue("CL")
public class Cliente extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Factura> facturaList;

    public Cliente() {
        super();
        this.facturaList = new ArrayList<>();
    }

    public Cliente(Integer cedula, String nombres, String apellidos, Integer telefono, Date fechaNacimiento, String direccion, String correo, String estado) {
        super(cedula, nombres, apellidos, telefono, fechaNacimiento, direccion, correo, estado);
        this.facturaList = new ArrayList<>();
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
    
}
