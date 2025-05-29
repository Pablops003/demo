DROP TABLE IF EXISTS tareas;
DROP TABLE IF EXISTS usuario;

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