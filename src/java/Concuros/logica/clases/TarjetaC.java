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
public class TarjetaC {
    
    private int codigo;
    private int numero_tarjeta;
    private int numero_verificacion;

    public TarjetaC(int codigo, int numero_tarjeta, int numero_verificacion) {
        this.codigo = codigo;
        this.numero_tarjeta = numero_tarjeta;
        this.numero_verificacion = numero_verificacion;
    }

    public TarjetaC() {
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(int numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public int getNumero_verificacion() {
        return numero_verificacion;
    }

    public void setNumero_verificacion(int numero_verificacion) {
        this.numero_verificacion = numero_verificacion;
    }
    
    
    
}
