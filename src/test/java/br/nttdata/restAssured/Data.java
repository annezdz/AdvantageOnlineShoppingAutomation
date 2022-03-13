package br.nttdata.restAssured;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Data {

	public Map<String, String> pegarDados() {

		RestAssured.baseURI = "http://localhost:8080/produtos/HP%20PAVILION%2015Z%20TOUCH%20LAPTOP";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		
		JsonPath jsonPathEvaluator = response.jsonPath();

		Map<String, String> listaCampo = new HashMap<String, String>();
		listaCampo.put("nameProduct", jsonPathEvaluator.get("nameProduct"));
		listaCampo.put("customization", jsonPathEvaluator.get("customization"));
		listaCampo.put("display", jsonPathEvaluator.get("display"));
		listaCampo.put("displayResolution", jsonPathEvaluator.get("displayResolution"));
		listaCampo.put("displaySize", jsonPathEvaluator.get("displaySize"));
		listaCampo.put("memory", jsonPathEvaluator.get("memory"));
		listaCampo.put("operatingSystem", jsonPathEvaluator.get("operatingSystem"));
		listaCampo.put("processor", jsonPathEvaluator.get("processor"));
		listaCampo.put("touchscreen", jsonPathEvaluator.get("touchscreen"));
		listaCampo.put("weight", jsonPathEvaluator.get("weight"));
		listaCampo.put("color", jsonPathEvaluator.get("color"));

		return listaCampo;
	}
	

	public Response pegarResponseBody() {

		RestAssured.baseURI = "http://localhost:8080/produtos/HP%20PAVILION%2015Z%20TOUCH%20LAPTOP";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		return response;
	}
	

	public Map<String, String> validaCampos() {

		JsonPath jsonPathEvaluator = pegarResponseBody().jsonPath();

		Map<String, String> listaCampo = new HashMap<String, String>();
		listaCampo.put("nameProduct", jsonPathEvaluator.get("nameProduct"));
		listaCampo.put("customization", jsonPathEvaluator.get("customization"));
		listaCampo.put("display", jsonPathEvaluator.get("display"));
		listaCampo.put("displayResolution", jsonPathEvaluator.get("displayResolution"));
		listaCampo.put("displaySize", jsonPathEvaluator.get("displaySize"));
		listaCampo.put("memory", jsonPathEvaluator.get("memory"));
		listaCampo.put("operatingSystem", jsonPathEvaluator.get("operatingSystem"));
		listaCampo.put("processor", jsonPathEvaluator.get("processor"));
		listaCampo.put("touchscreen", jsonPathEvaluator.get("touchscreen"));
		listaCampo.put("weight", jsonPathEvaluator.get("weight"));
		listaCampo.put("color", jsonPathEvaluator.get("color"));

		return listaCampo;
	}
	

	public String atualizaCor(String color) {

		RestAssured.baseURI = "http://localhost:8080/produtos/HP%20PAVILION%2015Z%20TOUCH%20LAPTOP";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("color", color);

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());

		Response response = request.patch("/" + color);
		return "The status received: " + response.statusLine();
	}
}
