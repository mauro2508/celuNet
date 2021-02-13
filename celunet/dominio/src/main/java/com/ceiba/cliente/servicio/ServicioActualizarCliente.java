package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioActualizarCliente {

    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";

    private final RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente (RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar (Cliente cliente){
        this.repositorioCliente.actualizar(cliente);
    }
}
