DELETE table tareas;
DELETE table usuario;

CREATE TABLE users (
       id uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
       username VARCHAR(50) NOT NULL UNIQUE,
       password VARCHAR(500) NOT NULL,
       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
     username VARCHAR(50) NOT NULL,
     authority VARCHAR(50) NOT NULL,
     CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

CREATE TABLE IF NOT EXISTS tareas (
    id uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    titulo text,
    descripcion text,
    categoria text,
    prioridad text,
    completada boolean,
    fecha date,
    usuario_id uuid REFERENCES users(id) ON DELETE CASCADE
);


INSERT INTO users (correo, nombre, contrasena) VALUES
                                               ('a@a','AAA','aA'),
                                               ('b@b','BBB','bB'),
                                               ('c@c','CCC','cC');

INSERT INTO tareas (titulo, descripcion, categoria, prioridad, completada, fecha, usuario_id) VALUES
    ('usuario A comprar pan', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='a@a')),
    ('usuario A comprar lecha', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='a@a')),
    ('usuario A comprar aZUCOAR', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='a@a')),

    ('usuario B comprar pan', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='b@b')),
    ('usuario B comprar lecha', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='b@b')),

    ('usuario C comprar lecha', 'comprar dos panes', 'compras','alta',true, '2009/02/02', (SELECT id FROM usuario WHERE correo='c@c'));