package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;

    public ComandoClienteTestDataBuilder (){
        nombre = "Mauricio";
        apellido = "Jimenez";
        email = "mauro@gmail.com";
        fechaNacimiento = LocalDate.of(1993,Month.JULY,14);
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoClienteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public ComandoClienteTestDataBuilder conApellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    public ComandoClienteTestDataBuilder conEmail(String email){
        this.email = email;
        return this;
    }

    public ComandoClienteTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ComandoCliente build(){
        return new ComandoCliente(id,nombre,apellido,email,fechaNacimiento,fechaCreacion);
    }
}
