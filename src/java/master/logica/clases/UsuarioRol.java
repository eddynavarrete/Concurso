/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author DiegoPalacios
 */
public class UsuarioRol {

    private int codigo;
    private Rol codigo_rol;
    private Usuario codigo_usuario;
    private int estado;

    public UsuarioRol() {
    }

    public UsuarioRol(int codigo, Rol codigo_rol, Usuario codigo_usuario, int estado) {
        this.codigo = codigo;
        this.codigo_rol = codigo_rol;
        this.codigo_usuario = codigo_usuario;
        this.estado = estado;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigo_rol
     */
    public Rol getCodigo_rol() {
        return codigo_rol;
    }

    /**
     * @param codigo_rol the codigo_rol to set
     */
    public void setCodigo_rol(Rol codigo_rol) {
        this.codigo_rol = codigo_rol;
    }

    /**
     * @return the codigo_usuario
     */
    public Usuario getCodigo_usuario() {
        return codigo_usuario;
    }

    /**
     * @param codigo_usuario the codigo_usuario to set
     */
    public void setCodigo_usuario(Usuario codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
