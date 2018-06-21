package com.ventasBasico.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMenu")
    private Integer idMenu;
    @Column(name = "accion")
    private String accion;
    @Column(name = "opcion")
    private String opcion;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "menuPadre", fetch = FetchType.EAGER)
    @OrderBy("orden ASC")
    private List<Menu> menuList;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_padre", referencedColumnName = "idMenu")
    private Menu menuPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<Menurol> menurolList;

    public Menu() {
    }

    public Menu(String accion, String opcion, Integer orden, String rutaImagen, String tipo, String estado) {
        this.accion = accion;
        this.opcion = opcion;
        this.orden = orden;
        this.rutaImagen = rutaImagen;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(Menu menuPadre) {
        this.menuPadre = menuPadre;
    }

    public List<Menurol> getMenurolList() {
        return menurolList;
    }

    public void setMenurolList(List<Menurol> menurolList) {
        this.menurolList = menurolList;
    }
    
}
