package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_FACTURA")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private int idFactura;
    @Column(name = "total")
    private Double total;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura")
    private Facturaventa facturaventa;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idPersona", insertable = false, updatable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idPersona", insertable = false, updatable = false)
    private Empleado empleado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura")
    private Facturacompra facturacompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Detallefactura> detallefacturaList;

    public Factura() {
    }

    public Factura(Double total) {
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Facturaventa getFacturaventa() {
        return facturaventa;
    }

    public void setFacturaventa(Facturaventa facturaventa) {
        this.facturaventa = facturaventa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Facturacompra getFacturacompra() {
        return facturacompra;
    }

    public void setFacturacompra(Facturacompra facturacompra) {
        this.facturacompra = facturacompra;
    }

    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }
    
}
