package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.*;

public class ServicioCrearCompraTest {

    @Test
    public void validarCompraExistenciaPreviaTest(){
        // arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCompra.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra,repositorioCliente);
        // act assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class, ServicioCrearCompra.LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA );

    }

    @Test
    public void validarAplicaDescuentoCumpleAnioTest(){
        // arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        LocalDate fechaCompra = compra.getFechaCompra();
        LocalDate fechaNacimiento = LocalDate.of(1993, fechaCompra.getMonth(), fechaCompra.getDayOfMonth());
        Cliente cliente = new ClienteTestDataBuilder().conId(1L).conFechaNacimiento(fechaNacimiento).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.obtener(Mockito.anyLong())).thenReturn(cliente);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra,repositorioCliente);
        // act
        servicioCrearCompra.ejecutar(compra);
        //assert
        Assert.assertEquals(new BigDecimal("0.2"), compra.getDescuento());
    }

    @Test
    public void ejecucionTest(){
        //arrange
        Compra compra = new CompraTestDataBuilder().build();
        Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.obtener(Mockito.anyLong())).thenReturn(cliente);
        Mockito.when(repositorioCompra.crear(compra)).thenReturn(1L);
        Mockito.when(repositorioCompra.existe(Mockito.anyString())).thenReturn(Boolean.FALSE);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra,repositorioCliente);
        // act
        Long id = servicioCrearCompra.ejecutar(compra);
        //assert
        Assert.assertEquals(new Long(1),id);

    }

    @Test
    public void validarAplicaDescuentoDiaCompra(){
        // arrange
        LocalDate fechaCompra = LocalDate.of(2021,2,20);
        Compra compra = new CompraTestDataBuilder().conFechaCompra(fechaCompra).build();
        Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.obtener(Mockito.anyLong())).thenReturn(cliente);
        Mockito.when(repositorioCompra.existe(Mockito.anyString())).thenReturn(Boolean.FALSE);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra,repositorioCliente);
        // act
        servicioCrearCompra.ejecutar(compra);
        //assert
        Assert.assertEquals(new BigDecimal("0.15"), compra.getDescuento());
    }

    @Test
    public void validarAplicaDescuentoCompraMayor(){
        // arrange
        LocalDate fechaCompra = LocalDate.of(2021,2,17);
        Compra compra = new CompraTestDataBuilder().conFechaCompra(fechaCompra).conValorTotalCompra(new BigDecimal(2500000)).build();
        Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.obtener(Mockito.anyLong())).thenReturn(cliente);
        Mockito.when(repositorioCompra.existe(Mockito.anyString())).thenReturn(Boolean.FALSE);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra,repositorioCliente);
        // act
        servicioCrearCompra.ejecutar(compra);
        //assert
        Assert.assertEquals(new BigDecimal("0.05"), compra.getDescuento());
    }
}
