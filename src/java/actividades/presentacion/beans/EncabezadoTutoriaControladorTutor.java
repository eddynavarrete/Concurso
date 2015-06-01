/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import actividades.logica.clases.EncabezadoTutoria;
import actividades.logica.funciones.FEncabezadoTutoria;
import master.logica.clases.Tutor;
import actividades.logica.clases.ModalidadTutoria;
import master.logica.funciones.FTutor;
import actividades.logica.funciones.FModalidadTutoria;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Janneth GS
 */

@ManagedBean
@ViewScoped

public class EncabezadoTutoriaControladorTutor {
    
    private EncabezadoTutoria objEncabezadoTutoria;
    private EncabezadoTutoria encabezadoTutoriaSel;
    private ArrayList<EncabezadoTutoria> lstEncabezadoTutoria;
    private java.util.Date FechaEncabezado;
    private ArrayList<Tutor> tutor;
    private ArrayList<ModalidadTutoria> modalidadTutoria;
    private boolean mostrarActualizar;
    private int valorMTSeleccionada;
    private int valorTSeleccionado;
    private long codigoTutor;
    
      
    
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    
     public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }
     
    
    public long getCodigoTutor() {
        return codigoTutor;
    }

    public void setCodigoTutor(long codigoTutor) {
        this.codigoTutor = codigoTutor;
    }

      

    public ArrayList<Tutor> getTutor() {
        return tutor;
    }

    public void setTutor(ArrayList<Tutor> tutor) {
        this.tutor = tutor;
    }

    public ArrayList<ModalidadTutoria> getModalidadTutoria() {
        return modalidadTutoria;
    }

    public void setModalidadTutoria(ArrayList<ModalidadTutoria> modalidadTutoria) {
        this.modalidadTutoria = modalidadTutoria;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorMTSeleccionada() {
        return valorMTSeleccionada;
    }

    public void setValorMTSeleccionada(int valorMTSeleccionada) {
        this.valorMTSeleccionada = valorMTSeleccionada;
    }

    public int getValorTSeleccionado() {
        return valorTSeleccionado;
    }

    public void setValorTSeleccionado(int valorTSeleccionado) {
        this.valorTSeleccionado = valorTSeleccionado;
    }

    public Date getFechaEncabezado() {
        return FechaEncabezado;
    }

    public void setFechaEncabezado(Date FechaEncabezado) {
        this.FechaEncabezado = FechaEncabezado;
    }

    public EncabezadoTutoria getObjEncabezadoTutoria() {
        return objEncabezadoTutoria;
    }

    public void setObjEncabezadoTutoria(EncabezadoTutoria objEncabezadoTutoria) {
        this.objEncabezadoTutoria = objEncabezadoTutoria;
    }

    public EncabezadoTutoria getEncabezadoTutoriaSel() {
        return encabezadoTutoriaSel;
    }

    public void setEncabezadoTutoriaSel(EncabezadoTutoria encabezadoTutoriaSel) {
        this.encabezadoTutoriaSel = encabezadoTutoriaSel;
    }

    public ArrayList<EncabezadoTutoria> getLstEncabezadoTutoria() {
        return lstEncabezadoTutoria;
    }

    public void setLstEncabezadoTutoria(ArrayList<EncabezadoTutoria> lstEncabezadoTutoria) {
        this.lstEncabezadoTutoria = lstEncabezadoTutoria;
    }

    public EncabezadoTutoriaControladorTutor() {
        this.reinit();
    }
     @PostConstruct
    public void postEncabezadoTutoriaControladorTutor(){
        this.cargarEncabezadoTutoria();
    }

   private void reinit(){
        this.objEncabezadoTutoria = new EncabezadoTutoria();
        this.encabezadoTutoriaSel = new EncabezadoTutoria();
        this.lstEncabezadoTutoria = new ArrayList<EncabezadoTutoria>();
        this.modalidadTutoria = new ArrayList<ModalidadTutoria>();
        this.tutor = new ArrayList<Tutor>();
        //this.cargarEncabezadoTutoria();
        this.cargarModalidadTutoria();
        this.cargarTutores();
        //this.encabezadoTutoriaSel = this.lstEncabezadoTutoria.get(0); 
        this.FechaEncabezado = new java.util.Date();
       } 
    
   
    private void cargarEncabezadoTutoria(){
        try {
            this.lstEncabezadoTutoria = FEncabezadoTutoria.ObtenerEncabezadoTutoriaDadoCodigoTutor(this.dm.getSesionTutorActual().getCodigo());
            this.encabezadoTutoriaSel = lstEncabezadoTutoria.get(0);
            System.out.println(lstEncabezadoTutoria.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEncabezadoTutoria dice: " + e.getMessage());
            System.out.println("private void cargarEncabezadoTutoria dice: " + e.getMessage());
            }
        }
    
    
     private void cargarModalidadTutoria(){
        try {
            this.modalidadTutoria = FModalidadTutoria.ObtenerModalidadTutoria();
            System.out.println(modalidadTutoria.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarModalidadTutoria dice: " + e.getMessage());
            System.out.println("private void cargarModalidadTutoria dice: " + e.getMessage());
            }
        }
    
    private void cargarTutores(){
        try {
            this.tutor = FTutor.ObtenerTutores();
            System.out.println(tutor.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarTutores dice: " + e.getMessage());
            System.out.println("private void cargarTutores dice: " + e.getMessage());
            }
        }
    
    
    public void insertarEncabezadoTutoria() {
        try {
            //this.encabezadoTutoriaSel.setFecha(new java.sql.Date(this.FechaEncabezado.getTime()));
                     
            ModalidadTutoria MTutoria = new ModalidadTutoria();
            MTutoria.setCodigo(valorMTSeleccionada);
            objEncabezadoTutoria.setCodigo_modalidad_tutoria(MTutoria);
            
            Tutor tutores = new Tutor();
            tutores.setCodigo(dm.getSesionTutorActual().getCodigo());
            objEncabezadoTutoria.setCodigo_tutor(tutores);
            
            this.objEncabezadoTutoria.setFecha(new java.sql.Date(this.FechaEncabezado.getTime()));
            
            
            if (FEncabezadoTutoria.Insertar(objEncabezadoTutoria)) {
                this.reinit();
                this.cargarEncabezadoTutoria();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEncabezadoTutoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarEncabezadoTutoria dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarEncabezadoTutoria dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarEncabezadoTutoria dice: " + e.getMessage());
            System.out.println("private void insertarEncabezadoTutoria dice: " + e.getMessage());
                }
        }

      
    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
    
    /**
     *
     */
    public void actualizarEncabezadoTutoria() {
        try {
    
            encabezadoTutoriaSel.setCodigo_tutor(FTutor.ObtenerTutorDadoCodigo(this.dm.getSesionTutorActual().getCodigo()));
            encabezadoTutoriaSel.setCodigo_modalidad_tutoria(FModalidadTutoria.ObtenerModalidadTutoriaDadoCodigo(encabezadoTutoriaSel.getCodigo_modalidad_tutoria().getCodigo()));
           
            this.encabezadoTutoriaSel.setFecha(new java.sql.Date(this.FechaEncabezado.getTime()));   
            
            if (FEncabezadoTutoria.actualizar(encabezadoTutoriaSel)) {
                encabezadoTutoriaSel = new EncabezadoTutoria();
                mostrarActualizar = false;
                this.reinit();
                this.cargarEncabezadoTutoria();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarEncabezadoTutoria.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarEncabezadoTutoria dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarEncabezadoTutoria dice: Error al guardar la información");
            }
        } catch (Exception e) {
           Util.addErrorMessage("private void actualizarEncabezadoTutoria dice: " + e.getMessage());
            System.out.println("private void actualizarEncabezadoTutoria dice: " + e.getMessage());
        }
    }
    
    
    public void eliminarEncabezadoTutoria() {
        try {
           //this.encabezadoTutoriaSel.setFecha(new java.sql.Date(this.FechaEncabezado.getTime())); 
            Tutor tutor = new Tutor();
            tutor.setCodigo(dm.getIntSesionTutor());
            encabezadoTutoriaSel.setCodigo_tutor(tutor);
                        
            
            if (FEncabezadoTutoria.eliminar((int) encabezadoTutoriaSel.getCodigo())) {
                this.reinit();
                this.cargarEncabezadoTutoria();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarEncabezadoTutoria.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarEncabezadoTutoria dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarEncabezadoTutoria dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarEncabezadoTutoria dice: " + e.getMessage());
            System.out.println("private void eliminarEncabezadoTutoria dice: " + e.getMessage());
        }
    }  
    
    
    
    
}
