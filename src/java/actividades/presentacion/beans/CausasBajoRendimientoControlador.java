/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import actividades.logica.clases.CausasBajoRendimiento;
import actividades.logica.funciones.FCausasBajoRendimiento;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
/**
 *
 * @author Janneth GS
 */

@ManagedBean
@ViewScoped

public class CausasBajoRendimientoControlador {
    
    private CausasBajoRendimiento objCausasBajoRendimiento;
    private CausasBajoRendimiento causasBajoRendimientoSel;
    private ArrayList<CausasBajoRendimiento> lstCausasBajoRendimiento;

    public CausasBajoRendimientoControlador() {
        this.reinit();
    }
  
    private void reinit(){
        this.objCausasBajoRendimiento = new CausasBajoRendimiento();
        this.causasBajoRendimientoSel = new CausasBajoRendimiento();
        this.lstCausasBajoRendimiento = new ArrayList<CausasBajoRendimiento>();
        this.cargarCausasBajoRendimiento();
        this.causasBajoRendimientoSel = this.lstCausasBajoRendimiento.get(0);        
       }  
    
    
    
    public CausasBajoRendimiento getObjCausasBajoRendimiento() {
        return objCausasBajoRendimiento;
    }

    public void setObjCausasBajoRendimiento(CausasBajoRendimiento objCausasBajoRendimiento) {
        this.objCausasBajoRendimiento = objCausasBajoRendimiento;
    }

    public CausasBajoRendimiento getCausasBajoRendimientoSel() {
        return causasBajoRendimientoSel;
    }

    public void setCausasBajoRendimientoSel(CausasBajoRendimiento causasBajoRendimientoSel) {
        this.causasBajoRendimientoSel = causasBajoRendimientoSel;
    }

    public ArrayList<CausasBajoRendimiento> getLstCausasBajoRendimiento() {
        return lstCausasBajoRendimiento;
    }

    public void setLstCausasBajoRendimiento(ArrayList<CausasBajoRendimiento> lstCausasBajoRendimiento) {
        this.lstCausasBajoRendimiento = lstCausasBajoRendimiento;
    }
    
    
    
    
    private void cargarCausasBajoRendimiento(){
        try {
            this.lstCausasBajoRendimiento = FCausasBajoRendimiento.ObtenerCausasBajoRendimiento();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCausasBajoRendimiento dice: " + e.getMessage());
            System.out.println("private void cargarCausasBajoRendimiento dice: " + e.getMessage());
            }
        }
    
    
    public void insertarCausasBajoRendimiento() {
        try {
            if (FCausasBajoRendimiento.Insertar(objCausasBajoRendimiento)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCausasBajoRendimiento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarCausasBajoRendimiento dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarCausasBajoRendimiento dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarCausasBajoRendimiento dice: " + e.getMessage());
            System.out.println("private void insertarCausasBajoRendimiento dice: " + e.getMessage());
                }
        }

     public void actualizarCausasBajoRendimiento() {
        try {
            if (FCausasBajoRendimiento.actualizar(causasBajoRendimientoSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarCausasBajoRendimiento.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarCausasBajoRendimiento dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarCausasBajoRendimiento dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarCausasBajoRendimiento dice: " + e.getMessage());
            System.out.println("private void actualizarCausasBajoRendimiento dice: " + e.getMessage());
        }
    }

    public void eliminarCausasBajoRendimiento() {
        try {
            if (FCausasBajoRendimiento.eliminar(causasBajoRendimientoSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCausasBajoRendimiento.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarCausasBajoRendimiento dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarCausasBajoRendimiento dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarCausasBajoRendimiento dice: " + e.getMessage());
            System.out.println("private void eliminarCausasBajoRendimiento dice: " + e.getMessage());
        }
    }
    
}