package com.ceiba.detallecompra.servicio.testdatabuilder;

import com.ceiba.detallecompra.comando.ComandoDetalleCompra;

public class ComandoDetalleCompraTestDataBuilder {
    private Long id;
    private Integer cantidad;
    private Long idCompra;
    private Long idProducto;

    public ComandoDetalleCompraTestDataBuilder(){
        cantidad = 1;
        idCompra = 1L;
        idProducto = 2L;
    }

    public ComandoDetalleCompraTestDataBuilder conCantidad(Integer cantidad){
        this.cantidad = cantidad;
        return this;
    }

    public ComandoDetalleCompraTestDataBuilder conIdCompra(Long idCompra){
        this.idCompra = idCompra;
        return this;
    }

    public ComandoDetalleCompraTestDataBuilder conIdProducto(Long idProducto){
        this.idProducto = idProducto;
        return this;
    }

    public ComandoDetalleCompra build(){
        return new ComandoDetalleCompra(id,cantidad,idCompra,idProducto);
    }
}
