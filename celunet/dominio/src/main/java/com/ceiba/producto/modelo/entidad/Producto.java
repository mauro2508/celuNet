package com.ceiba.producto.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import java.math.BigDecimal;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio";

    private Long id;
    private String nombre;
    private BigDecimal precio;

    public Producto(Long id, String nombre, BigDecimal precio){
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO);
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}
