/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Parametros;
import master.logica.funciones.FParametros;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Kleber
 */

@ManagedBean
@ViewScoped
public class ParametrosControlador {
    
    private Parametros objParametros;
    private Parametros parametrosSel;
    private ArrayList<Parametros> lstParametros;

    public Parametros getObjParametros() {
        return objParametros;
    }

    public void setObjParametros(Parametros objParametros) {
        this.objParametros = objParametros;
    }

    public Parametros getParametrosSel() {
        return parametrosSel;
    }

    public void setParametrosSel(Parametros parametrosSel) {
        this.parametrosSel = parametrosSel;
    }

    public ArrayList<Parametros> getLstParametros() {
        return lstParametros;
    }

    public void setLstParametros(ArrayList<Parametros> lstParametros) {
        this.lstParametros = lstParametros;
    }

   
    
    public ParametrosControlador() {
        this.reinit();
    }
   
        private void reinit(){
        this.objParametros = new Parametros();
        this.parametrosSel = new Parametros();
        this.cargarParametros();
        this.parametrosSel = this.lstParametros.get(0);
    }
    
    public void cargarParametros() {
        try {
            this.lstParametros = FParametros.ObtenerParametros();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarParametros dice: " + e.getMessage());
            System.out.println("private void cargarParametros dice: " + e.getMessage());
        }
     }
        
       
        public void insertarParametros() {
        try {
            if (FParametros.Insertar(objParametros)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoParametros.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarParametros dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarParametros dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarParametros dice: " + e.getMessage());
            System.out.println("private void insertarParametros dice: " + e.getMessage());
                }
        }

     public void actualizarParametros() {
        try {
            if (FParametros.actualizar(parametrosSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarParametros.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarParametros dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarParametros dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarParametros dice: " + e.getMessage());
            System.out.println("private void actualizarParametros dice: " + e.getMessage());
        }
    }

    public void eliminarParametros() {
        try {
            if (FParametros.eliminar(parametrosSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarFacultad.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarParametros dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarParametros dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarParametros dice: " + e.getMessage());
            System.out.println("private void eliminarParametros dice: " + e.getMessage());
        }
        
    }
}