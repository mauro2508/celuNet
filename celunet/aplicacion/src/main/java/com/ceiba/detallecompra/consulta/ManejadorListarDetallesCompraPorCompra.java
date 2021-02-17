package com.ceiba.detallecompra.consulta;

import com.ceiba.detalleCompra.modelo.dto.DtoDetalleCompra;
import com.ceiba.detalleCompra.puerto.dao.DaoDetalleCompra;
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
