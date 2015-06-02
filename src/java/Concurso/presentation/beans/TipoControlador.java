/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.presentation.beans;

import Concuros.logica.clases.TipoC;
import Concurso.logica.funciones.TipoF;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Usuario
 */

@ManagedBean
@ViewScoped
public class TipoControlador {
    
    
    private TipoC objTipo;
    private TipoC tipoSel;
    private ArrayList<TipoC> lstTipo;

    public TipoC getObjTipo() {
        return objTipo;
    }

    public void setObjTipo(TipoC objTipo) {
        this.objTipo = objTipo;
    }

    public TipoC getTipoSel() {
        return tipoSel;
    }

    public void setTipoSel(TipoC tipoSel) {
        this.tipoSel = tipoSel;
    }

    public ArrayList<TipoC> getLstTipo() {
        return lstTipo;
    }

    public void setLstTipo(ArrayList<TipoC> lstTipo) {
        this.lstTipo = lstTipo;
    }
    
    
    
    
      public TipoControlador() {
        this.reinit();
    }
//
//    
    private void reinit(){
        this.objTipo = new TipoC();
        this.tipoSel = new TipoC();
        this.cargarTipo();
        this.tipoSel = this.lstTipo.get(0);
    }
    
    public void cargarTipo() {
        try {
            this.lstTipo = TipoF.ObtenerTipo();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarTipo dice: " + e.getMessage());
            System.out.println("private void cargarTipo dice: " + e.getMessage());
        }
     }
        
        
        public void insertarTipo() {
        try {
            if (TipoF.Insertar(objTipo)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoTipo.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarTipo dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarTipo dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarTipo dice: " + e.getMessage());
            System.out.println("private void insertarTipo dice: " + e.getMessage());
                }
        }

     public void actualizarTarjeta() {
        try {
            if (TipoF.actualizar(tipoSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarTipo.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarTipo dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarTipo dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarTipo dice: " + e.getMessage());
            System.out.println("private void actualizarTipo dice: " + e.getMessage());
        }
    }

    public void eliminarTarjeta() {
        try {
            if (TipoF.eliminar(tipoSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarTipo.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarTipo dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarTipo dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarTipo dice: " + e.getMessage());
            System.out.println("private void eliminarTipo dice: " + e.getMessage());
        }
        
    }

   
  
    
    
    
}
