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
public class Estudiante {
  private long codigo;
  private String nombre;
  private String apellido;
  private String cedula;
  private int codigo_sicoa;
  private Periodos codigo_periodo;
  private Nivel codigo_nivel; 

    public Estudiante(long codigo, String nombre, String apellido, String cedula, int codigo_sicoa, Periodos codigo_periodo, Nivel codigo_nivel) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.codigo_sicoa = codigo_sicoa;
        this.codigo_periodo = codigo_periodo;
        this.codigo_nivel = codigo_nivel;
    }

    public Estudiante() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCodigo_sicoa() {
        return codigo_sicoa;
    }

    public void setCodigo_sicoa(int codigo_sicoa) {
        this.codigo_sicoa = codigo_sicoa;
    }

    public Periodos getCodigo_periodo() {
        return codigo_periodo;
    }

    public void setCodigo_periodo(Periodos codigo_periodo) {
        this.codigo_periodo = codigo_periodo;
    }

    public Nivel getCodigo_nivel() {
        return codigo_nivel;
    }

    public void setCodigo_nivel(Nivel codigo_nivel) {
        this.codigo_nivel = codigo_nivel;
    }
}
