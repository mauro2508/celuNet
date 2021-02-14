package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult{

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        BigDecimal precio = resultSet.getBigDecimal("precio");
        return new DtoProducto(id,nombre,precio);
    }
}
