package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cliente", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="cliente", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="cliente", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="cliente", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace="cliente", value="obtenerPorId")
    private static String sqlObtenerPorId;


    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public Long crear(Cliente cliente) {
        return this.customNamedParameterJdbcTemplate.crear(cliente, sqlCrear);
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.customNamedParameterJdbcTemplate.actualizar(cliente, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(String email) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email",email);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public Cliente obtener(long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idCliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,paramSource, new MapeoCliente());
    }
}
