package br.bdc.api.listar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class ListarUsuario {
	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users";
	}
	
	@Test
	public void listarUsuario() {
		String idUser = "10";
		
		RestAssured
		.given()
		.when()
			.get("/" + idUser)
		.then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void listarUsuarioIncorreto() {
		String idUser = "a";
		
		RestAssured
		.given()
		.when()
			.get("/" + idUser)
		.then()
			.log().all()
			.statusCode(404);
	}
	
	@Test
	public void listarUsuarioInexistente() {
		
		RestAssured
		.given()
		.when()
			.get("/100")
		.then()
			.log().all()
			.statusCode(404);
	}	
}
