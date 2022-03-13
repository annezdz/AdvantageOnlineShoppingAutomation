package br.nttdata.getRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;

import entities.Produto;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Data {

	public Map<String, String> getData() {

		RestAssured.baseURI = "http://localhost:8080/produtos/HP%20PAVILION%2015Z%20TOUCH%20LAPTOP";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

//		// Retrieve the body of the Response
//		ResponseBody body = response.getBody();
//
//		// By using the ResponseBody.asString() method, we can convert the  body
//		// into the string representation.
//		System.out.println("Response Body is: " + body.asString());

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
//		String idMassas = jsonPathEvaluator.get("idMassas");

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

//		// Retrieve the body of the Response
//		ResponseBody body = response.getBody();
//
//		// By using the ResponseBody.asString() method, we can convert the  body
//		// into the string representation.
//		System.out.println("Response Body is: " + body.asString());

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

	public static void main(String[] args) {

//		
//		RestAssured.baseURI = "http://localhost:8080/produtos/HP%20PAVILION%2015Z%20TOUCH%20LAPTOP";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.get();

//		// Retrieve the body of the Response
//		ResponseBody body = response.getBody();
//
//		// By using the ResponseBody.asString() method, we can convert the  body
//		// into the string representation.
//		System.out.println("Response Body is: " + body.asString());

		// First get the JsonPath object instance from the Response interface
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		
//		Map<String,String> listaCampo = new HashMap<String, String>();
//		listaCampo.put("nameProduct", jsonPathEvaluator.get("nameProduct"));
//		listaCampo.put("customization", jsonPathEvaluator.get("customization"));
//		listaCampo.put("display", jsonPathEvaluator.get("display"));
//		listaCampo.put("displayResolution", jsonPathEvaluator.get("displayResolution"));
//		listaCampo.put("displaySize", jsonPathEvaluator.get("displaySize"));
//		listaCampo.put("memory", jsonPathEvaluator.get("memory"));
//		listaCampo.put("operatingSystem", jsonPathEvaluator.get("operatingSystem"));
//		listaCampo.put("processor", jsonPathEvaluator.get("processor"));
//		listaCampo.put("touchscreen", jsonPathEvaluator.get("touchscreen"));
//		listaCampo.put("weight", jsonPathEvaluator.get("weight"));
//		listaCampo.put("color", jsonPathEvaluator.get("color"));
//
//		List<String> campos = new ArrayList();
//		campos.add(jsonPathEvaluator.get("nameProduct"));
//		campos.add(jsonPathEvaluator.get("customization"));
//		campos.add(jsonPathEvaluator.get("display"));
//		campos.add(jsonPathEvaluator.get("displayResolution"));
//		campos.add(jsonPathEvaluator.get("displaySize"));
//		campos.add(jsonPathEvaluator.get("memory"));
//		campos.add(jsonPathEvaluator.get("operatingSystem"));
//		campos.add(jsonPathEvaluator.get("processor"));
//		campos.add(jsonPathEvaluator.get("touchscreen"));
//		campos.add(jsonPathEvaluator.get("weight"));
//		campos.add(jsonPathEvaluator.get("color"));

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
//		String idMassas = jsonPathEvaluator.get("idMassas");
//		String nameProduct = jsonPathEvaluator.get("nameProduct");
//		String customization = jsonPathEvaluator.get("customization");
//		String display = jsonPathEvaluator.get("display");
//		String displayResolution = jsonPathEvaluator.get("displayResolution");
//		String displaySize = jsonPathEvaluator.get("displaySize");
//		String memory = jsonPathEvaluator.get("memory");
//		String operatingSystem = jsonPathEvaluator.get("operatingSystem");
//		String processor = jsonPathEvaluator.get("processor");
//		String touchscreen = jsonPathEvaluator.get("touchscreen");
//		String weight = jsonPathEvaluator.get("weight");
//		String color = jsonPathEvaluator.get("color");
////
//		System.out.println(" nameProduct " + nameProduct);
//		System.out.println(" customization " + customization);
//		System.out.println(" display " + display);
//		System.out.println(" displayResolution " + displayResolution);
//		System.out.println(" displaySize " + displaySize);
//		System.out.println(" memory " + memory);

		RestAssured.baseURI = "http://localhost:8080/produtos/HP%20PAVILION%2015Z%20TOUCH%20LAPTOP";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("color", "RED");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());

		// Validando resposta do servidor

		Response response = request.patch("/RED");
		System.out.println("The status received: " + response.statusLine());

	}

}
