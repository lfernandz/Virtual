package com.seresco.milena.business.service.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class EntitiesGroup {

    private Long id;

    private int grupoEntidades;

    private Date anotation;

    private Date fechaDesdeVigencia;

    private Date fechaHastaVigencia;

    private String dLarga;

    private String dCorta;

    private String siglas;

    private String calle;

    private int portal;

    private String bloque;

    private String escalera;

    private String piso;

    private String puerta;

    private int codigoPostal;

    private String otrasIndicaciones;

    private String poblacion;

    private String tipoCodigoEmpleado;

    private String tipoIdentificacionEmpleado;

    private int longitudNomenclador;

    private String validacion;

    private String identificacionContable;

    private String actividad;

    private int CodigoEntidadContable;

    private int cuentaProvicia;

    private int cuentaNumero;

    private int cuentaDig;

    private String bitmap;

    private String usuarioAnotation;

    private Date anulacion;

    private String usuarioAnulacion;

    private Date cierre;

    private String usuarioCierre;

    private Date anotationOrigen;

    private String numeracionAutEmpleado;

    private String ajusteLiquido;

    private int codigoEntiadContable;

    private String idiomaContrato;

    private String codigoCalendarioFestivo;

    private int clausulasAdicion;

    private int retribuciones;

}

