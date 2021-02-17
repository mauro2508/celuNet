package com.ceiba.compra.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.util.DateUtil;
import com.ceiba.compra.util.DescuentoUtil;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import java.util.UUID;

public class ServicioCrearCompra {
    public static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La compra ya existe en el sistema";

    private final RepositorioCompra repositorioCompra;
    private final RepositorioCliente repositorioCliente;


    public ServicioCrearCompra (RepositorioCompra repositorioCompra,
                                RepositorioCliente repositorioCliente){
        this.repositorioCompra = repositorioCompra;
        this.repositorioCliente = repositorioCliente;

    }

    public Long ejecutar(Compra compra){
        validarExistenciaPrevia(compra);
        aplicaDescuentoPorCumpleAnio(compra);
        asignarIdentificadorCompra(compra);
        return this.repositorioCompra.crear(compra);
    }

    private void validarExistenciaPrevia(Compra compra){
        boolean existe = this.repositorioCompra.existe(compra.getIdentificadorCompra());
        if(existe){
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void aplicaDescuentoPorCumpleAnio(Compra compra){
        Cliente cliente = this.repositorioCliente.obtener(compra.getIdCliente());
        if(DateUtil.compararMesDia(compra.getFechaCompra(),cliente.getFechaNacimiento())){
            compra.setDescuento(DescuentoUtil.VEINTE_PORCIENTO);
        }
    }

    private void asignarIdentificadorCompra(Compra compra) {
        compra.setIdentificadorCompra(UUID.randomUUID().toString());
    }
}
