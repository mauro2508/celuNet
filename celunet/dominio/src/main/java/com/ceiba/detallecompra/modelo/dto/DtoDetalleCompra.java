package com.ceiba.detallecompra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDetalleCompra {
    private Long id;
    private Integer cantidad;
    private Long idCompra;
    private Long idProducto;
}
