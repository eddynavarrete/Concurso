/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.presentation.beans;

import Concuros.logica.clases.TarjetaC;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class TarjetaControlador {
    
     private TarjetaC objTarjeta;
    private TarjetaC tarjetaSel;
    private ArrayList<TarjetaC> lstTarjeta;

    public TarjetaC getObjTarjeta() {
        return objTarjeta;
    }

    public void setObjTarjeta(TarjetaC objTarjeta) {
        this.objTarjeta = objTarjeta;
    }

    public TarjetaC getTarjetaSel() {
        return tarjetaSel;
    }

    public void setTarjetaSel(TarjetaC tarjetaSel) {
        this.tarjetaSel = tarjetaSel;
    }

    public ArrayList<TarjetaC> getLstTarjeta() {
        return lstTarjeta;
    }

    public void setLstTarjeta(ArrayList<TarjetaC> lstTarjeta) {
        this.lstTarjeta = lstTarjeta;
    }

   public TarjetaControlador() {
        this.reinit();
    }
//
//    
    private void reinit(){
        this.objTarjeta = new TarjetaC();
        this.facultadSel = new TarjetaC();
        this.cargarFacultad();
        this.facultadSel = this.lstFacultad.get(0);
    }
    
    public void cargarFacultad() {
        try {
            this.lstFacultad = FFacultad.ObtenerFacultades();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
            System.out.println("private void cargarFacultad dice: " + e.getMessage());
        }
     }
        
        
        public void insertarFacultad() {
        try {
            if (FFacultad.Insertar(objFacultad)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoFacultad.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarFacultad dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarFacultad dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarFacultad dice: " + e.getMessage());
            System.out.println("private void insertarFacultad dice: " + e.getMessage());
                }
        }

     public void actualizarFacultad() {
        try {
            if (FFacultad.actualizar(facultadSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarFacultad.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarFacultad dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarFacultad dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarFacultad dice: " + e.getMessage());
            System.out.println("private void actualizarFacultad dice: " + e.getMessage());
        }
    }

    public void eliminarFacultad() {
        try {
            if (FFacultad.eliminar(facultadSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarFacultad.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarFacultad dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarFacultad dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarFacultad dice: " + e.getMessage());
            System.out.println("private void eliminarFacultad dice: " + e.getMessage());
        }
        
    }

   
  
    
    
    
}
