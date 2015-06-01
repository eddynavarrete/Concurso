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
import master.logica.clases.Nivel;
import master.logica.clases.Escuela;
/**
 *
 * @author Janneth GS
 */
public class FNivel {
   
     public static boolean Insertar(Nivel nivel) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_nivel(?,?,?,?,?)";
            lstP.add(new Parametro(1, nivel.getCodigo_sicoa()));
            lstP.add(new Parametro(2, nivel.getNombre()));
            lstP.add(new Parametro(3, nivel.getParalelo()));
            lstP.add(new Parametro(4, nivel.getModalidad()));
            lstP.add(new Parametro(5, nivel.getCodigo_escuela().getCodigo()));
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
    
     public static boolean actualizar(Nivel nivel) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_nivel(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, nivel.getCodigo_sicoa()));
            lstP.add(new Parametro(2, nivel.getNombre()));
            lstP.add(new Parametro(3, nivel.getParalelo()));
            lstP.add(new Parametro(4, nivel.getModalidad()));
            lstP.add(new Parametro(5, nivel.getCodigo_escuela().getCodigo()));
            lstP.add(new Parametro(6, nivel.getCodigo()));
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
        String sql = "select * from master.f_delete_nivel(?)";
        lstP.add(new Parametro(1, codigo));
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
    
    
     public static ArrayList<Nivel> llenarNivel(ConjuntoResultado rs) throws Exception {
        ArrayList<Nivel> lst = new ArrayList<Nivel>();
        Nivel nivel = null;
        try {
            while (rs.next()) {
                nivel = new Nivel(rs.getInt("pcodigo"), rs.getInt("pcodigo_sicoa"), rs.getString("pnombre"), rs.getString("pparalelo"), rs.getString("pmodalidad"), FEscuela.ObtenerEscuelaDadoCodigo(rs.getInt("pcodigo_escuela")));
                lst.add(nivel);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Nivel> ObtenerNiveles() throws Exception {
        ArrayList<Nivel> lst = new ArrayList<Nivel>();
        try {
            String sql = "select * from master.f_select_nivel()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarNivel(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Nivel ObtenerNivelDadoCodigo(int codigo) throws Exception {
        Nivel lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_nivel_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Nivel();
            lst = llenarNivel(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    public static ArrayList<Nivel> ObtenerNivelesDadoCodigoEscuela(int codigo) throws Exception {
       ArrayList<Nivel> lst = new ArrayList<Nivel>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_nivel_dado_codigo_escuela(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarNivel(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    
    
    
}
