package com.ceiba.detallecompra.controlador;

import com.ceiba.ApplicationMock;

import com.ceiba.detallecompra.comando.ComandoDetalleCompra;
import com.ceiba.detallecompra.servicio.testdatabuilder.ComandoDetalleCompraTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorDetalleCompra.class)
public class ComandoControladorDetalleCompraTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoDetalleCompra detalleCompra = new ComandoDetalleCompraTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/detallesCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detalleCompra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoDetalleCompra detalleCompra = new ComandoDetalleCompraTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/detallesCompra/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detalleCompra)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception{
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/detallesCompra/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
