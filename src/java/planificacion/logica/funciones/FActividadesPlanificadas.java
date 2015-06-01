/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planificacion.logica.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FTutor;
import planificacion.logica.clases.ActividadesPlanificadas;
/**
 *
 * @author Janneth GS
 */
public class FActividadesPlanificadas {
  
      public static boolean Insertar(ActividadesPlanificadas actividadesplanificadas) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from planificacion.f_insert_actividades_planificadas(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, actividadesplanificadas.getNombre()));
            lstP.add(new Parametro(2, actividadesplanificadas.getDescripcion()));
            lstP.add(new Parametro(3, actividadesplanificadas.getFecha()));
            lstP.add(new Parametro(4, actividadesplanificadas.getObservacion()));
            lstP.add(new Parametro(5, actividadesplanificadas.getEstado()));
            lstP.add(new Parametro(6, actividadesplanificadas.getCodigo_tutor().getCodigo()));
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
    
     public static boolean actualizar(ActividadesPlanificadas actividadesplanificadas) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from planificacion.f_update_actividades_planificadas(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, actividadesplanificadas.getNombre()));
            lstP.add(new Parametro(2, actividadesplanificadas.getDescripcion()));
            lstP.add(new Parametro(3, actividadesplanificadas.getFecha()));
            lstP.add(new Parametro(4, actividadesplanificadas.getObservacion()));
            lstP.add(new Parametro(5, actividadesplanificadas.getEstado()));
            lstP.add(new Parametro(6, actividadesplanificadas.getCodigo_tutor().getCodigo()));
            lstP.add(new Parametro(7, actividadesplanificadas.getCodigo()));
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
    
    public static  boolean eliminar (int codigo) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from planificacion.f_delete_actividades_planificadas(?)";
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
    
     public static ArrayList<ActividadesPlanificadas> llenarActividadesPlanificadas(ConjuntoResultado rs) throws Exception {
        ArrayList<ActividadesPlanificadas> lst = new ArrayList<ActividadesPlanificadas>();
        ActividadesPlanificadas actividadesplanificadas = null;
        try {
            while (rs.next()) {
                actividadesplanificadas = new ActividadesPlanificadas(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getDate("pfecha"), 
                        rs.getString("pobservacion"), rs.getInt("pestado"), FTutor.ObtenerTutorDadoCodigo(rs.getInt("pcodigo_tutor")));
                lst.add(actividadesplanificadas);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<ActividadesPlanificadas> ObtenerActividadesPlanificadas() throws Exception {
        ArrayList<ActividadesPlanificadas> lst = new ArrayList<ActividadesPlanificadas>();
        try {
            String sql = "select * from planificacion.f_select_actividades_planificadas()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarActividadesPlanificadas(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    
    public static ActividadesPlanificadas ObtenerActividadesPlanificadasDadoCodigo(int codigo) throws Exception {
        ActividadesPlanificadas lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from planificacion.f_select_actividades_planificadas_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new ActividadesPlanificadas();
            lst = llenarActividadesPlanificadas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    
      public static  ArrayList<ActividadesPlanificadas> ObtenerActividadesPlanificadasDadoCodigoTutor(long codigo) throws Exception {
        ArrayList<ActividadesPlanificadas> lst = new  ArrayList<ActividadesPlanificadas>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from planificacion.f_select_actividades_planificadas_dado_codigo_tutor(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarActividadesPlanificadas(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    
    
  
}
