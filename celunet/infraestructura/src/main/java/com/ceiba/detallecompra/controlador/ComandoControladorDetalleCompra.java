package com.ceiba.detallecompra.controlador;

import com.ceiba.detallecompra.comando.ComandoDetalleCompra;
import com.ceiba.detallecompra.comando.manejador.ManejadorActualizarDetalleCompra;
import com.ceiba.detallecompra.comando.manejador.ManejadorCrearDetalleCompra;
import com.ceiba.detallecompra.comando.manejador.ManejadorEliminarDetalleCompra;
import org.springframework.beans.factory.annotation.Autowired;
import com.ceiba.ComandoRespuesta;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComandoControladorDetalleCompra implements ComandoControlador{

    private final ManejadorCrearDetalleCompra manejadorCrearDetalleCompra;
    private final ManejadorActualizarDetalleCompra manejadorActualizarDetalleCompra;
    private final ManejadorEliminarDetalleCompra manejadorEliminarDetalleCompra;

    //@Autowired
    public ComandoControladorDetalleCompra(ManejadorCrearDetalleCompra manejadorCrearDetalleCompra,
                                           ManejadorActualizarDetalleCompra manejadorActualizarDetalleCompra,
                                           ManejadorEliminarDetalleCompra manejadorEliminarDetalleCompra){
        this.manejadorCrearDetalleCompra = manejadorCrearDetalleCompra;
        this.manejadorActualizarDetalleCompra = manejadorActualizarDetalleCompra;
        this.manejadorEliminarDetalleCompra = manejadorEliminarDetalleCompra;

    }
    @Override
    public ComandoRespuesta<Long> crear(ComandoDetalleCompra comandoDetalleCompra) {
        return this.manejadorCrearDetalleCompra.ejecutar(comandoDetalleCompra);
    }

    @Override
    public void actualizar(ComandoDetalleCompra comandoDetalleCompra, Long id) {
        comandoDetalleCompra.setId(id);
        this.manejadorActualizarDetalleCompra.ejecutar(comandoDetalleCompra);
    }

    @Override
    public void eliminar(Long id) {
        this.manejadorEliminarDetalleCompra.ejecutar(id);
    }
}
