package api.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.Payload.User;
import api.endPoints.UserEndPoints;
import api.utilities.DataProviders;
import io.restassured.response.Response;

import com.github.javafaker.Faker;

public class UserTest {
	// Faker faker;
	User userpayload;

	/*
	 * @BeforeClass public void setUpData() { faker = new Faker(); userpayload = new
	 * User();
	 * 
	 * userpayload.setId(faker.idNumber().hashCode());
	 * userpayload.setUsername(faker.name().username());
	 * userpayload.setFirstName(faker.name().firstName());
	 * userpayload.setLastName(faker.name().lastName());
	 * userpayload.setEmail(faker.internet().emailAddress());
	 * userpayload.setPassword(faker.internet().password(5, 10));
	 * userpayload.setPhone(faker.phoneNumber().cellPhone());
	 * 
	 * 
	 * }
	 */
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void setPostUserdata(String userid, String Uname, String Fname, String LastName, String emaiid,
			String passwd, String phonenumber) {
		userpayload = new  User();
		userpayload.setId(Integer.parseInt(userid));
		userpayload.setUsername(Uname);
		userpayload.setFirstName(Fname);
		userpayload.setLastName(LastName);
		userpayload.setEmail(emaiid);
		userpayload.setPassword(passwd);
		userpayload.setPhone(phonenumber);

		Response responce = UserEndPoints.createUser(userpayload);
		responce.then().log().all();
		Assert.assertEquals(responce.getStatusCode(), 200);

	}

	/*
	 * @Test(priority = 1) public void testPostuser() {
	 * 
	 * 
	 * System.out.println(userpayload); System.out.println("=============");
	 * 
	 * Response responce = UserEndPoints.createUser(userpayload);
	 * responce.then().log().all(); Assert.assertEquals(responce.getStatusCode(),
	 * 200); }
	 */
	/*
	 * @Test(priority = 2) public void getUserByName() { Response responce =
	 * UserEndPoints.readUser(this.userpayload.getUsername());
	 * responce.then().log().all(); Assert.assertEquals(responce.getStatusCode(),
	 * 200); }
	 */

	/*
	 * @Test(priority = 3) public void updatetUserByName(String Fname, String
	 * LastName, String emaiid) {
	 * 
	 * userpayload.setUsername(Fname); userpayload.setUsername(LastName);
	 * userpayload.setUsername(emaiid);
	 * 
	 * Response responce =
	 * UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
	 * responce.then().log().all(); Assert.assertEquals(responce.getStatusCode(),
	 * 200); }
	 * 
	 * @Test(priority = 4) public void deleteByName() { Response responce =
	 * UserEndPoints.deleteUser(this.userpayload.getUsername());
	 * responce.then().log().all(); Assert.assertEquals(responce.getStatusCode(),
	 * 200); }
	 */

}
