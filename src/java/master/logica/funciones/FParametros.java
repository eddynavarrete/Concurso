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
import master.logica.clases.Parametros;

/**
 *
 * @author Kleber
 */
public class FParametros {
    public static boolean Insertar(Parametros parametros) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_parametro(?,?,?,?)";
            lstP.add(new Parametro(1, parametros.getDescripcion()));
            lstP.add(new Parametro(2, parametros.getValor_entero()));
            lstP.add(new Parametro(3, parametros.getValor_doble()));
            lstP.add(new Parametro(4, parametros.getValor_texto()));
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

public static ArrayList<Parametros> llenarParametros(ConjuntoResultado rs) throws Exception {
        ArrayList<Parametros> lst = new ArrayList<Parametros>();
        Parametros parametros = null;
        try {
            while (rs.next()) {
                parametros = new Parametros(rs.getInt("pcodigo"), rs.getString("pdescripcion"), rs.getInt("pvalor_entero"), rs.getDouble("pvalor_doble"), rs.getString("pvalor_texto"));
                lst.add(parametros);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

public static ArrayList<Parametros> ObtenerParametros() throws Exception {
        ArrayList<Parametros> lst = new ArrayList<Parametros>();
        try {
            String sql = "select * from master.f_select_parametro()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarParametros(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }


 public static Parametros ObtenerParametrosDadoCodigo(int codigo) throws Exception {
        Parametros lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_parametros_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Parametros();
            lst = llenarParametros(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
 
 
 public static boolean actualizar(Parametros parametros) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_parametro(?,?,?,?,?)";
            lstP.add(new Parametro(1, parametros.getDescripcion()));
            lstP.add(new Parametro(2, parametros.getValor_entero()));
            lstP.add(new Parametro(3, parametros.getValor_doble()));
            lstP.add(new Parametro(4, parametros.getValor_texto()));
            lstP.add(new Parametro(5, parametros.getCodigo()));
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
  
 public static  boolean eliminar (Parametros parametros) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master.f_delete_parametro(?)";
        lstP.add(new Parametro(1, parametros.getCodigo()));
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