package com.ceiba.cliente.controlador;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarCliente;
import com.ceiba.usuario.comando.ComandoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ceiba.ComandoRespuesta;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;

    @Autowired
    public ComandoControladorCliente (ManejadorCrearCliente manejadorCrearCliente,
                                      ManejadorActualizarCliente manejadorActualizarCliente,
                                      ManejadorEliminarCliente manejadorEliminarCliente ){
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;

    }

    @PostMapping
    @ApiOperation("Crear cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente){
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar cliente")
    public void eliminar (@PathVariable Long id){
        manejadorEliminarCliente.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar cliente")
    public void actualizar(@RequestBody ComandoCliente comandoCliente, @PathVariable Long id){
        comandoCliente.setId(id);
        manejadorActualizarCliente.ejecutar(comandoCliente);
    }
}
