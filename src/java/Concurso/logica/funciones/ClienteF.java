/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.ClienteC;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.util.ArrayList;
import accesodatos.AccesoDatos;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ClienteF {
    
    public static boolean Insertar(ClienteC cliente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_escuela(?,?,?,?,?,?,?)";
            
            lstP.add(new Parametro(1, cliente.getNombre()));
            lstP.add(new Parametro(2, cliente.getApellido()));
            lstP.add(new Parametro(3, cliente.getDireccion()));
            lstP.add(new Parametro(4, cliente.getTelefono()));
            lstP.add(new Parametro(5, cliente.getCorreo()));
            lstP.add(new Parametro(6, cliente.getCedula()));
            lstP.add(new Parametro(7, cliente.getCodigoTarjeta().getCodigo()));
            
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

    public static ArrayList<ClienteC> llenarCliente(ConjuntoResultado rs) throws Exception {
        ArrayList<ClienteC> lst = new ArrayList<ClienteC>();
        ClienteC cliente = null;
        try {
            while (rs.next()) {
                cliente = new ClienteC(rs.getInt("pcodigo"), rs.getString("pnombre"),rs.getString("papellido"),
                        rs.getString("pdireccion"),rs.getString("ptelefono"),rs.getString("pcorreo"),
                        TarjetaF.ObtenerTarjetaDadoCodigo(rs.getInt("pcodigo_tarjeta")),
                        rs.getString("pcedula"));
                lst.add(cliente);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<ClienteC> ObtenerCliente() throws Exception {
        ArrayList<ClienteC> lst = new ArrayList<ClienteC>();
        try {
            String sql = "select * from master.f_select_escuela()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCliente(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

 
    
    
    public static ClienteC ObtenerClienteDadoCodigo(int codigo) throws Exception {
        ClienteC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new ClienteC();
            lst =  llenarCliente(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   
    
    
    
   public static ArrayList<ClienteC> ObtenerClienteDadoCodigoTarjeta(int codigo) throws Exception {
       ArrayList<ClienteC> lst = new ArrayList<ClienteC>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_escuela_dado_codigo_facultad(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCliente(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static boolean actualizar(ClienteC cliente) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_escuela(?,?,?,?,?)";
       
            lstP.add(new Parametro(1, cliente.getNombre()));
            lstP.add(new Parametro(2, cliente.getApellido()));
            lstP.add(new Parametro(3, cliente.getDireccion()));
            lstP.add(new Parametro(4, cliente.getTelefono()));
            lstP.add(new Parametro(5, cliente.getCorreo()));
            lstP.add(new Parametro(6, cliente.getCodigoTarjeta().getCodigo()));
            lstP.add(new Parametro(7, cliente.getCedula()));
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
