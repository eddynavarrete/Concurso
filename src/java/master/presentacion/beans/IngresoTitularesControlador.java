//﻿/*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package master.presentacion.beans;
//
//import ec.edu.espoch.baseglobal.negocio.global.interop.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.xml.ws.WebServiceRef;
//import master.logica.clases.*;
//import master.logica.funciones.FEmpresa;
//import master.logica.funciones.FPersona;
//import master.logica.funciones.FTipoTitular;
//import org.primefaces.context.DefaultRequestContext;
//import recursos.Validaciones;
//
///**
// *
// * @author DiegoPalacios
// */
//@ManagedBean
//@ViewScoped
//public class IngresoTitularesControlador implements Serializable {
//
//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/webcentral.espoch.edu.ec/GlobalEspoch_Interop/manipulacionInfoAcademicaService.wsdl")
//    private ManipulacionInfoAcademicaService service_1;
//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/webcentral.espoch.edu.ec/GlobalEspoch_Interop/infoGeneralService.wsdl")
//    private InfoGeneralService service;
//    private java.util.List<ec.edu.espoch.baseglobal.negocio.global.interop.Provincia> provincias;
//    private java.util.List<ec.edu.espoch.baseglobal.negocio.global.interop.Ciudad> ciudades;
//    private int valorPaisSeleccionado;
//    private int valorProvinciaSeleccionado;
//    private int valorCiudadSeleccionado;
//    private int valorCriterioBusquedaPersona;
//    @ManagedProperty(value = "#{datosAplicacionControladorDataManager}")
//    private DatosAplicacionControladorDataManager dm;
//    @ManagedProperty(value = "#{busquedaTitularesControlador}")
//    private BusquedaTitularesControlador dmselectedPersona;
//    private DatosAplicacionControladorDataManager dm;
//    private ec.edu.espoch.baseglobal.negocio.global.interop.PersonaCompleto persona;
//    private ec.edu.espoch.baseglobal.negocio.global.interop.Direccion direccion;
//    private ec.edu.espoch.baseglobal.negocio.global.interop.Ciudad ciudad;
//    private master.logica.clases.Persona personaFinanciero;
//      private ArrayList<master.logica.clases.Persona> personasFinanciero;
//    private master.logica.clases.Persona personaRepresentanteLegal;
//    private Empresa empresa;
//    private Titular titular;
//    private int valorTipoTitularSeleccionado;
//    private TipoTitular tipoTitular;
//    private boolean mostrarDialogoNuevaEmpresa;
//    private boolean mostrarDialogoNuevaPersona;
//    private boolean mostrarDialogoSeleccioneOpcion;
//    private Ruc ruc;
//    private Representante_Legal representanteLegal;
//    private String criterioBusquedaRLegal;
//
//     private PersonaRuc selectedPersona;
//      private int valorCriterioSeleccionado;
//    public IngresoTitularesControlador() {
//        try {
//            provincias = new ArrayList<ec.edu.espoch.baseglobal.negocio.global.interop.Provincia>();
//            ciudades = new ArrayList<ec.edu.espoch.baseglobal.negocio.global.interop.Ciudad>();
//            persona = new ec.edu.espoch.baseglobal.negocio.global.interop.PersonaCompleto();
//            direccion = new ec.edu.espoch.baseglobal.negocio.global.interop.Direccion();
//            ciudad = new ec.edu.espoch.baseglobal.negocio.global.interop.Ciudad();
//            personaFinanciero = new master.logica.clases.Persona();
//              personasFinanciero= new ArrayList<master.logica.clases.Persona>();
//            personaRepresentanteLegal = new master.logica.clases.Persona();
//            ruc = new Ruc();
//            provincias.clear();
//            ciudades.clear();
//            this.obtenerProvinciasDadoPais();
//            this.obtenerCiudadesDadoProvincia();
//            mostrarDialogoNuevaEmpresa = false;
//            mostrarDialogoNuevaPersona = false;
//            mostrarDialogoSeleccioneOpcion = false;
//            titular = new Titular();
//            titular.setContrib_especial(false);
//            tipoTitular = new TipoTitular();
//            empresa = new Empresa();
//            representanteLegal = new Representante_Legal();
//            personaRepresentanteLegal.setApellido_paternno("Sin Representante Legal");
//                selectedPersona = new PersonaRuc();
//            System.out.println("PASO");
//        } catch (java.lang.Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    public List<Ciudad> getCiudades() {
//        return ciudades;
//    }
//
//    public int getValorCiudadSeleccionado() {
//        return valorCiudadSeleccionado;
//    }
//
//    public void setValorCiudadSeleccionado(int valorCiudadSeleccionado) {
//        this.valorCiudadSeleccionado = valorCiudadSeleccionado;
//    }
//
//    public void setCiudades(List<Ciudad> ciudades) {
//        this.ciudades = ciudades;
//    }
//
//    public List<Provincia> getProvincias() {
//        return provincias;
//    }
//
//    public void setProvincias(List<Provincia> provincias) {
//        this.provincias = provincias;
//    }
//
//    public InfoGeneralService getService() {
//        return service;
//    }
//
//    public void setService(InfoGeneralService service) {
//        this.service = service;
//    }
//
//    public int getValorPaisSeleccionado() {
//        return valorPaisSeleccionado;
//    }
//
//    public void setValorPaisSeleccionado(int valorPaisSeleccionado) {
//        this.valorPaisSeleccionado = valorPaisSeleccionado;
//    }
//
//    public int getValorProvinciaSeleccionado() {
//        return valorProvinciaSeleccionado;
//    }
//
//    public void setValorProvinciaSeleccionado(int valorProvinciaSeleccionado) {
//        this.valorProvinciaSeleccionado = valorProvinciaSeleccionado;
//    }
//
//    public void obtenerProvinciasDadoPais() throws java.lang.Exception {
//        service = new InfoGeneralService();
//        ec.edu.espoch.baseglobal.negocio.global.interop.InfoGeneral port = service.getInfoGeneralPort();
//        provincias = port.getProvincias(valorPaisSeleccionado);
//        if (provincias.isEmpty()) {
//            provincias.clear();
//            ciudades.clear();
//        } else {
//            valorProvinciaSeleccionado = 0;
//            ciudades.clear();
//            ciudades = port.getCiudades(valorProvinciaSeleccionado);
//        }
//    }
//
//    public void obtenerCiudadesDadoProvincia() throws java.lang.Exception {
//        service = new InfoGeneralService();
//        ec.edu.espoch.baseglobal.negocio.global.interop.InfoGeneral port = service.getInfoGeneralPort();
//        ciudades = port.getCiudades(valorProvinciaSeleccionado);
//    }
//
//    /**
//     * @return the dm
//     */
//    public DatosAplicacionControladorDataManager getDm() {
//        return dm;
//    }
//
//    /**
//     * @param dm the dm to set
//     */
//    public void setDm(DatosAplicacionControladorDataManager dm) {
//        this.dm = dm;
//    }
//
//    public boolean validarCedula() {
//        boolean b = false;
//        if (persona.getCedula().length() == 10) {
//            StringBuffer str = new StringBuffer(persona.getCedula());
//            java.lang.String strCedula = str.insert(9, "-").toString();
//            b = Validaciones.ValidaCedula(strCedula);
//        } else {
//            b = false;
//        }
//        return b;
//    }
//
//    public void obtenerPersonaDadoCriterioBusqueda() {
//        ///////////////////////HASTA AQUI
//        por cedula
//        if (valorCriterioBusquedaPersona == 0) {
//            try {
//                  personaFinanciero = null;
//                personaRepresentanteLegal = FPersona.ObtenerPersonaDadoIdentificacion("cedula", criterioBusquedaRLegal);
//                if (personaRepresentanteLegal.getCodigo_global() != 0) {
//                    representanteLegal.setCodigo_titular_empresa(empresa);
//                    representanteLegal.setCodigo_titular_persona(personaRepresentanteLegal);
//                    representanteLegal.setEstado(1);
//
//                    DefaultRequestContext.getCurrentInstance().execute("dialogoBuscarRepresentanteLegal.hide()");
//                } else {
//                    personaRepresentanteLegal.setApellido_paternno("No existen datos");
//                    DefaultRequestContext.getCurrentInstance().execute("dialogoBuscarRepresentanteLegal.hide()");
//                       personaRepresentanteLegal=null;
//                }
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//
//        } else {
//          //  por pasaporte
//            if (valorCriterioBusquedaPersona == 1) {
//
//                try {
//                      personaFinanciero = null;
//                    personaRepresentanteLegal = FPersona.ObtenerPersonaDadoIdentificacion("pasaporte", criterioBusquedaRLegal);
//                    if (personaRepresentanteLegal.getCodigo_global() != 0) {
//                        representanteLegal.setCodigo_titular_empresa(empresa);
//                        representanteLegal.setCodigo_titular_persona(personaRepresentanteLegal);
//                        representanteLegal.setEstado(1);
//
//                        DefaultRequestContext.getCurrentInstance().execute("dialogoBuscarRepresentanteLegal.hide()");
//                    } else {
//                        personaRepresentanteLegal.setApellido_paternno("No existen datos");
//                        DefaultRequestContext.getCurrentInstance().execute("dialogoBuscarRepresentanteLegal.hide()");
//                           personaRepresentanteLegal=null;
//                    }
//
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//
//            } else {
//                por ruc
//                if (valorCriterioBusquedaPersona == 2) {
//                    try {
//                          personaFinanciero = null;
//                        personaRepresentanteLegal = FPersona.ObtenerPersonaDadoIdentificacion("ruc", criterioBusquedaRLegal);
//                        if (personaRepresentanteLegal.getCodigo_global() != 0) {
//                            representanteLegal.setCodigo_titular_empresa(empresa);
//                            representanteLegal.setCodigo_titular_persona(personaRepresentanteLegal);
//                            representanteLegal.setEstado(1);
//
//                            DefaultRequestContext.getCurrentInstance().execute("dialogoBuscarRepresentanteLegal.hide()");
//                        } else {
//                            personaRepresentanteLegal.setApellido_paternno("No existen datos");
//                            DefaultRequestContext.getCurrentInstance().execute("dialogoBuscarRepresentanteLegal.hide()");
//                               personaRepresentanteLegal=null;
//                        }
//
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                } else {
//                }
//            }
//
//        }
//    }
//
//    public void mensaje() {
//        System.out.print("Mensaje");
//
//    }
//    Insercion a la base de datos centralizada a la base de datos FINANCIERO_DB schema master
//
//    public void insertarPersona() {
//        if ((tipoTitular.getDescripcion().toString().equals("NATURAL NACIONAL"))) {
//            minimo la cedula Y Calcular RUC para naturales
//            if (persona.getCedula().isEmpty()) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La cédula es un campo requerido para personas NATURALES - NACIONALES", null));
//                txtCedula.requestFocus();
//            } else {
//                boolean bandera = validarCedula();
//                if (bandera == true) {
//                    if (ruc.getIdentificacion().isEmpty()) {
//                        procesoInsertarPersona();
//                    } else {
//                        boolean band = recursos.ValidaRucNaturales.validacionCedula(ruc.getIdentificacion());
//                        if (band == true) {
//                            procesoInsertarPersona();
//                        } else {
//                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ruc érroneo", null));
//                              txtRUC.requestFocus();
//                        }
//                    }
//
//                } else {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cédula érronea", null));
//                    txtCedula.requestFocus();
//                }
//            }
//
//
//        } else {
//            if ((tipoTitular.getDescripcion().toString().equals("SOCIEDAD"))) {
//                /minimo ruc
//                if (ruc.getIdentificacion().isEmpty()) {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El ruc es un campo requerido para SOCIEDADES", null));
//                    txtCedula.requestFocus();
//                } else {
//                    boolean band = recursos.ValidaRucJuridicos_Extranjeros.validacionRUC(ruc.getIdentificacion());
//                    if (band == true) {
//                        procesoInsertarEmpresa();
//
//                    } else {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ruc érroneo", null));
//                    }
//                }
//            } else {
//                if (((tipoTitular.getDescripcion().toString().equals("NATURAL EXTRANJERA RESIDENTE")))
//                        || ((tipoTitular.getDescripcion().toString().toString().equals("NATURAL EXTRANJERA NO RESIDENTE")))) {
//                    minimo el pasaporte
//                    if (persona.getPasaporte().isEmpty()) {
//                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El pasaporte es un campo requerido para EXTRANJEROS", null));
//                        txtPasaporte.requestFocus();
//                    } else {
//                        if (persona.getCedula().isEmpty()) {
//                        } else {
//                            boolean bandera = validarCedula();
//                            if (bandera == true) {
//                            } else {
//                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cédula érronea", null));
//                                txtCedula.requestFocus();
//                            }
//                        }
//                        if (ruc.getIdentificacion().isEmpty()) {
//                            procesoInsertarPersona();
//                        } else {
//                            boolean bandera = recursos.ValidaRucJuridicos_Extranjeros.validacionRUC(ruc.getIdentificacion());
//                            if (bandera == true) {
//                                procesoInsertarPersona();
//                            } else {
//                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ruc érroneo", null));
//                                txtCedula.requestFocus();
//                            }
//                        }
//                    }
//                } else {
//
//
//                    if ((tipoTitular.getDescripcion().toString().equals("SOCIEDAD PUBLICA"))) {
//                        minimo el ruc
//                        if (ruc.getIdentificacion().isEmpty()) {
//                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El ruc es un campo requerido para SOCIEDADES PUBLICAS", null));
//                        } else {
//                            boolean band = recursos.ValidaRucEP.validaRucEP(ruc.getIdentificacion());
//                            if (band == true) {
//
//                                procesoInsertarEmpresa();
//
//                            } else {
//                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ruc érroneo", null));
//                            }
//                        }
//                    } else {
//                    }
//                }
//            }
//        }
//    }
//
//    public void procesoInsertarPersona() {
//        try {
//            service_1 = new ec.edu.espoch.baseglobal.negocio.global.interop.ManipulacionInfoAcademicaService();
//            ec.edu.espoch.baseglobal.negocio.global.interop.ManipulacionInfoAcademica port = service_1.getManipulacionInfoAcademicaPort();
//            ec.edu.espoch.baseglobal.negocio.global.interop.Credencial credencial = new ec.edu.espoch.baseglobal.negocio.global.interop.Credencial();
//            credencial.setSistema("Financiero");
//            credencial.setToken("sistemaFINANCIEROespoch2010");
//            credencial.setCedula("0603094517");
//            persona.setApellidos(personaFinanciero.getApellido_paternno().toUpperCase());
//            persona.setNombres(personaFinanciero.getPrimer_nombre().toUpperCase());
//            persona.setRuc(ruc.getIdentificacion());
//            persona.setCodigo("0");
//            ciudad.setCodigo(valorCiudadSeleccionado);
//            direccion.setCiudad(ciudad);
//            direccion.setPersona(null);
//            persona.setDireccion(direccion);
//            persona.setVive(true);
//            long result = port.manejaPersona(persona, credencial);
//            if (result > 0) {
//                insertamos en FINANCIERO_DB
//                titular.setFecha_registro(recursos.Tools.obtieneFechaActualenMiliseg());
//                titular.setCodigo_tipo_titular(tipoTitular);
//                /ruc
//                if (!ruc.getIdentificacion().isEmpty()) {
//                    ruc.setCodigo_titular(titular);
//                    ruc.setEstado(1);
//                } else {
//                    ruc = null;
//                }
//
//
//                personaFinanciero.setCodigo_global(result);
//                personaFinanciero.setCedula(persona.getCedula());
//                personaFinanciero.setPasaporte(persona.getPasaporte());
//                personaFinanciero.setCodigo_titular(titular);
//                personaFinanciero.setApellido_paternno(personaFinanciero.getApellido_paternno().toUpperCase());
//                personaFinanciero.setApellido_materno(personaFinanciero.getApellido_paternno().toUpperCase());
//                personaFinanciero.setPrimer_nombre(personaFinanciero.getPrimer_nombre().toUpperCase());
//                personaFinanciero.setSegundo_nombre(personaFinanciero.getPrimer_nombre().toUpperCase());
//                insertamos en Financiero_DB
//                boolean bandera = FPersona.insertar(personaFinanciero, ruc);
//                if (bandera) {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos Insertados con exito", null));
//                    DefaultRequestContext.getCurrentInstance().execute("wdialogoNuevaPersona.hide()");
//                    limpiar objetos
//                    persona = new PersonaCompleto();
//                    personaFinanciero = new master.logica.clases.Persona();
//                    ciudad = new Ciudad();
//                    direccion = new Direccion();
//                    titular = new Titular();
//                    ruc = new Ruc();
//                } else {
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al insertar los datos", null));
//                }
//
//
//            } else {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al insertar los datos", null));
//            }
//
//        } catch (java.lang.Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
//        }
//    }
//
//    public void procesoInsertarEmpresa() {
//        try {
//
//            /representante legal
//            representanteLegal.setCodigo_titular_empresa(empresa);
//
//            representanteLegal.setCodigo_titular_persona(personaRepresentanteLegal);
//            representanteLegal.setEstado(1);
//            paises
//
//            titular.setFecha_registro(recursos.Tools.obtieneFechaActualenMiliseg());
//            titular.setCodigo_tipo_titular(tipoTitular);
//            /ruc
//            ruc.setCodigo_titular(titular);
//            ruc.setEstado(1);
//
//            titular.setCodigo_tipo_titular(tipoTitular);
//            /
//            empresa.setCodigo_titular(titular);
//            empresa.setCiudad(valorCiudadSeleccionado);
//            empresa.setProvincia(valorProvinciaSeleccionado);
//            empresa.setPais(valorPaisSeleccionado);
//
//            boolean b = FEmpresa.insertar(empresa, ruc, representanteLegal);
//            if (b) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos Insertados con exito", null));
//                DefaultRequestContext.getCurrentInstance().execute("wdialogoNuevaEmpresa.hide()");
//                limpiar objetos
//                personaRepresentanteLegal = new master.logica.clases.Persona();
//                titular = new Titular();
//                ruc = new Ruc();
//                empresa = new Empresa();
//                representanteLegal = new Representante_Legal();
//            } else {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al insertar los datos", null));
//            }
//
//        } catch (java.lang.Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
//        }
//    }
//
//    /**
//     * @return the persona
//     */
//    public ec.edu.espoch.baseglobal.negocio.global.interop.PersonaCompleto getPersona() {
//        System.out.println("GET PERSONA: " + persona.getCedula());
//        return persona;
//    }
//
//    /**
//     * @param persona the persona to set
//     */
//    public void setPersona(ec.edu.espoch.baseglobal.negocio.global.interop.PersonaCompleto persona) {
//        System.out.println("SET PERSONA: " + persona.getCedula());
//        this.persona = persona;
//    }
//
//    /**
//     * @return the direccion
//     */
//    public ec.edu.espoch.baseglobal.negocio.global.interop.Direccion getDireccion() {
//        return direccion;
//    }
//
//    /**
//     * @param direccion the direccion to set
//     */
//    public void setDireccion(ec.edu.espoch.baseglobal.negocio.global.interop.Direccion direccion) {
//        this.direccion = direccion;
//    }
//
//    /**
//     * @return the ciudad
//     */
//    public ec.edu.espoch.baseglobal.negocio.global.interop.Ciudad getCiudad() {
//        return ciudad;
//    }
//
//    /**
//     * @param ciudad the ciudad to set
//     */
//    public void setCiudad(ec.edu.espoch.baseglobal.negocio.global.interop.Ciudad ciudad) {
//        this.ciudad = ciudad;
//    }
//
//    public master.logica.clases.Persona getPersonaFinanciero() {
//        return personaFinanciero;
//    }
//
//    /**
//     * @param personaFinanciero the personaFinanciero to set
//     */
//    public void setPersonaFinanciero(master.logica.clases.Persona personaFinanciero) {
//        this.personaFinanciero = personaFinanciero;
//    }
//
//    /**
//     * @return the titular
//     */
//    public Titular getTitular() {
//        return titular;
//    }
//
//    /**
//     * @param titular the titular to set
//     */
//    public void setTitular(Titular titular) {
//        this.titular = titular;
//    }
//
//    public void activarDialogos() {
//
//        try {
//            if (tipoTitular.getDescripcion() != null || tipoTitular != null) {
//                if (tipoTitular.getDescripcion().startsWith("NATURAL")) {
//                    setMostrarDialogoNuevaEmpresa(false);
//                    setMostrarDialogoSeleccioneOpcion(false);
//                    setMostrarDialogoNuevaPersona(true);
//                    DefaultRequestContext.getCurrentInstance().execute("wdialogoNuevaPersona.show();wwizP.loadStep(wwizP.cfg.steps[0], true);");
//                } else {
//                    if (tipoTitular.getDescripcion().startsWith("SOCIEDAD")) {
//                        setMostrarDialogoNuevaEmpresa(true);
//                        setMostrarDialogoNuevaPersona(false);
//                        setMostrarDialogoSeleccioneOpcion(false);
//                        DefaultRequestContext.getCurrentInstance().execute("wdialogoNuevaEmpresa.show();wwizE.loadStep(wwizE.cfg.steps[0], true);");
//                    } else {
//                        if (valorTipoTitularSeleccionado == 0) {
//                            setMostrarDialogoNuevaEmpresa(false);
//                            setMostrarDialogoNuevaPersona(false);
//                            setMostrarDialogoSeleccioneOpcion(true);
//                            DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//
//                        } else {
//                            setMostrarDialogoNuevaEmpresa(false);
//                            setMostrarDialogoNuevaPersona(false);
//                            setMostrarDialogoSeleccioneOpcion(true);
//                            DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//                        }
//                    }
//                }
//            } else {
//                setMostrarDialogoNuevaEmpresa(false);
//                setMostrarDialogoNuevaPersona(false);
//                setMostrarDialogoSeleccioneOpcion(true);
//                DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//            }
//             personaFinanciero=null;
//            System.out.print("PASO EL CONTROL DE DIALOGOS");
//        } catch (java.lang.Exception e) {
//            System.out.print("NO PASO EL CONTROL DE DIALOGOS");
//            System.out.print(e.getMessage());
//            DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//            setMostrarDialogoNuevaEmpresa(false);
//            setMostrarDialogoNuevaPersona(false);
//            setMostrarDialogoSeleccioneOpcion(true);
//        }
//
//    }
//
//    public void activarDialogosBusqueda() {
//
//        try {
//            if (tipoTitular.getDescripcion() != null || tipoTitular != null) {
//                if (tipoTitular.getDescripcion().startsWith("NATURAL")) {
//                    setMostrarDialogoNuevaEmpresa(false);
//                    setMostrarDialogoSeleccioneOpcion(false);
//                    setMostrarDialogoNuevaPersona(true);
//                    DefaultRequestContext.getCurrentInstance().execute("wdialogoBusquedaPersonas.show()");
//                } else {
//                    if (tipoTitular.getDescripcion().startsWith("SOCIEDAD")) {
//                        setMostrarDialogoNuevaEmpresa(true);
//                        setMostrarDialogoNuevaPersona(false);
//                        setMostrarDialogoSeleccioneOpcion(false);
//                        DefaultRequestContext.getCurrentInstance().execute("wdialogoBusquedaEmpresas.show()");
//                    } else {
//                        if (valorTipoTitularSeleccionado == 0) {
//                            setMostrarDialogoNuevaEmpresa(false);
//                            setMostrarDialogoNuevaPersona(false);
//                            setMostrarDialogoSeleccioneOpcion(true);
//                            DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//
//                        } else {
//                            setMostrarDialogoNuevaEmpresa(false);
//                            setMostrarDialogoNuevaPersona(false);
//                            setMostrarDialogoSeleccioneOpcion(true);
//                            DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//                        }
//                    }
//                }
//            } else {
//                setMostrarDialogoNuevaEmpresa(false);
//                setMostrarDialogoNuevaPersona(false);
//                setMostrarDialogoSeleccioneOpcion(true);
//                DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//            }
//             personaFinanciero=null;
//            System.out.print("PASO EL CONTROL DE DIALOGOS");
//        } catch (java.lang.Exception e) {
//            System.out.print("NO PASO EL CONTROL DE DIALOGOS");
//            System.out.print(e.getMessage());
//            DefaultRequestContext.getCurrentInstance().execute("wdialogoSeleccioneOpcion.show()");
//            setMostrarDialogoNuevaEmpresa(false);
//            setMostrarDialogoNuevaPersona(false);
//            setMostrarDialogoSeleccioneOpcion(true);
//        }
//
//    }
//
//    public void obtenerTipotularDadoCodigo() throws java.lang.Exception {
//        tipoTitular = null;
//        try {
//            setTipoTitular(FTipoTitular.ObtenerTipoTitularDadoCodigo(getValorTipoTitularSeleccionado()));
//        } catch (java.lang.Exception e) {
//            System.out.print(e.getMessage());
//        }
//    }
//
//    /**
//     * @return the valorTipoTitularSeleccionado
//     */
//    public int getValorTipoTitularSeleccionado() {
//        return valorTipoTitularSeleccionado;
//    }
//
//    /**
//     * @param valorTipoTitularSeleccionado the valorTipoTitularSeleccionado to
//     * set
//     */
//    public void setValorTipoTitularSeleccionado(int valorTipoTitularSeleccionado) {
//        this.valorTipoTitularSeleccionado = valorTipoTitularSeleccionado;
//    }
//
//    /**
//     * @return the tipoTitular
//     */
//    public TipoTitular getTipoTitular() {
//        return tipoTitular;
//    }
//
//    /**
//     * @param tipoTitular the tipoTitular to set
//     */
//    public void setTipoTitular(TipoTitular tipoTitular) {
//        this.tipoTitular = tipoTitular;
//    }
//
//    /**
//     * @return the mostrarDialogoNuevaEmpresa
//     */
//    public boolean isMostrarDialogoNuevaEmpresa() {
//        return mostrarDialogoNuevaEmpresa;
//    }
//
//    /**
//     * @param mostrarDialogoNuevaEmpresa the mostrarDialogoNuevaEmpresa to set
//     */
//    public void setMostrarDialogoNuevaEmpresa(boolean mostrarDialogoNuevaEmpresa) {
//        this.mostrarDialogoNuevaEmpresa = mostrarDialogoNuevaEmpresa;
//    }
//
//    /**
//     * @return the mostrarDialogoNuevaPersona
//     */
//    public boolean isMostrarDialogoNuevaPersona() {
//        return mostrarDialogoNuevaPersona;
//    }
//
//    /**
//     * @param mostrarDialogoNuevaPersona the mostrarDialogoNuevaPersona to set
//     */
//    public void setMostrarDialogoNuevaPersona(boolean mostrarDialogoNuevaPersona) {
//        this.mostrarDialogoNuevaPersona = mostrarDialogoNuevaPersona;
//    }
//
//    /**
//     * @return the ruc
//     */
//    public Ruc getRuc() {
//        return ruc;
//    }
//
//    /**
//     * @param ruc the ruc to set
//     */
//    public void setRuc(Ruc ruc) {
//        this.ruc = ruc;
//    }
//
//    /**
//     * @return the mostrarDialogoSeleccioneOpcion
//     */
//    public boolean isMostrarDialogoSeleccioneOpcion() {
//        return mostrarDialogoSeleccioneOpcion;
//    }
//
//    /**
//     * @param mostrarDialogoSeleccioneOpcion the mostrarDialogoSeleccioneOpcion
//     * to set
//     */
//    public void setMostrarDialogoSeleccioneOpcion(boolean mostrarDialogoSeleccioneOpcion) {
//        this.mostrarDialogoSeleccioneOpcion = mostrarDialogoSeleccioneOpcion;
//    }
//
//    /**
//     * @return the empresa
//     */
//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    /**
//     * @param empresa the empresa to set
//     */
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }
//
//    /**
//     * @return the valorCriterioBusquedaPersona
//     */
//    public int getValorCriterioBusquedaPersona() {
//        return valorCriterioBusquedaPersona;
//    }
//
//    /**
//     * @param valorCriterioBusquedaPersona the valorCriterioBusquedaPersona to
//     * set
//     */
//    public void setValorCriterioBusquedaPersona(int valorCriterioBusquedaPersona) {
//        this.valorCriterioBusquedaPersona = valorCriterioBusquedaPersona;
//    }
//
//    /**
//     * @return the representanteLegal
//     */
//    public Representante_Legal getRepresentanteLegal() {
//        return representanteLegal;
//    }
//
//    /**
//     * @param representanteLegal the representanteLegal to set
//     */
//    public void setRepresentanteLegal(Representante_Legal representanteLegal) {
//        this.representanteLegal = representanteLegal;
//    }
//
//    /**
//     * @return the personaRepresentanteLegal
//     */
//    public master.logica.clases.Persona getPersonaRepresentanteLegal() {
//        return personaRepresentanteLegal;
//    }
//
//    /**
//     * @param personaRepresentanteLegal the personaRepresentanteLegal to set
//     */
//    public void setPersonaRepresentanteLegal(master.logica.clases.Persona personaRepresentanteLegal) {
//        this.personaRepresentanteLegal = personaRepresentanteLegal;
//    }
//
//    /**
//     * @return the criterioBusquedaRLegal
//     */
//    public String getCriterioBusquedaRLegal() {
//        return criterioBusquedaRLegal;
//    }
//
//    /**
//     * @param criterioBusquedaRLegal the criterioBusquedaRLegal to set
//     */
//    public void setCriterioBusquedaRLegal(String criterioBusquedaRLegal) {
//        this.criterioBusquedaRLegal = criterioBusquedaRLegal;
//    }
//
//    public void asignarSelectedRepresentanteLegal() {
//        try {
//            personaRepresentanteLegal = FPersona.ObtenerPersonaDadoCodigo(dmselectedPersona.getSelectedPersona().getCodigo());
//            System.out.print(personaRepresentanteLegal.getCedula());
//        } catch (java.lang.Exception e) {
//            System.out.print(dmselectedPersona.getSelectedPersona().getApellido_paternno() + " " + e.getMessage());
//        }
//        DefaultRequestContext.getCurrentInstance().execute("dialogoBusquedaPersonas.hide()");
//        DefaultRequestContext.getCurrentInstance().execute("wdialogoNuevaEmpresa.show()");
//    }
//
//    /**
//     * @return the dmselectedPersona
//     */
//    public BusquedaTitularesControlador getDmselectedPersona() {
//        return dmselectedPersona;
//    }
//
//    /**
//     * @param dmselectedPersona the dmselectedPersona to set
//     */
//    public void setDmselectedPersona(BusquedaTitularesControlador dmselectedPersona) {
//        this.dmselectedPersona = dmselectedPersona;
//    }
//}
