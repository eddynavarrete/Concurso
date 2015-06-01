/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concuros.logica.clases;
import  Concuros.logica.clases.TarjetaC;
/**
 *
 * @author Usuario
 */
public class ClienteC {
    
    private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private TarjetaC codigoTarjeta;
    private String cedula;

    public ClienteC(int codigo, String nombre, String apellido, String direccion, String telefono, String correo, TarjetaC codigoTarjeta,String cedula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.codigoTarjeta = codigoTarjeta;
        this.cedula = cedula;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public ClienteC() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public TarjetaC getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(TarjetaC codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }
        
    
}
