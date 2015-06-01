/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import actividades.logica.clases.ModalidadTutoria;
import actividades.logica.funciones.FModalidadTutoria;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Janneth GS
 */
@ManagedBean
@ViewScoped

public class ModalidadTutoriaControlador {
    private ModalidadTutoria objModalidadTutoria;
    private ModalidadTutoria modalidadTutoriaSel;
    private ArrayList<ModalidadTutoria> lstModalidadTutoria;
   

    public ModalidadTutoria getObjModalidadTutoria() {
        return objModalidadTutoria;
    }

    public void setObjModalidadTutoria(ModalidadTutoria objModalidadTutoria) {
        this.objModalidadTutoria = objModalidadTutoria;
    }

    public ModalidadTutoria getModalidadTutoriaSel() {
        return modalidadTutoriaSel;
    }

    public void setModalidadTutoriaSel(ModalidadTutoria modalidadTutoriaSel) {
        this.modalidadTutoriaSel = modalidadTutoriaSel;
    }

    public ArrayList<ModalidadTutoria> getLstModalidadTutoria() {
        return lstModalidadTutoria;
    }

    public void setLstModalidadTutoria(ArrayList<ModalidadTutoria> lstModalidadTutoria) {
        this.lstModalidadTutoria = lstModalidadTutoria;
    }

    public ModalidadTutoriaControlador() {
        this.reinit();
    }
    
    private void reinit(){
        this.objModalidadTutoria = new ModalidadTutoria();
        this.modalidadTutoriaSel = new ModalidadTutoria();
        this.lstModalidadTutoria = new ArrayList<ModalidadTutoria>();
        this.cargarModalidadTutoria();
        //this.modalidadTutoriaSel = this.lstModalidadTutoria.get(0);        
       }  
    
  private void cargarModalidadTutoria(){
        try {
            this.lstModalidadTutoria = FModalidadTutoria.ObtenerModalidadTutoria();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarModalidadTutoria dice: " + e.getMessage());
            System.out.println("private void cargarModalidadTutoria dice: " + e.getMessage());
            }
        }
    
    
    public void insertarModalidadTutoria() {
        try {
            if (FModalidadTutoria.Insertar(objModalidadTutoria)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoModalidadTutoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarModalidadTutoria dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarModalidadTutoria dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarModalidadTutoria dice: " + e.getMessage());
            System.out.println("private void insertarModalidadTutoria dice: " + e.getMessage());
                }
        }

     public void actualizarModalidadTutoria() {
        try {
            if (FModalidadTutoria.actualizar(modalidadTutoriaSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarModalidadTutoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarModalidadTutoria dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarModalidadTutoria dice: Error al guardar la información");
            }
        } catch (Exception e) {
           Util.addErrorMessage("private void actualizarModalidadTutoria dice: " + e.getMessage());
            System.out.println("private void actualizarModalidadTutoria dice: " + e.getMessage());
        }
    }

    public void eliminarModalidadTutoria() {
        try {
            if (FModalidadTutoria.eliminar(modalidadTutoriaSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarModalidadTutoria.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarModalidadTutoria dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarModalidadTutoria dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarModalidadTutoria dice: " + e.getMessage());
            System.out.println("private void eliminarModalidadTutoria dice: " + e.getMessage());
        }
    }  
    
}
