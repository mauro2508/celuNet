package com.ceiba.detallecompra.adaptador.dao;


import com.ceiba.detallecompra.modelo.dto.DtoDetalleCompra;
import org.springframework.jdbc.core.RowMapper;
import com.ceiba.infraestructura.jdbc.MapperResult;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDetalleCompra implements RowMapper<DtoDetalleCompra>, MapperResult{

    @Override
    public DtoDetalleCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Integer cantidad = resultSet.getInt("cantidad");
        Long idCompra = resultSet.getLong("id_compra");
        Long idProducto = resultSet.getLong("id_producto");
        return new DtoDetalleCompra(id,cantidad,idCompra,idProducto);
    }
}
