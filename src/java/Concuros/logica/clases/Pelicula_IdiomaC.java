/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concuros.logica.clases;

/**
 *
 * @author Usuario
 */
public class Pelicula_IdiomaC {
    
    private int codigo;
    private PeliculaC codigo_pelicula;
    private IdiomaC codigo_idioma;

    public Pelicula_IdiomaC() {
    }

    public Pelicula_IdiomaC(int codigo, PeliculaC codigo_pelicula, IdiomaC codigo_idioma) {
        this.codigo = codigo;
        this.codigo_pelicula = codigo_pelicula;
        this.codigo_idioma = codigo_idioma;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PeliculaC getCodigo_pelicula() {
        return codigo_pelicula;
    }

    public void setCodigo_pelicula(PeliculaC codigo_pelicula) {
        this.codigo_pelicula = codigo_pelicula;
    }

    public IdiomaC getCodigo_idioma() {
        return codigo_idioma;
    }

    public void setCodigo_idioma(IdiomaC codigo_idioma) {
        this.codigo_idioma = codigo_idioma;
    }
    
    
    
}
