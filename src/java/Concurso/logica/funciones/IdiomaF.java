/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.IdiomaC;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import accesodatos.AccesoDatos;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class IdiomaF {
    
    public static boolean Insertar(IdiomaC idioma) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_accion(?,?)";
            lstP.add(new Parametro(1, idioma.getNombre()));
            
            
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

    public static ArrayList<IdiomaC> llenarIdioma(ConjuntoResultado rs) throws Exception {
        ArrayList<IdiomaC> lst = new ArrayList<IdiomaC>();
        IdiomaC idioma = null;
        try {
            while (rs.next()) {
                idioma = new IdiomaC(rs.getInt("pcodigo"), rs.getString("pnombre"));
                lst.add(idioma);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<IdiomaC> ObtenerIdioma() throws Exception {
        ArrayList<IdiomaC> lst = new ArrayList<IdiomaC>();
        try {
            
            //consulta Postgres ojo
            String sql = "select * from master.f_select_acciones()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarIdioma(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static IdiomaC ObtenerIdiomaDadoCodigo(int codigo) throws Exception {
        IdiomaC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            //consulta postgres ojo
            String sql = "select * from master.f_select_acciones_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new IdiomaC();
            lst = llenarIdioma(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(IdiomaC ciudad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            //consulta postgres ojo
            String sql = "select * from master.f_update_accion(?)";
            lstP.add(new Parametro(1, ciudad.getNombre()));
            
            
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
        //consulta postgres ojo
        String sql = "select * from master.f_delete_accion(?)";
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
}