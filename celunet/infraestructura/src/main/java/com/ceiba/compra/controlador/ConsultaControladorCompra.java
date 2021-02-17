package com.ceiba.compra.controlador;


import com.ceiba.compra.consulta.ManejadorListarCompras;
import com.ceiba.compra.consulta.ManejadorListarComprasPorCliente;
import com.ceiba.compra.consulta.ManejadorObtenerPorIdentificadorCompra;
import com.ceiba.compra.modelo.dto.DtoCompra;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorCompra implements ConsultaControlador{

    private final ManejadorListarCompras manejadorListarCompras;
    private final ManejadorListarComprasPorCliente manejadorListarComprasPorCliente;
    private final ManejadorObtenerPorIdentificadorCompra manejadorObtenerPorIdentificadorCompra;

    public ConsultaControladorCompra(ManejadorListarCompras manejadorListarCompras,
                                     ManejadorListarComprasPorCliente manejadorListarComprasPorCliente,
                                     ManejadorObtenerPorIdentificadorCompra manejadorObtenerPorIdentificadorCompra){
        this.manejadorListarCompras = manejadorListarCompras;
        this.manejadorListarComprasPorCliente = manejadorListarComprasPorCliente;
        this.manejadorObtenerPorIdentificadorCompra = manejadorObtenerPorIdentificadorCompra;
    }
    @Override
    public List<DtoCompra> listar() {
        return this.manejadorListarCompras.ejecutar();
    }

    @Override
    public List<DtoCompra> listarComprasPorCliente(Long idCliente) {
        return this.manejadorListarComprasPorCliente.ejecutar(idCliente);
    }

    @Override
    public DtoCompra obtenerPorIdentificadorCompra(String identificadorCompra) {
        return this.manejadorObtenerPorIdentificadorCompra.ejecutar(identificadorCompra);
    }
}
