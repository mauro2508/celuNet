package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.controlador.ConsultaControladorUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorCompra.class)
public class ConsultaControladorCompraTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception{
        // arrange

        // act - assert
        mocMvc.perform(get("/compras")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].identificadorCompra", is("95813e77-1b83-7vff-5179-a3d4db96fge7")));

    }

    @Test
    public void listarPorCliente() throws Exception{
        // arrange
        Long idCliente = 1L;

        // act - assert
        mocMvc.perform(get("/compras/{idCliente}",idCliente)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].identificadorCompra", is("95813e77-1b83-7vff-5179-a3d4db96fge7")));
    }

    @Test
    public void obtenerPorIdentificador() throws Exception{
        // arrange
        String identificadorCompra = "95813e77-1b83-7vff-5179-a3d4db96fge7";

        // act - assert
        mocMvc.perform(get("/compras/detalle/{identificadorCompra}", identificadorCompra)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.identificadorCompra", is("95813e77-1b83-7vff-5179-a3d4db96fge7")));
    }
}
