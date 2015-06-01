/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.*;
import javax.sql.DataSource;

/**
 *
 * @author Dada
 */
public class AccesoDatos {

    public static ConjuntoResultado ejecutaQuery(String query) throws Exception {

        ResultSet rs = null;
        PreparedStatement pst = null;
        ConjuntoResultado conj = new ConjuntoResultado();
        Connection con = null;
        try {
            Global global = new Global();
            Class.forName(global.getDRIVER());
            try {
//                Context c = new InitialContext();
//                DataSource ds = (DataSource) c.lookup(global.getJDNI());
//                con = ds.getConnection();
                con = DriverManager.getConnection(global.getURL(), global.getUSER(), global.getPASS());
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();
                conj.Fill(rs);
                rs.close();
                pst.close();
                rs = null;
                pst = null;
            } catch (SQLException exConec) {
                throw exConec;
            } finally {
                try {
                    if (con != null) {
                        if (!(con.isClosed())) {
                            con.close();
                        }
                        con = null;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } catch (ClassNotFoundException exCarga) {
            throw exCarga;
        }
        return conj;
    }

    public static ConjuntoResultado ejecutaQuery(String query, ArrayList<Parametro> parametros) throws Exception {

        ResultSet rs = null;
        PreparedStatement ptrs = null;
        ConjuntoResultado conj = new ConjuntoResultado();
        Connection con = null;
        try {
            Global global = new Global();
            Class.forName(global.getDRIVER());
            try {
//                Context c = new InitialContext();
//                DataSource ds = (DataSource) c.lookup(global.getJDNI());
//                con = ds.getConnection();
                String url = global.getURL();
                con = DriverManager.getConnection(url, global.getUSER(), global.getPASS());
                ptrs = con.prepareStatement(query);
                for (Parametro parametro : parametros) {
                    //  if (parametro.getTipo() == 0) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
//                    } else {
//                        ptrs.setObject(parametro.getPosicion(), parametro.getValor(), parametro.getTipo());
//                    }
                }
                //   System.out.println(ptrs.toString());
                rs = ptrs.executeQuery();
                conj.Fill(rs);
                rs.close();
                ptrs.close();
                rs = null;
                ptrs = null;
            } catch (SQLException exConec) {
                throw exConec;
            } finally {
                try {
                    if (con != null) {
                        if (!(con.isClosed())) {
                            con.close();
                        }
                        con = null;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } catch (ClassNotFoundException exCarga) {
            throw exCarga;
        }
        return conj;
    }
}
