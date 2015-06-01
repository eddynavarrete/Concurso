/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author Kleber
 */
public class Parametros {
    
    private int codigo;
    private String descripcion;
    private int valor_entero;
    private double valor_doble;
    private String valor_texto;

    public Parametros(int codigo, String descripcion, int valor_entero, double valor_doble, String valor_texto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor_entero = valor_entero;
        this.valor_doble = valor_doble;
        this.valor_texto = valor_texto;
    }

    public Parametros() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor_entero() {
        return valor_entero;
    }

    public void setValor_entero(int valor_entero) {
        this.valor_entero = valor_entero;
    }

    public double getValor_doble() {
        return valor_doble;
    }

    public void setValor_doble(double valor_doble) {
        this.valor_doble = valor_doble;
    }

    public String getValor_texto() {
        return valor_texto;
    }

    public void setValor_texto(String valor_texto) {
        this.valor_texto = valor_texto;
    }
 }
