/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Escuela;
import master.logica.funciones.FEscuela;
import master.logica.clases.Facultad;
import master.logica.funciones.FFacultad;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Janneth GS
 */

@ManagedBean
@ViewScoped


public class EscuelaControlador {
    
    private Escuela objEscuela;
    private Escuela escuelaSel;
    private ArrayList<Escuela> lstEscuelas;
    private ArrayList<Facultad> facultades;
    private boolean mostrarActualizar;
    private int valorFSeleccionado;
    private int FSeleccionada;

    public int getFSeleccionada() {
        return FSeleccionada;
    }

    public void setFSeleccionada(int FSeleccionada) {
        this.FSeleccionada = FSeleccionada;
    }

   

    

    public ArrayList<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(ArrayList<Facultad> facultades) {
        this.facultades = facultades;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorFSeleccionado() {
        return valorFSeleccionado;
    }

    public void setValorFSeleccionado(int valorFSeleccionado) {
        this.valorFSeleccionado = valorFSeleccionado;
    }

    public Escuela getObjEscuela() {
        return objEscuela;
    }

    public void setObjEscuela(Escuela objEscuela) {
        this.objEscuela = objEscuela;
    }

    public Escuela getEscuelaSel() {
        return escuelaSel;
    }

    public void setEscuelaSel(Escuela escuelaSel) {
        this.escuelaSel = escuelaSel;
    }

    public ArrayList<Escuela> getLstEscuelas() {
        return lstEscuelas;
    }

    public void setLstEscuelas(ArrayList<Escuela> lstEscuelas) {
        this.lstEscuelas = lstEscuelas;
    }
    
  
    public EscuelaControlador() {
        this.reinit();
    }
    
    
    
    private void reinit(){
        this.objEscuela = new Escuela();
        this.escuelaSel = new Escuela();
        this.lstEscuelas = new ArrayList<Escuela>();
        this.facultades = new ArrayList<Facultad>();
        this.cargarFacultades();
        this.cargarEscuela();
        this.escuelaSel = this.lstEscuelas.get(0);
    }
    
    public void cargarEscuela() {
        try {
            this.lstEscuelas= FEscuela.ObtenerEscuelas();
            this.escuelaSel = lstEscuelas.get(0);
            System.out.println(lstEscuelas.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEscuela dice: " + e.getMessage());
            System.out.println("private void cargarEscuela dice: " + e.getMessage());
        }
     }
      
    
    private void cargarFacultades(){
        try {
            this.facultades = FFacultad.ObtenerFacultades();
            System.out.println(facultades.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultades dice: " + e.getMessage());
            System.out.println("private void cargarFacultades dice: " + e.getMessage());
            }
        }
   
        
    public void insertarEscuela() {
        try {
            
            
            
            Facultad facultad = new Facultad();
            facultad.setCodigo(valorFSeleccionado);
            objEscuela.setCodigo_facultad(facultad);
            
                       
            
            if(FEscuela.Insertar(objEscuela)){
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEscuela.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarEscuela dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarEscuela dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarEscuela dice: " + e.getMessage());
            System.out.println("private void insertarEscuela dice: " + e.getMessage());
                }
        }

      public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
    
    
     public void actualizarEscuela() {
        try {
            escuelaSel.setCodigo_facultad(FFacultad.ObtenerFacultadDadoCodigo(escuelaSel.getCodigo_facultad().getCodigo()));
            if (FEscuela.actualizar(escuelaSel)){
                escuelaSel = new Escuela();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarEscuela.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarEscuela dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarEscuela dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarEscuela dice: " + e.getMessage());
            System.out.println("private void actualizarEscuela dice: " + e.getMessage());
        }
    }

    public void eliminarEscuela() {
        try {
            if (FEscuela.eliminar(escuelaSel.getCodigo())){
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarEscuela.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarEscuela dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarEscueladice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarEscuela dice: " + e.getMessage());
            System.out.println("private void eliminarEscuela dice: " + e.getMessage());
        }
        
    }

   
  
    
    
    
}
