/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.presentation.beans;

import Concuros.logica.clases.IdiomaC;
import Concuros.logica.clases.PeliculaC;
import Concuros.logica.clases.Pelicula_IdiomaC;
import Concurso.logica.funciones.IdiomaF;
import Concurso.logica.funciones.PeliculaF;
import Concurso.logica.funciones.Pelicula_IdiomaF;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import recursos.Util;

/**
 *
 * @author Usuario
 */


@ManagedBean
@ViewScoped
public class Pelicula_IdiomaControlador {
    
    private Pelicula_IdiomaC objPelicula_Idioma;
    private Pelicula_IdiomaC peliIdiomaSel;
    private ArrayList<Pelicula_IdiomaC> lstPelicuIdioma;
    private ArrayList<IdiomaC> lstIdioma;
    private ArrayList<PeliculaC> lstPelicula;
    private boolean mostrarActualizar;
    private int valorIdiomaSeleccionado;
    private int valorPeliculaSeleccionado;

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorIdiomaSeleccionado() {
        return valorIdiomaSeleccionado;
    }

    public void setValorIdiomaSeleccionado(int valorIdiomaSeleccionado) {
        this.valorIdiomaSeleccionado = valorIdiomaSeleccionado;
    }

    public int getValorPeliculaSeleccionado() {
        return valorPeliculaSeleccionado;
    }

    public void setValorPeliculaSeleccionado(int valorPeliculaSeleccionado) {
        this.valorPeliculaSeleccionado = valorPeliculaSeleccionado;
    }

    public Pelicula_IdiomaC getObjPelicula_Idioma() {
        return objPelicula_Idioma;
    }

    public void setObjPelicula_Idioma(Pelicula_IdiomaC objPelicula_Idioma) {
        this.objPelicula_Idioma = objPelicula_Idioma;
    }

    public Pelicula_IdiomaC getPeliIdiomaSel() {
        return peliIdiomaSel;
    }

    public void setPeliIdiomaSel(Pelicula_IdiomaC peliIdiomaSel) {
        this.peliIdiomaSel = peliIdiomaSel;
    }

    public ArrayList<Pelicula_IdiomaC> getLstEstudiantes() {
        return lstPelicuIdioma;
    }

    public void setLstEstudiantes(ArrayList<Pelicula_IdiomaC> lstEstudiantes) {
        this.lstPelicuIdioma = lstEstudiantes;
    }

    public ArrayList<IdiomaC> getLstIdioma() {
        return lstIdioma;
    }

    public void setLstIdioma(ArrayList<IdiomaC> lstIdioma) {
        this.lstIdioma = lstIdioma;
    }

    public ArrayList<PeliculaC> getLstPelicula() {
        return lstPelicula;
    }

    public void setLstPelicula(ArrayList<PeliculaC> lstPelicula) {
        this.lstPelicula = lstPelicula;
    }
    
     public Pelicula_IdiomaControlador() {
        this.reinit();
    }

    
    private void reinit(){
        this.objPelicula_Idioma = new Pelicula_IdiomaC();
        this.peliIdiomaSel = new Pelicula_IdiomaC();
        this.lstPelicuIdioma = new ArrayList<Pelicula_IdiomaC>();
        this.lstIdioma = new ArrayList<IdiomaC>();  
        this.lstPelicula = new ArrayList<PeliculaC>();
        
        //this.estudianteSel = this.lstEstudiantes.get(0);
        this.cargarPelicula_Idioma();
        //this.cargarNiveles();
        this.cargarIdioma();
        this.cargarPelicula();
        
    }
    
    public void cargarPelicula_Idioma() {
        try {
            this.lstPelicuIdioma = Pelicula_IdiomaF.ObtenerPeliculaIdioma();
            this.peliIdiomaSel = lstPelicuIdioma.get(0);
            System.out.println(lstPelicuIdioma.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEstudiante dice: " + e.getMessage());
            System.out.println("private void cargarEstudiante dice: " + e.getMessage());
        }
     }
    
    
    private void cargarPelicula(){
        try {
            this.lstPelicula= PeliculaF.ObtenerPelicula();
            System.out.println(lstPelicula.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarPelicula dice: " + e.getMessage());
            System.out.println("private void cargarPelicula dice: " + e.getMessage());
            }
        }
    
    private void cargarIdioma(){
        try {
            this.lstIdioma = IdiomaF.ObtenerIdioma();
            System.out.println(lstIdioma.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarIdioma dice: " + e.getMessage());
            System.out.println("private void cargarIdioma dice: " + e.getMessage());
            }
        }
    
     
     public void obtenerPeliculaIdiomaDadoCodigoIdioma() {
        try {
            lstPelicuIdioma.clear();
            lstPelicuIdioma = Pelicula_IdiomaF.ObtenerPeliculaIdiomaDadoCodigoIdioma(valorIdiomaSeleccionado);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarIdiomaDadoCodigoIdioma: " + e.getMessage());
            System.out.println("private void cargarIdiomaDadoCodigoIdioma: " + e.getMessage());
        }
    }
     
     public void obtenerPeliculaIdiomaDadoCodigoPelicula() {
        try {
            lstPelicuIdioma.clear();
            lstPelicuIdioma = Pelicula_IdiomaF.ObtenerPeliculaIdiomaDadoCodigoPelicula(valorPeliculaSeleccionado);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarIdiomaDadoCodigoIdioma: " + e.getMessage());
            System.out.println("private void cargarIdiomaDadoCodigoIdioma: " + e.getMessage());
        }
    }
       
        
        
      
            
            
           
    
}

