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
import master.logica.clases.Estudiante;
/**
 *
 * @author Janneth GS
 */
public class FEstudiante {
    
    public static boolean Insertar(Estudiante estudiante) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_estudiante(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, estudiante.getNombre()));
            lstP.add(new Parametro(2, estudiante.getApellido()));
            lstP.add(new Parametro(3, estudiante.getCedula()));
            lstP.add(new Parametro(4, estudiante.getCodigo_sicoa()));
            lstP.add(new Parametro(5, estudiante.getCodigo_periodo().getCodigo()));
            lstP.add(new Parametro(6, estudiante.getCodigo_nivel().getCodigo()));
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
    
     public static boolean actualizar(Estudiante estudiante) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_estudiante(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, estudiante.getNombre()));
            lstP.add(new Parametro(2, estudiante.getApellido()));
            lstP.add(new Parametro(3, estudiante.getCedula()));
            lstP.add(new Parametro(4, estudiante.getCodigo_sicoa()));
            lstP.add(new Parametro(5, estudiante.getCodigo_periodo().getCodigo()));
            lstP.add(new Parametro(6, estudiante.getCodigo_nivel().getCodigo()));
            lstP.add(new Parametro(7, estudiante.getCodigo_nivel().getCodigo()));
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
        String sql = "select * from master.f_delete_estudiante(?)";
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
    
    
     public static ArrayList<Estudiante> llenarEstudiante(ConjuntoResultado rs) throws Exception {
        ArrayList<Estudiante> lst = new ArrayList<Estudiante>();
        Estudiante estudiante = null;
        try {
            while (rs.next()) {
                estudiante = new Estudiante(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("papellido"), rs.getString("pcedula"), rs.getInt("pcodigo_sicoa"), FPeriodos.ObtenerPeriodoDadoCodigo(rs.getInt("pcodigo_periodo")), FNivel.ObtenerNivelDadoCodigo(rs.getInt("pcodigo_nivel")));
                lst.add(estudiante);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Estudiante> ObtenerEstudiantes() throws Exception {
        ArrayList<Estudiante> lst = new ArrayList<Estudiante>();
        try {
            String sql = "select * from master.f_select_estudiante()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEstudiante(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Estudiante ObtenerEstudianteDadoCodigo(int codigo) throws Exception {
        Estudiante lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_estudiante_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Estudiante();
            lst = llenarEstudiante(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
}
