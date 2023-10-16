package api.endPoints;

import static io.restassured.RestAssured.given;

import api.Payload.User;
import io.restassured.response.Response;
import io.restassured.http.*;

public class UserEndPoints {

	public static Response createUser(User payload) {
		Response responce = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(routes.post_url);
		return responce;

	}

	public static Response readUser(String userName) {
		System.out.println("===========" + userName);
		Response responce = given().pathParam("username", userName).when().get(routes.get_url);
		return responce;
	}

	public static Response updateUser(String userName, User payload) {

		Response responce = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(routes.put_url);
		return responce;

	}

	public static Response deleteUser(String userName) {
		Response responce = given().pathParam("username", userName).when().delete(routes.delete_url);
		return responce;

	}
}
