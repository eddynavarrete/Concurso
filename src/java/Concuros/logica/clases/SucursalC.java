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
public class SucursalC {
    
    private int codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private CiudadC codigo_ciudad;
    private SalaC codigo_sala;

    public SucursalC() {
    }

    public SucursalC(int codigo, String nombre, String direccion, String telefono, CiudadC codigo_ciudad, SalaC codigo_sala) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codigo_ciudad = codigo_ciudad;
        this.codigo_sala = codigo_sala;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CiudadC getCodigo_ciudad() {
        return codigo_ciudad;
    }

    public void setCodigo_ciudad(CiudadC codigo_ciudad) {
        this.codigo_ciudad = codigo_ciudad;
    }

    public SalaC getCodigo_sala() {
        return codigo_sala;
    }

    public void setCodigo_sala(SalaC codigo_sala) {
        this.codigo_sala = codigo_sala;
    }
    
    
    
    
}
