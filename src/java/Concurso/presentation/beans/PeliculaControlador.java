/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.presentation.beans;

import Concuros.logica.clases.PeliculaC;
import Concuros.logica.clases.TipoC;
import Concurso.logica.funciones.PeliculaF;
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

public class PeliculaControlador {
    
    private PeliculaC objPelicula;
    private PeliculaC peliculaSel;
    private ArrayList<PeliculaC> lstPelicula;
    private ArrayList<TipoC> lstTipo;
    private boolean mostrarActualizar;
    private int valorTipoSeleccionado;

    public PeliculaC getObjPelicula() {
        return objPelicula;
    }

    public void setObjPelicula(PeliculaC objPelicula) {
        this.objPelicula = objPelicula;
    }

    public PeliculaC getPeliculaSel() {
        return peliculaSel;
    }

    public void setPeliculaSel(PeliculaC peliculaSel) {
        this.peliculaSel = peliculaSel;
    }

    public ArrayList<PeliculaC> getLstPelicula() {
        return lstPelicula;
    }

    public void setLstPelicula(ArrayList<PeliculaC> lstPelicula) {
        this.lstPelicula = lstPelicula;
    }

    public ArrayList<TipoC> getLstTipo() {
        return lstTipo;
    }

    public void setLstTipo(ArrayList<TipoC> LstTipo) {
        this.lstTipo = LstTipo;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorTipoSeleccionado() {
        return valorTipoSeleccionado;
    }

    public void setValorTipoSeleccionado(int valorTipoSeleccionado) {
        this.valorTipoSeleccionado = valorTipoSeleccionado;
    }
    
     public PeliculaControlador() {
        this.reinit();
    }

    
    private void reinit(){
        this.objPelicula = new PeliculaC();
        this.peliculaSel = new PeliculaC();
        this.lstPelicula = new ArrayList<PeliculaC>();
        this.lstTipo = new ArrayList<TipoC>();  
        
        //this.estudianteSel = this.lstEstudiantes.get(0);
        this.cargarPeliculas();
        //this.cargarNiveles();
        this.cargarTipo();
        
        
    }
    
    public void cargarPeliculas() {
        try {
            this.lstPelicula = PeliculaF.ObtenerPelicula();
            this.peliculaSel = lstPelicula.get(0);
            System.out.println(lstPelicula.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarPelicula dice: " + e.getMessage());
            System.out.println("private void cargarPelicula dice: " + e.getMessage());
        }
     }
    
    
    private void cargarTipo(){
        try {
            this.lstTipo= TipoF.ObtenerTipo();
            System.out.println(lstTipo.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarTipo dice: " + e.getMessage());
            System.out.println("private void cargarTipo dice: " + e.getMessage());
            }
        }
    
   
    
    
     public void obtenerPeliculaDadoCodigoTipo() {
        try {
            lstPelicula.clear();
            lstPelicula = PeliculaF.ObtenerPeliculaDadoCodigoTipo(valorTipoSeleccionado);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarPeliculaDadoCodigoTipo: " + e.getMessage());
            System.out.println("private void cargarPeliculaDadoCodigoTipo: " + e.getMessage());
        }
    }
     
               
        
        public void insertarPelicula() {
        try {
            
         
            
            TipoC tipo = new TipoC();
            tipo.setCodigo(valorTipoSeleccionado);
            objPelicula.setCodigo_tipo(tipo);
            
            if (PeliculaF.Insertar(objPelicula)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoPelicula.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarPelicula dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarPelicula dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarPelicula dice: " + e.getMessage());
            System.out.println("private void insertarPelicula dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarEstudiante() {
        try {
            
            peliculaSel.setCodigo_tipo(TipoF.ObtenerTipoDadoCodigo(peliculaSel.getCodigo_tipo().getCodigo()));
            
                       
            if (PeliculaF.actualizar(peliculaSel)) {
                peliculaSel = new PeliculaC();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarPelicula.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarPelicula dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarPelicula dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarPelicula dice: " + e.getMessage());
            System.out.println("private void actualizarPelicula dice: " + e.getMessage());
        }
    }

    public void eliminarPelicula() {
        try {
            if (PeliculaF.eliminar((int) peliculaSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPelicula.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarPelicula dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarPelicula dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarPelicula dice: " + e.getMessage());
            System.out.println("private void eliminarPelicula dice: " + e.getMessage());
        }
        
    }
    
}