package GraphQL;

import static io.restassured.RestAssured.*;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 

public class Createlocation {
	


	    public static void Createlocation() {

	        String payload = "{\"query\":\"query ($CharacterId: Int!, $locationId: Int!,$episodeId: Int!) {\\n  character(characterId:$CharacterId) {\\n    name\\n    id\\n    type\\n    gender\\n    image\\n  }\\n  location(locationId: $locationId) {\\n    name\\n    dimension\\n    type\\n  }\\n  episode(episodeId: $episodeId) {\\n    id\\n    name\\n    air_date\\n  }\\n}\",\"variables\":{\"CharacterId\":25526,\"locationId\":34086,\"episodeId\":23097}}";

	        RequestSpecification req = new RequestSpecBuilder()
	                .setBaseUri("https://rahulshettyacademy.com")
	                .setContentType(ContentType.JSON)
	                .build();

	        String response = given()
	                .log().all()
	                .spec(req)
	                .body(payload)
	        .when()
	                .post("/gq/graphql")
	        .then()
	                .log().all()
	                .statusCode(200)
	                .extract()
	                .response().asString();

	        JsonPath js = new JsonPath(response);

	        String name = js.getString("data.character.name");
	        System.out.println(name);
	        System.out.println("added new project");
	        System.out.println("added new project2");
	        System.out.println("added new project3");
	    }

	    public static void main(String[] args) {
	        Createlocation();
	    }
	}

