package com.ceiba.detallecompra.servicio;


import com.ceiba.detallecompra.modelo.entidad.DetalleCompra;
import com.ceiba.detallecompra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarDetalleCompra {

    public static final String EL_DETALLE_DE_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "El detalle de compra ya existe en el sistema";

    private final RepositorioDetalleCompra repositorioDetalleCompra;

    public ServicioActualizarDetalleCompra (RepositorioDetalleCompra repositorioDetalleCompra){
        this.repositorioDetalleCompra = repositorioDetalleCompra;
    }

    public void ejecutar(DetalleCompra detalleCompra){
        validarExistenciaPrevia(detalleCompra);
        this.repositorioDetalleCompra.actualizar(detalleCompra);
    }

    private void validarExistenciaPrevia(DetalleCompra detalleCompra){
        boolean existe = this.repositorioDetalleCompra.existeExcluyendoId(detalleCompra.getId(), detalleCompra.getIdCompra(), detalleCompra.getIdProducto());
        if(existe){
            throw new ExcepcionDuplicidad(EL_DETALLE_DE_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
