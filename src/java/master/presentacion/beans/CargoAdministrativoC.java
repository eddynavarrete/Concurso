/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.CCargoAdministrativo;
import master.logica.funciones.CFCargoAdministrativo;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author escorpiondj
 */
@ManagedBean
@ViewScoped


public class CargoAdministrativoC {

    private CCargoAdministrativo objCargoAdministrativo;
    private CCargoAdministrativo objCargoAdministrativoSel;
    private ArrayList<CCargoAdministrativo> lstCargosAdministrativos;

    public CargoAdministrativoC() {
        this.reinit();
    }

    private void reinit() {
        this.objCargoAdministrativo = new CCargoAdministrativo();
        this.objCargoAdministrativoSel = new CCargoAdministrativo();
        this.cargarCargosAdministrativos();
        this.objCargoAdministrativoSel = this.lstCargosAdministrativos.get(0);
    }

    public CCargoAdministrativo getObjCargoAdministrativo() {
        return objCargoAdministrativo;
    }

    public void setObjCargoAdministrativo(CCargoAdministrativo objCargoAdministrativo) {
        this.objCargoAdministrativo = objCargoAdministrativo;
    }

    public CCargoAdministrativo getObjCargoAdministrativoSel() {
        return objCargoAdministrativoSel;
    }

    public void setObjCargoAdministrativoSel(CCargoAdministrativo objCargoAdministrativoSel) {
        this.objCargoAdministrativoSel = objCargoAdministrativoSel;
    }

    public ArrayList<CCargoAdministrativo> getLstCargosAdministrativos() {
        return lstCargosAdministrativos;
    }

    public void setLstCargosAdministrativos(ArrayList<CCargoAdministrativo> lstCargosAdministrativos) {
        this.lstCargosAdministrativos = lstCargosAdministrativos;
    }

    private void cargarCargosAdministrativos() {
        try {
            this.lstCargosAdministrativos = CFCargoAdministrativo.ObtenerCargosAdministrativos();
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarCargosAdministrativos dice: " + e.getMessage());
            System.out.println("private void cargarCargosAdministrativos dice: " + e.getMessage());
        }
    }

    public void insertarCargoAdministrativo() {
        try {
            if (CFCargoAdministrativo.insertar(objCargoAdministrativo)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoCargoAdministrativo.hide()");
                Util.addSuccessMessage("Información guardada con exito");
                System.out.println("public void insertarCargoAdministrativo dice: Información guardada con exito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void insertarCargoAdministrativo dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarCargoAdministrativo dice: " + e.getMessage());
            System.out.println("private void insertarCargoAdministrativo dice: " + e.getMessage());
        }
    }

    public void actualizarCargoAdministrativo() {
        try {
            if (CFCargoAdministrativo.actualizar(objCargoAdministrativoSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarCargoAdministrativo.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarCargoAdministrativo dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarCargoAdministrativo dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarCargoAdministrativo dice: " + e.getMessage());
            System.out.println("private void actualizarCargoAdministrativo dice: " + e.getMessage());
        }
    }

    public void eliminarCargoAdministrativo() {
        try {
            if (CFCargoAdministrativo.eliminar(objCargoAdministrativoSel)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarCargoAdministrativo.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarCargoAdministrativo dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarCargoAdministrativo dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarCargoAdministrativo dice: " + e.getMessage());
            System.out.println("private void eliminarCargoAdministrativo dice: " + e.getMessage());
        }
    }
}
