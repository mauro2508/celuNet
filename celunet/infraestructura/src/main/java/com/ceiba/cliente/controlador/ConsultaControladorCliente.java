package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.consulta.ManejadorObtenerCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags={"Controlador consulta cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;
    private final ManejadorObtenerCliente manejadorObtenerCliente;

    @Autowired
    public ConsultaControladorCliente (ManejadorListarClientes manejadorListarClientes,
                                       ManejadorObtenerCliente manejadorObtenerCliente ){
        this.manejadorListarClientes = manejadorListarClientes;
        this.manejadorObtenerCliente = manejadorObtenerCliente;
    }

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<DtoCliente> listar(){
        return manejadorListarClientes.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("obtener cliente por id")
    public DtoCliente obtenerPorId(@PathVariable Long id){
        return this.manejadorObtenerCliente.ejecutar(id);
    }
}

