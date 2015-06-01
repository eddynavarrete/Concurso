/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concuros.logica.clases;

/**
 *
 * @author Usuario
 */
public class PeliculaC {
    private int codigo;
    private String nombre;
    private String duracion;
    private String censura;
    private TipoC codigo_tipo;

    public PeliculaC() {
    }

    public PeliculaC(int codigo, String nombre, String duracion, String censura, TipoC codigo_tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracion = duracion;
        this.censura = censura;
        this.codigo_tipo = codigo_tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCensura() {
        return censura;
    }

    public void setCensura(String censura) {
        this.censura = censura;
    }

    public TipoC getCodigo_tipo() {
        return codigo_tipo;
    }

    public void setCodigo_tipo(TipoC codigo_tipo) {
        this.codigo_tipo = codigo_tipo;
    }
    
    
    
}
