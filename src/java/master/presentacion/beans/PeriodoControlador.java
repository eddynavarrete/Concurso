/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package master.presentacion.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Periodos;
import master.logica.funciones.FPeriodos;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
/**
 *
 * @author Janneth GS
 */
@ManagedBean
@ViewScoped

public final class PeriodoControlador implements Serializable{
    private Periodos objPeriodos;
    private Periodos periodosSel;
    private ArrayList<Periodos> lstPeriodos;
    private java.util.Date FechaInicio;
    private java.util.Date FechaFin;

    
    

    public Periodos getObjPeriodos() {
        return objPeriodos;
    }

    public void setObjPeriodos(Periodos objPeriodos) {
        this.objPeriodos = objPeriodos;
    }

    public Periodos getPeriodosSel() {
        return periodosSel;
    }

    public void setPeriodosSel(Periodos periodosSel) {
        this.periodosSel = periodosSel;
    }

    public ArrayList<Periodos> getLstPeriodos() {
        return lstPeriodos;
    }

    public void setLstPeriodos(ArrayList<Periodos> lstPeriodos) {
        this.lstPeriodos = lstPeriodos;
    }

    public PeriodoControlador() {
        this.reinit();
    }
   
    private void reinit(){
        this.objPeriodos = new Periodos();
        this.periodosSel = new Periodos();
        this.cargarPeriodos();
        this.periodosSel = this.lstPeriodos.get(0);        
        this.FechaInicio = new java.util.Date();
        this.FechaFin = new java.util.Date();
    }  
    
    private void cargarPeriodos(){
        try {
            this.lstPeriodos = FPeriodos.ObtenerPeriodos();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarPeriodos dice: " + e.getMessage());
            System.out.println("private void cargarPeriodos dice: " + e.getMessage());
            }
        }
    
    public void insertarPeriodos() {
        try {
            this.objPeriodos.setFecha_inicio(new java.sql.Date(this.FechaInicio.getTime()));
            this.objPeriodos.setFecha_fin(new java.sql.Date(this.FechaFin.getTime()));
            if (FPeriodos.Insertar(objPeriodos)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoPeriodos.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarPeriodos dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarPeriodos dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarPeriodos dice: " + e.getMessage());
            System.out.println("private void insertarPeriodos dice: " + e.getMessage());
                }
        }

     public void actualizarPeriodos() {
        try {
            this.objPeriodos.setFecha_inicio(new java.sql.Date(this.FechaInicio.getTime()));
            this.objPeriodos.setFecha_fin(new java.sql.Date(this.FechaFin.getTime()));
            if (FPeriodos.actualizar(periodosSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarPeriodos.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarPeriodos dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarPeriodos dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarPeriodos dice: " + e.getMessage());
            System.out.println("private void actualizarPeriodos dice: " + e.getMessage());
        }
    }

    public void eliminarPeriodos() {
        try {
            if (FPeriodos.eliminar(periodosSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPeriodos.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarPeriodos dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarPeriodos dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarPeriodos dice: " + e.getMessage());
            System.out.println("private void eliminarPeriodos dice: " + e.getMessage());
        }
    
}

    /**
     * @return the FechaInicio
     */
    public java.util.Date getFechaInicio() {
        return FechaInicio;
    }

    /**
     * @param FechaInicio the FechaInicio to set
     */
    public void setFechaInicio(java.util.Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    /**
     * @return the FechaFin
     */
    public java.util.Date getFechaFin() {
        return FechaFin;
    }

    /**
     * @param FechaFin the FechaFin to set
     */
    public void setFechaFin(java.util.Date FechaFin) {
        this.FechaFin = FechaFin;
    }

   
   
}
