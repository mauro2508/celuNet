package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCompraTest {

    @Test
    public void validarCompraExistenciaPreviaTest(){
        //arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(compra),ExcepcionDuplicidad.class, ServicioActualizarCompra.LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA );
    }
}
