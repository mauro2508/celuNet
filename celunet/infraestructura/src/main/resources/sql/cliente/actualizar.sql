update cliente
set nombre = :nombre,
	apellido = :apellido,
	email = :email,
	fecha_nacimiento = :fechaNacimiento,
	fecha_creacion = :fechaCreacion
where id = :id