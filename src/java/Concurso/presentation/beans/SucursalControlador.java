/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concurso.presentation.beans;
import Concuros.logica.clases.CiudadC;
import Concuros.logica.clases.SalaC;
import Concuros.logica.clases.SucursalC;
import Concurso.logica.funciones.CiudadF;
import Concurso.logica.funciones.SalaF;
import Concurso.logica.funciones.SucursalF;
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
public class SucursalControlador {
 
    private SucursalC objSucursal;
    private SucursalC sucursalSel;
    private ArrayList<SucursalC> lstSucursal;
    private ArrayList<CiudadC> lstCiudad;
    private ArrayList<SalaC> lstSala;
    private boolean mostrarActualizar;
    private int valorCiudadSeleccionado;
    private int valorSalaSeleccionado;

    public SucursalC getObjSucursalC() {
        return objSucursal;
    }

    public void setObjSucursalC(SucursalC objSucursalC) {
        this.objSucursal = objSucursalC;
    }

    public SucursalC getSucursalSel() {
        return sucursalSel;
    }

    public void setSucursalSel(SucursalC sucursalSel) {
        this.sucursalSel = sucursalSel;
    }

    public ArrayList<SucursalC> getLstSucursal() {
        return lstSucursal;
    }

    public void setLstSucursal(ArrayList<SucursalC> lstSucursal) {
        this.lstSucursal = lstSucursal;
    }

    public ArrayList<CiudadC> getLstCiudad() {
        return lstCiudad;
    }

    public void setLstCiudad(ArrayList<CiudadC> lstCiudad) {
        this.lstCiudad = lstCiudad;
    }

    public ArrayList<SalaC> getLstSala() {
        return lstSala;
    }

    public void setLstSala(ArrayList<SalaC> lstSala) {
        this.lstSala = lstSala;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorCiudadSeleccionado() {
        return valorCiudadSeleccionado;
    }

    public void setValorCiudadSeleccionado(int valorCiudadSeleccionado) {
        this.valorCiudadSeleccionado = valorCiudadSeleccionado;
    }

    public int getValorSalaSeleccionado() {
        return valorSalaSeleccionado;
    }

    public void setValorSalaSeleccionado(int valorSalaSeleccionado) {
        this.valorSalaSeleccionado = valorSalaSeleccionado;
    }

       
     public SucursalControlador() {
        this.reinit();
    }

    private void reinit(){
        this.objSucursal = new SucursalC();
        this.sucursalSel = new SucursalC();
        this.lstSucursal = new ArrayList<SucursalC>();
        this.lstCiudad = new ArrayList<CiudadC>();  
        this.lstSala = new ArrayList<SalaC>(); 
        
        //this.estudianteSel = this.lstEstudiantes.get(0);
        this.cargarSucursal();
        //this.cargarNiveles();
        this.cargarCiudad();
        //Cargar Sala
        this.cargarSala(); 
        
    }
    
    public void cargarSucursal() {
        try {
            this.lstSucursal = SucursalF.ObtenerSucursal();
            this.sucursalSel = lstSucursal.get(0);
            System.out.println(lstSucursal.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarSucursal dice: " + e.getMessage());
            System.out.println("private void cargarSucursal dice: " + e.getMessage());
        }
     }
    
    
    private void cargarCiudad(){
        try {
            this.lstCiudad= CiudadF.ObtenerCiudad();
            System.out.println(lstCiudad.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCiudad dice: " + e.getMessage());
            System.out.println("private void cargarCiudad dice: " + e.getMessage());
            }
        }
     private void cargarSala(){
        try {
            this.lstSala= SalaF.ObtenerSalas();
            System.out.println(lstSala.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarSala dice: " + e.getMessage());
            System.out.println("private void cargarSala dice: " + e.getMessage());
            }
        }
   
     public void insertarSucursal() {
        try {
                 
            CiudadC ciudad = new CiudadC();
            ciudad.setCodigo(valorCiudadSeleccionado);
            objSucursal.setCodigo_ciudad(ciudad);
            
            if (SucursalF.Insertar(objSucursal)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoSucursal.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarPelicula dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarPelicula dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarSucursal dice: " + e.getMessage());
            System.out.println("private void insertarSucursal dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarSucursal() {
        try {
            
            sucursalSel.setCodigo_ciudad(CiudadF.ObtenerCiudadDadoCodigo(valorCiudadSeleccionado));
                                   
            if (SucursalF.actualizar(sucursalSel)) {
                sucursalSel = new SucursalC();
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

}