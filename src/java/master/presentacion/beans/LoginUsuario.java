/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Usuario;
import master.logica.funciones.*;
import recursos.Util;
import java.util.Date;
import recursos.Tools;

/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class LoginUsuario {

    Usuario usuario;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    public LoginUsuario() {
        usuario = new Usuario();
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String login() {
        ResourceBundle recurso = ResourceBundle.getBundle("/recursos/mensajesSeguridad");
        try {
            this.dm.setSesionUsuario(FUsuario.autenticarUsuario(this.usuario.getIdentificacion(), this.usuario.getClave()));
            if (this.dm.getSesionUsuario() != null) {
                //this.dm.setSesionPersona(FUsuarioPersona.obtenerUsuarioPersonaDadoCodigoUsuario(this.dm.getSesionUsuario().getCodigo()));
                this.dm.setSesionUsuarioRoles(FUsuarioRol.obtenerRolesDadoUsuario(this.dm.getSesionUsuario().getCodigo()));
                this.dm.setSesionPeriodos(FPeriodos.ObtenerPeriodoActual());
                
               // this.dm.setIntSesionTutor(FTutor.ObtenerCodigoTutorDadoIdentificacionUsuario(this.dm.getSesionUsuario().getIdentificacion()));
                //this.dm.setSesionTutor(FTutor.ObtenerCodigoTutorDadoIdentificacion(this.dm.getSesionUsuario().getIdentificacion()));
                
                
                this.dm.setValidado(Boolean.TRUE);
                if (this.dm.getSesionUsuarioRoles().isEmpty()) {
                    Util.addErrorMessage("El usuario no tiene perfiles asignados, comuniquese con el administrador del sistema");
                    return "/login";
                }
                
               
                
                
                
                this.dm.setSesionUsuarioRolActual(this.dm.getSesionUsuarioRoles().get(0));
                this.dm.setSesionPeriodoActual(this.dm.getSesionPeriodos().get(0));
                this.dm.setSesionTutorActual(this.dm.getSesionTutor());
                
                
            //    FTutor.ObtenerCodigoTutorDadoIdentificacionUsuario(this.usuario);
                //this.dm.setSesionTutorActual(FTutor.ObtenerTutorDadoUsuarioRol(this.dm.getSesionUsuarioRolActual().getCodigo()));
              //this.dm.setIntSesionTutor(this.dm.getIntSesionTutor());
                //this.dm.getSesionUsuario().setUtimo_acceso(Tools.obtieneFechaActualSegundos()); //gettime devuelve el dato en long
                
              
              
              
              
              
              FUsuario.actualizarUltimoAccesoUsuario(Tools.obtieneFechaActualSegundos(), this.dm.getSesionUsuario().getCodigo());

                FNodoMenu objMenu = new FNodoMenu();
                this.dm.setMenu(objMenu.generarMenuUsuario(this.dm.getSesionUsuarioRolActual().getCodigo_rol().getCodigo())); //menu de usuario, arrays list
                this.dm.setPaginaActual("home.xhtml");

                return "/seguridad/index?faces-redirect=true"; // forzando q vaya a la parte interna/segura del sitio
            } else {
                Util.addErrorMessage(null, recurso.getString("login"));
                this.dm.setValidado(Boolean.FALSE);
                return "/login";
            }
        } catch (Exception e) {
            Util.addErrorMessage(e, String.format(recurso.getString("errorCatch"), "Autentificacion"));
            return "/login";
        }

    }

    public String cerrarSesion() {
        this.dm.destroy();
        return "/index.xhtml?faces-redirect=true";

    }
}
