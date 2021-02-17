package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.detallecompra.puerto.repositorio.RepositorioDetalleCompra;
import com.ceiba.detallecompra.servicio.ServicioActualizarDetalleCompra;
import com.ceiba.detallecompra.servicio.ServicioCrearDetalleCompra;
import com.ceiba.detallecompra.servicio.ServicioEliminarDetalleCompra;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    /* --- Beans Usuario ---*/
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	

    /* --- Beans Cliente ---*/
    @Bean
    public ServicioCrearCliente servicioCrearCliente (RepositorioCliente repositorioCliente){
        return  new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente (RepositorioCliente repositorioCliente){
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente (RepositorioCliente repositorioCliente){
        return new ServicioActualizarCliente(repositorioCliente);
    }

    /* --- Beans Compra ---*/
    @Bean
    public ServicioCrearCompra servicioCrearCompra (RepositorioCompra repositorioCompra, RepositorioCliente repositorioCliente){
        return new ServicioCrearCompra(repositorioCompra, repositorioCliente);
    }
    @Bean
    public ServicioActualizarCompra servicioActualizarCompra (RepositorioCompra repositorioCompra){
        return new ServicioActualizarCompra(repositorioCompra);
    }
    @Bean
    public ServicioEliminarCompra servicioEliminarCompra (RepositorioCompra repositorioCompra){
        return new ServicioEliminarCompra(repositorioCompra);
    }

    /* --- Beans detalle compra ---*/
    @Bean
    public ServicioCrearDetalleCompra servicioCrearDetalleCompra(RepositorioDetalleCompra repositorioDetalleCompra){
        return new ServicioCrearDetalleCompra(repositorioDetalleCompra);
    }
    @Bean
    public ServicioActualizarDetalleCompra servicioActualizarDetalleCompra (RepositorioDetalleCompra repositorioDetalleCompra){
        return new ServicioActualizarDetalleCompra(repositorioDetalleCompra);
    }
    @Bean
    public ServicioEliminarDetalleCompra servicioEliminarDetalleCompra (RepositorioDetalleCompra repositorioDetalleCompra){
        return new ServicioEliminarDetalleCompra(repositorioDetalleCompra);
    }

}
