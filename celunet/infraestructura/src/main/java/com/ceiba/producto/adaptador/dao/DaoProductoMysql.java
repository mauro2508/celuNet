package com.ceiba.producto.adaptador.dao;



import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;

import java.util.List;

@Component
public class DaoProductoMysql implements DaoProducto {


    private static final String PRODUCTO = "producto";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = PRODUCTO, value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = PRODUCTO, value="obtenerPorId")
    private static String sqlObtenerPorId;

    public DaoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoProducto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,new MapeoProducto());
    }

    @Override
    public DtoProducto obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId, paramSource,new MapeoProducto());
    }
}
