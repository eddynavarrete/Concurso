/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import master.logica.clases.Usuario;
import master.logica.clases.UsuarioRol;
import master.logica.clases.Tutor;

/**
 *
 * @author DiegoPalacios
 */
public class FUsuario {
    
        
    

    public static int Insertar(Usuario usuario, UsuarioRol usuarioRol) throws Exception {

        long ejeUsuario = 0;
        int ejeUsuarioRol = 0;
        Conexion con = new Conexion();
        try {
            if (con.getCon().getAutoCommit()) {
                con.getCon().setAutoCommit(false);
            }
            ///////////////INSERTO en la tabal usuario
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, usuario.getApellidos()));
            lstP.add(new Parametro(2, usuario.getNombres()));
            lstP.add(new Parametro(3, usuario.getIdentificacion()));
            lstP.add(new Parametro(4, usuario.getNombre_corto()));
            lstP.add(new Parametro(5, usuario.getClave()));
            lstP.add(new Parametro(6, usuario.getClave_pregunta()));
            lstP.add(new Parametro(7, usuario.getClave_respuesta()));
            lstP.add(new Parametro(8, usuario.getMail()));
            lstP.add(new Parametro(9, usuario.getEstado()));
            lstP.add(new Parametro(10, usuario.getPrimer_acceso()));
            lstP.add(new Parametro(11, usuario.getUtimo_acceso()));
            lstP.add(new Parametro(12, usuario.getUltima_ip()));
            lstP.add(new Parametro(13, usuario.getFecha_modificacion()));
            lstP.add(new Parametro(14, usuario.getCodigo_salt()));
            lstP.add(new Parametro(15, usuario.getRuta_firma()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getLong(0) > 0);
                ejeUsuario = rs.getLong(0);
            }
            ////inserto en la tabla Usuario Rol
            ArrayList<Parametro> lstP1 = new ArrayList<Parametro>();
            String sql1 = "select * from master.f_insert_usuario_rol(?,?,?)";

            lstP1.add(new Parametro(1, usuarioRol.getCodigo_rol().getCodigo()));
            lstP1.add(new Parametro(2, ejeUsuario));
            lstP1.add(new Parametro(3, usuarioRol.getEstado()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstP1);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                ejeUsuarioRol = rs1.getInt(0);
            }

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return ejeUsuarioRol;
    }

    
    public static long InsertarTutor(Usuario usuario, UsuarioRol usuarioRol, Tutor tutor) throws Exception {
        long ejeUsuario = 0;
        int ejeUsuarioRol = 0;
        boolean ejeTutor = false;
        
        boolean ejef = false;
        Conexion con = new Conexion();
        try {
            if (con.getCon().getAutoCommit()) {
                con.getCon().setAutoCommit(false);
            }
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_insert_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, usuario.getApellidos()));
            lstP.add(new Parametro(2, usuario.getNombres()));
            lstP.add(new Parametro(3, usuario.getIdentificacion()));
            lstP.add(new Parametro(4, usuario.getNombre_corto()));
            lstP.add(new Parametro(5, usuario.getClave()));
            lstP.add(new Parametro(6, usuario.getClave_pregunta()));
            lstP.add(new Parametro(7, usuario.getClave_respuesta()));
            lstP.add(new Parametro(8, usuario.getMail()));
            lstP.add(new Parametro(9, usuario.getEstado()));
            lstP.add(new Parametro(10, usuario.getPrimer_acceso()));
            lstP.add(new Parametro(11, usuario.getUtimo_acceso()));
            lstP.add(new Parametro(12, usuario.getUltima_ip()));
            lstP.add(new Parametro(13, usuario.getFecha_modificacion()));
            lstP.add(new Parametro(14, usuario.getCodigo_salt()));
            lstP.add(new Parametro(15, usuario.getRuta_firma()));
            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getLong(0) > 0);
                ejeUsuario = rs.getLong(0);
            }

            ArrayList<Parametro> lstP1 = new ArrayList<Parametro>();
            String sql1 = "select * from master.f_insert_usuario_rol(?,?,?)";
            lstP1.add(new Parametro(1, usuarioRol.getCodigo_rol().getCodigo()));
            lstP1.add(new Parametro(2, ejeUsuario));
            lstP1.add(new Parametro(3, usuarioRol.getEstado()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstP1);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                ejeUsuarioRol = rs1.getInt(0);
            }
            
            
            ArrayList<Parametro> lstP2 = new ArrayList<Parametro>();
            String sql2 = "select * from master.f_insert_tutor(?,?,?)";
            lstP2.add(new Parametro(1, tutor.getCodigo_nivel().getCodigo()));
            lstP2.add(new Parametro(2, tutor.getCodigo_periodo().getCodigo()));
            lstP2.add(new Parametro(3, ejeUsuarioRol));
            ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql2, lstP2);
            while (rs2.next()) {
                if (rs2.getString(0).equals("true"));
                ejeTutor = true;
            }
            

            if ((ejeUsuario > 0) && (ejeUsuarioRol > 0) && (ejeTutor == true)) 
            {
                ejef = true;
            } else {
                ejef = false;
            }
            con.getCon().commit();
        } catch (SQLException exConec) {
            con.getCon().rollback();
            throw new Exception(exConec.getMessage());
        }
        return ejeUsuario;
    }


     public static Usuario ObtenerUsuarioDadoIdentificacion(String identificacion) throws Exception {
        Usuario lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_usuario_dado_identificacion(?)";
            lstP.add(new Parametro(1, identificacion));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
    
    public static boolean Editar(Usuario usuario, UsuarioRol usuarioRol) throws Exception {

        boolean  band = false;
        boolean  band1 = false;
        
        Conexion con = new Conexion();
        try {
            if (con.getCon().getAutoCommit()) {
                con.getCon().setAutoCommit(false);
            }
            ///////////////INSERTO en la tabal usuario
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, usuario.getApellidos()));
            lstP.add(new Parametro(2, usuario.getNombres()));
            lstP.add(new Parametro(3, usuario.getIdentificacion()));
            lstP.add(new Parametro(4, usuario.getNombre_corto()));
            lstP.add(new Parametro(5, usuario.getClave()));
            lstP.add(new Parametro(6, usuario.getClave_pregunta()));
            lstP.add(new Parametro(7, usuario.getClave_respuesta()));
            lstP.add(new Parametro(8, usuario.getMail()));
            lstP.add(new Parametro(9, usuario.getEstado()));
            lstP.add(new Parametro(10, usuario.getPrimer_acceso()));
            lstP.add(new Parametro(11, usuario.getUtimo_acceso()));
            lstP.add(new Parametro(12, usuario.getUltima_ip()));
            lstP.add(new Parametro(13, usuario.getFecha_modificacion()));
            lstP.add(new Parametro(14, usuario.getCodigo_salt()));
            lstP.add(new Parametro(15, usuario.getRuta_firma()));
            lstP.add(new Parametro(16, usuario.getCodigo())); 
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
               band1=true;
            }
            ////inserto en la tabla Usuario Rol
            ArrayList<Parametro> lstP1 = new ArrayList<Parametro>();
            String sql1 = "select * from master.f_update_usuario_rol(?,?,?,?)";

            lstP1.add(new Parametro(1, usuarioRol.getCodigo_rol().getCodigo()));
            lstP1.add(new Parametro(2, usuario.getCodigo()));
            lstP1.add(new Parametro(3, usuarioRol.getEstado()));
            lstP1.add(new Parametro(4, usuarioRol.getCodigo()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstP1);
            while (rs1.next()) {
                if (rs1.getString(0).equals("true"));
                band = true;
            }

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return band;
    }

    public static boolean Eliminar(long codigo) throws Exception {
        boolean ban = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_delete_usuario_usuario_rol(?)";
            lstP.add(new Parametro(1, codigo ));            
            ConjuntoResultado rs = accesodatos.AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                ban = true;
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return ban;
    }

    public static Usuario ObtenerUsuarioDadoCodigo(long codigo) throws Exception {
        Usuario lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_usuario_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Usuario> llenarUsuarios(ConjuntoResultado rs) throws Exception {
        ArrayList<Usuario> lst = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            while (rs.next()) {
                usuario = new Usuario(rs.getLong("pcodigo"), rs.getString("papellidos"), rs.getString("pnombres"), rs.getString("pidentificacion"), rs.getString("pnombre_corto"), rs.getString("pclave"), rs.getString("pclave_pregunta"), rs.getString("pclave_respuesta"), rs.getString("pmail"), rs.getInt("pestado"), rs.getTimeStamp("pprimer_acceso"), rs.getTimeStamp("putimo_acceso"), rs.getString("pultima_ip"), rs.getTimeStamp("pfecha_modificacion"), rs.getString("pcodigo_salt"), rs.getString("pruta_firma"));
                lst.add(usuario);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Usuario> ObtenerUsuarios() throws Exception {
        ArrayList<Usuario> lst = new ArrayList<Usuario>();
        try {
            String sql = "select * from master.f_select_usuarios()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarUsuarios(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizarUltimoAccesoUsuario(java.sql.Timestamp ultimoAcceso, long codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_update_ultimo_acceso_usuario(?,?)";
            lstP.add(new Parametro(1, ultimoAcceso));
            lstP.add(new Parametro(2, codigo));
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

    //autenticar
    public static Usuario autenticarUsuario(String cedula, String password) throws Exception {
        Usuario lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master.f_select_usuario_dado_cedula_y_clave(?,?)";
            lstP.add(new Parametro(1, cedula));
            lstP.add(new Parametro(2, password));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
