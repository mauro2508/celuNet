create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 email varchar(100) not null,
 fecha_nacimiento date not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 precio DECIMAL(15,3) not null,
 primary key (id)
);

create table compra (
 id int(11) not null auto_increment,
 identificador_compra varchar(100) not null,
 descripcion varchar(100) not null,
 valor_total_compra DECIMAL(15,3) not null,
 id_cliente int(11) not null,
 descuento DECIMAL(3,2) not null,
 fecha_compra date not null,
 primary key (id)
);

Alter table compra ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id) on update cascade on delete cascade;

create table detalle_compra(
 id int(11) not null auto_increment,
 cantidad int not null,
 id_compra int(11) not null,
 id_producto int(11) not null,
 primary key (id)
);
Alter table detalle_compra ADD FOREIGN KEY (id_compra) REFERENCES compra(id) on update cascade on delete cascade;
Alter table detalle_compra ADD FOREIGN KEY (id_producto) REFERENCES producto(id);

insert into producto(nombre, precio) values ('Xiaomi redmi note 8', 600000);
insert into producto(nombre, precio) values ('Huawei P20 Lite', 500000);
insert into producto(nombre, precio) values ('Iphone x', 3500000);
insert into producto(nombre, precio) values ('Samgung s21', 750000);
