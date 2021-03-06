package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearClienteTest {

    @Test
    public void validarClienteExistenciaPreviaTest(){
        //arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(Boolean.TRUE);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class, servicioCrearCliente.EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA );
    }

    @Test
    public void ejecutarTest(){
        //arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn(1L);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(Boolean.FALSE);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        // act
        Long idCliente = servicioCrearCliente.ejecutar(cliente);
        // assert
        Assert.assertEquals(new Long(1), idCliente);
    }
}
