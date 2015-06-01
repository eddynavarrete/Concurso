/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package master.logica.clases;

/**
 *
 * @author Janneth GS
 */
public class Facultad {
  private int codigo;
  private String nombre;
  private String descripcion;
  private int codigo_sicoa;

    public Facultad(int codigo, String nombre, String descripcion, int codigo_sicoa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_sicoa = codigo_sicoa;
    }

    public Facultad() {
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

    public int getCodigo_sicoa() {
        return codigo_sicoa;
    }

    public void setCodigo_sicoa(int codigo_sicoa) {
        this.codigo_sicoa = codigo_sicoa;
    }
}
