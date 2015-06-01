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
import master.logica.clases.CCargoAdministrativo;


/**
 *
 * @author Javier
 */
public class CFCargoAdministrativo {
     public static boolean insertar(CCargoAdministrativo cargoAdministrativo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_cargo_administrativo(?,?,?)";
            lstP.add(new Parametro(1, cargoAdministrativo.getStrNombre()));
            lstP.add(new Parametro(2, cargoAdministrativo.getStrObservacion()));
            lstP.add(new Parametro(3, cargoAdministrativo.getIntEstado()));
            
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
   
   public static boolean actualizar(CCargoAdministrativo cargoAdministrativo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_cargo_administrativo(?,?,?,?)";
            lstP.add(new Parametro(1, cargoAdministrativo.getStrNombre()));
            lstP.add(new Parametro(2, cargoAdministrativo.getStrObservacion()));
            lstP.add(new Parametro(3, cargoAdministrativo.getIntEstado()));
            lstP.add(new Parametro(4, cargoAdministrativo.getIntCodigo()));
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
   
   public static boolean eliminar(CCargoAdministrativo cargoAdministrativo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_delete_cargo_administrativo(?)";
            lstP.add(new Parametro(1, cargoAdministrativo.getIntCodigo()));
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
   
 public static ArrayList<CCargoAdministrativo> llenarCargoAdministrativos(ConjuntoResultado rs) throws Exception
      {
          ArrayList<CCargoAdministrativo> lst = new ArrayList<CCargoAdministrativo>();
          CCargoAdministrativo cargoAdministrativo=null;
          
          try {
            while(rs.next())
            {
                     cargoAdministrativo= new CCargoAdministrativo(rs.getInt(0),rs.getString(1), rs.getString(2),rs.getInt(3));
                     lst.add(cargoAdministrativo);
            }
            } catch (Exception e) {
                 lst.clear();
                throw e;
          }
         return lst;
      }
    public static CCargoAdministrativo ObtenerCargoAdministrativoDadoCodigo(int codigo) throws Exception
    {
       CCargoAdministrativo lst;
          try
        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master.f_select_cargo_administrativo_dado_codigo(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new CCargoAdministrativo();
         lst= llenarCargoAdministrativos(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
    
    public static  ArrayList<CCargoAdministrativo> ObtenerCargosAdministrativos() throws Exception
    {
       ArrayList<CCargoAdministrativo> lst = new ArrayList<CCargoAdministrativo>();
          try
        {
         String sql = "select * from master.f_select_cargos_administrativos()";
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
         lst= llenarCargoAdministrativos(rs);
          rs=null;

        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
}
