package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import org.springframework.jdbc.core.RowMapper;
import com.ceiba.infraestructura.jdbc.MapperResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String email = resultSet.getString("email");
        LocalDate fechaNacimiento= extraerLocalDate(resultSet, "fecha_nacimiento");
        LocalDateTime fechaCreacion= extraerLocalDateTime(resultSet, "fecha_creacion");
        return new DtoCliente(id,nombre,apellido,email,fechaNacimiento,fechaCreacion);
    }
}
