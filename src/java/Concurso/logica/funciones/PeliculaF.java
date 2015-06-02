/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.PeliculaC;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import accesodatos.AccesoDatos;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */
public class PeliculaF {
    public static boolean Insertar(PeliculaC pelicula) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_escuela(?,?,?,?)";
            
            lstP.add(new Parametro(1, pelicula.getNombre()));
            lstP.add(new Parametro(2, pelicula.getDuracion()));
            lstP.add(new Parametro(3, pelicula.getCensura()));
            lstP.add(new Parametro(4, pelicula.getCodigo_tipo().getCodigo()));
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

    public static ArrayList<PeliculaC> llenarPelicula(ConjuntoResultado rs) throws Exception {
        ArrayList<PeliculaC> lst = new ArrayList<PeliculaC>();
        PeliculaC pelicula = null;
        try {
            while (rs.next()) {
                pelicula = new PeliculaC(rs.getInt("pcodigo"), rs.getString("pnombre"),rs.getString("pduracion"),
                        rs.getString("pcensura"),TipoF.ObtenerTipoDadoCodigo(rs.getInt("pcodigo_tipo")));
                lst.add(pelicula);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<PeliculaC> ObtenerPelicula() throws Exception {
        ArrayList<PeliculaC> lst = new ArrayList<PeliculaC>();
        try {
            String sql = "select * from master.f_select_escuela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPelicula(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

 
    
    
    public static PeliculaC ObtenerPeliculaDadoCodigo(int codigo) throws Exception {
        PeliculaC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new PeliculaC();
            lst =  llenarPelicula(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   
    
    
    
   public static ArrayList<PeliculaC> ObtenerPeliculaDadoCodigoTipo(int codigo) throws Exception {
       ArrayList<PeliculaC> lst = new ArrayList<PeliculaC>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo_facultad(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarPelicula(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean actualizar(PeliculaC pelicula) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_escuela(?,?,?,?,?)";
       
            lstP.add(new Parametro(1, pelicula.getNombre()));
            lstP.add(new Parametro(2, pelicula.getDuracion()));
            lstP.add(new Parametro(3, pelicula.getCensura()));
            lstP.add(new Parametro(4, pelicula.getCodigo_tipo().getCodigo()));
            
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

