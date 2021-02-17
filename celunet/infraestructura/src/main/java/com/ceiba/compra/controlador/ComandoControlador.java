package com.ceiba.compra.controlador;

import com.ceiba.compra.comando.ComandoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.ceiba.ComandoRespuesta;


@RequestMapping("/compras")
@Api(tags = { "Controlador comando compra"})
public interface ComandoControlador {

    @PostMapping
    @ApiOperation("Crear compra")
    ComandoRespuesta <Long> crear(@RequestBody ComandoCompra comandoCompra);

    @PutMapping("/{id}")
    @ApiOperation("Actualizar compra")
    void actualizar(@RequestBody ComandoCompra comandoCompra, @PathVariable Long id );

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar compra")
    void eliminar(@PathVariable Long id);

}
