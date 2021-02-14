package com.ceiba.detallecompra.comando.fabrica;

import com.ceiba.detalleCompra.modelo.entidad.DetalleCompra;
import com.ceiba.detallecompra.comando.ComandoDetalleCompra;
import org.springframework.stereotype.Component;

@Component
public class FabricaDetalleCompra {

    public DetalleCompra crear(ComandoDetalleCompra comandoDetalleCompra){
        return new DetalleCompra(comandoDetalleCompra.getId(), comandoDetalleCompra.getCantidad(),
                comandoDetalleCompra.getIdCompra(), comandoDetalleCompra.getIdProducto());
    }
}
