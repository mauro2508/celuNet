insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into cliente(nombre,apellido,email,fecha_nacimiento, fecha_creacion) values('Luisa', 'Diaz', 'Lufe@gmail.com','1993-07-14', now());

insert into producto(nombre, precio) values ('Xiaomi redmi note 8', 600000);
insert into producto(nombre, precio) values ('Huawei P20 Lite', 500000);

insert into compra(identificador_compra, descripcion, valor_total_compra, id_cliente, descuento, fecha_compra) values('95813e77-1b83-7vff-5179-a3d4db96fge7', 'compra producto xiaomi', 600000,1,0,'2021-02-16');

insert into detalle_compra(cantidad, id_compra,id_producto) values(1,1,1);