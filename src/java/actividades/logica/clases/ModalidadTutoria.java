/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.logica.clases;

/**
 *
 * @author Janneth GS
 */
public class ModalidadTutoria {
  private int codigo;
  private String nombre;
  private String descripcion; 
  private int estado; 

    public ModalidadTutoria(int codigo, String nombre, String descripcion, int estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public ModalidadTutoria() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
