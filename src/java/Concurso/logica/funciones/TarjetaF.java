/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.TarjetaC;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class TarjetaF {
    
    
    public static boolean Insertar(TarjetaC tarjeta) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_accion(?,?)";
            lstP.add(new Parametro(1, tarjeta.getNumero_tarjeta()));
            lstP.add(new Parametro(2, tarjeta.getNumero_verificacion()));
            
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

    public static ArrayList<TarjetaC> llenarTarjeta(ConjuntoResultado rs) throws Exception {
        ArrayList<TarjetaC> lst = new ArrayList<TarjetaC>();
        TarjetaC tarjeta = null;
        try {
            while (rs.next()) {
                tarjeta = new TarjetaC(rs.getInt("pcodigo"), rs.getInt("pnumero_tarjeta"), rs.getInt("pnumero_verificacion"));
                lst.add(tarjeta);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<TarjetaC> ObtenerTarjetas() throws Exception {
        ArrayList<TarjetaC> lst = new ArrayList<TarjetaC>();
        try {
            
            //consulta Postgres ojo
            String sql = "select * from master.f_select_acciones()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTarjeta(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static TarjetaC ObtenerTarjetaDadoCodigo(int codigo) throws Exception {
        TarjetaC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            //consulta postgres ojo
            String sql = "select * from master.f_select_acciones_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new TarjetaC();
            lst = llenarTarjeta(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(TarjetaC tarjeta) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            //consulta postgres ojo
            String sql = "select * from master.f_update_accion(?,?,?,?,?)";
            lstP.add(new Parametro(1, tarjeta.getNumero_tarjeta()));
            lstP.add(new Parametro(2, tarjeta.getNumero_verificacion()));
            
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

