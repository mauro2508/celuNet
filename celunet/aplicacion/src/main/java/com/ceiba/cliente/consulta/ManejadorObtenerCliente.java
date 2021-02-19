package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCliente {
    private final DaoCliente daoCliente;

    public ManejadorObtenerCliente (DaoCliente daoCliente){
        this.daoCliente = daoCliente;
    }

    public DtoCliente ejecutar (Long id){
        return this.daoCliente.obtenerPorId(id);
    }
}
