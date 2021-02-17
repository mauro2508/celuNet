package com.ceiba.compra.controlador;


import com.ceiba.compra.consulta.ManejadorListarCompras;
import com.ceiba.compra.consulta.ManejadorListarComprasPorCliente;
import com.ceiba.compra.consulta.ManejadorObtenerPorIdentificadorCompra;
import com.ceiba.compra.modelo.dto.DtoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
@Api(tags = { "Controlador consulta compras"})
public class ConsultaControladorCompra{

    private final ManejadorListarCompras manejadorListarCompras;
    private final ManejadorListarComprasPorCliente manejadorListarComprasPorCliente;
    private final ManejadorObtenerPorIdentificadorCompra manejadorObtenerPorIdentificadorCompra;

    @Autowired
    public ConsultaControladorCompra(ManejadorListarCompras manejadorListarCompras,
                                     ManejadorListarComprasPorCliente manejadorListarComprasPorCliente,
                                     ManejadorObtenerPorIdentificadorCompra manejadorObtenerPorIdentificadorCompra){
        this.manejadorListarCompras = manejadorListarCompras;
        this.manejadorListarComprasPorCliente = manejadorListarComprasPorCliente;
        this.manejadorObtenerPorIdentificadorCompra = manejadorObtenerPorIdentificadorCompra;
    }

    @GetMapping
    @ApiOperation("Listar compras")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompras.ejecutar();
    }

    @GetMapping("/{idCliente}")
    @ApiOperation("Listar compras por cliente")
    public List<DtoCompra> listarComprasPorCliente(@PathVariable Long idCliente) {
        return this.manejadorListarComprasPorCliente.ejecutar(idCliente);
    }

    @GetMapping("/detalle/{identificadorCompra}")
    @ApiOperation("Obtiene una compra por el identificador de compra")
    public DtoCompra obtenerPorIdentificadorCompra(@PathVariable String identificadorCompra) {
        return this.manejadorObtenerPorIdentificadorCompra.ejecutar(identificadorCompra);
    }
}
