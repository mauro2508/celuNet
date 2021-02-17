update compra
set identificador_compra = :identificadorCompra,
	descripcion = :descripcion,
	valor_total_compra = :valorTotalCompra,
	id_cliente = :idCliente,
	descuento = :descuento,
	fecha_compra = :fechaCompra
where id = :id