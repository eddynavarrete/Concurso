/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Nivel;
import master.logica.funciones.FNivel;
import master.logica.clases.Escuela;
import master.logica.funciones.FEscuela;
import master.logica.clases.Facultad;
import master.logica.funciones.FFacultad;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Kleber
 */
@ManagedBean
@ViewScoped
public class NivelControlador {

    private Nivel objNivel;
    private Nivel nivelSel;
    private ArrayList<Nivel> lstNiveles;
    private ArrayList<Escuela> lstEscuelas;
    private ArrayList<Facultad> lstFacultades;
    private int valorEscuela;
    private boolean mostrarActualizar;
    private int valorESeleccionada;
    private int valorFSeleccionada;
    
    
    
    public ArrayList<Escuela> getLstEscuelas() {
        return lstEscuelas;
    }

    public void setLstEscuelas(ArrayList<Escuela> lstEscuelas) {
        this.lstEscuelas = lstEscuelas;
    }

    public ArrayList<Facultad> getLstFacultades() {
        return lstFacultades;
    }

    public void setLstFacultades(ArrayList<Facultad> lstFacultades) {
        this.lstFacultades = lstFacultades;
    }

    public int getValorFSeleccionada() {
        return valorFSeleccionada;
    }

    public void setValorFSeleccionada(int valorFSeleccionada) {
        this.valorFSeleccionada = valorFSeleccionada;
    }

    public int getValorEscuela() {
        return valorEscuela;
    }

    public void setValorEscuela(int valorEscuela) {
        this.valorEscuela = valorEscuela;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorESeleccionada() {
        return valorESeleccionada;
    }

    public void setValorESeleccionada(int valorESeleccionada) {
        this.valorESeleccionada = valorESeleccionada;
    }

    public Nivel getObjNivel() {
        return objNivel;
    }

    public void setObjNivel(Nivel objNivel) {
        this.objNivel = objNivel;
    }

    public Nivel getNivelSel() {
        return nivelSel;
    }

    public void setNivelSel(Nivel nivelSel) {
        this.nivelSel = nivelSel;
    }

    public ArrayList<Nivel> getLstNiveles() {
        return lstNiveles;
    }

    public void setLstNiveles(ArrayList<Nivel> lstNiveles) {
        this.lstNiveles = lstNiveles;
    }

    public NivelControlador() {

        this.reinit();
    }
//
//    

    private void reinit() {
        this.objNivel = new Nivel();
        this.nivelSel = new Nivel();
        this.lstNiveles = new ArrayList<Nivel>();
        this.lstEscuelas = new ArrayList<Escuela>();
        this.lstFacultades = new ArrayList<Facultad>();
        this.cargarNivel();
        this.cargarFacultad();
    }

    public void cargarNivel() {
        try {
            this.lstNiveles = FNivel.ObtenerNiveles();
            this.nivelSel = lstNiveles.get(0);
            System.out.println(lstNiveles.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarNivel dice: " + e.getMessage());
            System.out.println("private void cargarNivel dice: " + e.getMessage());
        }
    }

    private void cargarEscuela() {
        try {
            this.lstEscuelas = FEscuela.ObtenerEscuelas();
            System.out.println(lstEscuelas.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEscuela dice: " + e.getMessage());
            System.out.println("private void cargarEscuela dice: " + e.getMessage());
        }
    }

    private void cargarFacultad() {
        try {
            this.lstFacultades = FFacultad.ObtenerFacultades();
            System.out.println(lstFacultades.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
            System.out.println("private void cargarFacultad dice: " + e.getMessage());
        }
    }

    public void obtenerEscuelasDadoCodigoFacultad() {
        try {
            lstEscuelas.clear();
            lstEscuelas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(valorFSeleccionada);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
            System.out.println("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
        }
    }

    
    
    public void insertarNivel() {
        try {

            Escuela escuela = new Escuela();
            escuela.setCodigo(valorESeleccionada);
            objNivel.setCodigo_escuela(escuela);

            if (FNivel.Insertar(objNivel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoNivel.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarNivel dice: Error al guardar la información");
            } else {
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarNivel dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarNivel dice: " + e.getMessage());
            System.out.println("private void insertarNivel dice: " + e.getMessage());
        }
    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarNivel() {
        try {

            nivelSel.setCodigo_escuela(FEscuela.ObtenerEscuelaDadoCodigo(nivelSel.getCodigo_escuela().getCodigo()));

            if (FNivel.actualizar(nivelSel)) {
                nivelSel = new Nivel();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarNivel.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarNivel dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarNivel dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarNivel dice: " + e.getMessage());
            System.out.println("private void actualizarNivel dice: " + e.getMessage());
        }
    }

    public void eliminarNivel() {
        try {
            if (FNivel.eliminar(nivelSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarNivel.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarNivel dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarNivel dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarNivel dice: " + e.getMessage());
            System.out.println("private void eliminarNivel dice: " + e.getMessage());
        }

    }

}
