/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import master.logica.clases.Menu_Sitio;
import master.logica.funciones.FMenu_Sitio;
import org.apache.taglibs.standard.functions.Functions;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class IndexControlador implements Serializable {

    private ArrayList<Menu_Sitio> lstMenuSitio;
    //sesion del sitio
    @ManagedProperty(value = "#{sesionSitioDataManager}")
    private SesionSitioDataManager dmSitio;

    public IndexControlador() {
        this.cargarMenuSitio();
    }

    public SesionSitioDataManager getDmSitio() {
        return dmSitio;
    }

    public void setDmSitio(SesionSitioDataManager dmSitio) {
        this.dmSitio = dmSitio;
    }

    public ArrayList<Menu_Sitio> getLstMenuSitio() {
        return lstMenuSitio;
    }

    public void setLstMenuSitio(ArrayList<Menu_Sitio> lstMenuSitio) {
        this.lstMenuSitio = lstMenuSitio;
    }

    public void cargarMenuSitio() {
        try {
            lstMenuSitio = FMenu_Sitio.ObtenerMenuSitio();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public String cambiarPagina() {

        return "/faces" + (Functions.substring(this.dmSitio.getPaginaActual().getUrl(), 2,
                this.dmSitio.getPaginaActual().getUrl().length() - 6));
    }

}
