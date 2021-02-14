package com.ceiba.detallecompra.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarDetalleCompra implements  ManejadorComando<Long>{

    private final ServicioEliminarCompra servicioEliminarCompra;

    public ManejadorEliminarDetalleCompra (ServicioEliminarCompra servicioEliminarCompra){
        this.servicioEliminarCompra = servicioEliminarCompra;
    }

    public void ejecutar(Long idDetalleCompra){
        this.servicioEliminarCompra.ejecutar(idDetalleCompra);
    }
}
