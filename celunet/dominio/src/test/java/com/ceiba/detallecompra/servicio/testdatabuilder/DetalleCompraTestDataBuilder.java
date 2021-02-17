package com.ceiba.detallecompra.servicio.testdatabuilder;

import com.ceiba.detallecompra.modelo.entidad.DetalleCompra;

public class DetalleCompraTestDataBuilder {

    private Long id;
    private Integer cantidad;
    private Long idCompra;
    private Long idProducto;

    public DetalleCompraTestDataBuilder(){
        cantidad = 1;
        idCompra = 1L;
        idProducto = 1L;
    }

    public DetalleCompraTestDataBuilder conId(Long id){
        this.id = id;
        return  this;
    }

    public DetalleCompra build(){
        return new DetalleCompra(id,cantidad,idCompra,idProducto);
    }
}
