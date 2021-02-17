package com.ceiba.detallecompra.adaptador.repositorio;

import com.ceiba.detalleCompra.modelo.entidad.DetalleCompra;
import com.ceiba.detalleCompra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDetalleCompraMysql implements RepositorioDetalleCompra {

    private static final String DETALLE_COMPRA = "detalle_compra";
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = DETALLE_COMPRA, value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = DETALLE_COMPRA, value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = DETALLE_COMPRA, value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = DETALLE_COMPRA, value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace = DETALLE_COMPRA, value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioDetalleCompraMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(DetalleCompra detalleCompra) {
        return this.customNamedParameterJdbcTemplate.crear(detalleCompra,sqlCrear);
    }

    @Override
    public void actualizar(DetalleCompra detalleCompra) {
        this.customNamedParameterJdbcTemplate.actualizar(detalleCompra,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }

    @Override
    public boolean existe(Long idCompra, Long idProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCompra", idCompra);
        paramSource.addValue("idProducto", idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long idCompra, Long idProducto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        paramSource.addValue("idCompra", idCompra);
        paramSource.addValue("idProducto", idProducto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
