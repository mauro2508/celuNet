package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;

import java.util.List;

public interface DaoCompra {

    /**
     * Permite listar las compras
     * @return las compras
     */
    List<DtoCompra>listar();

    /**
     * Permite listar las compras asociadas a un cliente
     * @param idCliente
     * @return las compras del cliente.
     */
    List<DtoCompra> listarComprasPorCliente(Long idCliente);

    /**
     * Permite obtener la compra asociada a un identificadorCompra
     * @param identificadorCompra
     * @return compra
     */
    DtoCompra obtenerCompraPorIdentificadorCompra(String identificadorCompra);
}
