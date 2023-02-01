package br.dbc.api.inserir;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class InserirUsuario {

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users";
	}
	
	@Test
	public void criarUsuario() {
		String corpo = "{"
				+ "    \"name\": \"Miguel\","
				+ "    \"job\": \"Analista\""
				+ "}";
		
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.body(corpo)
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(201)
			.body("id", Matchers.is(Matchers.notNullValue()));
	}
	
	@Test
	public void criarUsuarioNomeVazio() {
		String corpo = "{"
				+ "    \"name\": \"\","
				+ "    \"job\": \"Analista\""
				+ "}";
		
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.body(corpo)
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(400);
	}
	
	@Test
	public void criarUsuarioJobVazio() {
		String corpo = "{"
				+ "    \"name\": \"Miguel\","
				+ "    \"job\": \"\""
				+ "}";
		
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.body(corpo)
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(400);
	}
	
	@Test
	public void criarUsuarioNomeNulo() {
		String corpo = "{"
				+ "    \"name\": ,"
				+ "    \"job\": \"Analista\""
				+ "}";
		
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.body(corpo)
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(400);
	}
	
	
	@Test
	public void criarUsuarioJobNulo() {
		String corpo = "{"
				+ "    \"name\": \"Miguel\","
				+ "    \"job\": "
				+ "}";
		
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.body(corpo)
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(400);
	}
	
	@Test
	public void criarUsuarioVerboIncorreto() {
		String corpo = "{"
				+ "    \"name\": \"Miguel\","
				+ "    \"job\": \"Analista\""
				+ "}";
		
		RestAssured
		.given()
			.contentType(ContentType.JSON)
			.body(corpo)
		.when()
			.put()
		.then()
			.log().all()
			.statusCode(404)
			.body("id", Matchers.is(Matchers.notNullValue()));
	}
}
