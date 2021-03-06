package com.ceiba.compra.modelo.entidad;

import com.ceiba.compra.util.DateUtil;
import com.ceiba.compra.util.DescuentoUtil;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Compra {

    private static final String SE_DEBE_INGRESAR_EL_IDENTIFICADOR_COMPRA = "Se debe ingresar el identificador de la compra";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_TOTAL_COMPRA = "Se debe ingresar el valor total de la compra";
    private static final String SE_DEBE_INGRESAR_EL_CLIENTE = "Se debe ingresar el cliente";
    private static final String SE_DEBE_INGRESAR_EL_DESCUENTO = "Se debe ingresar el descuento";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_COMPRA = "Se debe ingresar la fecha de la compra";
    private static final BigDecimal MINIMO_VALOR_TOTAL_COMPRA_APLICA_DESCUENTO = new BigDecimal(2000000);


    public Compra(Long id,String identificadorCompra, String descripcion, BigDecimal valorTotalCompra, Long idCliente, BigDecimal descuento,
                  LocalDate fechaCompra){
        validarObligatorio(identificadorCompra, SE_DEBE_INGRESAR_EL_IDENTIFICADOR_COMPRA);
        validarObligatorio(valorTotalCompra, SE_DEBE_INGRESAR_EL_VALOR_TOTAL_COMPRA);
        validarObligatorio(idCliente, SE_DEBE_INGRESAR_EL_CLIENTE);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);

        this.id = id;
        this.identificadorCompra = identificadorCompra;
        this.descripcion = descripcion;
        this.valorTotalCompra = valorTotalCompra;
        this.idCliente = idCliente;
        this.descuento = descuento;
        this.fechaCompra = fechaCompra;

        aplicarDescuentoTotalCompra();
    }
    private Long id;
    private String identificadorCompra;
    private String descripcion;
    private BigDecimal valorTotalCompra;
    private Long idCliente;
    private BigDecimal descuento;
    private LocalDate fechaCompra;


    public void setDescuento(BigDecimal descuento) {
        recalcularDescuentoCompra(descuento);

    }

    public void setIdentificadorCompra(String identificadorCompra) {
        this.identificadorCompra = identificadorCompra;
    }


    private boolean aplicaDescuentoBlackFriday(){
        return  fechaCompra.equals(DateUtil.obtenerFechaUltimoViernesMes());
    }

    private boolean aplicaDescuentoPorDiaCompra(){
        return DateUtil.compararDia(fechaCompra, DayOfWeek.SATURDAY);
    }

    private boolean aplicaDescuentoCompraMayor(){
        return valorTotalCompra.compareTo(MINIMO_VALOR_TOTAL_COMPRA_APLICA_DESCUENTO) > 0;
    }

    private BigDecimal obtenerPorcentajeDescuento(){
        BigDecimal desc;
        if(aplicaDescuentoBlackFriday()){
            desc = DescuentoUtil.TREINTA_Y_CINCO_PORCIENTO;
        }
        else if(aplicaDescuentoPorDiaCompra()) {
            desc = (this.descuento !=null && this.descuento.compareTo(DescuentoUtil.QUINCE_PORCIENTO) > 0)
                    ?this.descuento:DescuentoUtil.QUINCE_PORCIENTO;
        }else{
            desc = this.descuento != null?this.descuento:new BigDecimal(BigInteger.ZERO);
        }

        if(aplicaDescuentoCompraMayor()){
            desc = desc.add(DescuentoUtil.CINCO_PORCIENTO);
        }

        return  desc;
    }

    private void aplicarDescuentoTotalCompra(){
        this.descuento = obtenerPorcentajeDescuento();
        this.valorTotalCompra = DescuentoUtil.aplicarDescuento(this.valorTotalCompra,
                descuento);
    }

    private void recalcularDescuentoCompra(BigDecimal descuentoNuevo){
        if(this.descuento.compareTo(new BigDecimal(BigInteger.ZERO))>0){
            BigDecimal descuentoAnterior = this.getDescuento();
            this.descuento = descuentoNuevo;
            this.valorTotalCompra = DescuentoUtil.recalcularDescuento(this.valorTotalCompra, descuentoAnterior, obtenerPorcentajeDescuento());
            this.descuento = obtenerPorcentajeDescuento();
        }else{
            this.descuento = descuentoNuevo;
            aplicarDescuentoTotalCompra();
        }
    }
}
