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
public class ReservaC {
    
    private int codigo;
    private ClienteC codigo_cliente;
    private SucursalC codigo_sucursal;
    private PeliculaC codigo_pelicula;
    private String fecha_reserva;
    private String hora_reserva;

    public ReservaC() {
    }

    public ReservaC(int codigo, ClienteC codigo_cliente, SucursalC codigo_sucursal, PeliculaC codigo_pelicula, String fecha_reserva, String hora_reserva) {
        this.codigo = codigo;
        this.codigo_cliente = codigo_cliente;
        this.codigo_sucursal = codigo_sucursal;
        this.codigo_pelicula = codigo_pelicula;
        this.fecha_reserva = fecha_reserva;
        this.hora_reserva = hora_reserva;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClienteC getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(ClienteC codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public SucursalC getCodigo_sucursal() {
        return codigo_sucursal;
    }

    public void setCodigo_sucursal(SucursalC codigo_sucursal) {
        this.codigo_sucursal = codigo_sucursal;
    }

    public PeliculaC getCodigo_pelicula() {
        return codigo_pelicula;
    }

    public void setCodigo_pelicula(PeliculaC codigo_pelicula) {
        this.codigo_pelicula = codigo_pelicula;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(String hora_reserva) {
        this.hora_reserva = hora_reserva;
    }
    
    
    
}
