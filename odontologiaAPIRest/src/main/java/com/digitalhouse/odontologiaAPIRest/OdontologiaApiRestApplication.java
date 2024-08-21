package com.digitalhouse.odontologiaAPIRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OdontologiaApiRestApplication {

	public static void main(String[] args) {
		com.digitalhouse.odontologiaAPIRest.dao.BD.correrSQLScript("src/main/java/com/digitalhouse/odontologiaAPIRest/bd/create_tables.sql");
		SpringApplication.run(OdontologiaApiRestApplication.class, args);
	}

}
