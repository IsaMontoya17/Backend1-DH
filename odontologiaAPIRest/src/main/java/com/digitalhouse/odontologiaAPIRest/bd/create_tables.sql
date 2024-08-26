DROP TABLE IF EXISTS ODONTOLOGOS;

CREATE TABLE ODONTOLOGOS (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    APELLIDO VARCHAR(100) NOT NULL,
    NOMBRE VARCHAR(100) NOT NULL,
    MATRICULA VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS DOMICILIOS;

CREATE TABLE DOMICILIOS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CALLE VARCHAR(100) NOT NULL,
    NUMERO INT NOT NULL,
    LOCALIDAD VARCHAR(100) NOT NULL,
    PROVINCIA VARCHAR(100) NOT NULL
);


DROP TABLE IF EXISTS PACIENTES;

CREATE TABLE PACIENTES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    APELLIDO VARCHAR(100) NOT NULL,
    DNI VARCHAR(100) NOT NULL,
    FECHA_ALTA DATE NOT NULL,
    DOMICILIO_ID INT NOT NULL
);
