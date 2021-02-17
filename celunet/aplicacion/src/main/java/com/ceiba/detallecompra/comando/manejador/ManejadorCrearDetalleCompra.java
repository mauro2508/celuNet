package com.ceiba.detallecompra.comando.manejador;

import com.ceiba.detallecompra.modelo.entidad.DetalleCompra;
import com.ceiba.detallecompra.servicio.ServicioCrearDetalleCompra;
import com.ceiba.detallecompra.comando.ComandoDetalleCompra;
import com.ceiba.detallecompra.comando.fabrica.FabricaDetalleCompra;
import org.springframework.stereotype.Component;
import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearDetalleCompra implements ManejadorComandoRespuesta<ComandoDetalleCompra, ComandoRespuesta<Long>> {

    private final FabricaDetalleCompra fabricaDetalleCompra;
    private final ServicioCrearDetalleCompra servicioCrearDetalleCompra;

    public ManejadorCrearDetalleCompra (FabricaDetalleCompra fabricaDetalleCompra,
                                        ServicioCrearDetalleCompra servicioCrearDetalleCompra){
        this.fabricaDetalleCompra = fabricaDetalleCompra;
        this.servicioCrearDetalleCompra = servicioCrearDetalleCompra;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDetalleCompra comandoDetalleCompra){
        DetalleCompra detalleCompra = this.fabricaDetalleCompra.crear(comandoDetalleCompra);
        return new ComandoRespuesta<>(this.servicioCrearDetalleCompra.ejecutar(detalleCompra));
    }
}
