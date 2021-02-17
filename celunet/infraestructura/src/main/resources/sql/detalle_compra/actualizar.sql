update detalle_compra
set cantidad = :cantidad,
	id_compra = :idCompra,
	id_producto = :idProducto
where id = :id