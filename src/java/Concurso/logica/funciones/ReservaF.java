/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.ReservaC;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import accesodatos.AccesoDatos;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ReservaF {
    
    
    public static boolean Insertar(ReservaC reserva) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_escuela(?,?,?,?,?)";
            
            lstP.add(new Parametro(1, reserva.getCodigo_cliente().getCodigo()));
            lstP.add(new Parametro(2, reserva.getCodigo_sucursal().getCodigo()));
            lstP.add(new Parametro(3, reserva.getCodigo_pelicula().getCodigo()));
            lstP.add(new Parametro(4, reserva.getFecha_reserva()));
            lstP.add(new Parametro(5, reserva.getHora_reserva()));
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

    public static ArrayList<ReservaC> llenarReserva(ConjuntoResultado rs) throws Exception {
        ArrayList<ReservaC> lst = new ArrayList<ReservaC>();
        ReservaC reserva = null;
        try {
            while (rs.next()) {
                reserva = new ReservaC(rs.getInt("pcodigo"), ClienteF.ObtenerClienteDadoCodigo(rs.getInt("pcodigo_cliente")),
                        SucursalF.ObtenerSucursalDadoCodigo(rs.getInt("pcodigo_sucursal")),
                        PeliculaF.ObtenerPeliculaDadoCodigo(rs.getInt("pcodigo_pelicula")),rs.getString("pfecha_reserva"),
                        rs.getString("phora_reserva"));
                lst.add(reserva);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<ReservaC> ObtenerReserva() throws Exception {
        ArrayList<ReservaC> lst = new ArrayList<ReservaC>();
        try {
            String sql = "select * from master.f_select_escuela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarReserva(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

 
    
    
    public static ReservaC ObtenerReservaDadoCodigo(int codigo) throws Exception {
        ReservaC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new ReservaC();
            lst =  llenarReserva(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   
    
    
    
   public static ArrayList<ReservaC> ObtenerReservaDadoCodigoTarjeta(int codigo) throws Exception {
       ArrayList<ReservaC> lst = new ArrayList<ReservaC>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo_facultad(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarReserva(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean actualizar(ReservaC reserva) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_escuela(?,?,?,?,?)";
       
            lstP.add(new Parametro(1, reserva.getCodigo_cliente().getCodigo()));
            lstP.add(new Parametro(2, reserva.getCodigo_sucursal().getCodigo()));
            lstP.add(new Parametro(3, reserva.getCodigo_pelicula().getCodigo()));
            lstP.add(new Parametro(4, reserva.getFecha_reserva()));
            lstP.add(new Parametro(5, reserva.getHora_reserva()));
            
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