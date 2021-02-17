package com.ceiba.detallecompra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.detalleCompra.modelo.entidad.DetalleCompra;
import com.ceiba.detalleCompra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.detalleCompra.servicio.ServicioActualizarDetalleCompra;
import com.ceiba.detalleCompra.servicio.ServicioCrearDetalleCompra;
import com.ceiba.detallecompra.servicio.testdatabuilder.DetalleCompraTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarDetalleCompraTest {

    @Test
    public void validarDetalleCompraExistenciaPreviaTest(){
        //arrange
        DetalleCompra detalleCompra = new DetalleCompraTestDataBuilder().conId(1L).build();
        RepositorioDetalleCompra repositorioDetalleCompra = Mockito.mock(RepositorioDetalleCompra.class);
        Mockito.when(repositorioDetalleCompra.existeExcluyendoId(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyLong())).thenReturn(true);
        ServicioActualizarDetalleCompra servicioActualizarDetalleCompra = new ServicioActualizarDetalleCompra(repositorioDetalleCompra);
        // act - assert
        BasePrueba.assertThrows(()-> servicioActualizarDetalleCompra.ejecutar(detalleCompra), ExcepcionDuplicidad.class, ServicioCrearDetalleCompra.EL_DETALLE_DE_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void ejecutarTest(){
        //arrange
        DetalleCompra detalleCompra = new DetalleCompraTestDataBuilder().conId(1L).build();
        RepositorioDetalleCompra repositorioDetalleCompra = Mockito.mock(RepositorioDetalleCompra.class);
        Mockito.when(repositorioDetalleCompra.existeExcluyendoId(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyLong())).thenReturn(Boolean.FALSE);
        ServicioActualizarDetalleCompra servicioActualizarDetalleCompra = new ServicioActualizarDetalleCompra(repositorioDetalleCompra);
        // act
        servicioActualizarDetalleCompra.ejecutar(detalleCompra);
        // assert
        Mockito.verify(repositorioDetalleCompra).actualizar(detalleCompra);
    }
}
