package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {

    private static final String COMPRA = "compra";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = COMPRA, value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = COMPRA, value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = COMPRA, value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = COMPRA, value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace = COMPRA, value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioCompraMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Compra compra) {
        return this.customNamedParameterJdbcTemplate.crear(compra,sqlCrear);
    }

    @Override
    public void actualizar(Compra compra) {
        this.customNamedParameterJdbcTemplate.actualizar(compra,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String identificadorCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificadorCompra", identificadorCompra);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String identificadorCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        paramSource.addValue("identificadorCompra", identificadorCompra);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
