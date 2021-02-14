package com.ceiba.detallecompra.consulta;

import com.ceiba.detalleCompra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detalleCompra.puerto.dao.DaoDetalleCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDetallesCompra {

    private final DaoDetalleCompra daoDetalleCompra;

    public ManejadorListarDetallesCompra (DaoDetalleCompra daoDetalleCompra){
        this.daoDetalleCompra = daoDetalleCompra;
    }

    public List<DtoDetalleCompra> ejecutar(){
        return this.daoDetalleCompra.listar();
    }
}
