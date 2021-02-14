package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCompra {

    private Long id;
    private String identificadorCompra;
    private String descripcion;
    private BigDecimal valorTotalCompra;
    private Long idCliente;
    private BigDecimal descuento;
    private LocalDate fechaCompra;
}
