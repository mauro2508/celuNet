package com.ceiba.compra.controlador;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.manejador.ManejadorActualizarCompra;
import com.ceiba.compra.comando.manejador.ManejadorCrearCompra;
import com.ceiba.compra.comando.manejador.ManejadorEliminarCompra;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.ComandoRespuesta;

@RestController
public class ComandoControladorCompra implements ComandoControlador{

    private final ManejadorCrearCompra manejadorCrearCompra;
    private final ManejadorActualizarCompra manejadorActualizarCompra;
    private final ManejadorEliminarCompra manejadorEliminarCompra;

    public ComandoControladorCompra (ManejadorCrearCompra manejadorCrearCompra,
                                     ManejadorActualizarCompra manejadorActualizarCompra,
                                     ManejadorEliminarCompra manejadorEliminarCompra){
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorActualizarCompra = manejadorActualizarCompra;
        this.manejadorEliminarCompra = manejadorEliminarCompra;

    }
    @Override
    public ComandoRespuesta<Long> crear(ComandoCompra comandoCompra) {
        return this.manejadorCrearCompra.ejecutar(comandoCompra);
    }

    @Override
    public void actualizar(ComandoCompra comandoCompra, Long id) {
        comandoCompra.setId(id);
        this.manejadorActualizarCompra.ejecutar(comandoCompra);
    }

    @Override
    public void eliminar(Long id) {
        this.manejadorEliminarCompra.ejecutar(id);
    }
}
