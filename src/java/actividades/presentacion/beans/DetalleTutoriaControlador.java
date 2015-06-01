/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import actividades.logica.clases.DetalleTutoria;
import actividades.logica.funciones.FDetalleTutoria;
import actividades.logica.clases.CausasBajoRendimiento;
import actividades.logica.clases.EncabezadoTutoria;
import actividades.logica.funciones.FCausasBajoRendimiento;
import actividades.logica.funciones.FEncabezadoTutoria;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Janneth GS
 */
@ManagedBean
@ViewScoped

public class DetalleTutoriaControlador {
    
    private DetalleTutoria objDetalleTutoria;
    private DetalleTutoria detalleTutoriaSel;
    private ArrayList<DetalleTutoria> lstDetalleTutoria;
    private ArrayList<CausasBajoRendimiento> causasBajoRendimiento;
    private ArrayList<EncabezadoTutoria> encabezadoTutoria;
    private boolean mostrarActualizar;
    private int valorCBRSeleccionada;
    private int valorETSeleccionada;

    public ArrayList<CausasBajoRendimiento> getCausasBajoRendimiento() {
        return causasBajoRendimiento;
    }

    public void setCausasBajoRendimiento(ArrayList<CausasBajoRendimiento> causasBajoRendimiento) {
        this.causasBajoRendimiento = causasBajoRendimiento;
    }

    public ArrayList<EncabezadoTutoria> getEncabezadoTutoria() {
        return encabezadoTutoria;
    }

    public void setEncabezadoTutoria(ArrayList<EncabezadoTutoria> encabezadoTutoria) {
        this.encabezadoTutoria = encabezadoTutoria;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorCBRSeleccionada() {
        return valorCBRSeleccionada;
    }

    public void setValorCBRSeleccionada(int valorCBRSeleccionada) {
        this.valorCBRSeleccionada = valorCBRSeleccionada;
    }

    public int getValorETSeleccionada() {
        return valorETSeleccionada;
    }

    public void setValorETSeleccionada(int valorETSeleccionada) {
        this.valorETSeleccionada = valorETSeleccionada;
    }

    public DetalleTutoria getObjDetalleTutoria() {
        return objDetalleTutoria;
    }

    public void setObjDetalleTutoria(DetalleTutoria objDetalleTutoria) {
        this.objDetalleTutoria = objDetalleTutoria;
    }

    public DetalleTutoria getDetalleTutoriaSel() {
        return detalleTutoriaSel;
    }

    public void setDetalleTutoriaSel(DetalleTutoria detalleTutoriaSel) {
        this.detalleTutoriaSel = detalleTutoriaSel;
    }

    public ArrayList<DetalleTutoria> getLstDetalleTutoria() {
        return lstDetalleTutoria;
    }

    public void setLstDetalleTutoria(ArrayList<DetalleTutoria> lstDetalleTutoria) {
        this.lstDetalleTutoria = lstDetalleTutoria;
    }

    public DetalleTutoriaControlador() {
        this.reinit();
    }
    
    private void reinit(){
        this.objDetalleTutoria = new DetalleTutoria();
        this.detalleTutoriaSel = new DetalleTutoria();
        this.lstDetalleTutoria = new ArrayList<DetalleTutoria>();
        this.encabezadoTutoria = new ArrayList<EncabezadoTutoria>();
        this.causasBajoRendimiento = new ArrayList<CausasBajoRendimiento>();
       // this.detalleTutoriaSel = this.lstDetalleTutoria.get(0);
        this.cargarDetalleTutoria();
        this.cargarCausasBajoRendimiento();
        this.cargarEncabezadoTutoria();
    }
    
    private void cargarDetalleTutoria(){
        try {
            this.lstDetalleTutoria = FDetalleTutoria.ObtenerDetalleTutoria();
            this.detalleTutoriaSel = lstDetalleTutoria.get(0);
            System.out.println(lstDetalleTutoria.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDetalleTutoria dice: " + e.getMessage());
            System.out.println("private void cargarDetalleTutoria dice: " + e.getMessage());
            }
        }
    
    
        private void cargarEncabezadoTutoria(){
        try {
            this.encabezadoTutoria = FEncabezadoTutoria.ObtenerEncabezadoTutoria();
            System.out.println(encabezadoTutoria.get(0).getActividad());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEncabezadoTutoria dice: " + e.getMessage());
            System.out.println("private void cargarEncabezadoTutoria dice: " + e.getMessage());
            }
        }
    
        private void cargarCausasBajoRendimiento(){
        try {
            this.causasBajoRendimiento = FCausasBajoRendimiento.ObtenerCausasBajoRendimiento();
            System.out.println(causasBajoRendimiento.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCausasBajoRendimiento dice: " + e.getMessage());
            System.out.println("private void cargarCausasBajoRendimiento dice: " + e.getMessage());
            }
        }
        
        
    public void insertarDetalleTutoria() {
        try {
            
            EncabezadoTutoria ETutoria = new EncabezadoTutoria();
            ETutoria.setCodigo(valorETSeleccionada);
            objDetalleTutoria.setCodigo_encabezado(ETutoria);
            
            CausasBajoRendimiento CBRendimiento = new CausasBajoRendimiento();
            CBRendimiento.setCodigo(valorCBRSeleccionada);
            objDetalleTutoria.setCodigo_causas_bajo_rendimiento(CBRendimiento);
            
            
            if (FDetalleTutoria.Insertar(objDetalleTutoria)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoDetalleTutoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarDetalleTutoria dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarDetalleTutoria dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDetalleTutoria dice: " + e.getMessage());
            System.out.println("private void insertarDetalleTutoria dice: " + e.getMessage());
                }
        }
    
    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
    

     public void actualizarDetalleTutoria() {
        try {
            detalleTutoriaSel.setCodigo_encabezado(FEncabezadoTutoria.ObtenerEncabezadoTutoriaDadoCodigo((int) detalleTutoriaSel.getCodigo_encabezado().getCodigo()));
            detalleTutoriaSel.setCodigo_causas_bajo_rendimiento(FCausasBajoRendimiento.ObtenerCausasBajoRendimientoDadoCodigo(detalleTutoriaSel.getCodigo_causas_bajo_rendimiento().getCodigo()));
            
            
            if (FDetalleTutoria.actualizar(detalleTutoriaSel)) {
                detalleTutoriaSel = new DetalleTutoria();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarDetalleTutoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarDetalleTutoria dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarDetalleTutoria dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarDetalleTutoria dice: " + e.getMessage());
            System.out.println("private void actualizarDetalleTutoria dice: " + e.getMessage());
        }
    }

    public void eliminarDetalleTutoria() {
        try {
            if (FDetalleTutoria.eliminar((int) detalleTutoriaSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarDetalleTutoria.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarDetalleTutoria dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarDetalleTutoria dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarDetalleTutoria dice: " + e.getMessage());
            System.out.println("private void eliminarDetalleTutoria dice: " + e.getMessage());
        }
    }  
}
