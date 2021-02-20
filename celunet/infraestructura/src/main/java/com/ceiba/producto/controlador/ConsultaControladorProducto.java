package com.ceiba.producto.controlador;

import com.ceiba.producto.consulta.ManejadorListarProductos;
import com.ceiba.producto.consulta.ManejadorObtenerPorId;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador consulta productos"})
public class ConsultaControladorProducto{

    private final ManejadorListarProductos manejadorListarProductos;
    private final ManejadorObtenerPorId manejadorObtenerPorId;

    public ConsultaControladorProducto (ManejadorListarProductos manejadorListarProductos,
                                        ManejadorObtenerPorId manejadorObtenerPorId){
        this.manejadorListarProductos = manejadorListarProductos;
        this.manejadorObtenerPorId = manejadorObtenerPorId;
    }
    @GetMapping
    @ApiOperation(value = "Listar productos")
    public List<DtoProducto> listar() {
        return this.manejadorListarProductos.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar productos")
    public DtoProducto obtenerPorId(@PathVariable Long id){
        return this.manejadorObtenerPorId.ejecutar(id);
    }
}
