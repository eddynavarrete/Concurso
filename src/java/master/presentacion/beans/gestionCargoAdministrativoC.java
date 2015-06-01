/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.logica.clases.*;
import master.logica.funciones.*;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
/**
 *
 * @author Javier
 */
@ManagedBean
@ViewScoped
public class gestionCargoAdministrativoC {
 
 
 private ArrayList<CCargoAdministrativo> lstCargoAdministrativos;
  private CCargoAdministrativo objCargoAdministrativo;
  private CCargoAdministrativo cargoAdministrativoSel;

    public gestionCargoAdministrativoC() {
      this.cargarCargoAdministrativo();
     this.objCargoAdministrativo= new CCargoAdministrativo();
        
    }

    public ArrayList<CCargoAdministrativo> getLstCargoAdministrativos() {
        return lstCargoAdministrativos;
    }

    public void setLstCargoAdministrativos(ArrayList<CCargoAdministrativo> lstCargoAdministrativos) {
        this.lstCargoAdministrativos = lstCargoAdministrativos;
    }

    public CCargoAdministrativo getObjCargoAdministrativo() {
        return objCargoAdministrativo;
    }

    public void setObjCargoAdministrativo(CCargoAdministrativo objCargoAdministrativo) {
        this.objCargoAdministrativo = objCargoAdministrativo;
    }

    public CCargoAdministrativo getCargoAdministrativoSel() {
        return cargoAdministrativoSel;
    }

    public void setCargoAdministrativoSel(CCargoAdministrativo cargoAdministrativoSel) {
        this.cargoAdministrativoSel = cargoAdministrativoSel;
    }

    

    
    
  public void cargarCargoAdministrativo(){
     
      try {
          this.lstCargoAdministrativos = CFCargoAdministrativo.ObtenerCargosAdministrativos();
      } catch (Exception e) {
          Util.addErrorMessage(e,"Error al acceder a la base de datos");
      }
  }
  public void insertarCargoAdminitrativo(){
//              try {
//            objPersona.setCodigo_global(0);
//            if (FPersona.insertar(objPersona) == true) {
//                
//            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Insertados");
//            FacesContext.getCurrentInstance().addMessage(null, mensaje);
//            DefaultRequestContext.getCurrentInstance().execute("wdlgAgregarPersona.hide()");  
//            this.cargarPersonas();
//            this.objPersona = new CPais();
//            } else {
//                FacesMessage mensajeError=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no se Insertó");
//                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
//            }
//        } catch (Exception e) {
//             FacesMessage mensajeErrorIngreso=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
//            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
//        }      
  }
  
   public void actualizarCargoAdminitrativo (){
//     try {
//         personaSel.set(0);
//         if (FPersona.actualizar(personaSel)) {
//               FacesMessage mensajeActualizacion=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Actualizados");
//                FacesContext.getCurrentInstance().addMessage(null,mensajeActualizacion);
//                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarPersona.hide()");             
//         } else {
//              FacesMessage mensajeErrorActualizacion=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no Actualizados");
//             FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
//         }
//         
//     } catch (Exception e) {
//          FacesMessage mensajeErrorA=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
//            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
//     }           
} 

   public void eliminarCargoAdminitrativo (){
//    try {
//        if (FPersona.eliminar(personaSel.getCodigo_persona())) {       
//          FacesMessage mensajeEliminar=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Eliminados");
//          FacesContext.getCurrentInstance().addMessage(null,mensajeEliminar);
//          DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPersona.hide()");
//          this.cargarPersonas();
//            
//        } else {
//             FacesMessage mensajeErrorEliminar=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no se Eliminó");
//             FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);            
//        }
//    } catch (Exception e) {
//           FacesMessage mensajeErrorE=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
//            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
//    }     
}   
}//Cierrala clase

