package com.ceiba.compra.adaptador.dao;


import com.ceiba.compra.modelo.dto.DtoCompra;
import org.springframework.jdbc.core.RowMapper;
import com.ceiba.infraestructura.jdbc.MapperResult;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCompra  implements RowMapper<DtoCompra>, MapperResult {
    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String identificadorCompra = resultSet.getString("identificador_compra");
        String descripcion = resultSet.getString("descripcion");
        BigDecimal valorTotalCompra = resultSet.getBigDecimal("valor_total_compra");
        Long idCliente = resultSet.getLong("id_cliente");
        BigDecimal descuento = resultSet.getBigDecimal("descuento");
        LocalDate fechaCompra = extraerLocalDate(resultSet, "fecha_compra");
        return new DtoCompra(id,identificadorCompra,descripcion,valorTotalCompra,idCliente,
                descuento,fechaCompra);
    }
}
