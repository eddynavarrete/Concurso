/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.Pelicula_IdiomaC;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import accesodatos.AccesoDatos;
import java.sql.SQLException;
/**

/**
 *
 * @author Usuario
 */
public class Pelicula_IdiomaF {
    
    public static boolean Insertar(Pelicula_IdiomaC pelicula_idioma) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_escuela(?,?)";
            
            lstP.add(new Parametro(1, pelicula_idioma.getCodigo_pelicula().getCodigo()));
            lstP.add(new Parametro(2, pelicula_idioma.getCodigo_idioma().getCodigo()));
            
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

    public static ArrayList<Pelicula_IdiomaC> llenarPeliculaIdioma(ConjuntoResultado rs) throws Exception {
        ArrayList<Pelicula_IdiomaC> lst = new ArrayList<Pelicula_IdiomaC>();
        Pelicula_IdiomaC pelicula_idioma = null;
        try {
            while (rs.next()) {
                pelicula_idioma = new Pelicula_IdiomaC(rs.getInt("pcodigo"),PeliculaF.ObtenerPeliculaDadoCodigo(rs.getInt("pcodigo_pelicula")),IdiomaF.ObtenerIdiomaDadoCodigo(rs.getInt("pcodigo_idioma")));
                lst.add(pelicula_idioma);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Pelicula_IdiomaC> ObtenerPeliculaIdioma() throws Exception {
        ArrayList<Pelicula_IdiomaC> lst = new ArrayList<Pelicula_IdiomaC>();
        try {
            String sql = "select * from master.f_select_escuela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPeliculaIdioma(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

 
    
    
    public static Pelicula_IdiomaC ObtenerPeliculaIdiomaDadoCodigo(int codigo) throws Exception {
        Pelicula_IdiomaC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Pelicula_IdiomaC();
            lst =  llenarPeliculaIdioma(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   
    
    
    
   public static ArrayList<Pelicula_IdiomaC> ObtenerSucursalDadoCodigoTarjeta(int codigo) throws Exception {
       ArrayList<Pelicula_IdiomaC> lst = new ArrayList<Pelicula_IdiomaC>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo_facultad(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarPeliculaIdioma(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean actualizar(Pelicula_IdiomaC pelicula_idioma) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_escuela(?,?,?,?,?)";
       
           
            lstP.add(new Parametro(4, pelicula_idioma.getCodigo_pelicula().getCodigo()));
            lstP.add(new Parametro(5, pelicula_idioma.getCodigo_idioma().getCodigo()));
            
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

    public static boolean eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_delete_escuela(?)";
            lstP.add(new Parametro(1, codigo));
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
    
     

}