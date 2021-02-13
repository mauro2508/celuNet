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