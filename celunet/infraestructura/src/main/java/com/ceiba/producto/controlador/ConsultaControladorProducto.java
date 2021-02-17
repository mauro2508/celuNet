package com.ceiba.producto.controlador;

import com.ceiba.producto.consulta.ManejadorListarProductos;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorProducto implements ConsultaControlador{

    private ManejadorListarProductos manejadorListarProductos;

    public ConsultaControladorProducto (ManejadorListarProductos manejadorListarProductos){
        this.manejadorListarProductos = manejadorListarProductos;
    }
    @Override
    public List<DtoProducto> listar() {
        return this.manejadorListarProductos.ejecutar();
    }
}
