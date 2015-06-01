/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package master.logica.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.Tutor;
import master.logica.clases.Nivel;
import master.logica.clases.Periodos;
import master.logica.clases.UsuarioRol;
/**
 *
 * @author Janneth GS
 */
public class FTutor {
  
    public static boolean Insertar(Tutor tutor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_tutor(?,?,?)";
            lstP.add(new Parametro(1, tutor.getCodigo_nivel().getCodigo()));
            lstP.add(new Parametro(2, tutor.getCodigo_periodo().getCodigo()));
            lstP.add(new Parametro(3, tutor.getCodigo_usuario_rol().getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
     public static boolean actualizar(Tutor tutor) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_tutor(?,?,?,?)";
            lstP.add(new Parametro(1, tutor.getCodigo_nivel().getCodigo()));
            lstP.add(new Parametro(2, tutor.getCodigo_periodo().getCodigo()));
            lstP.add(new Parametro(3, tutor.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(4, tutor.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
     
    public static long ObtenerCodigoTutorDadoIdentificacionUsuario(String identificacion) throws Exception {
        {
            long codigoTutor = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_tutor_dado_identificacion_retorna_cod_tutor(?)";
            lstP.add(new Parametro(1, identificacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while(rs.next() )
            {
              if(rs.getLong(0) >0 );
                   codigoTutor = rs.getLong(0);
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return codigoTutor;
    } 
    }
     
    public static  boolean eliminar (int codigo) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master.f_delete_tutor(?)";
        lstP.add(new Parametro(1,codigo));
        ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
        while(rs.next() )
            {
              if(rs.getString(0).equals("true"));
                   eje=true;
            }
            } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return eje;
    }
    
    
     public static ArrayList<Tutor> llenarTutor(ConjuntoResultado rs) throws Exception {
        ArrayList<Tutor> lst = new ArrayList<Tutor>();
        Tutor tutor = null;
        try {
            while (rs.next()) {
                tutor = new Tutor(rs.getInt("pcodigo"),FNivel.ObtenerNivelDadoCodigo(rs.getInt("pcodigo_nivel")), FPeriodos.ObtenerPeriodoDadoCodigo(rs.getInt("pcodigo_periodo")), FUsuarioRol.obtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")));
                lst.add(tutor);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
     
 

    public static ArrayList<Tutor> ObtenerTutores() throws Exception {
        ArrayList<Tutor> lst = new ArrayList<Tutor>();
        try {
            String sql = "select * from master.f_select_tutor()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTutor(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Tutor ObtenerTutorDadoCodigo(long codigo) throws Exception {
        Tutor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_tutor_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Tutor();
            lst = llenarTutor(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    
    public static Tutor ObtenerTutorDadoCodigoNivel(int codigo) throws Exception {
       Tutor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_tutor_dado_codigo_nivel(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarTutor(rs).get(0);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
     public static Tutor ObtenerTutorDadoUsuarioRol(int codigo_usuario_rol) throws Exception {
       Tutor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_tutor_dado_codigo_usuario_rol(?)";
            lstP.add(new Parametro(1, codigo_usuario_rol));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarTutor(rs).get(0);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
   
    
     public static Tutor ObtenerTutorDadoCodigoNivelPeriodo(int codigo_nivel, int codigo_periodo) throws Exception {
       Tutor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  master.f_select_tutor_dado_codigo_nivel_periodo(?,?)";
            lstP.add(new Parametro(1, codigo_nivel));
            lstP.add(new Parametro(2, codigo_periodo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarTutor(rs).get(0);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
     
     
public static Tutor ObtenerCodigoTutorDadoIdentificacion(String identificacion) throws Exception {
        Tutor lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_tutor_dado_identificacion(?)";
            lstP.add(new Parametro(1, identificacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Tutor();
            lst = llenarTutor(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }           
            
 
//   public static ArrayList<Tutor> ObtenerCodigoTutorDadoIdentificacion(String identificacion) throws Exception {
//        ArrayList<Tutor> lst = new ArrayList<Tutor>();
//        try {
//            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
//            String sql = "select * from master.f_select_tutor_dado_identificacion(?)";
//            lstP.add(new Parametro(1, identificacion));
//            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
//            lst = llenarTutor(rs);
//            rs = null;
//
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return lst;
//    }




//    public static Tutor ObtenerUsuarioDadoCodigoTutor(int codigo) throws Exception {
//        Tutor lst;
//        try {
//            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
//            String sql = "select * from master.f_select_usuario_dado_codigo_tutor(?)";
//            lstP.add(new Parametro(1, codigo));
//            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
//            lst = new Tutor();
//            lst = llenarTutor(rs).get(0);
//            rs = null;
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return lst;
//    }
//    
    
}
