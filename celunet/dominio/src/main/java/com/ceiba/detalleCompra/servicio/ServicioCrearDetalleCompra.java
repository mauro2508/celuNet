package com.ceiba.detalleCompra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.detalleCompra.modelo.entidad.DetalleCompra;
import com.ceiba.detalleCompra.puerto.repositorio.RepositorioDetalleCompra;

public class ServicioCrearDetalleCompra {

    public static final String EL_DETALLE_DE_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "El detalle de compra ya existe en el sistema";


    private final RepositorioDetalleCompra repositorioDetalleCompra;

    public ServicioCrearDetalleCompra( RepositorioDetalleCompra repositorioDetalleCompra){
        this.repositorioDetalleCompra = repositorioDetalleCompra;
    }

    public Long ejecutar (DetalleCompra detalleCompra){
        validarExistenciaPrevia(detalleCompra);
        return this.repositorioDetalleCompra.crear(detalleCompra);
    }
    private void validarExistenciaPrevia(DetalleCompra detalleCompra){
        boolean existe = this.repositorioDetalleCompra.existe(detalleCompra.getIdCompra(), detalleCompra.getIdProducto());
        if(existe){
            throw new ExcepcionDuplicidad(EL_DETALLE_DE_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
