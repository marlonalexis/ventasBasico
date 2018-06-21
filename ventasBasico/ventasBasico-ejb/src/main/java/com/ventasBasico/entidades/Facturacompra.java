package com.ventasBasico.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "facturacompra")
@DiscriminatorValue("CO")
public class Facturacompra extends Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    public Facturacompra() {
        super();
    }

    public Facturacompra(Double total) {
        super(total);
    }

}
