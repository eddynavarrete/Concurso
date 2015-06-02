/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concurso.presentation.beans;
import Concuros.logica.clases.CiudadC;
import Concurso.logica.funciones.CiudadF;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Kleber
 */
//public class CiudadControlador {
    
@ManagedBean
@ViewScoped

public class CiudadControlador  {
    
    private CiudadC objCiudad;
    private CiudadC ciudadSel;
    private ArrayList<CiudadC> lstCiudad;

        public CiudadC getObjCiudad() {
            return objCiudad;
        }

        public void setObjCiudad(CiudadC objCiudad) {
            this.objCiudad = objCiudad;
        }

        public CiudadC getCiudadSel() {
            return ciudadSel;
        }

        public void setCiudadSel(CiudadC ciudadSel) {
            this.ciudadSel = ciudadSel;
        }

        public ArrayList<CiudadC> getLstCiudad() {
            return lstCiudad;
        }

        public void setLstCiudad(ArrayList<CiudadC> lstCiudad) {
            this.lstCiudad = lstCiudad;
        }

   

   public CiudadControlador() {
        this.reinit();
    }
//
//    
    private void reinit(){
        this.objCiudad = new CiudadC();
        this.ciudadSel = new CiudadC();
        this.cargarCiudad();
        this.ciudadSel = this.lstCiudad.get(0);
    }
    
    public void cargarCiudad() {
        try {
            this.lstCiudad = CiudadF.ObtenerCiudad();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
            System.out.println("private void cargarFacultad dice: " + e.getMessage());
        }
     }
        
        
        public void insertarCiudad() {
        try {
            if (CiudadF.Insertar(objCiudad)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCiudad.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarCiudad dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarCiudad dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertar Ciudad  dice: " + e.getMessage());
            System.out.println("private void insertar Ciudad dice: " + e.getMessage());
                }
        }

     public void actualizarCiudad() {
        try {
            if (CiudadF.actualizar(ciudadSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarCiudad.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizar Ciudad dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarCiudad dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarCiudad dice: " + e.getMessage());
            System.out.println("private void actualizarCiudad dice: " + e.getMessage());
        }
    }

    public void eliminarCiudad() {
        try {
            if (CiudadF.eliminar(ciudadSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCiudad.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarCiudad dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarCiudad dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarCiudad dice: " + e.getMessage());
            System.out.println("private void eliminarCiudad dice: " + e.getMessage());
        }
    }
}
          