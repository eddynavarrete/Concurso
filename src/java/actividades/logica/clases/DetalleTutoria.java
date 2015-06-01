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
public class DetalleTutoria {
  private long codigo;
  private String nombre;
  private String apellido;
  private String cedula;
  private int codigo_sicoa;
  private EncabezadoTutoria codigo_encabezado;
  private  CausasBajoRendimiento codigo_causas_bajo_rendimiento;  

    public DetalleTutoria(long codigo, String nombre, String apellido, String cedula, int codigo_sicoa, EncabezadoTutoria codigo_encabezado, CausasBajoRendimiento codigo_causas_bajo_rendimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.codigo_sicoa = codigo_sicoa;
        this.codigo_encabezado = codigo_encabezado;
        this.codigo_causas_bajo_rendimiento = codigo_causas_bajo_rendimiento;
    }

    public DetalleTutoria() {
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

    public EncabezadoTutoria getCodigo_encabezado() {
        return codigo_encabezado;
    }

    public void setCodigo_encabezado(EncabezadoTutoria codigo_encabezado) {
        this.codigo_encabezado = codigo_encabezado;
    }

    public CausasBajoRendimiento getCodigo_causas_bajo_rendimiento() {
        return codigo_causas_bajo_rendimiento;
    }

    public void setCodigo_causas_bajo_rendimiento(CausasBajoRendimiento codigo_causas_bajo_rendimiento) {
        this.codigo_causas_bajo_rendimiento = codigo_causas_bajo_rendimiento;
    }
}
