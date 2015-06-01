/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Escuela;
import master.logica.clases.Facultad;
import master.logica.clases.Nivel;
import master.logica.clases.Periodos;
import master.logica.clases.Rol;
import master.logica.clases.Tutor;
import master.logica.clases.Usuario;
import master.logica.clases.UsuarioRol;
import master.logica.funciones.FEscuela;
import master.logica.funciones.FFacultad;
import master.logica.funciones.FNivel;
import master.logica.funciones.FPeriodos;
import master.logica.funciones.FRoles;
import master.logica.funciones.FTutor;
import master.logica.funciones.FUsuario;
import master.logica.funciones.FUsuarioRol;
import org.primefaces.context.DefaultRequestContext;
import recursos.Tools;
import recursos.Util;
/**
 *
 * @author Janneth GS
 */
@ManagedBean
@ViewScoped

public class TutorConsulta1Controlador {

    private Tutor objTutor;
    private Tutor objTutorBuscar;
    private Tutor tutorSel;
    private Usuario objUsuarioBuscar;
    private Usuario objUsuario;
    private Nivel nivel;
    private Periodos periodos;
    private Rol roles;
    private UsuarioRol objUsuarioRol;
    private ArrayList<Tutor> lstTutor;
    private ArrayList<Nivel> lstNiveles;
    private ArrayList<Periodos> lstPeriodos;
    private ArrayList<UsuarioRol> lstUsuarioRol;
    private ArrayList<Usuario> lstUsuario;
    private ArrayList<Escuela> lstEscuelas;
    private ArrayList<Facultad> lstFacultades;
    private ArrayList<Rol> lstRoles;
    private boolean mostrarActualizar;
    private int valorPSeleccionado;
    private int valorNSeleccionado;
    private int valorRSeleccionado;
    private int valorESeleccionada;
    private int valorFSeleccionada; 
    private int valorUSeleccionado;
    private int valorURSeleeccionado;
    private String valorIdentificacion;

    public int getValorURSeleeccionado() {
        return valorURSeleeccionado;
    }

    public void setValorURSeleeccionado(int valorURSeleeccionado) {
        this.valorURSeleeccionado = valorURSeleeccionado;
    }

    public Rol getRoles() {
        return roles;
    }

    public void setRoles(Rol roles) {
        this.roles = roles;
    }

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public UsuarioRol getObjUsuarioRol() {
        return objUsuarioRol;
    }

    public void setObjUsuarioRol(UsuarioRol objUsuarioRol) {
        this.objUsuarioRol = objUsuarioRol;
    }

    public Usuario getObjUsuarioBuscar() {
        return objUsuarioBuscar;
    }

    public void setObjUsuarioBuscar(Usuario objUsuarioBuscar) {
        this.objUsuarioBuscar = objUsuarioBuscar;
    }

  
    public String getValorIdentificacion() {
        return valorIdentificacion;
    }

    public void setValorIdentificacion(String valorIdentificacion) {
        this.valorIdentificacion = valorIdentificacion;
    }
   
    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Periodos getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Periodos periodos) {
        this.periodos = periodos;
    }

    public Tutor getObjTutorBuscar() {
        return objTutorBuscar;
    }

    public void setObjTutorBuscar(Tutor objTutorBuscar) {
        this.objTutorBuscar = objTutorBuscar;
    }

    public int getValorRSeleccionado() {
        return valorRSeleccionado;
    }

    public void setValorRSeleccionado(int valorRSeleccionado) {
        this.valorRSeleccionado = valorRSeleccionado;
    }

    public ArrayList<Rol> getLstRoles() {
        return lstRoles;
    }

    public void setLstRoles(ArrayList<Rol> lstRoles) {
        this.lstRoles = lstRoles;
    }

    public int getValorUSeleccionado() {
        return valorUSeleccionado;
    }

    public void setValorUSeleccionado(int valorUSeleccionado) {
        this.valorUSeleccionado = valorUSeleccionado;
    }

    public ArrayList<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(ArrayList<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    
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

    public int getValorESeleccionada() {
        return valorESeleccionada;
    }

    public void setValorESeleccionada(int valorESeleccionada) {
        this.valorESeleccionada = valorESeleccionada;
    }

    public int getValorFSeleccionada() {
        return valorFSeleccionada;
    }

    public void setValorFSeleccionada(int valorFSeleccionada) {
        this.valorFSeleccionada = valorFSeleccionada;
    }
    
    public ArrayList<Nivel> getLstNiveles() {
        return lstNiveles;
    }

    public void setLstNiveles(ArrayList<Nivel> lstNiveles) {
        this.lstNiveles = lstNiveles;
    }

    public ArrayList<Periodos> getLstPeriodos() {
        return lstPeriodos;
    }

    public void setLstPeriodos(ArrayList<Periodos> lstPeriodos) {
        this.lstPeriodos = lstPeriodos;
    }

    public ArrayList<UsuarioRol> getLstUsuarioRol() {
        return lstUsuarioRol;
    }

    public void setLstUsuarioRol(ArrayList<UsuarioRol> lstUsuarioRol) {
        this.lstUsuarioRol = lstUsuarioRol;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorPSeleccionado() {
        return valorPSeleccionado;
    }

    public void setValorPSeleccionado(int valorPSeleccionado) {
        this.valorPSeleccionado = valorPSeleccionado;
    }

    public int getValorNSeleccionado() {
        return valorNSeleccionado;
    }

    public void setValorNSeleccionado(int valorNSeleccionado) {
        this.valorNSeleccionado = valorNSeleccionado;
    }

    public Tutor getObjTutor() {
        return objTutor;
    }

    public void setObjTutor(Tutor objTutor) {
        this.objTutor = objTutor;
    }

    public Tutor getTutorSel() {
        return tutorSel;
    }

    public void setTutorSel(Tutor tutorSel) {
        this.tutorSel = tutorSel;
    }

    public ArrayList<Tutor> getLstTutor() {
        return lstTutor;
    }

    public void setLstTutor(ArrayList<Tutor> lstTutor) {
        this.lstTutor = lstTutor;
    }
        
    
     public TutorConsulta1Controlador() {
        this.reinit();
    }
//
 
     
     
     private void reinit(){
        this.objTutor = new Tutor();
        this.tutorSel = new Tutor();
        this.objTutorBuscar = new Tutor();
        this.objUsuarioBuscar = new Usuario();
        this.objUsuario = new Usuario();
        this.objUsuarioRol = new UsuarioRol();
        this.lstTutor = new ArrayList<Tutor>();
        this.lstNiveles = new ArrayList<Nivel>();
        this.lstPeriodos = new ArrayList<Periodos>();
        this.lstUsuarioRol = new ArrayList<UsuarioRol>();
        this.lstUsuario = new ArrayList<Usuario>();
        this.lstEscuelas = new ArrayList<Escuela>();
        this.lstFacultades = new ArrayList<Facultad>();
        this.lstRoles = new ArrayList<Rol>();
        //this.tutorSel = this.lstTutor.get(0);
        this.cargarTutor();
        //this.cargarNiveles();
        this.cargarPeriodos();
        //this.cargarUsuarioRol();
        this.cargarFacultad();
        this.cargarUsuarios();
//        this.obtenerEscuelasDadoCodigoFacultad();
//        this.obtenerNivelDadoCodigoEscuela();
//        this.obtenerRolesDadoCodigoUsuario();
        this.cargarRoles();
    }
      
      public void cargarTutor() {
        try {
            this.lstTutor= FTutor.ObtenerTutores();
            this.tutorSel = lstTutor.get(0);
            System.out.println(lstTutor.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarTutor dice: " + e.getMessage());
            System.out.println("private void cargarTutor dice: " + e.getMessage());
        }
     }
      
      
      
         public void cargarRoles() {
        try {
            this.lstRoles= FRoles.ObtenerRoles();
            System.out.println(lstRoles.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarRoles dice: " + e.getMessage());
            System.out.println("private void cargarRoles dice: " + e.getMessage());
        }
     }
      
//    private void cargarNiveles(){
//        try {
//            this.lstNiveles = FNivel.ObtenerNiveles();
//            System.out.println(lstNiveles.get(0).getNombre());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarNiveles dice: " + e.getMessage());
//            System.out.println("private void cargarNiveles dice: " + e.getMessage());
//            }
//        }  
      
      
//    private void cargarEscuela() {
//        try {
//            this.lstEscuelas = FEscuela.ObtenerEscuelas();
//            System.out.println(lstEscuelas.get(0).getNombre());
//        } catch (Exception e) {
//            Util.addErrorMessage("private void cargarEscuela dice: " + e.getMessage());
//            System.out.println("private void cargarEscuela dice: " + e.getMessage());
//        }
//    }

    private void cargarFacultad() {
        try {
            this.lstFacultades = FFacultad.ObtenerFacultades();
            System.out.println(lstFacultades.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
            System.out.println("private void cargarFacultad dice: " + e.getMessage());
        }
    }
    
    
    private void cargarPeriodos(){
        try {
            this.lstPeriodos = FPeriodos.ObtenerPeriodos();
            System.out.println(lstPeriodos.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarPeriodos dice: " + e.getMessage());
            System.out.println("private void cargarPeriodos dice: " + e.getMessage());
            }
        }  
    
    
    private void cargarUsuarios(){
        try {
            this.lstUsuario = FUsuario.ObtenerUsuarios();
            System.out.println(lstUsuario.get(0).getNombres());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarUsuarios dice: " + e.getMessage());
            System.out.println("private void cargarUsuarios dice: " + e.getMessage());
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
     
        public void obtenerNivelDadoCodigoEscuela() {
        try {
            lstNiveles.clear();
            lstNiveles = FNivel.ObtenerNivelesDadoCodigoEscuela(valorESeleccionada);
        } catch (Exception e) {
            Util.addErrorMessage("private void obtenerNivelDadoCodigoEscuela: " + e.getMessage());
            System.out.println("private void obtenerNivelDadoCodigoEscuela: " + e.getMessage());
        }
    }
        
        
        public void obtenerRolesDadoCodigoUsuario() {
        try {
            lstRoles.clear();
            lstRoles = FRoles.ObtenerRolesDadoCodigoUsuario(valorUSeleccionado);
        } catch (Exception e) {
            Util.addErrorMessage("private void obtenerRolesDadoCodigoUsuario: " + e.getMessage());
            System.out.println("private void obtenerRolesDadoCodigoUsuario: " + e.getMessage());
        }
    }
        
        
         public void obtenerUsuariosRolesDadoCodigoUsuario() {
        try {
            lstUsuarioRol.clear();
            lstUsuarioRol = FUsuarioRol.obtenerRolesDadoUsuario(valorUSeleccionado);
        } catch (Exception e) {
            Util.addErrorMessage("private void obtenerRolesDadoCodigoUsuario: " + e.getMessage());
            System.out.println("private void obtenerRolesDadoCodigoUsuario: " + e.getMessage());
        }
    }
        
        
        public void buscarTutor() {
            try {
                
                  //objTutor = null;
                objTutorBuscar = FTutor.ObtenerTutorDadoCodigoNivel(valorNSeleccionado);
                if (objTutorBuscar != null) {
                        DefaultRequestContext.getCurrentInstance().execute("dlgBuscarTutor.hide()");
                } else {
                    Util.addSuccessMessage("Datos no encontrados");
                        System.out.println("public void buscarTutor dice:No existen datos del tutor asignado");
                        objTutorBuscar = null;
                    }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
        
        
         public void buscarTutorDadoNivelYPeriodo() {
            try {
                objTutorBuscar = new Tutor();
                  //objTutor = null;
                objTutorBuscar = FTutor.ObtenerTutorDadoCodigoNivelPeriodo(valorNSeleccionado,valorPSeleccionado);
                if (objTutorBuscar != null) {
                        DefaultRequestContext.getCurrentInstance().execute("dlgBuscarTutor.hide()");
                } else {
                    objTutorBuscar = null; 
                    DefaultRequestContext.getCurrentInstance().execute("dlgBuscarTutor.hide()");
                    //Util.addSuccessMessage("Datos no encontrados");
                       // System.out.println("public void buscarTutorDadoNivelYPeriodo dice:No existen datos del tutor asignado");
                       
                    }
                 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
        
         public void buscarUsuarioDadoIdentificacion() {
            try {
                
                  //objTutor = null;
                objUsuarioBuscar = FUsuario.ObtenerUsuarioDadoIdentificacion(valorIdentificacion);
//                if (objUsuarioBuscar != null) {
//                        DefaultRequestContext.getCurrentInstance().execute("dlgBuscarUsuario.hide()");
//                } else {
//                    Util.addSuccessMessage("Datos no encontrados");
//                        System.out.println("public void buscarUsuarioDadoIdentificacion dice:No existen datos del tutor asignado");
//                        objUsuarioBuscar = null;
//                    }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
            
        public void insertarUsuario_UsuarioRol_Tutor() {
        try {
            

           //this.reinit();
            
            objUsuario.setUltima_ip("127.0.0.1");
            objUsuario.setCodigo_salt("unach2014");
            objUsuario.setRuta_firma("firma");
            objUsuario.setPrimer_acceso(Tools.obtieneFechaActualSegundos());
            objUsuario.setUtimo_acceso(Tools.obtieneFechaActualSegundos());
            objUsuario.setFecha_modificacion(Tools.obtieneFechaActualSegundos()); 
            
            objUsuarioRol.setEstado(0);
            
            Rol roles = new Rol();
            roles.setCodigo(valorRSeleccionado);
            objUsuarioRol.setCodigo_rol(roles);
            
            Nivel nivel = new Nivel();
            nivel.setCodigo(valorNSeleccionado);
            objTutor.setCodigo_nivel(nivel);
            
            Periodos periodos = new Periodos();
            periodos.setCodigo(valorPSeleccionado);
            objTutor.setCodigo_periodo(periodos);
            

            FUsuario.InsertarTutor(objUsuario, objUsuarioRol, objTutor);
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoTutor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarTutor dice: " + e.getMessage());
            System.out.println("private void insertarTutor dice: " + e.getMessage());
                }
        }
        
    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }

    public void actualizarTutor() {
        try {
            
            tutorSel.setCodigo_nivel(FNivel.ObtenerNivelDadoCodigo(valorNSeleccionado));
            tutorSel.setCodigo_periodo(FPeriodos.ObtenerPeriodoDadoCodigo(valorPSeleccionado));
            tutorSel.setCodigo_usuario_rol(FUsuarioRol.obtenerUsuarioRolDadoCodigo(valorURSeleeccionado));
            
            
            if (FTutor.actualizar(tutorSel)){
                
                mostrarActualizar = false;
                this.reinit();
                tutorSel = new Tutor();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarTutor.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarTutor dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarTutor dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarTutor dice: " + e.getMessage());
            System.out.println("private void actualizarTutor dice: " + e.getMessage());
        }
    }

    public void eliminarTutor() {
        try {
            if (FTutor.eliminar((int) tutorSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarTutor.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarTutor dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarTutor dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarTutor dice: " + e.getMessage());
            System.out.println("private void eliminarTutor dice: " + e.getMessage());
        }
        
    }  
    
   
}

