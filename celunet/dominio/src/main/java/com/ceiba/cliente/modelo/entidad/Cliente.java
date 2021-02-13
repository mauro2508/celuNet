package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_EL_EMAIL = "Se debe ingresar el email";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_CLIENTE = "Se debe ingresar el apellido del cliente";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;

    public Cliente(Long id, String nombre, String apellido, String email, LocalDate fechaNacimiento, LocalDateTime fechaCreacion){
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_CLIENTE);
        validarObligatorio(email, SE_DEBE_INGRESAR_EL_EMAIL);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
    }


}
