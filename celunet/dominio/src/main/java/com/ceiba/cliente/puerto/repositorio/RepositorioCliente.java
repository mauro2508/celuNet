package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;


public interface RepositorioCliente {

    /**
     * Permite crear un cliente
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite actualizar un cliente
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite eliminar un cliente
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un cliente con un email
     * @param email
     * @return si existe o no
     */
    boolean existe(String email);

    /**
     * Permite validar si existe un cliente con un email excluyendo un id
     * @param email
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String email);

    /**
     * Permite obtener el cliente por id
     * @param idCliente
     * @return Cliente
     */
    Cliente obtener (long idCliente);
}
