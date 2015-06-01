/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso.logica.funciones;
import Concuros.logica.clases.SalaC;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class SalaF {
    
    public static boolean Insertar(SalaC sala) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_accion(?,?)";
            lstP.add(new Parametro(1, sala.getNombre()));
            lstP.add(new Parametro(2, sala.getCapacidad()));
            
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

    public static ArrayList<SalaC> llenarSala(ConjuntoResultado rs) throws Exception {
        ArrayList<SalaC> lst = new ArrayList<SalaC>();
        SalaC sala = null;
        try {
            while (rs.next()) {
                sala = new SalaC(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getInt("pcapacidad"));
                lst.add(sala);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<SalaC> ObtenerSalas() throws Exception {
        ArrayList<SalaC> lst = new ArrayList<SalaC>();
        try {
            
            //consulta Postgres ojo
            String sql = "select * from master.f_select_acciones()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarSala(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static SalaC ObtenerSalaDadoCodigo(int codigo) throws Exception {
        SalaC lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            //consulta postgres ojo
            String sql = "select * from master.f_select_acciones_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new SalaC();
            lst = llenarSala(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(SalaC sala) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            
            //consulta postgres ojo
            String sql = "select * from master.f_update_accion(?,?,?,?,?)";
            lstP.add(new Parametro(1, sala.getNombre()));
            lstP.add(new Parametro(2, sala.getCapacidad()));
            
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

    
    
   