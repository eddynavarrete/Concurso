/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author Javier
 */
public class CCargoAdministrativo {
    
  private int intCodigo;
  private String strNombre;
  private String strObservacion;
  private int intEstado;

    public CCargoAdministrativo(int intCodigo, String strNombre, String strObservacion, int intEstado) {
        this.intCodigo = intCodigo;
        this.strNombre = strNombre;
        this.strObservacion = strObservacion;
        this.intEstado = intEstado;
    }

    public CCargoAdministrativo() {
    }


    
    public int getIntCodigo() {
        return intCodigo;

    }

    public void setIntCodigo(int intCodigo) {
        this.intCodigo = intCodigo;
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
