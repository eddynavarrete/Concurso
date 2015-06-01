/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package master.logica.clases;

/**
 *
 * @author Janneth GS
 */
public class Tutor {
  private long codigo;
  private Nivel codigo_nivel;
  private Periodos codigo_periodo;
  private UsuarioRol codigo_usuario_rol; 
  
  
  public Tutor() {
    }

    public Tutor(long codigo, Nivel codigo_nivel, Periodos codigo_periodo, UsuarioRol codigo_usuario_rol) {
        this.codigo = codigo;
        this.codigo_nivel = codigo_nivel;
        this.codigo_periodo = codigo_periodo;
        this.codigo_usuario_rol = codigo_usuario_rol;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Nivel getCodigo_nivel() {
        return codigo_nivel;
    }

    public void setCodigo_nivel(Nivel codigo_nivel) {
        this.codigo_nivel = codigo_nivel;
    }

    public Periodos getCodigo_periodo() {
        return codigo_periodo;
    }

    public void setCodigo_periodo(Periodos codigo_periodo) {
        this.codigo_periodo = codigo_periodo;
    }

    public UsuarioRol getCodigo_usuario_rol() {
        return codigo_usuario_rol;
    }

    public void setCodigo_usuario_rol(UsuarioRol codigo_usuario_rol) {
        this.codigo_usuario_rol = codigo_usuario_rol;
    }
}
