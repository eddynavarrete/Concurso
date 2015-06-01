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
import master.logica.clases.Escuela;
import master.logica.clases.Facultad;

/**
 *
 * @author Janneth GS
 */
public class FEscuela {

    public static boolean Insertar(Escuela escuela) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_escuela(?,?,?,?)";
            lstP.add(new Parametro(1, escuela.getCodigo_facultad().getCodigo()));
            lstP.add(new Parametro(2, escuela.getNombre()));
            lstP.add(new Parametro(3, escuela.getDescripcion()));
            lstP.add(new Parametro(4, escuela.getCodigo_sicoa()));
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

    public static ArrayList<Escuela> llenarEscuela(ConjuntoResultado rs) throws Exception {
        ArrayList<Escuela> lst = new ArrayList<Escuela>();
        Escuela escuela = null;
        try {
            while (rs.next()) {
                escuela = new Escuela(rs.getInt("pcodigo"), FFacultad.ObtenerFacultadDadoCodigo(rs.getInt("pcodigo_facultad")),
                        rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pcodigo_sicoa"));
                lst.add(escuela);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Escuela> ObtenerEscuelas() throws Exception {
        ArrayList<Escuela> lst = new ArrayList<Escuela>();
        try {
            String sql = "select * from master.f_select_escuela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEscuela(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

 
    
    
    public static Escuela ObtenerEscuelaDadoCodigo(int codigo) throws Exception {
        Escuela lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Escuela();
            lst = llenarEscuela(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   
    
    
    
   public static ArrayList<Escuela> ObtenerEscuelaDadoCodigoFacultad(int codigo) throws Exception {
       ArrayList<Escuela> lst = new ArrayList<Escuela>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo_facultad(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEscuela(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean actualizar(Escuela escuela) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_escuela(?,?,?,?,?)";
            lstP.add(new Parametro(1, escuela.getCodigo_facultad().getCodigo()));
            lstP.add(new Parametro(2, escuela.getNombre()));
            lstP.add(new Parametro(3, escuela.getDescripcion()));
            lstP.add(new Parametro(4, escuela.getCodigo_sicoa()));
            lstP.add(new Parametro(5, escuela.getCodigo()));
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
