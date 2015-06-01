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
import actividades.logica.clases.ModalidadTutoria;
/**
 *
 * @author Janneth GS
 */
public class FModalidadTutoria {
 
    public static boolean Insertar(ModalidadTutoria modalidadtutoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_insert_modalidad_tutoria(?,?,?)";
            lstP.add(new Parametro(1, modalidadtutoria.getNombre()));
            lstP.add(new Parametro(2, modalidadtutoria.getDescripcion()));
            lstP.add(new Parametro(3, modalidadtutoria.getEstado()));
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
    
     public static ArrayList<ModalidadTutoria> llenarModalidadTutoria(ConjuntoResultado rs) throws Exception {
        ArrayList<ModalidadTutoria> lst = new ArrayList<ModalidadTutoria>();
        ModalidadTutoria modalidadtutoria = null;
        try {
            while (rs.next()) {
                modalidadtutoria = new ModalidadTutoria(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pestado"));
                lst.add(modalidadtutoria);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<ModalidadTutoria> ObtenerModalidadTutoria() throws Exception {
        ArrayList<ModalidadTutoria> lst = new ArrayList<ModalidadTutoria>();
        try {
            String sql = "select * from actividades.f_select_modalidad_tutoria()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarModalidadTutoria(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ModalidadTutoria ObtenerModalidadTutoriaDadoCodigo(int codigo) throws Exception {
        ModalidadTutoria lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_select_modalidad_tutoria_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new ModalidadTutoria();
            lst = llenarModalidadTutoria(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
 public static boolean actualizar(ModalidadTutoria modalidadtutoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_update_modalidad_tutoria((?,?,?,?)";
            lstP.add(new Parametro(1, modalidadtutoria.getNombre()));
            lstP.add(new Parametro(2, modalidadtutoria.getDescripcion()));
            lstP.add(new Parametro(3, modalidadtutoria.getEstado()));
            lstP.add(new Parametro(4, modalidadtutoria.getCodigo()));
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
    
    public static  boolean eliminar (ModalidadTutoria modalidadtutoria) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from actividades.f_delete_modalidad_tutoria(?)";
        lstP.add(new Parametro(1,modalidadtutoria.getCodigo()));
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
    
    
}
