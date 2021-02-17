select id, identificador_compra, descripcion, valor_total_compra, id_cliente,descuento, fecha_compra
from compra WHERE identificador_compra = :identificadorCompra;