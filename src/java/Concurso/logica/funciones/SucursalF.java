/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.SucursalC;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import accesodatos.AccesoDatos;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */
public class SucursalF {
    public static boolean Insertar(SucursalC sucursal) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_escuela(?,?,?,?,?)";
            
            lstP.add(new Parametro(1, sucursal.getNombre()));
            lstP.add(new Parametro(2, sucursal.getDireccion()));
            lstP.add(new Parametro(3, sucursal.getTelefono()));
            lstP.add(new Parametro(4, sucursal.getCodigo_ciudad().getCodigo()));
            lstP.add(new Parametro(5, sucursal.getCodigo_sala().getCodigo()));
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

    public static ArrayList<SucursalC> llenarSucursal(ConjuntoResultado rs) throws Exception {
        ArrayList<SucursalC> lst = new ArrayList<SucursalC>();
        SucursalC sucursal = null;
        try {
            while (rs.next()) {
                sucursal = new SucursalC(rs.getInt("pcodigo"), rs.getString("pnombre"),rs.getString("pdireccion"),
                        rs.getString("ptelefono"),CiudadF.ObtenerCiudadDadoCodigo(rs.getInt("pcodigo_ciudad")),
                        SalaF.ObtenerSalaDadoCodigo(rs.getInt("pcodigo_sala")));
                lst.add(sucursal);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<SucursalC> ObtenerSucursal() throws Exception {
        ArrayList<SucursalC> lst = new ArrayList<SucursalC>();
        try {
            String sql = "select * from master.f_select_escuela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarSucursal(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

 
    
    
    public static SucursalC ObtenerSucursalDadoCodigo(int codigo) throws Exception {
        SucursalC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new SucursalC();
            lst =  llenarSucursal(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   
    
    
    
   public static ArrayList<SucursalC> ObtenerSucursalDadoCodigoTarjeta(int codigo) throws Exception {
       ArrayList<SucursalC> lst = new ArrayList<SucursalC>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo_facultad(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarSucursal(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean actualizar(SucursalC sucursal) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_escuela(?,?,?,?,?)";
       
            lstP.add(new Parametro(1, sucursal.getNombre()));
            lstP.add(new Parametro(2, sucursal.getDireccion()));
            lstP.add(new Parametro(3, sucursal.getTelefono()));
            lstP.add(new Parametro(4, sucursal.getCodigo_ciudad().getCodigo()));
            lstP.add(new Parametro(5, sucursal.getCodigo_sala().getCodigo()));
            
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