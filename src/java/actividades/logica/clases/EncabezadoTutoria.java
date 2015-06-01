/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.logica.clases;
import java.sql.Date;
import master.logica.clases.Tutor;

/**
 *
 * @author Janneth GS
 */
public class EncabezadoTutoria {
  private long codigo;
  private Date fecha;
  private String actividad;
  private Tutor codigo_tutor;
  private ModalidadTutoria codigo_modalidad_tutoria;
  
   public EncabezadoTutoria() {
    }

    public EncabezadoTutoria(long codigo, Date fecha, String actividad, Tutor codigo_tutor, ModalidadTutoria codigo_modalidad_tutoria) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.actividad = actividad;
        this.codigo_tutor = codigo_tutor;
        this.codigo_modalidad_tutoria = codigo_modalidad_tutoria;
    }

   
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Tutor getCodigo_tutor() {
        return codigo_tutor;
    }

    public void setCodigo_tutor(Tutor codigo_tutor) {
        this.codigo_tutor = codigo_tutor;
    }

    public ModalidadTutoria getCodigo_modalidad_tutoria() {
        return codigo_modalidad_tutoria;
    }

    public void setCodigo_modalidad_tutoria(ModalidadTutoria codigo_modalidad_tutoria) {
        this.codigo_modalidad_tutoria = codigo_modalidad_tutoria;
    }
}
