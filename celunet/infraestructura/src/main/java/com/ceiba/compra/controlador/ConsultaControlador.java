package com.ceiba.compra.controlador;

import com.ceiba.compra.modelo.dto.DtoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/compras")
@Api(tags = { "Controlador consulta compras"})
public interface ConsultaControlador {

    @GetMapping
    @ApiOperation("Listar compras")
    List<DtoCompra> listar();

    @GetMapping("/{idCliente}")
    @ApiOperation("Listar compras por cliente")
    List<DtoCompra>listarComprasPorCliente(@PathVariable Long idCliente);

    @GetMapping("/detalle/{identificadorCompra}")
    @ApiOperation("Obtiene una compra por el identificador de compra")
    DtoCompra obtenerPorIdentificadorCompra(@PathVariable String identificadorCompra);
}
