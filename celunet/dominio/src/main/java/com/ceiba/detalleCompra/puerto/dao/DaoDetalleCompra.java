package com.ceiba.detalleCompra.puerto.dao;

import com.ceiba.detalleCompra.modelo.dto.DtoDetalleCompra;

import java.util.List;

public interface DaoDetalleCompra {
    /**
     * permite listar los detalles de compra
     * @return los detalles de compra
     */
    List<DtoDetalleCompra> listar();

    /**
     * permite listar los detalles de una compra
     * @param idCompra
     * @return
     */
    List<DtoDetalleCompra> listarDetallesPorCompra(Long idCompra);
}
