INSERT INTO categorias (nombre)
    VALUES('codigo'),('ejercicio'),('salud mental'),('tramites');

INSERT INTO tareas (nombre,descripcion,categoria_id,is_completed)
    VALUES('Hacer pesas', 'Dia de piernas', 2, false),
          ('Sacar certificado','Titularizacion',4, false),
          ('Hacer el login', 'Interceptores', 1, false);
