package com.ceiba.detallecompra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.detallecompra.comando.ComandoDetalleCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/detallesCompra")
@Api(tags = { "Controlador comando detalles compra"})
public interface ComandoControlador {

    @PostMapping
    @ApiOperation("Crear detalle Compra")
    ComandoRespuesta <Long> crear(@RequestBody ComandoDetalleCompra comandoDetalleCompra);

    @PutMapping("/{id}")
    @ApiOperation("Actualizar detalle Compra")
    void actualizar(@RequestBody ComandoDetalleCompra comandoDetalleCompra, @PathVariable Long id);

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar detalle compra")
    void eliminar(@PathVariable Long id);
}
