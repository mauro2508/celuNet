package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.util.DescuentoUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public class CompraTestDataBuilder {

    private Long id;
    private String identificadorCompra;
    private String descripcion;
    private BigDecimal valorTotalCompra;
    private Long idCliente;
    private BigDecimal descuento;
    private LocalDate fechaCompra;

    public CompraTestDataBuilder(){
        identificadorCompra = UUID.randomUUID().toString();
        descripcion = "compra de productos Xiaomi";
        valorTotalCompra = new BigDecimal(1500000);
        idCliente = 1L;
        descuento = new BigDecimal(BigInteger.ZERO);
        fechaCompra = LocalDate.now();
    }

    public CompraTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public Compra build(){
        return new Compra(id,identificadorCompra,descripcion,valorTotalCompra,idCliente,descuento,fechaCompra);
    }
}
