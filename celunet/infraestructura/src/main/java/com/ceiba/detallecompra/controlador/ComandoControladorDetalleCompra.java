package com.ceiba.detallecompra.controlador;

import com.ceiba.detallecompra.comando.ComandoDetalleCompra;
import com.ceiba.detallecompra.comando.manejador.ManejadorActualizarDetalleCompra;
import com.ceiba.detallecompra.comando.manejador.ManejadorCrearDetalleCompra;
import com.ceiba.detallecompra.comando.manejador.ManejadorEliminarDetalleCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.ceiba.ComandoRespuesta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detallesCompra")
@Api(tags = { "Controlador comando detalles compra"})
public class ComandoControladorDetalleCompra{

    private final ManejadorCrearDetalleCompra manejadorCrearDetalleCompra;
    private final ManejadorActualizarDetalleCompra manejadorActualizarDetalleCompra;
    private final ManejadorEliminarDetalleCompra manejadorEliminarDetalleCompra;

    @Autowired
    public ComandoControladorDetalleCompra(ManejadorCrearDetalleCompra manejadorCrearDetalleCompra,
                                           ManejadorActualizarDetalleCompra manejadorActualizarDetalleCompra,
                                           ManejadorEliminarDetalleCompra manejadorEliminarDetalleCompra){
        this.manejadorCrearDetalleCompra = manejadorCrearDetalleCompra;
        this.manejadorActualizarDetalleCompra = manejadorActualizarDetalleCompra;
        this.manejadorEliminarDetalleCompra = manejadorEliminarDetalleCompra;

    }
    @PostMapping
    @ApiOperation("Crear detalle Compra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDetalleCompra comandoDetalleCompra) {
        return this.manejadorCrearDetalleCompra.ejecutar(comandoDetalleCompra);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar detalle Compra")
    public void actualizar(@RequestBody ComandoDetalleCompra comandoDetalleCompra, @PathVariable Long id) {
        comandoDetalleCompra.setId(id);
        this.manejadorActualizarDetalleCompra.ejecutar(comandoDetalleCompra);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar detalle compra")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarDetalleCompra.ejecutar(id);
    }
}
