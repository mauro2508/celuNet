package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public class ComandoCompraTestDataBuilder {

    private Long id;
    private String identificadorCompra;
    private String descripcion;
    private BigDecimal valorTotalCompra;
    private Long idCliente;
    private BigDecimal descuento;
    private LocalDate fechaCompra;

    public ComandoCompraTestDataBuilder(){
        identificadorCompra = UUID.randomUUID().toString();
        descripcion = "Compra celulares";
        valorTotalCompra = new BigDecimal(1000000);
        idCliente = 1L;
        descuento = new BigDecimal(BigInteger.ZERO);
        fechaCompra = LocalDate.now();
    }

    public ComandoCompraTestDataBuilder conIdentificadorCompra(String identificadorCompra){
        this.identificadorCompra = identificadorCompra;
        return this;
    }

    public ComandoCompraTestDataBuilder conDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }

    public ComandoCompraTestDataBuilder conValorTotalCompra(BigDecimal valorTotalCompra){
        this.valorTotalCompra = valorTotalCompra;
        return this;
    }

    public ComandoCompraTestDataBuilder conIdCliente(Long idCliente){
        this.idCliente = idCliente;
        return this;
    }

    public ComandoCompraTestDataBuilder conDescuento(BigDecimal descuento){
        this.descuento = descuento;
        return this;
    }

    public ComandoCompraTestDataBuilder conFechaCompra(LocalDate fechaCompra){
        this.fechaCompra = fechaCompra;
        return this;
    }

    public ComandoCompra build(){
        return new ComandoCompra(id,identificadorCompra,descripcion,valorTotalCompra,idCliente,
                descuento,fechaCompra);
    }
}
