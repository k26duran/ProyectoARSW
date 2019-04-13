



CREATE TABLE automoviles (
	color varchar(255) NULL,
	modelo varchar(255) NULL,
	placa varchar(255) NOT NULL,
	tipo varchar(255) NULL,
	CONSTRAINT automovil_pkey PRIMARY KEY (placa)
);

CREATE TABLE conductores (
	id bigserial NOT NULL,
	apellidos varchar(255) NULL,
	calificacion int4 NULL,
	celular varchar(255) NULL,
	clave varchar(255) NULL,
	correo varchar(255) NULL,
	fecha_nacimiento timestamp NULL,
	nombres varchar(255) NULL,
	automovil_id varchar(255) NULL,
	CONSTRAINT conductor_pkey PRIMARY KEY (id),
	CONSTRAINT UK_CORREO_CONDUCTOR UNIQUE (correo),
	CONSTRAINT UK_CELULAR__CONDUCTOR UNIQUE (celular),
	CONSTRAINT FK_CONDUCTOR_AUTOMOVIL FOREIGN KEY (automovil_id) REFERENCES automoviles(placa)
);



CREATE TABLE pasajeros (
	id bigserial NOT NULL,
	apellidos varchar(255) NULL,
	calificacion int4 NULL,
	celular varchar(255) NULL,
	clave varchar(255) NULL,
	correo varchar(255) NULL,
	fecha_nacimiento timestamp NULL,
	nombres varchar(255) NULL,
	CONSTRAINT pasajero_pkey PRIMARY KEY (id),
	CONSTRAINT UK_CELULAR_PASAJERO UNIQUE (celular),
	CONSTRAINT UK_CORREO_PASAJERO UNIQUE (correo)
);


CREATE TABLE viajes (
	id bigserial NOT NULL,
	aceptado bool NOT NULL,
	calificacion_al_conductor int4 NOT NULL,
	calificacion_al_pasajero int4 NOT NULL,
	correo_conductor varchar(255)  NULL,
	correo_pasajero varchar(255) NOT NULL,
	costo int4 NOT NULL,
	fecha varchar(255) NULL,
	lugar_destino varchar(255) NULL,
	lugar_origen varchar(255) NULL,
	tiempo int4 NOT NULL,
	CONSTRAINT viajes_pkey PRIMARY KEY (id),
	CONSTRAINT FK_VIAJES_CODUCTOR FOREIGN KEY (correo_conductor) REFERENCES conductores(correo),
	CONSTRAINT FK_VIAJES_PASAJERO FOREIGN KEY (correo_pasajero) REFERENCES pasajeros(correo)
);





CREATE TABLE comentario (
	id bigserial NOT NULL,
	contenido varchar(255) NULL,
	"date" timestamp NULL,
	viaje_id int8 NULL,
	CONSTRAINT comentario_pkey PRIMARY KEY (id),
	CONSTRAINT FK_COMENTARIO_VIAJES FOREIGN KEY (viaje_id) REFERENCES viajes(id)
);




CREATE TABLE cuentabancaria (
	numero bigserial NOT NULL,
	activa bool NOT NULL,
	conductor_id int8 NULL,
	pasajero_id int8 NULL,
	CONSTRAINT cuenta_bancaria_pkey PRIMARY KEY (numero),
	CONSTRAINT FK_CUENTA_PASAJERO FOREIGN KEY (pasajero_id) REFERENCES pasajeros(id),
	CONSTRAINT FK_CUENTA_CONDUCTOR FOREIGN KEY (conductor_id) REFERENCES conductores(id)
);

-- Drop table

-- DROP TABLE public.cupon;

CREATE TABLE  cupones (
	id bigserial NOT NULL,
	activo bool NULL,
	cupon varchar(255) NULL,
	pasajero_id int8 NULL,
	CONSTRAINT cupon_pkey PRIMARY KEY (id),
	CONSTRAINT FK_CUPON_PASAJARO FOREIGN KEY (pasajero_id) REFERENCES pasajeros(id)
);


insert into automoviles(tipo,color,placa,modelo) values ('camioneta','negra','ARS219','Mercedes-2017');

insert into conductores(nombres, apellidos , calificacion , celular , clave  , correo , fecha_nacimiento , automovil_id) 
			values ('Camilo' ,'Velandia' , 0 , '320989471' , 'NoEsUnaClave' , 'corre1o@arsw',now(),'ARS219');

		
insert into pasajeros(nombres, apellidos , calificacion , celular , clave  , correo , fecha_nacimiento) 
	values ('John David' ,'Ibanez Rodrigue' , 0 , '3209894071' , 'NoEsUnaClave' , 'correo@arsw',now());


insert into  viajes(aceptado,calificacion_al_conductor,calificacion_al_pasajero,conductor_id,correo_conductor,correo_pasajero,costo,fecha,lugar_destino,
					lugar_origen,pasajero_id,tiempo)
					values(true,5,5,1,'correoUsr','correoUsr',10000,now(),'san Joaquin','Tunal',1,50000);	

insert into pasajeros(nombres, apellidos , calificacion , celular , clave  , correo , fecha_nacimiento) 
	values ('Kare paola' ,'Duran ' , 0 , '320989071' , 'SiEsUnaClave' , 'paola@arsw',now());

insert into  viajes(aceptado,calificacion_al_conductor,calificacion_al_pasajero,conductor_id,correo_conductor,correo_pasajero,costo,fecha,lugar_destino,
					lugar_origen,pasajero_id,tiempo)
					values(true,5,5,1,'correoUsr','correoUsr',10000,now(),'san Joaquin','Tunal',1,50000);


/*
	{
        "correo": "correo@arsw",
        "nombres": "John David",
        "apellidos": "Ibanez Rodrigue",
        "celular": "3209894071",
        "calificacion": 0,
        "fechaNacimiento": null,
        "clave": null,
        "cupones": [],
        "viajes": [],
        "tipoUsuario": "usuario"
    }

*/