package com.ceiba.producto.consulta;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerPorId {

    private final DaoProducto daoProducto;

    public ManejadorObtenerPorId (DaoProducto daoProducto){
        this.daoProducto = daoProducto;
    }

    public DtoProducto ejecutar(Long id){
        return this.daoProducto.obtenerPorId(id);
    }
}
