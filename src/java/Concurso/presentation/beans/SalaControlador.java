/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concurso.presentation.beans;

import Concuros.logica.clases.SalaC;
import Concurso.logica.funciones.SalaF;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Kleber
 */
@ManagedBean
@ViewScoped
public class SalaControlador {
    
    private SalaC objSala;
    private SalaC salaSel;
    private ArrayList<SalaC> lstSala;

    public SalaC getObjSala() {
        return objSala;
    }

    public void setObjSala(SalaC objSala) {
        this.objSala = objSala;
    }

    public SalaC getSalaSel() {
        return salaSel;
    }

    public void setSalaSel(SalaC salaSel) {
        this.salaSel = salaSel;
    }

    public ArrayList<SalaC> getLstSala() {
        return lstSala;
    }

    public void setLstSala(ArrayList<SalaC> lstSala) {
        this.lstSala = lstSala;
    }

         
   public SalaControlador() {
        this.reinit();
    }
//
//    
    private void reinit(){
        this.objSala = new SalaC();
        this.salaSel = new SalaC();
        this.cargarSala();
        this.salaSel = this.lstSala.get(0);
    }
    
    public void cargarSala() {
        try {
            this.lstSala = SalaF.ObtenerSalas();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarSala dice: " + e.getMessage());
            System.out.println("private void cargarSala dice: " + e.getMessage());
        }
     }
        
        
        public void insertarSala() {
        try {
            if (SalaF.Insertar(objSala)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoSala.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarSala dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarSala dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertar Sala  dice: " + e.getMessage());
            System.out.println("private void insertar Sala dice: " + e.getMessage());
                }
        }

     public void actualizarSala() {
        try {
            if (SalaF.actualizar(salaSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarSala.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizar Sala dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarIdioma dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarSala dice: " + e.getMessage());
            System.out.println("private void actualizarSala dice: " + e.getMessage());
        }
    }

    public void eliminarSala() {
        try {
            if (SalaF.eliminar(salaSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarSala.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarSala dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarIdioma dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarSala dice: " + e.getMessage());
            System.out.println("private void eliminarSala dice: " + e.getMessage());
        }
    }
}
