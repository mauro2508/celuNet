package com.ceiba.detallecompra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.detalleCompra.modelo.entidad.DetalleCompra;
import com.ceiba.detalleCompra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.detalleCompra.servicio.ServicioCrearDetalleCompra;
import com.ceiba.detallecompra.servicio.testdatabuilder.DetalleCompraTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearDetalleCompraTest {

    @Test
    public void validarDetalleCompraExistenciaPreviaTest(){
        // arrange
        DetalleCompra detalleCompra = new DetalleCompraTestDataBuilder().conId(1L).build();
        RepositorioDetalleCompra repositorioDetalleCompra = Mockito.mock(RepositorioDetalleCompra.class);
        Mockito.when(repositorioDetalleCompra.existe(Mockito.anyLong(),Mockito.anyLong())).thenReturn(true);
        ServicioCrearDetalleCompra servicioCrearDetalleCompra = new ServicioCrearDetalleCompra(repositorioDetalleCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearDetalleCompra.ejecutar(detalleCompra), ExcepcionDuplicidad.class,ServicioCrearDetalleCompra.EL_DETALLE_DE_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void ejecutarTest(){
        // arrange
        DetalleCompra detalleCompra = new DetalleCompraTestDataBuilder().build();
        RepositorioDetalleCompra repositorioDetalleCompra = Mockito.mock(RepositorioDetalleCompra.class);
        Mockito.when(repositorioDetalleCompra.existe(Mockito.anyLong(),Mockito.anyLong())).thenReturn(Boolean.FALSE);
        Mockito.when(repositorioDetalleCompra.crear(detalleCompra)).thenReturn(1L);
        ServicioCrearDetalleCompra servicioCrearDetalleCompra = new ServicioCrearDetalleCompra(repositorioDetalleCompra);
        // act
        Long idDetalleCompra = servicioCrearDetalleCompra.ejecutar(detalleCompra);
        // assert
        Assert.assertEquals(new Long(1), idDetalleCompra);
    }
}
