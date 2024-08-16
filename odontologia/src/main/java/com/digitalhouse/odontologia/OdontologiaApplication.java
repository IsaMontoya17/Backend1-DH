package com.digitalhouse.odontologia;

import com.digitalhouse.odontologia.dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OdontologiaApplication {

	public static void main(String[] args) {
		BD.correrSQLScript("src/main/java/com/digitalhouse/odontologia/bd/create_tables.sql");
		SpringApplication.run(OdontologiaApplication.class, args);
	}


}
