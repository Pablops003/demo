CREATE TABLE Tarea(

    id uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    titulo text
);

INSERT INTO Tarea(titulo) VALUES ('comprar'),('Hacer deporte')