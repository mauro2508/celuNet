package com.ceiba.compra.util;

import java.math.BigDecimal;

public final class DescuentoUtil {

    public static final BigDecimal TREINTA_Y_CINCO_PORCIENTO = new BigDecimal("0.35");
    public static final BigDecimal VEINTE_PORCIENTO = new BigDecimal("0.2");
    public static final BigDecimal  QUINCE_PORCIENTO = new BigDecimal("0.15");
    public static final BigDecimal CINCO_PORCIENTO = new BigDecimal("0.05");
    public static final BigDecimal CIEN_PORCIENTO = new BigDecimal("1");

    private DescuentoUtil() {}

    public static BigDecimal aplicarDescuento(BigDecimal valor, BigDecimal descuento) {
        return valor.subtract((valor.multiply(descuento)));
    }

    public static BigDecimal recalcularDescuento(BigDecimal valorAnterior, BigDecimal descuentoAnterior,
                                                 BigDecimal descuentoNuevo){
        BigDecimal valor = valorAnterior.add(valorAnterior.multiply(descuentoAnterior).divide(CIEN_PORCIENTO.subtract(descuentoAnterior)));

        return  valor.subtract(valor.multiply(descuentoNuevo));
    }
}
