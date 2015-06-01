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
import actividades.logica.clases.DetalleTutoria;
import actividades.logica.clases.EncabezadoTutoria;
import actividades.logica.clases.CausasBajoRendimiento;
/**
 *
 * @author Janneth GS
 */
public class FDetalleTutoria {
  
    public static boolean Insertar(DetalleTutoria detalletutoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_insert_detalle_tutoria(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, detalletutoria.getNombre()));
            lstP.add(new Parametro(2, detalletutoria.getApellido()));
            lstP.add(new Parametro(3, detalletutoria.getCedula()));
            lstP.add(new Parametro(4, detalletutoria.getCodigo_sicoa()));
            lstP.add(new Parametro(5, detalletutoria.getCodigo_encabezado().getCodigo()));
            lstP.add(new Parametro(6, detalletutoria.getCodigo_causas_bajo_rendimiento().getCodigo()));
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

    public static ArrayList<DetalleTutoria> llenarDetalleTutoria(ConjuntoResultado rs) throws Exception {
        ArrayList<DetalleTutoria> lst = new ArrayList<DetalleTutoria>();
        DetalleTutoria detalletutoria = null;
        try {
            while (rs.next()) {
                detalletutoria = new DetalleTutoria(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("papellido"), rs.getString("pcedula"), rs.getInt("pcodigo_sicoa"), FEncabezadoTutoria.ObtenerEncabezadoTutoriaDadoCodigo(rs.getInt("pcodigo_encabezado")), FCausasBajoRendimiento.ObtenerCausasBajoRendimientoDadoCodigo(rs.getInt("pcodigo_causas_bajo_rendimiento")));
                lst.add(detalletutoria);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<DetalleTutoria> ObtenerDetalleTutoria() throws Exception {
        ArrayList<DetalleTutoria> lst = new ArrayList<DetalleTutoria>();
        try {
            String sql = "select * from actividades.f_select_detalle_tutoria()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDetalleTutoria(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static DetalleTutoria ObtenerDetalleTutoriaDadoCodigo(int codigo) throws Exception {
        DetalleTutoria lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_select_detalle_tutoria_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new DetalleTutoria();
            lst = llenarDetalleTutoria(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(DetalleTutoria detalletutoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.f_update_detalle_tutoria(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, detalletutoria.getNombre()));
            lstP.add(new Parametro(2, detalletutoria.getApellido()));
            lstP.add(new Parametro(3, detalletutoria.getCedula()));
            lstP.add(new Parametro(4, detalletutoria.getCodigo_sicoa()));
            lstP.add(new Parametro(5, detalletutoria.getCodigo_encabezado().getCodigo()));
            lstP.add(new Parametro(6, detalletutoria.getCodigo_causas_bajo_rendimiento().getCodigo()));
            lstP.add(new Parametro(7, detalletutoria.getCodigo()));
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
        String sql = "select * from actividades.f_delete_detalle_tutoria(?)";
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
