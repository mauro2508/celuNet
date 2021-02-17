package com.ceiba.detallecompra.comando.manejador;
import com.ceiba.detallecompra.modelo.entidad.DetalleCompra;
import com.ceiba.detallecompra.servicio.ServicioActualizarDetalleCompra;
import com.ceiba.detallecompra.comando.ComandoDetalleCompra;
import com.ceiba.detallecompra.comando.fabrica.FabricaDetalleCompra;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarDetalleCompra implements ManejadorComando<ComandoDetalleCompra>{

    private final FabricaDetalleCompra fabricaDetalleCompra;
    private final ServicioActualizarDetalleCompra servicioActualizarDetalleCompra;

    public ManejadorActualizarDetalleCompra (FabricaDetalleCompra fabricaDetalleCompra,
                                             ServicioActualizarDetalleCompra servicioActualizarDetalleCompra){
        this.fabricaDetalleCompra = fabricaDetalleCompra;
        this.servicioActualizarDetalleCompra = servicioActualizarDetalleCompra;
    }

    public void ejecutar(ComandoDetalleCompra comandoDetalleCompra){
        DetalleCompra detalleCompra = this.fabricaDetalleCompra.crear(comandoDetalleCompra);
        this.servicioActualizarDetalleCompra.ejecutar(detalleCompra);
    }
}
