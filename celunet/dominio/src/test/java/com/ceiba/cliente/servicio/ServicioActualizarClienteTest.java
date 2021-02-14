package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarClienteTest {

    @Test
    public void validarClienteExistenciaPreviaTest(){
        Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(Boolean.TRUE);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class, servicioActualizarCliente.EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA );
    }
}
