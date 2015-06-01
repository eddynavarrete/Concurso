    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planificacion.presentacion.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import planificacion.logica.clases.ActividadesPlanificadas;
import planificacion.logica.funciones.FActividadesPlanificadas;
import master.logica.clases.Tutor;
import master.logica.funciones.FTutor;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
/**
 *
 * @author Janneth GS
 */
@ManagedBean
@ViewScoped
public final class ActividadesPlanificadasControlador implements Serializable{
 
    private ArrayList<ActividadesPlanificadas> actividadesplanificadas;
    private ActividadesPlanificadas actividadplanificada;
    private ArrayList<Tutor> tutores;
    private boolean mostrarActualizar;
    private int valorAPseleccionada;
    private ActividadesPlanificadas seleccionarAP;
    private java.util.Date FechaAP;

    public int getValorAPseleccionada() {
        return valorAPseleccionada;
    }

    public void setValorAPseleccionada(int valorAPseleccionada) {
        this.valorAPseleccionada = valorAPseleccionada;
    }


    public ArrayList<ActividadesPlanificadas> getActividadesplanificadas() {
        return actividadesplanificadas;
    }

    public void setActividadesplanificadas(ArrayList<ActividadesPlanificadas> actividadesplanificadas) {
        this.actividadesplanificadas = actividadesplanificadas;
    }

    public ActividadesPlanificadas getActividadplanificada() {
        return actividadplanificada;
    }

    public void setActividadplanificada(ActividadesPlanificadas actividadplanificada) {
        this.actividadplanificada = actividadplanificada;
    }

    public ArrayList<Tutor> getTutores() {
        return tutores;
    }

    public void setTutores(ArrayList<Tutor> tutores) {
        this.tutores = tutores;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ActividadesPlanificadas getSeleccionarAP() {
        return seleccionarAP;
    }

    public void setSeleccionarAP(ActividadesPlanificadas seleccionarAP) {
        this.seleccionarAP = seleccionarAP;
    }
   
    public Date getFechaAP() {
        return FechaAP;
    }

    public void setFechaAP(Date FechaAP) {
        this.FechaAP = FechaAP;   
    }
   
    public ActividadesPlanificadasControlador() {
        this.reinit();
    }  
    
    private void reinit(){
        this.actividadesplanificadas = new ArrayList<ActividadesPlanificadas>();
        this.actividadplanificada = new ActividadesPlanificadas();
        this.tutores = new ArrayList<Tutor>();
        this.seleccionarAP = new ActividadesPlanificadas();
        this.cargarActividadesPlanificadas();
        this.cargarTutores();
        this.FechaAP = new java.util.Date();
        //this.seleccionarAP = this.actividadesplanificadas.get(0);
        
    }
   
    private void cargarActividadesPlanificadas(){
        try {
            this.actividadesplanificadas = FActividadesPlanificadas.ObtenerActividadesPlanificadas();
            seleccionarAP = actividadesplanificadas.get(0);
            System.out.println(actividadesplanificadas.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarActividadesPlanificadas dice: " + e.getMessage());
            System.out.println("private void cargarActividadesPlanificadas dice: " + e.getMessage());
            }
        }
    
     private void cargarTutores(){
        try {
            this.tutores = FTutor.ObtenerTutores();
            System.out.println(tutores.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarActividadesPlanificadas dice: " + e.getMessage());
            System.out.println("private void cargarTutores dice: " + e.getMessage());
            }
        }
     
    public void insertarActividadesPlanificadas() {
        try {
            this.actividadplanificada.setFecha(new java.sql.Date(this.FechaAP.getTime()));
            
            
            Tutor tutor = new Tutor();
            tutor.setCodigo(valorAPseleccionada);
            actividadplanificada.setCodigo_tutor(tutor);        
            
            
            
            if (FActividadesPlanificadas.Insertar(actividadplanificada)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoActividadesPlanificadas.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarActividadesPlanificadas dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarActividadesPlanificadas dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarActividadesPlanificadas dice: " + e.getMessage());
            System.out.println("private void insertarActividadesPlanificadas dice: " + e.getMessage());
                }
        }
    
    
    
    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }

     public void actualizarActividadesPlanificadas() {
        try {
            seleccionarAP.setCodigo_tutor(FTutor.ObtenerTutorDadoCodigo((int) seleccionarAP.getCodigo_tutor().getCodigo()));
            if (FActividadesPlanificadas.actualizar(seleccionarAP)) {
                seleccionarAP = new ActividadesPlanificadas();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarActividadesPlanificadas.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarActividadesPlanificadas dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarActividadesPlanificadas dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarActividadesPlanificadas dice: " + e.getMessage());
            System.out.println("private void actualizarActividadesPlanificadas dice: " + e.getMessage());
        }
    }

    public void eliminarActividadesPlanificadas() {
        try {
            if (FActividadesPlanificadas.eliminar((int) seleccionarAP.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarActividadesPlanificadas.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarActividadesPlanificadas dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarActividadesPlanificadas dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarActividadesPlanificadas dice: " + e.getMessage());
            System.out.println("private void eliminarActividadesPlanificadas dice: " + e.getMessage());
        }
    }
    
}
