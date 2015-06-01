/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.CDependencia;
import master.logica.clases.Institucion;
import master.logica.funciones.CFDependencia;
import master.logica.funciones.FInstitucion;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author escorpiondj
 */
@ManagedBean
@ViewScoped
public class DependenciaC {

    private ArrayList<CDependencia> dependencias;
    private CDependencia objDependencia;
    private CDependencia objDependenciaSel;
    private ArrayList<Institucion> instituciones;
    private Institucion objInstitucionSel;

    public DependenciaC() {
        this.objDependencia = new CDependencia();
        this.objDependenciaSel = new CDependencia();
        this.objInstitucionSel = new Institucion();
        cargarDependencias();
        cargarInstituciones();
    }

    public ArrayList<CDependencia> getDependencias() {
        return dependencias;
    }

    public void setDependencias(ArrayList<CDependencia> dependencias) {
        this.dependencias = dependencias;
    }

    public CDependencia getObjDependencia() {
        return objDependencia;
    }

    public void setObjDependencia(CDependencia objDependencia) {
        this.objDependencia = objDependencia;
    }

    public CDependencia getObjDependenciaSel() {
        return objDependenciaSel;
    }

    public void setObjDependenciaSel(CDependencia objDependenciaSel) {
        this.objDependenciaSel = objDependenciaSel;
    }

    public ArrayList<Institucion> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(ArrayList<Institucion> instituciones) {
        this.instituciones = instituciones;
    }

    public Institucion getObjInstitucionSel() {
        return objInstitucionSel;
    }

    public void setObjInstitucionSel(Institucion objInstitucionSel) {
        this.objInstitucionSel = objInstitucionSel;
    }

    private void cargarDependencias() {
        try {
            this.dependencias = CFDependencia.ObtenerDependencias();
            this.objDependenciaSel = dependencias.get(0);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarDependencias() dice: " + e.getMessage());
            System.out.println("private void cargarDependencias() dice: " + e.getMessage());
        }
    }

    private void cargarInstituciones() {
        try {
            this.instituciones = FInstitucion.ObtenerInstituciones();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarInstituciones dice: " + e.getMessage());
            System.out.println("private void cargarInstituciones dice: " + e.getMessage());
        }
    }

    public void insertarDependencia() {
        try {
            this.objDependencia.setObjCodigoInstitucion(FInstitucion.ObtenerInstitucionDadoCodigo(objInstitucionSel.getCodigo()));
            if (CFDependencia.insertar(objDependencia)) {
                objDependencia = new CDependencia();
                cargarDependencias();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevaDependencia.hide()");
                Util.addSuccessMessage("Información guardada con exito");
                System.out.println("public void insertarDependencia dice: Información guardada con exito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void insertarDependencia dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarDependencia dice: " + e.getMessage());
            System.out.println("private void insertarDependencia dice: " + e.getMessage());
        }
    }

    public void editarDependencia() {
        try {
            this.objDependenciaSel.setObjCodigoInstitucion(FInstitucion.ObtenerInstitucionDadoCodigo(this.objDependenciaSel.getObjCodigoInstitucion().getCodigo()));
            if (CFDependencia.actualizar(objDependenciaSel)) {
                objDependenciaSel = new CDependencia();
                cargarDependencias();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarDependencia.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void editarDependencia dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void editarDependencia dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void editarDependencia dice: " + e.getMessage());
            System.out.println("private void editarDependencia dice: " + e.getMessage());
        }
    }

    public void eliminarDependencia() {
        try {
            if (CFDependencia.eliminar(objDependenciaSel)) {
                objDependenciaSel = new CDependencia();
                cargarDependencias();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarDependencia.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarDependencia dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarDependencia dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarDependencia dice: " + e.getMessage());
            System.out.println("private void eliminarDependencia dice: " + e.getMessage());
        }
    }

}
