package com.ceiba.detallecompra.consulta;

import com.ceiba.detallecompra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detallecompra.puerto.dao.DaoDetalleCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDetallesCompraPorCompra {

    private final DaoDetalleCompra daoDetalleCompra;

    public ManejadorListarDetallesCompraPorCompra (DaoDetalleCompra daoDetalleCompra){
        this.daoDetalleCompra = daoDetalleCompra;
    }

    public List<DtoDetalleCompra> ejecutar(Long idCompra){
       return this.daoDetalleCompra.listarDetallesPorCompra(idCompra);
    }
}
