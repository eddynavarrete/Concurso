/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.presentation.beans;

import Concuros.logica.clases.TarjetaC;
import Concurso.logica.funciones.TarjetaF;
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
        this.tarjetaSel = new TarjetaC();
        this.cargarTarjeta();
        this.tarjetaSel = this.lstTarjeta.get(0);
    }
    
    public void cargarTarjeta() {
        try {
            this.lstTarjeta = TarjetaF.ObtenerTarjetas();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarTarjetas dice: " + e.getMessage());
            System.out.println("private void cargarTarjetas dice: " + e.getMessage());
        }
     }
        
        
        public void insertarTarjeta() {
        try {
            if (TarjetaF.Insertar(objTarjeta)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoTarjeta.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarTarjeta dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertartarjeta dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarTarjeta dice: " + e.getMessage());
            System.out.println("private void insertartarjeta dice: " + e.getMessage());
                }
        }

     public void actualizarTarjeta() {
        try {
            if (TarjetaF.actualizar(tarjetaSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarTarjeta.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarTarjeta dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarTarjeta dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarTarjeta dice: " + e.getMessage());
            System.out.println("private void actualizarTarjeta dice: " + e.getMessage());
        }
    }

    public void eliminarTarjeta() {
        try {
            if (TarjetaF.eliminar(tarjetaSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarTarjeta.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarTarjeta dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarTarjeta dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarTarjeta dice: " + e.getMessage());
            System.out.println("private void eliminarTarjeta dice: " + e.getMessage());
        }
        
    }

   
  
    
    
    
}
