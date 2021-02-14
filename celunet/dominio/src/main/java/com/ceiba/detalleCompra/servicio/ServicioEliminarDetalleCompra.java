package com.ceiba.detalleCompra.servicio;

import com.ceiba.detalleCompra.puerto.repositorio.RepositorioDetalleCompra;

public class ServicioEliminarDetalleCompra {

    private final RepositorioDetalleCompra repositorioDetalleCompra;

    public ServicioEliminarDetalleCompra (RepositorioDetalleCompra repositorioDetalleCompra){
        this.repositorioDetalleCompra = repositorioDetalleCompra;
    }

    public void ejecutar(Long id){
        this.repositorioDetalleCompra.eliminar(id);
    }
}
