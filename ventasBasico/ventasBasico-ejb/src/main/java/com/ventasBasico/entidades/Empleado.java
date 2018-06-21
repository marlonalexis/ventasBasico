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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "empleado")
@DiscriminatorValue("PE") 
public class Empleado extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "sueldo")
    private Integer sueldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Factura> facturaList;

    public Empleado() {
        super();
        this.facturaList = new ArrayList<>();
    }

    public Empleado(Integer cedula, String nombres, String apellidos, Integer telefono, Date fechaNacimiento, String direccion, String correo, String estado, Date fechaIngreso, Integer sueldo) {
        super(cedula, nombres, apellidos, telefono, fechaNacimiento, direccion, correo, estado);
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
        this.facturaList = new ArrayList<>();
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
    
}
