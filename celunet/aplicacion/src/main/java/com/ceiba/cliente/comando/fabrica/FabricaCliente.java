package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaCliente {

    public Cliente crear(ComandoCliente comandoCliente){
        return new Cliente(comandoCliente.getId(),
                comandoCliente.getNombre(), comandoCliente.getApellido(),
                comandoCliente.getEmail(),comandoCliente.getFechaNacimiento(),
                comandoCliente.getFechaCreacion());

    }
}
