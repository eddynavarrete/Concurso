/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.Periodos;

/**
 *
 * @author DiegoPalacios
 */
public class FPeriodos {

    public static boolean compararAperturaSubidaProformas(long fecha) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_comparar_apertura_subida_proformas(?)";
            lstP.add(new Parametro(1, (fecha)));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true")) {
                    eje = true;
                } else {
                    eje = false;
                }
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    
    public static boolean Insertar(Periodos periodos) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_periodo(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, periodos.getNombre()));
            lstP.add(new Parametro(2, periodos.getFecha_inicio()));
            lstP.add(new Parametro(3, periodos.getFecha_fin()));
            lstP.add(new Parametro(4, periodos.getTipo()));
            lstP.add(new Parametro(5, periodos.getObservaciones()));
            lstP.add(new Parametro(6, periodos.getCodigo_sicoa()));
            lstP.add(new Parametro(7, periodos.getEstado()));
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

    public static ArrayList<Periodos> llenarPeriodo(ConjuntoResultado rs) throws Exception {
        ArrayList<Periodos> lst = new ArrayList<Periodos>();
        Periodos periodos = null;
        try {
            while (rs.next()) {
                periodos = new Periodos(rs.getInt("pcodigo"), 
                        rs.getString("pnombre"), 
                        rs.getDate("pfecha_inicio"), 
                        rs.getDate("pfecha_fin"), 
                        rs.getInt("ptipo"), 
                        rs.getString("pobservaciones"),
                        rs.getInt("pcodigo_sicoa"), 
                        rs.getInt("pestado"));
                lst.add(periodos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Periodos> ObtenerPeriodos() throws Exception {
        ArrayList<Periodos> lst = new ArrayList<Periodos>();
        try {
            String sql = "select * from master.f_select_periodo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPeriodo(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Periodos> ObtenerPeriodoActual() throws Exception {
        ArrayList<Periodos> lst = new ArrayList<Periodos>();
        try {
            String sql = "select * from master.f_select_periodo_activo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPeriodo(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    

    public static Periodos ObtenerPeriodoDadoCodigo(int codigo) throws Exception {
        Periodos lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_periodo_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Periodos();
            lst = llenarPeriodo(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(Periodos periodos) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_periodo(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, periodos.getNombre()));
            lstP.add(new Parametro(2, periodos.getFecha_inicio()));
            lstP.add(new Parametro(3, periodos.getFecha_fin()));
            lstP.add(new Parametro(4, periodos.getTipo()));
            lstP.add(new Parametro(5, periodos.getObservaciones()));
            lstP.add(new Parametro(6, periodos.getCodigo_sicoa()));
            lstP.add(new Parametro(7, periodos.getEstado()));
            lstP.add(new Parametro(8, periodos.getCodigo()));
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
    
    public static  boolean eliminar (Periodos periodos) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master.f_delete_periodo(?)";
        lstP.add(new Parametro(1,periodos.getCodigo()));
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
