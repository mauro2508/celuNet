package com.ceiba.detallecompra.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDetalleCompra {
    private Long id;
    private Integer cantidad;
    private Long idCompra;
    private Long idProducto;
}
