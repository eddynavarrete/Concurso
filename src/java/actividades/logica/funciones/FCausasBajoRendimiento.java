/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actividades.logica.funciones;
import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import actividades.logica.clases.CausasBajoRendimiento;
/**
 *
 * @author Janneth GS
 */
public class FCausasBajoRendimiento {
    public static boolean Insertar(CausasBajoRendimiento causasbajorendimiento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_insert_causas_bajo_rendimiento(?,?,?)";
            lstP.add(new Parametro(1, causasbajorendimiento.getNombre()));
            lstP.add(new Parametro(2, causasbajorendimiento.getDescripcion()));
            lstP.add(new Parametro(3, causasbajorendimiento.getEstado()));
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
    
     public static ArrayList<CausasBajoRendimiento> llenarCausasBajoRendimiento(ConjuntoResultado rs) throws Exception {
        ArrayList<CausasBajoRendimiento> lst = new ArrayList<CausasBajoRendimiento>();
        CausasBajoRendimiento causasbajorendimiento = null;
        try {
            while (rs.next()) {
                causasbajorendimiento = new CausasBajoRendimiento(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pestado"));
                lst.add(causasbajorendimiento);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<CausasBajoRendimiento> ObtenerCausasBajoRendimiento() throws Exception {
        ArrayList<CausasBajoRendimiento> lst = new ArrayList<CausasBajoRendimiento>();
        try {
            String sql = "select * from actividades.f_select_causas_bajo_rendimiento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCausasBajoRendimiento(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static CausasBajoRendimiento ObtenerCausasBajoRendimientoDadoCodigo(int codigo) throws Exception {
        CausasBajoRendimiento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_select_causas_bajo_rendimiento_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new CausasBajoRendimiento();
            lst = llenarCausasBajoRendimiento(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
 public static boolean actualizar(CausasBajoRendimiento causasbajorendimiento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_update_causas_bajo_rendimiento(?,?,?,?)";
            lstP.add(new Parametro(1, causasbajorendimiento.getNombre()));
            lstP.add(new Parametro(2, causasbajorendimiento.getDescripcion()));
            lstP.add(new Parametro(3, causasbajorendimiento.getEstado()));
            lstP.add(new Parametro(4, causasbajorendimiento.getCodigo()));
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
    
    public static  boolean eliminar (CausasBajoRendimiento causasbajorendimiento) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from actividades.f_delete_causas_bajo_rendimiento(?)";
        lstP.add(new Parametro(1,causasbajorendimiento.getCodigo()));
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
