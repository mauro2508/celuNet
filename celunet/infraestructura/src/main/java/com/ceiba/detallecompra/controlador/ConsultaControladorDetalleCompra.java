package com.ceiba.detallecompra.controlador;

import com.ceiba.detallecompra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detallecompra.consulta.ManejadorListarDetallesCompra;
import com.ceiba.detallecompra.consulta.ManejadorListarDetallesCompraPorCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detallesCompra")
@Api(tags = { "Controlador consulta detalles compra"})
public class ConsultaControladorDetalleCompra{

    private final ManejadorListarDetallesCompra manejadorListarDetallesCompra;
    private final ManejadorListarDetallesCompraPorCompra manejadorListarDetallesCompraPorCompra;

    @Autowired
    public ConsultaControladorDetalleCompra(ManejadorListarDetallesCompra manejadorListarDetallesCompra,
                                            ManejadorListarDetallesCompraPorCompra manejadorListarDetallesCompraPorCompra){
        this.manejadorListarDetallesCompra = manejadorListarDetallesCompra;
        this.manejadorListarDetallesCompraPorCompra = manejadorListarDetallesCompraPorCompra;
    }
    @GetMapping()
    @ApiOperation("Lista los detalles de compras")
    public List<DtoDetalleCompra> listar() {
        return this.manejadorListarDetallesCompra.ejecutar();
    }

    @GetMapping("/{idCompra}")
    @ApiOperation("Lista los detalles de una compra")
    public List<DtoDetalleCompra> listarDetallesPorCompra(@PathVariable Long idCompra) {
        return this.manejadorListarDetallesCompraPorCompra.ejecutar(idCompra);
    }
}
