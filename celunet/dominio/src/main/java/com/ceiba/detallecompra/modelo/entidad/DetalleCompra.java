package com.ceiba.detallecompra.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
@Getter
public class DetalleCompra {

    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD = "Se debe ingresar la cantidad";
    private static final String SE_DEBE_INGRESAR_LA_COMPRA = "Se debe ingresar la compra";
    private static final String SE_DEBE_INGRESAR_EL_PRODUCTO = "Se debe ingresar el producto";

    private Long id;
    private Integer cantidad;
    private Long idCompra;
    private Long idProducto;

    public DetalleCompra (Long id, Integer cantidad, Long idCompra, Long idProducto){
        validarObligatorio(cantidad,SE_DEBE_INGRESAR_LA_CANTIDAD);
        validarObligatorio(idCompra,SE_DEBE_INGRESAR_LA_COMPRA);
        validarObligatorio(idProducto,SE_DEBE_INGRESAR_EL_PRODUCTO);
        this.id = id;
        this.cantidad = cantidad;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
    }
}
