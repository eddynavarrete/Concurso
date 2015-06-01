/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.logica.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import actividades.logica.clases.EncabezadoTutoria;
import master.logica.funciones.FTutor;
import actividades.logica.clases.ModalidadTutoria;
/**
 *
 * @author Janneth GS
 */
public class FEncabezadoTutoria {
   
    public static boolean Insertar(EncabezadoTutoria encabezadotutoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_insert_encabezado_tutoria(?,?,?,?)";
            lstP.add(new Parametro(1, encabezadotutoria.getFecha()));
            lstP.add(new Parametro(2, encabezadotutoria.getActividad()));
            lstP.add(new Parametro(3, encabezadotutoria.getCodigo_tutor().getCodigo()));
            lstP.add(new Parametro(4, encabezadotutoria.getCodigo_modalidad_tutoria().getCodigo()));
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
    
    public static boolean actualizar(EncabezadoTutoria encabezadotutoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_update_encabezado_tutoria(?,?,?,?,?)";
            lstP.add(new Parametro(1, encabezadotutoria.getFecha()));
            lstP.add(new Parametro(2, encabezadotutoria.getActividad()));
            lstP.add(new Parametro(3, encabezadotutoria.getCodigo_tutor().getCodigo()));
            lstP.add(new Parametro(4, encabezadotutoria.getCodigo_modalidad_tutoria().getCodigo()));
            lstP.add(new Parametro(5, encabezadotutoria.getCodigo()));
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
        String sql = "select * from actividades.f_delete_encabezado_tutoria(?)";
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
    
    
    public static ArrayList<EncabezadoTutoria> llenarEncabezadoTutoria(ConjuntoResultado rs) throws Exception {
        ArrayList<EncabezadoTutoria> lst = new ArrayList<EncabezadoTutoria>();
        EncabezadoTutoria encabezadotutoria = null;
        try {
            while (rs.next()) {
                encabezadotutoria = new EncabezadoTutoria(rs.getInt("pcodigo"), rs.getDate("pfecha"), rs.getString("pactividad"), FTutor.ObtenerTutorDadoCodigo(rs.getInt("pcodigo_tutor")), FModalidadTutoria.ObtenerModalidadTutoriaDadoCodigo(rs.getInt("pcodigo_modalidad_tutor")));
                lst.add(encabezadotutoria);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<EncabezadoTutoria> ObtenerEncabezadoTutoria() throws Exception {
        ArrayList<EncabezadoTutoria> lst = new ArrayList<EncabezadoTutoria>();
        try {
            String sql = "select * from actividades.f_select_encabezado_tutoria()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEncabezadoTutoria(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static EncabezadoTutoria ObtenerEncabezadoTutoriaDadoCodigo(int codigo) throws Exception {
        EncabezadoTutoria lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_select_encabezado_tutoria_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new EncabezadoTutoria();
            lst = llenarEncabezadoTutoria(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
       
    
    public static  ArrayList<EncabezadoTutoria> ObtenerEncabezadoTutoriaDadoCodigoTutor(long codigo) throws Exception {
        ArrayList<EncabezadoTutoria> lst = new  ArrayList<EncabezadoTutoria>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_select_encabezado_tutoria_dado_codigo_tutor(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEncabezadoTutoria(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
}
