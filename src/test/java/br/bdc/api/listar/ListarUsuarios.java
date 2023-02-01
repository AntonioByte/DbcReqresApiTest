package br.bdc.api.listar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class ListarUsuarios {

	@BeforeAll
	public static void setup() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users?page=2";
	}
	
	@Test
	public void listarUsuarios() {
		
		RestAssured
		.given()
		.when()
			.get()
		.then()
			.log().all()
			.statusCode(200);
	}
}
