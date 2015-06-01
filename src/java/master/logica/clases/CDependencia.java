/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author Javier
 */
public class CDependencia {

    private int intCodigo;
    private Institucion objCodigoInstitucion;
    private String strCodificacion;
    private String strNombre;
    private String strObservacion;
    private int intEstado;

    public CDependencia(int intCodigo, Institucion objCodigoInstitucion, String strCodificacion, String strNombre, String strObservacion, int intEstado) {
        this.intCodigo = intCodigo;
        this.objCodigoInstitucion = objCodigoInstitucion;
        this.strCodificacion = strCodificacion;
        this.strNombre = strNombre;
        this.strObservacion = strObservacion;
        this.intEstado = intEstado;
    }

    public CDependencia() {
    }

    public int getIntCodigo() {
        return intCodigo;
    }

    public void setIntCodigo(int intCodigo) {
        this.intCodigo = intCodigo;
    }

    public Institucion getObjCodigoInstitucion() {
        return objCodigoInstitucion;
    }

    public void setObjCodigoInstitucion(Institucion objCodigoInstitucion) {
        this.objCodigoInstitucion = objCodigoInstitucion;
    }

    public String getStrCodificacion() {
        return strCodificacion;
    }

    public void setStrCodificacion(String strCodificacion) {
        this.strCodificacion = strCodificacion;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrObservacion() {
        return strObservacion;
    }

    public void setStrObservacion(String strObservacion) {
        this.strObservacion = strObservacion;
    }

    public int getIntEstado() {
        return intEstado;
    }

    public void setIntEstado(int intEstado) {
        this.intEstado = intEstado;
    }

}
