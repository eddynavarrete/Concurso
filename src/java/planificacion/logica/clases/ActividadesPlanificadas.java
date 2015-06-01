/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planificacion.logica.clases;
import java.sql.Date;
import master.logica.clases.Tutor;
/**
 *
 * @author Janneth GS
 */
public class ActividadesPlanificadas {
  private long codigo;
  private String nombre;
  private String descripcion;
  private Date fecha;
  private String observacion;
  private int estado;
  private Tutor codigo_tutor;   

    public ActividadesPlanificadas() {
    }

    public ActividadesPlanificadas(long codigo, String nombre, String descripcion, Date fecha, String observacion, int estado, Tutor codigo_tutor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.observacion = observacion;
        this.estado = estado;
        this.codigo_tutor = codigo_tutor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Tutor getCodigo_tutor() {
        return codigo_tutor;
    }

    public void setCodigo_tutor(Tutor codigo_tutor) {
        this.codigo_tutor = codigo_tutor;
    }
}
