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
import master.logica.clases.CDependencia;
//import master.logica.clases.CDependencia;

/**
 *
 * @author Javier
 */
public class CFDependencia {

    public static boolean insertar(CDependencia dependencia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_dependencia(?,?,?,?,?)";
            lstP.add(new Parametro(1, dependencia.getObjCodigoInstitucion().getCodigo()));
            lstP.add(new Parametro(2, dependencia.getStrCodificacion()));
            lstP.add(new Parametro(3, dependencia.getStrNombre()));
            lstP.add(new Parametro(4, dependencia.getStrObservacion()));
            lstP.add(new Parametro(5, dependencia.getIntEstado()));

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

    public static boolean actualizar(CDependencia dependencia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_dependencia(?,?,?,?,?,?)";

            lstP.add(new Parametro(1, dependencia.getObjCodigoInstitucion().getCodigo()));
            lstP.add(new Parametro(2, dependencia.getStrCodificacion()));
            lstP.add(new Parametro(3, dependencia.getStrNombre()));
            lstP.add(new Parametro(4, dependencia.getStrObservacion()));
            lstP.add(new Parametro(5, dependencia.getIntEstado()));
            lstP.add(new Parametro(6, dependencia.getIntCodigo()));
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

    public static boolean eliminar(CDependencia dependencia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_delete_dependencia(?)";
            lstP.add(new Parametro(1, dependencia.getIntCodigo()));
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

    public static ArrayList<CDependencia> llenarDependencia(ConjuntoResultado rs) throws Exception {
        ArrayList<CDependencia> lst = new ArrayList<CDependencia>();
        CDependencia dependencia = null;

        try {
            while (rs.next()) {
                dependencia = new CDependencia(rs.getInt("pcodigo"), FInstitucion.ObtenerInstitucionDadoCodigo(rs.getInt("pcodigo_institucion")), rs.getString("pcodificacion"),
                        rs.getString("pnombre"), rs.getString("pobservacion"), rs.getInt("pestado"));
                lst.add(dependencia);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static CDependencia ObtenerDependenciaDadoCodigo(int codigo) throws Exception{
        CDependencia lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_dependencia_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new CDependencia();
            lst = llenarDependencia(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<CDependencia> ObtenerDependencias() throws Exception {
        ArrayList<CDependencia> lst = new ArrayList<CDependencia>();
        try {
            String sql = "select * from master.f_select_dependencias()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDependencia(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
