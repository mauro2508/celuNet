package com.ceiba.detallecompra.adaptador.dao;


import com.ceiba.detalleCompra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detalleCompra.puerto.dao.DaoDetalleCompra;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDetalleCompraMysql implements DaoDetalleCompra {

    private static final String DETALLE_COMPRA = "detalle_compra";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = DETALLE_COMPRA, value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = DETALLE_COMPRA, value="listarPorCompra")
    private static String sqlListarPorCompra;

    public DaoDetalleCompraMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;

    }
    @Override
    public List<DtoDetalleCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDetalleCompra());
    }

    @Override
    public List<DtoDetalleCompra> listarDetallesPorCompra(Long idCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCompra", idCompra);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorCompra, paramSource,new MapeoDetalleCompra());
    }
}
