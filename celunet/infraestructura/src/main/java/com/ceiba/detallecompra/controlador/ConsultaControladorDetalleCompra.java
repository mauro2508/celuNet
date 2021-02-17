package com.ceiba.detallecompra.controlador;

import com.ceiba.detalleCompra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detallecompra.consulta.ManejadorListarDetallesCompra;
import com.ceiba.detallecompra.consulta.ManejadorListarDetallesCompraPorCompra;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorDetalleCompra implements ConsultaControlador{

    private final ManejadorListarDetallesCompra manejadorListarDetallesCompra;
    private final ManejadorListarDetallesCompraPorCompra manejadorListarDetallesCompraPorCompra;

    public ConsultaControladorDetalleCompra(ManejadorListarDetallesCompra manejadorListarDetallesCompra,
                                            ManejadorListarDetallesCompraPorCompra manejadorListarDetallesCompraPorCompra){
        this.manejadorListarDetallesCompra = manejadorListarDetallesCompra;
        this.manejadorListarDetallesCompraPorCompra = manejadorListarDetallesCompraPorCompra;
    }
    @Override
    public List<DtoDetalleCompra> listar() {
        return this.manejadorListarDetallesCompra.ejecutar();
    }

    @Override
    public List<DtoDetalleCompra> listarDetallesPorCompra(@PathVariable Long idCompra) {
        return this.manejadorListarDetallesCompraPorCompra.ejecutar(idCompra);
    }
}
