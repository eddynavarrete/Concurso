/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import actividades.logica.clases.CausasBajoRendimiento;
import actividades.logica.clases.ModalidadTutoria;
import actividades.logica.funciones.FCausasBajoRendimiento;
import actividades.logica.funciones.FModalidadTutoria;
import planificacion.logica.clases.ActividadesPlanificadas;
import planificacion.logica.funciones.FActividadesPlanificadas;
import planificacion.presentacion.beans.ActividadesPlanificadasControladorTutor;
import java.util.ArrayList;
import master.logica.clases.Escuela;
import master.logica.clases.Estudiante;
import master.logica.clases.Facultad;
import master.logica.clases.Nivel;
import master.logica.clases.Periodos;
import master.logica.clases.Rol;
import master.logica.clases.Tutor;
import master.logica.clases.Usuario;
import master.logica.clases.UsuarioRol;
import master.logica.funciones.FTutor;
import recursos.Tools;
import javax.faces.bean.ManagedProperty;
import master.presentacion.beans.SesionUsuarioDataManager;

/**
 *
 * @author Janneth GS
 */
public class NewMain {

    /**
     * @param <error>
     * @param <error>
     * @param <error>
     * @param <error>
     * @param args the command line arguments
     */

      
    public static void main(String[] args) {
        // TODO code application logic here
//        try {
//            Facultad objet = new Facultad();
//            objet.setNombre("Facultad de Ingenieria");
//            objet.setDescripcion("Profesionales ingeniosos");
//            objet.setCodigo_sicoa(258);
//            boolean b = FFacultad.Insertar(objet);
//            System.out.println(b);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        
//        try {
//            Periodos objet = new Periodos();
//            objet.setNombre("Facultad de Ingenieria");
//            objet.setFecha_inicio(Tools.FechaDateDadoString("01/01/2014"));
//            objet.setFecha_fin(Tools.FechaDateDadoString("01/01/2014"));
//            objet.setTipo(2);
//            objet.setObservaciones("ninguna");
//            objet.setCodigo_sicoa(2002);
//            objet.setEstado(0);
//            boolean b = FPeriodos.Insertar(objet);
//            System.out.println(b);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//         try {
//            Facultad objet = new Facultad();
//            objet.setNombre("Facultad de Ingenieria 3");
//            objet.setDescripcion("Profesionales ingeniosos 3");
//            objet.setCodigo_sicoa(100);
//            objet.setCodigo(3);
//            boolean b = FFacultad.actualizar(objet);
//            System.out.println(b);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        
//           try {
//            Facultad objet = new Facultad();
//           // objet.setCodigo(3);
//            boolean b = FFacultad.eliminar(4);
//            System.out.println(b);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        
//        try {
//            Escuela objet = new Escuela();
//            Facultad facultad = new Facultad();
//            facultad.setCodigo(3);
//            objet.setCodigo_facultad(facultad);
//            objet.setNombre("Escuela de Ingenieria Ambienteal");
//            objet.setDescripcion("Ingenieros para cuidar el medio ambiente");
//            objet.setCodigo_sicoa(1006);
//            boolean b = FEscuela.Insertar(objet);
//            System.out.println(b);
//            System.out.println("Ingreso exitoso");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Error al ingreso ");
//            
//        }
//
//   }
//
//}
//            try {
//            ModalidadTutoria objet = new ModalidadTutoria();
//            objet.setNombre("Otra");
//            objet.setDescripcion("Otro tipo de modalidad acerca de la tutoria");
//            objet.setEstado(1);
//            boolean b = FModalidadTutoria.Insertar(objet);
//            System.out.println(b);
//            System.out.println("Ingreso exitoso");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Error al ingreso ");
//            
//        }    
//        try {
//            CausasBajoRendimiento objet = new CausasBajoRendimiento();
//            objet.setNombre("Otro 2");
//            objet.setDescripcion("Otro tipo de causa que no se especifica");
//            objet.setEstado(1);
//            boolean b = FCausasBajoRendimiento.Insertar(objet);
//            System.out.println(b);
//            System.out.println("Ingreso exitoso");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Error al ingreso ");
//            
//        }   
//        try {
//            Estudiante objet = new Estudiante();
//            objet.setNombre("Gissela");
//            objet.setApellido("Siguenza");
//            objet.setCedula("0602536520");
//            objet.setCodigo_sicoa(15223);
//            Periodos periodo = new Periodos();
//            periodo.setCodigo(2);
//            objet.;
//            objet.setNombre("Escuela de Ingenieria Ambienteal");
//            objet.setDescripcion("Ingenieros para cuidar el medio ambiente");
//            objet.setCodigo_sicoa(1006);
//            boolean b = FEscuela.Insertar(objet);
//            System.out.println(b);
//            System.out.println("Ingreso exitoso");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Error al ingreso ");
//            
//        }
//        try {
//            ArrayList<Escuela> lista = new ArrayList<Escuela>();
//            lista = FEscuela.ObtenerEscuelas();
//            for (Escuela escuela : lista) {
//                System.out.println(escuela.getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            Escuela obj= FEscuela.ObtenerEscuelaDadoCodigo(1);
//            System.out.println(obj.getNombre());
//                    
//        } catch (Exception e) {
//        }
        
//        try {
//            ArrayList<ActividadesPlanificadas> lista = new ArrayList<ActividadesPlanificadas>();
//            lista = FActividadesPlanificadas.ObtenerActividadesPlanificadasDadoCodigoTutor(8);
//            for (ActividadesPlanificadas ap : lista) {
//                //System.out.println(modalidadtutoria.getCodigo());
//                System.out.println(ap.getNombre());
//                //System.out.println(modalidadtutoria.getDescripcion());
//                //System.out.println(modalidadtutoria.getEstado());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
        
//        
//        try {
//            ArrayList<ModalidadTutoria> lista = new ArrayList<ModalidadTutoria>();
//            lista = FModalidadTutoria.ObtenerModalidadTutoria();
//            for (ModalidadTutoria modalidadtutoria : lista) {
//                //System.out.println(modalidadtutoria.getCodigo());
//                System.out.println(modalidadtutoria.getNombre());
//                //System.out.println(modalidadtutoria.getDescripcion());
//                //System.out.println(modalidadtutoria.getEstado());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//         try {
//            ModalidadTutoria obj= FModalidadTutoria.ObtenerModalidadTutoriaDadoCodigo(1);
//            System.out.println(obj.getNombre());
//                    
//        } catch (Exception e) {
//        }
//        try {
//            ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
//            lista = FEstudiante.ObtenerEstudiantes();
//            for (Estudiante estudiante : lista) {
//                System.out.println(estudiante.getApellido());
//                System.out.println(estudiante.getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        
//        try {
//            ArrayList<Escuela> listas = new ArrayList<Escuela>();
//            listas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(5);
//            for (Escuela estudiante : listas) {
//                System.out.println(estudiante.getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        
//        try {
//            ArrayList<Nivel> listas = new ArrayList<Nivel>();
//            listas = FNivel.ObtenerNivelesDadoCodigoEscuela(2);
//            for (Nivel nivel : listas) {
//                System.out.println(nivel.getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            ArrayList<Rol> listas = new ArrayList<Rol>();
//            listas = FRoles.ObtenerRolesDadoCodigoUsuario(22);
//            for (Rol rol : listas) {
//                System.out.println(rol.getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        
//        try {
//            Escuela obj= FEscuela.ObtenerEscuelaDadoCodigo(1);
//            System.out.println(obj.getNombre());
//                    
//        } catch (Exception e) {
//        }
//        try {
//            
//            Escuela obj= FEscuela.ObtenerEscuelaDadoCodigoFacultad(5);
//            System.out.println(obj.getNombre());
//            
//                    
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            ArrayList<Facultad> lista = new ArrayList<Facultad>();
//            lista = FFacultad.ObtenerFacultades();
//            for (Facultad facultad : lista) {
//                System.out.println(facultad.getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//                try {
//            ArrayList<Tutor> lista = new ArrayList<Tutor>();
//            lista = FTutor.ObtenerTutores();
//            for (Tutor tutor : lista) {
//                System.out.println(tutor.getCodigo());
//                System.out.println(tutor.getCodigo_nivel());
//                System.out.println(tutor.getCodigo_periodo());
//                System.out.println(tutor.getCodigo_usuario_rol());
//                
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//            
//       try {
//            
//            Escuela obj= FEscuela.ObtenerEscuelaDadoCodigoFacultad(3);
//            System.out.println(obj.getNombre());
//            
//                    
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//            
//        try {
//            ArrayList<Usuario> lista = new ArrayList<Usuario>();
//            lista = FUsuario.ObtenerUsuarios();
//            for (Usuario usuario : lista) {
//                System.out.println(usuario.getApellidos());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("no funciona");
//        }
//        
//        
//          try {
//           Usuario obj= FUsuario.ObtenerUsuarioDadoIdentificacion("0604056598");
//            System.out.println(obj.getNombres());
//              System.out.println(obj.getApellidos());
//        } catch (Exception e) {
//        }
//        try {
//            ArrayList<Periodos> lista = new ArrayList<Periodos>();
//            lista = FPeriodos.ObtenerPeriodos();
//            for (Periodos periodos : lista) {
//                System.out.println(periodos.getNombre());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            Usuario objet = new Usuario();
//
//            objet.setApellidos("Molina");
//            objet.setNombres("Fernando");
//            objet.setIdentificacion("0604032108");
//            objet.setNombre_corto("fmolina");
//            objet.setClave("fer2014");
//            objet.setClave_pregunta("ciudad de nacimiento");
//            objet.setClave_respuesta("guano");
//            objet.setMail("fmolina@unach.edu.ec");
//            objet.setEstado(1);
//            objet.setPrimer_acceso(Tools.obtieneFechaActualSegundos());
//            objet.setUtimo_acceso(Tools.obtieneFechaActualSegundos());
//            objet.setFecha_modificacion(Tools.obtieneFechaActualSegundos());
//            objet.setUltima_ip("192.168.220.35");
//            objet.setCodigo_salt("uno");
//            objet.setRuta_firma("firma");
//
//            Rol rol = new Rol();
//            rol.setCodigo(11);
//            UsuarioRol usuarioRol = new UsuarioRol();
//            usuarioRol.setCodigo_rol(rol);
//            usuarioRol.setCodigo_usuario(objet);
//            usuarioRol.setEstado(1);
//            Nivel nivel = new Nivel();
//            nivel.setCodigo(1);
//            Periodos periodo = new Periodos();
//            periodo.setCodigo(5);
//            Tutor tutor = new Tutor();
//            tutor.setCodigo_nivel(nivel);
//            tutor.setCodigo_periodo(periodo);
//            
////
////            FUsuario.Insertar(objet, usuarioRol, tutor);
////            System.out.println("ingreso correcto");
////        } catch (Exception e) {
////            System.out.println("error al ingresar");
////        }
//
    }

}
