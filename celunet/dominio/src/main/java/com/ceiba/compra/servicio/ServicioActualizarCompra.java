package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCompra {
    public static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";

    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra (RepositorioCompra repositorioCompra){
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Compra compra){
        validarExistenciaPrevia(compra);
        this.repositorioCompra.actualizar(compra);
    }

    private void validarExistenciaPrevia(Compra compra){
        boolean existe = this.repositorioCompra.existeExcluyendoId(compra.getId(), compra.getIdentificadorCompra());
        if(existe){
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
