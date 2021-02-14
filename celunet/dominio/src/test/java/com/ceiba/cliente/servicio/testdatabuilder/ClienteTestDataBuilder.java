package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteTestDataBuilder {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;

    public ClienteTestDataBuilder(){
        this.nombre = "pedro";
        this.apellido = "Guarin";
        this.email = "pedro@gmail.com";
        this.fechaNacimiento = LocalDate.of(1990,1,1);
        this.fechaCreacion = LocalDateTime.now();
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Cliente build(){
        return new Cliente(id,nombre,apellido,email,fechaNacimiento,fechaCreacion);
    }
}
