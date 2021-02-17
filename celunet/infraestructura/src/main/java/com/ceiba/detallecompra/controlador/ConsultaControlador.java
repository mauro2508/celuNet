package com.ceiba.detallecompra.controlador;

import com.ceiba.detalleCompra.modelo.dto.DtoDetalleCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/detallesCompra")
@Api(tags = { "Controlador consulta detalles compra"})
public interface ConsultaControlador {

    @GetMapping()
    @ApiOperation("Lista los detalles de compras")
    List<DtoDetalleCompra> listar();

    @GetMapping("/{idCompra}")
    @ApiOperation("Lista los detalles de una compra")
    List<DtoDetalleCompra> listarDetallesPorCompra(Long idCompra);

}
