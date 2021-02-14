package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCompraPorIdentificadorCompra {

    private final DaoCompra daoCompra;

    public ManejadorObtenerCompraPorIdentificadorCompra (DaoCompra daoCompra){
        this.daoCompra = daoCompra;
    }

    public DtoCompra ejecutar(String identificadorCompra){
        return this.daoCompra.obtenerCompraPorIdentificadorCompra(identificadorCompra);
    }
}
