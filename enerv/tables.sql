-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-03-10 07:16:35.405

-- tables
-- Table: AutoMoviles
CREATE TABLE AutoMoviles (
    placa varchar(20)  NOT NULL,
    modelo varchar(20)  NOT NULL,
    color varchar(20)  NOT NULL,
    tipo varchar(20)  NOT NULL,
    CONSTRAINT AutoMoviles_pk PRIMARY KEY (placa)
);

-- Table: Coductores
CREATE TABLE Coductores (
    nombre varchar(20)  NOT NULL,
    apellido varchar(20)  NOT NULL,
    fechaDeNacimiento date  NOT NULL,
    Documento varchar(15)  NOT NULL,
    CONSTRAINT Coductores_pk PRIMARY KEY (Documento)
);

-- Table: Comentarios
CREATE TABLE Comentarios (
    id int  NOT NULL,
    Comentario varchar(20)  NOT NULL,
    fecha date  NOT NULL,
    CONSTRAINT Comentarios_pk PRIMARY KEY (id)
);

-- Table: Pasajeros
CREATE TABLE Pasajeros (
    nombre varchar(20)  NOT NULL,
    apellido varchar(20)  NOT NULL,
    documento varchar(15)  NOT NULL,
    CONSTRAINT Pasajeros_pk PRIMARY KEY (documento)
);

-- Table: TarjetasDeCreditos
CREATE TABLE TarjetasDeCreditos (
    id int  NOT NULL,
    Banco varchar(15)  NOT NULL,
    activa boolean  NOT NULL,
    CONSTRAINT TarjetasDeCreditos_pk PRIMARY KEY (id)
);

-- Table: Viajes
CREATE TABLE Viajes (
    lugarDeDestino varchar(20)  NOT NULL,
    costo int  NOT NULL,
    tiempo int  NOT NULL,
    id int  NOT NULL,
    CONSTRAINT Viajes_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Coductores_AutoMoviles (table: Coductores)
ALTER TABLE Coductores ADD CONSTRAINT Coductores_AutoMoviles
    FOREIGN KEY (Documento)
    REFERENCES AutoMoviles (placa)  ;

-- Reference: Coductores_Comentarios (table: Coductores)
ALTER TABLE Coductores ADD CONSTRAINT Coductores_Comentarios
    FOREIGN KEY (Documento)
    REFERENCES Comentarios (id)  ;

-- Reference: Coductores_TarjetasDeCreditos (table: Coductores)
ALTER TABLE Coductores ADD CONSTRAINT Coductores_TarjetasDeCreditos
    FOREIGN KEY (Documento)
    REFERENCES TarjetasDeCreditos (id)  ;

-- Reference: Pasajeros_TarjetasDeCreditos (table: Pasajeros)
ALTER TABLE Pasajeros ADD CONSTRAINT Pasajeros_TarjetasDeCreditos
    FOREIGN KEY (documento)
    REFERENCES TarjetasDeCreditos (id)  ;

-- Reference: Viajes_Coductores (table: Viajes)
ALTER TABLE Viajes ADD CONSTRAINT Viajes_Coductores
    FOREIGN KEY (id)
    REFERENCES Coductores (Documento)  ;

-- Reference: Viajes_Pasajeros (table: Viajes)
ALTER TABLE Viajes ADD CONSTRAINT Viajes_Pasajeros
    FOREIGN KEY (id)
    REFERENCES Pasajeros (documento)  ;

-- End of file.

