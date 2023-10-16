package api.endPoints;

public class routes {

	// Swagger URL: https://petstore.swagger.io
	// Create User (post) :https://petstore.swagger.io/user
	// Get User (Get) :/user/{username}
	// Update User (Put) :/user/{username}
	// delete User (Delete) :/user/{username}

	public static String base_url = "https://petstore.swagger.io/v2";
	public static String post_url =base_url+"/user";
	public static String get_url =base_url+"/user/{username}";
	public static String put_url =base_url+"/user/{username}";
	public static String delete_url =base_url+"/user/{username}";

}
