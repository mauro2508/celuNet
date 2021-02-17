package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import java.util.List;

@Component
public class DaoCompraMysql implements DaoCompra {

    private static final String COMPRA = "compra";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = COMPRA, value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = COMPRA, value="listarPorCliente")
    private static String sqlListarPorCliente;

    @SqlStatement(namespace = COMPRA, value="obtenerPorIdentificador")
    private static String sqlObtenerPorIdentificador;

    public DaoCompraMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public List<DtoCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCompra());
    }

    @Override
    public List<DtoCompra> listarComprasPorCliente(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", idCliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorCliente, paramSource,new MapeoCompra());
    }

    @Override
    public DtoCompra obtenerPorIdentificadorCompra(String identificadorCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificadorCompra", identificadorCompra);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorIdentificador, paramSource,new MapeoCompra());
    }
}
