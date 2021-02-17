package com.ceiba.detallecompra.comando.manejador;

import com.ceiba.detalleCompra.servicio.ServicioEliminarDetalleCompra;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarDetalleCompra implements  ManejadorComando<Long>{

    private final ServicioEliminarDetalleCompra servicioEliminarDetalleCompra;

    public ManejadorEliminarDetalleCompra (ServicioEliminarDetalleCompra servicioEliminarDetalleCompra){
        this.servicioEliminarDetalleCompra = servicioEliminarDetalleCompra;
    }

    public void ejecutar(Long id){
        this.servicioEliminarDetalleCompra.ejecutar(id);
    }
}
