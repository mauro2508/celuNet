package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Compra {

    private static final String SE_DEBE_INGRESAR_EL_IDENTIFICADOR_COMPRA = "Se debe ingresar el identificador de la compra";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_TOTAL_COMPRA = "Se debe ingresar el valor total de la compra";
    private static final String SE_DEBE_INGRESAR_EL_CLIENTE = "Se debe ingresar el cliente";
    private static final String SE_DEBE_INGRESAR_EL_DESCUENTO = "Se debe ingresar el descuento";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_COMPRA = "Se debe ingresar la fecha de la compra";

    public Compra(Long id,String identificadorCompra, String descripcion, BigDecimal valorTotalCompra, Long idCliente, BigDecimal descuento,
                  LocalDate fechaCompra){
        validarObligatorio(identificadorCompra, SE_DEBE_INGRESAR_EL_IDENTIFICADOR_COMPRA);
        validarObligatorio(valorTotalCompra, SE_DEBE_INGRESAR_EL_VALOR_TOTAL_COMPRA);
        validarObligatorio(idCliente, SE_DEBE_INGRESAR_EL_CLIENTE);
        validarObligatorio(descuento, SE_DEBE_INGRESAR_EL_DESCUENTO);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);

        this.id = id;
        this.identificadorCompra = identificadorCompra;
        this.descripcion = descripcion;
        this.valorTotalCompra = valorTotalCompra;
        this.idCliente = idCliente;
        this.descuento = descuento;
        this.fechaCompra = fechaCompra;
    }
    private Long id;
    private String identificadorCompra;
    private String descripcion;
    private BigDecimal valorTotalCompra;
    private Long idCliente;
    private BigDecimal descuento;
    private LocalDate fechaCompra;


    public void setValorTotalCompra(BigDecimal valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public void setIdentificadorCompra(String identificadorCompra) {
        this.identificadorCompra = identificadorCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
