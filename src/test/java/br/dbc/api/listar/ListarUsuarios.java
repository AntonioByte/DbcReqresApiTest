package br.dbc.api.listar;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class ListarUsuarios {

	@BeforeAll
	public static void setup() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users";
	}
	
	@Test
	public void listarUsuarios() {
		
		RestAssured
		.given()
		.when()
			.get("?page=1")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void listarUsuariosPag() {
		
		RestAssured
		.given()
		.when()
			.get("?page=2")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	
	@Test
	public void listarTotalUsuarios() {
		
		RestAssured
		.given()
		.when()
			.get("?page=2")
		.then()
			.log().all()
			.statusCode(200)
			.body("per_page", Matchers.is(6))
			.body("data", Matchers.hasSize(6));
	}
	
	@Test
	public void listarPaginaInexistente() {
		
		RestAssured
		.given()
		.when()
			.get("?page=200")
		.then()
			.log().all()
			.statusCode(400);
	}
	
	@Test
	public void listarPaginaMetodoIncorreto() {
		
		RestAssured
		.given()
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(415);
	}	
}
