package com.ceiba.compra.controlador;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.manejador.ManejadorActualizarCompra;
import com.ceiba.compra.comando.manejador.ManejadorCrearCompra;
import com.ceiba.compra.comando.manejador.ManejadorEliminarCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ceiba.ComandoRespuesta;

@RestController
@RequestMapping("/compras")
@Api(tags = { "Controlador comando compra"})
public class ComandoControladorCompra{

    private final ManejadorCrearCompra manejadorCrearCompra;
    private final ManejadorActualizarCompra manejadorActualizarCompra;
    private final ManejadorEliminarCompra manejadorEliminarCompra;

    @Autowired
    public ComandoControladorCompra (ManejadorCrearCompra manejadorCrearCompra,
                                     ManejadorActualizarCompra manejadorActualizarCompra,
                                     ManejadorEliminarCompra manejadorEliminarCompra){
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorActualizarCompra = manejadorActualizarCompra;
        this.manejadorEliminarCompra = manejadorEliminarCompra;

    }

    @PostMapping
    @ApiOperation("Crear compra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCompra comandoCompra) {
        return this.manejadorCrearCompra.ejecutar(comandoCompra);
    }


    @PutMapping("/{id}")
    @ApiOperation("Actualizar compra")
    public void actualizar(@RequestBody ComandoCompra comandoCompra, @PathVariable Long id) {
        comandoCompra.setId(id);
        this.manejadorActualizarCompra.ejecutar(comandoCompra);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar compra")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarCompra.ejecutar(id);
    }
}
