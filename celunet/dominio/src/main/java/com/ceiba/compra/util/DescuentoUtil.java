package com.ceiba.compra.util;

import java.math.BigDecimal;

public class DescuentoUtil {

    public static final BigDecimal TREINTA_Y_CINCO_PORCIENTO = new BigDecimal("0.35");
    public static final BigDecimal VEINTE_PORCIENTO = new BigDecimal("0.2");
    public static final BigDecimal  QUINCE_PORCIENTO = new BigDecimal("0.15");
    public static final BigDecimal CINCO_PORCIENTO = new BigDecimal(0.05);
    private static final BigDecimal PORCENTAJE = new BigDecimal(100);

    private DescuentoUtil() {}

    public static BigDecimal aplicarDescuento(BigDecimal valor, BigDecimal descuento) {
        return valor.subtract((valor.multiply(descuento).divide(PORCENTAJE, BigDecimal.ROUND_HALF_UP)));
    }
}
