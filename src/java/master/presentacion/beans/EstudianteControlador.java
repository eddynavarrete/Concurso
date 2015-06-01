/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Escuela;
import master.logica.funciones.FEscuela;
import master.logica.clases.Estudiante;
import master.logica.funciones.FEstudiante;
import master.logica.clases.Facultad;
import master.logica.funciones.FEstudiante;
import master.logica.clases.Periodos;
import master.logica.funciones.FPeriodos;
import master.logica.clases.Nivel;
import master.logica.funciones.FFacultad;
import master.logica.funciones.FNivel;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
/**
 *
 * @author Janneth GS
 */
@ManagedBean
@ViewScoped


public class EstudianteControlador {
    private Estudiante objEstudiante;
    private Estudiante estudianteSel;
    private ArrayList<Estudiante> lstEstudiantes;
    private ArrayList<Periodos> LstPeriodos;
    private ArrayList<Nivel> lstNiveles;
    private ArrayList<Escuela> lstEscuelas;
    private ArrayList<Facultad> lstFacultades;
    private boolean mostrarActualizar;
    private int valorPSeleccionado;
    private int valorNSeleccionado;
    private int valorESeleccionada;
    private int valorFSeleccionada;  

    public ArrayList<Escuela> getLstEscuelas() {
        return lstEscuelas;
    }

    public void setLstEscuelas(ArrayList<Escuela> lstEscuelas) {
        this.lstEscuelas = lstEscuelas;
    }

    public ArrayList<Facultad> getLstFacultades() {
        return lstFacultades;
    }

    public void setLstFacultades(ArrayList<Facultad> lstFacultades) {
        this.lstFacultades = lstFacultades;
    }

    public int getValorESeleccionada() {
        return valorESeleccionada;
    }

    public void setValorESeleccionada(int valorESeleccionada) {
        this.valorESeleccionada = valorESeleccionada;
    }

    public int getValorFSeleccionada() {
        return valorFSeleccionada;
    }

    public void setValorFSeleccionada(int valorFSeleccionada) {
        this.valorFSeleccionada = valorFSeleccionada;
    }

    

    public ArrayList<Periodos> getLstPeriodos() {
        return LstPeriodos;
    }

    public void setLstPeriodos(ArrayList<Periodos> LstPeriodos) {
        this.LstPeriodos = LstPeriodos;
    }

    public ArrayList<Nivel> getLstNiveles() {
        return lstNiveles;
    }

    public void setLstNiveles(ArrayList<Nivel> lstNiveles) {
        this.lstNiveles = lstNiveles;
    }
    
    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public int getValorPSeleccionado() {
        return valorPSeleccionado;
    }

    public void setValorPSeleccionado(int valorPSeleccionado) {
        this.valorPSeleccionado = valorPSeleccionado;
    }

    public int getValorNSeleccionado() {
        return valorNSeleccionado;
    }

    public void setValorNSeleccionado(int valorNSeleccionado) {
        this.valorNSeleccionado = valorNSeleccionado;
    }
    

    public Estudiante getObjEstudiante() {
        return objEstudiante;
    }

    public void setObjEstudiante(Estudiante objEstudiante) {
        this.objEstudiante = objEstudiante;
    }

    public Estudiante getEstudianteSel() {
        return estudianteSel;
    }

    public void setEstudianteSel(Estudiante estudianteSel) {
        this.estudianteSel = estudianteSel;
    }

    public ArrayList<Estudiante> getLstEstudiantes() {
        return lstEstudiantes;
    }

    public void setLstEstudiantes(ArrayList<Estudiante> lstEstudiantes) {
        this.lstEstudiantes = lstEstudiantes;
    }
 
    public EstudianteControlador() {
        this.reinit();
    }

    
    private void reinit(){
        this.objEstudiante = new Estudiante();
        this.estudianteSel = new Estudiante();
        this.lstEstudiantes = new ArrayList<Estudiante>();
        this.LstPeriodos = new ArrayList<Periodos>();  
        this.lstFacultades = new ArrayList<Facultad>();
        this.lstEscuelas = new ArrayList<Escuela>();
        this.lstNiveles = new ArrayList<Nivel>();
        //this.estudianteSel = this.lstEstudiantes.get(0);
        this.cargarEstudiantes();
        //this.cargarNiveles();
        this.cargarPeriodos();
        this.cargarFacultad();
        
    }
    
    public void cargarEstudiantes() {
        try {
            this.lstEstudiantes = FEstudiante.ObtenerEstudiantes();
            this.estudianteSel = lstEstudiantes.get(0);
            System.out.println(lstEstudiantes.get(0).getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEstudiante dice: " + e.getMessage());
            System.out.println("private void cargarEstudiante dice: " + e.getMessage());
        }
     }
    
    
    private void cargarPeriodos(){
        try {
            this.LstPeriodos= FPeriodos.ObtenerPeriodos();
            System.out.println(LstPeriodos.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarPeriodos dice: " + e.getMessage());
            System.out.println("private void cargarPeriodos dice: " + e.getMessage());
            }
        }
    
    private void cargarNiveles(){
        try {
            this.lstNiveles = FNivel.ObtenerNiveles();
            System.out.println(lstNiveles.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarNiveles dice: " + e.getMessage());
            System.out.println("private void cargarNiveles dice: " + e.getMessage());
            }
        }
    
    private void cargarFacultad() {
        try {
            this.lstFacultades = FFacultad.ObtenerFacultades();
            System.out.println(lstFacultades.get(0).getNombre());
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarFacultad dice: " + e.getMessage());
            System.out.println("private void cargarFacultad dice: " + e.getMessage());
        }
    }
        
     public void obtenerEscuelasDadoCodigoFacultad() {
        try {
            lstEscuelas.clear();
            lstEscuelas = FEscuela.ObtenerEscuelaDadoCodigoFacultad(valorFSeleccionada);
        } catch (Exception e) {
            Util.addErrorMessage("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
            System.out.println("private void cargarEscuelasDadoCodigoFacultad: " + e.getMessage());
        }
    }
     
        public void obtenerNivelDadoCodigoEscuela() {
        try {
            lstNiveles.clear();
            lstNiveles = FNivel.ObtenerNivelesDadoCodigoEscuela(valorESeleccionada);
        } catch (Exception e) {
            Util.addErrorMessage("private void obtenerNivelDadoCodigoEscuela: " + e.getMessage());
            System.out.println("private void obtenerNivelDadoCodigoEscuela: " + e.getMessage());
        }
    }
        
        
        public void insertarEstudiante() {
        try {
            
            Nivel nivel = new Nivel();
            nivel.setCodigo(valorNSeleccionado);
            objEstudiante.setCodigo_nivel(nivel);
            
            Periodos periodo = new Periodos();
            periodo.setCodigo(valorPSeleccionado);
            objEstudiante.setCodigo_periodo(periodo);
            
            if (FEstudiante.Insertar(objEstudiante)) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEstudiante.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void insertarEstudiante dice: Error al guardar la información");
           } else { 
                Util.addSuccessMessage("Error al guardar la información");
                System.out.println("public void insertarEstudiante dice: Error al guardar la información");
           }
        } catch (Exception e) {
            Util.addErrorMessage("private void insertarEstudiante dice: " + e.getMessage());
            System.out.println("private void insertarEstudiante dice: " + e.getMessage());
                }
        }

    public void cambiarEstadoMostrarActualizar(){
        mostrarActualizar = true;
    }
        
     public void actualizarEstudiante() {
        try {
            
            estudianteSel.setCodigo_nivel(FNivel.ObtenerNivelDadoCodigo(estudianteSel.getCodigo_nivel().getCodigo()));
            estudianteSel.setCodigo_periodo(FPeriodos.ObtenerPeriodoDadoCodigo(estudianteSel.getCodigo_periodo().getCodigo()));
            
            if (FEstudiante.actualizar(estudianteSel)) {
                estudianteSel = new Estudiante();
                mostrarActualizar = false;
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarEstudiante.hide()");
                Util.addSuccessMessage("Información guardada con éxito");
                System.out.println("public void actualizarEstudiante dice: Información guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al guardar la información");
                System.out.println("public void actualizarEstudiante dice: Error al guardar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void actualizarEstudiante dice: " + e.getMessage());
            System.out.println("private void actualizarEstudiante dice: " + e.getMessage());
        }
    }

    public void eliminarEstudiante() {
        try {
            if (FEstudiante.eliminar((int) estudianteSel.getCodigo())) {
                this.reinit();
                DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarEstudiante.hide()");
                Util.addSuccessMessage("Información eliminada.");
                System.out.println("public void eliminarEstudiante dice: Información eliminada.");
            } else {
                Util.addErrorMessage("Error al eliminar la información.");
                System.out.println("public void eliminarEstudiante dice: Error al eliminar la información");
            }
        } catch (Exception e) {
            Util.addErrorMessage("private void eliminarEstudiante dice: " + e.getMessage());
            System.out.println("private void eliminarEstudiante dice: " + e.getMessage());
        }
        
    }
    
}

