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
public class Nivel {
  private int codigo;
  private int codigo_sicoa;
  private String nombre;
  private String paralelo;
  private String modalidad;
  private Escuela codigo_escuela;

    public Nivel(int codigo, int codigo_sicoa, String nombre, String paralelo, String modalidad, Escuela codigo_escuela) {
        this.codigo = codigo;
        this.codigo_sicoa = codigo_sicoa;
        this.nombre = nombre;
        this.paralelo = paralelo;
        this.modalidad = modalidad;
        this.codigo_escuela = codigo_escuela;
    }

    public Nivel() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_sicoa() {
        return codigo_sicoa;
    }

    public void setCodigo_sicoa(int codigo_sicoa) {
        this.codigo_sicoa = codigo_sicoa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Escuela getCodigo_escuela() {
        return codigo_escuela;
    }

    public void setCodigo_escuela(Escuela codigo_escuela) {
        this.codigo_escuela = codigo_escuela;
    }

    public void setCodigo_escuela(int valorESeleccionada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
