package com.ventasBasico.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "facturaventa")
@DiscriminatorValue("VE")
public class Facturaventa extends Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    public Facturaventa() {
        super();
    }

    public Facturaventa(Double total) {
        super(total);
    }

}
