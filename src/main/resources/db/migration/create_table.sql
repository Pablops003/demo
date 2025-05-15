DELETE table tareas;
DELETE table usuario;

CREATE TABLE IF NOT EXISTS usuario (
                                       id uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    correo text,
    nombre text,
    contrasena text);

CREATE TABLE IF NOT EXISTS tareas (
                                      id uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    titulo text,
    descripcion text,
    categoria text,
    prioridad text,
    completada boolean,
    fecha date,
    usuario_id uuid REFERENCES usuario(id) ON DELETE CASCADE

    );


INSERT INTO usuario (correo, nombre, contrasena) VALUES ('a@a','AAA','aA'),  ('b@b','BBB','bB'),  ('c@c','CCC','cC');

INSERT INTO tareas (titulo, descripcion, categoria, prioridad, completada, fecha, usuario_id) VALUES
    ('usuario A comprar pan', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='a@a')),
    ('usuario A comprar lecha', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='a@a')),
    ('usuario A comprar aZUCOAR', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='a@a')),

    ('usuario B comprar pan', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='b@b')),
    ('usuario B comprar lecha', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='b@b')),

    ('usuario C comprar lecha', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='c@c'));