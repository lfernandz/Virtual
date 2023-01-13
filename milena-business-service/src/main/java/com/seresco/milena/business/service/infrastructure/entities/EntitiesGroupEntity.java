package com.seresco.milena.business.service.infrastructure.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "NHGRP")
public class EntitiesGroupEntity implements Serializable {

    @Id
    @Column(name = "ID", length = 9, nullable = false)
    private Long id;

    @Column(name = "GRUPO_ENT")
    private int grupoEntidades; // Cód. Grupo de entidades

    @Column(name = "ANOTACION")
    private Date anotation; //    Fecha y hora anotación reg.

    @Column(name = "F_DESVIG")
    private Date fechaDesdeVigencia; // Fecha desde vigencia

    @Column(name = "F_HASVIG")
    private Date fechaHastaVigencia; // Fecha hasta vigencia

    @Column(name = "D_LARGA", length = 50)
    private String dLarga; // Denominación larga

    @Column(name = "D_CORTA", length = 20)
    private String dCorta; // Denominación corta

    @Column(name = "SIGLAS", length = 2)
    private String siglas;

    @Column(name = "CALLE", length = 40)
    private String calle;

    @Column(name = "PORTAL")
    private int portal;

    @Column(name = "BLOQUE", length = 3)
    private String bloque;

    @Column(name = "ESCALERA", length = 2)
    private String escalera;

    @Column(name = "PISO", length = 2)
    private String piso;

    @Column(name = "PUERTA", length = 2)
    private String puerta;

    @Column(name = "CODPOS")
    private int codigoPostal;

    @Column(name = "OTRAS_IND", length = 40)
    private String otrasIndicaciones;

    @Column(name = "POBLACION", length = 5)
    private String poblacion;

    @Column(name = "IND_TIPOEMPL", length = 1)
    private String tipoCodigoEmpleado; // Tipo código empleado: X,N

    @Column(name = "IND_EMPLEADO", length = 1)
    private String tipoIdentificacionEmpleado; // Ident. cód. empleado: N,C,T

    @Column(name = "LONG_CIP")
    private int longitudNomenclador; // Longitud C.I.P. / Nomenclator

    @Column(name = "IND_VAL_EMPL", length = 1)
    private String validacion; // Validación letra: S,N

    @Column(name = "IND_ID_CONT", length = 1)
    private String identificacionContable; //Identificación contable: N,E

    @Column(name = "ACTIVIDAD", length = 40)
    private String actividad; // Descripción de la actividad

    @Column(name = "ENT_CTBLE")
    private int CodigoEntidadContable;

    @Column(name = "CCC_PROV")
    private int cuentaProvicia; // Cód. cta cotización, Provincia

    @Column(name = "CCC_NUM")
    private int cuentaNumero; // Cód. cta cotización, Número

    @Column(name = "CCC_DIG")
    private int cuentaDig; // Cód. cta cotización, Díg. ctrl

    @Column(name = "BITMAP", length = 15)
    private String bitmap; // Nombre del bitmap

    @Column(name = "ANOTA_USU", length = 8)
    private String usuarioAnotation; // Usuario autor anotación reg.

    @Column(name = "ANULACION")
    private Date anulacion; // Fecha y hora anulación reg.

    @Column(name = "ANULA_USU", length = 8)
    private String usuarioAnulacion; // Usuario autor anulación reg.

    @Column(name = "CIERRE")
    private Date cierre; // Fecha y hora cierre reg.

    @Column(name = "CIERRE_USU", length = 8)
    private String usuarioCierre; // Usuario autor cierre reg.

    @Column(name = "ANOT_ORIG")
    private Date anotationOrigen; // Fecha y hora anotación origen

    @Column(name = "IND_NAU_CIP", length = 1)
    private String numeracionAutEmpleado; // Numeración aut. empleado: S,N

    @Column(name = "IND_AJUSTE_LIQ", length = 1)
    private String ajusteLiquido; // Ajuste líquido TC1: S,N

    @Column(name = "ENT_CTABLE_SUPL")
    private int codigoEntiadContable; // Cód. Entidad contab. rec. supl

    @Column(name = "IDIOMA_CON", length = 10)
    private String idiomaContrato; // Idioma Impresión contratos

    @Column(name = "CAL_FESTIVO", length = 18)
    private String codigoCalendarioFestivo; // Cód. calendario festivo

    @Column(name = "IND_IMPR_CLAU")
    private int clausulasAdicion; // Ind. Imprime clausulas adicion

    @Column(name = "IND_IMPR_RETRIB")
    private int retribuciones; // Ind. Imprime retribuciones

}