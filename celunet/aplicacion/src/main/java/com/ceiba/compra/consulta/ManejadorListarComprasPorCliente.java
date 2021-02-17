package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarComprasPorCliente {

    private final DaoCompra daoCompra;

    public ManejadorListarComprasPorCliente(DaoCompra daoCompra){
        this.daoCompra = daoCompra;
    }

    public List<DtoCompra> ejecutar(Long idCliente){
        return this.daoCompra.listarComprasPorCliente(idCliente);
    }
}
