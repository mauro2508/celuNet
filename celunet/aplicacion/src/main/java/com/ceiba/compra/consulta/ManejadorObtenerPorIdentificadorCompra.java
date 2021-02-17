package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerPorIdentificadorCompra {

    private final DaoCompra daoCompra;

    public ManejadorObtenerPorIdentificadorCompra(DaoCompra daoCompra){
        this.daoCompra = daoCompra;
    }

    public DtoCompra ejecutar(String identificadorCompra){
        return this.daoCompra.obtenerPorIdentificadorCompra(identificadorCompra);
    }
}
