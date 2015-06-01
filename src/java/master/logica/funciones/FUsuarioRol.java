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
import master.logica.clases.UsuarioRol;

/**
 *
 * @author DiegoPalacios
 */
public class FUsuarioRol {

    public static boolean Insertar(UsuarioRol ur) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_usuario_rol(?,?,?)";
            lstP.add(new Parametro(1, ur.getCodigo_rol().getCodigo()));
            lstP.add(new Parametro(2, ur.getCodigo_usuario().getCodigo()));
            lstP.add(new Parametro(3, ur.getEstado()));
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

    public static boolean Actualizar(UsuarioRol ur) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_usuario_rol(?,?,?,?)";
            lstP.add(new Parametro(1, ur.getCodigo_rol().getCodigo()));
            lstP.add(new Parametro(2, ur.getCodigo_usuario().getCodigo()));
            lstP.add(new Parametro(3, ur.getEstado()));
            lstP.add(new Parametro(4, ur.getCodigo()));
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

    public static boolean Eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_delete_usuario_rol(?)";
            lstP.add(new Parametro(1, codigo));
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

    public static ArrayList<UsuarioRol> llenarUsuarioRol(ConjuntoResultado rs) throws Exception {
        ArrayList<UsuarioRol> lst = new ArrayList<UsuarioRol>();
        UsuarioRol ur = null;
        try {
            while (rs.next()) {
                ur = new UsuarioRol(rs.getInt("pcodigo"),
                        FRoles.ObtenerRolDadoCodigo(rs.getInt("pcodigo_rol")),
                        FUsuario.ObtenerUsuarioDadoCodigo(rs.getInt("pcodigo_usuario")),
                        rs.getInt("pestado"));
                lst.add(ur);
            }
        } catch (Exception e) {
            lst.clear();
            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
            //    ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return lst;
    }

    public static ArrayList<UsuarioRol> ObtenerUsuariosRol() throws Exception {
        ArrayList<UsuarioRol> lst = new ArrayList<UsuarioRol>();
        try {
            String sql = "select * from master.f_select_usuarios_rol()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarUsuarioRol(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static UsuarioRol obtenerUsuarioRolDadoCodigo(int codigo) throws Exception {
        UsuarioRol lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_usuarios_rol_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new UsuarioRol();
            lst = llenarUsuarioRol(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<UsuarioRol> obtenerRolesDadoUsuario(long codigo_usuario) throws Exception {
        ArrayList<UsuarioRol> lst = new ArrayList<UsuarioRol>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_roles_dado_usuario(?)";
            lstP.add(new Parametro(1, codigo_usuario));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarUsuarioRol(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
