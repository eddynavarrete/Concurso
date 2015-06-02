/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concurso.presentation.beans;
import Concuros.logica.clases.IdiomaC;
import Concurso.logica.funciones.IdiomaF;
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
public class IdiomaControlador {
    
    private IdiomaC objIdioma;
    private IdiomaC idiomaSel;
    private ArrayList<IdiomaC> lstIdioma;

    public IdiomaC getObjIdioma() {
        return objIdioma;
    }

    public void setObjIdioma(IdiomaC objIdioma) {
        this.objIdioma = objIdioma;
    }

    public IdiomaC getIdiomaSel() {
        return idiomaSel;
    }

    public void setIdiomaSel(IdiomaC idiomaSel) {
        this.idiomaSel = idiomaSel;
    }

    public ArrayList<IdiomaC> getLstIdioma() {
        return lstIdioma;
    }

    public void setLstIdioma(ArrayList<IdiomaC> lstIdioma) {
        this.lstIdioma = lstIdioma;
    }

      
   public IdiomaControlador() {
        this.reinit();
    }
//
//    
    private void reinit(){
        this.objIdioma = new IdiomaC();
        this.idiomaSel = new IdiomaC();
        this.cargarIdioma();
        this.idiomaSel = this.lstIdioma.get(0);
    }
    
    public void cargarIdioma() {
        try {
            this.lstIdioma = IdiomaF.ObtenerIdioma();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarIdioma dice: " + e.getMessage());
            System.out.println("private void cargarIdioma dice: " + e.getMessage());
        }
     }
        
        
        public void insertarIdioma() {
        try {
            if (IdiomaF.Insertar(objIdioma)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoIdioma.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarCiudad dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarIdioma dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertar Idioma  dice: " + e.getMessage());
            System.out.println("private void insertar Idioma dice: " + e.getMessage());
                }
        }

     public void actualizarIdioma() {
        try {
            if (IdiomaF.actualizar(idiomaSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarIdioma.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizar Idioma dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarIdioma dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarIdioma dice: " + e.getMessage());
            System.out.println("private void actualizarIdioma dice: " + e.getMessage());
        }
    }

    public void eliminarIdioma() {
        try {
            if (IdiomaF.eliminar(idiomaSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarIdioma.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarIdioma dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarIdioma dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarIdioma dice: " + e.getMessage());
            System.out.println("private void eliminarIdiomadice: " + e.getMessage());
        }
    }
}
