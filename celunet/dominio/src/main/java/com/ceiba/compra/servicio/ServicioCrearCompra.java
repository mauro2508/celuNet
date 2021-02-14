package com.ceiba.compra.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.util.DateUtil;
import com.ceiba.compra.util.DescuentoUtil;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.UUID;

public class ServicioCrearCompra {
    public static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";
    private static final BigDecimal MINIMO_VALOR_TOTAL_COMPRA_APLICA_DESCUENTO = new BigDecimal(2000000);

    private final RepositorioCompra repositorioCompra;
    private final RepositorioCliente repositorioCliente;
    private final LocalDate fechaActual;


    public ServicioCrearCompra (RepositorioCompra repositorioCompra,
                                RepositorioCliente repositorioCliente){
        this.repositorioCompra = repositorioCompra;
        this.repositorioCliente = repositorioCliente;
        this.fechaActual = LocalDate.now();
    }

    public Long ejecutar(Compra compra){
        validarExistenciaPrevia(compra);
        aplicarDescuentoTotalCompra(compra);
        asignarIdentificadorCompra(compra);
        asignarFechaCompra(compra);
        return this.repositorioCompra.crear(compra);
    }

    private void validarExistenciaPrevia(Compra compra){
        boolean existe = this.repositorioCompra.existe(compra.getIdentificadorCompra());
        if(existe){
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private boolean aplicaDescuentoPorCumpleAnio(Compra compra){
        Cliente cliente = this.repositorioCliente.obtener(compra.getIdCliente());
        return DateUtil.compararMesDia(fechaActual,cliente.getFechaNacimiento());
    }

    private boolean aplicaDescuentoBlackFriday(Compra compra){
        return  fechaActual.equals(DateUtil.obtenerFechaUltimoViernesMes());
    }

    private boolean aplicaDescuentoPorDiaCompra(Compra compra){
        return DateUtil.compararDia(fechaActual, DayOfWeek.SATURDAY);
    }

    private boolean aplicaDescuentoCompraMayor(Compra compra){
        return compra.getValorTotalCompra().compareTo(MINIMO_VALOR_TOTAL_COMPRA_APLICA_DESCUENTO) > 0;
    }

    private BigDecimal obtenerPorcentajeDescuento(Compra compra){
        BigDecimal descuento;

        if(aplicaDescuentoBlackFriday(compra)){
            descuento = DescuentoUtil.TREINTA_Y_CINCO_PORCIENTO;
        }else if(aplicaDescuentoPorCumpleAnio(compra)){
            descuento = DescuentoUtil.VEINTE_PORCIENTO;
        }
        else if(aplicaDescuentoPorDiaCompra(compra)) {
            descuento = DescuentoUtil.QUINCE_PORCIENTO;
        }else{
            descuento = new BigDecimal(BigInteger.ZERO);
        }

        if(aplicaDescuentoCompraMayor(compra)){
           descuento = descuento.add(DescuentoUtil.CINCO_PORCIENTO);
        }
        return descuento;
    }

    private void aplicarDescuentoTotalCompra(Compra compra){
        BigDecimal descuento = obtenerPorcentajeDescuento(compra);
        compra.setDescuento(descuento);
        compra.setValorTotalCompra(DescuentoUtil.aplicarDescuento(compra.getValorTotalCompra(),
                descuento));
    }

    private void asignarIdentificadorCompra(Compra compra) {
        compra.setIdentificadorCompra(UUID.randomUUID().toString());
    }

    private void asignarFechaCompra(Compra compra){
        compra.setFechaCompra(fechaActual);
    }
}
