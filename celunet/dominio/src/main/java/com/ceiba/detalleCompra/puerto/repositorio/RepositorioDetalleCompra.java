package com.ceiba.detalleCompra.puerto.repositorio;

import com.ceiba.detalleCompra.modelo.entidad.DetalleCompra;

public interface RepositorioDetalleCompra {

    /**
     * Permite crear un detalle de compra
     * @param detalleCompra
     * @return el id generado
     */
    Long crear(DetalleCompra detalleCompra);

    /**
     * Permite actualizar un detalle de compra
     * @param detalleCompra
     */
    void actualizar(DetalleCompra detalleCompra);

    /**
     * Permite eliminar un detalle de compra
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un detalle de compra con idCompra e idProducto
     * @param idCompra
     * @param idProducto
     * @return si existe o no
     */
    boolean existe(Long idCompra, Long idProducto);

    /**
     * Permite validar si existe un detalle de compra con idCompra e idProducto excluyendo un id
     * @param id
     *  @param idCompra
     *  @param idProducto
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,Long idCompra, Long idProducto);
}
