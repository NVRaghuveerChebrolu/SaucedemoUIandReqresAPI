package qumu;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

public class ReqresStepDefinition {
    private Response response;
    private String BASE_URL = "https://reqres.in/api";
    List<Integer> userIds;
    int totalUserCount=0;
    
    @Given("I get the default list of users for on 1st page")
    public void getDefaultUserList() {
        response = given().when().get(BASE_URL + "/users?page=1");
        response.then().statusCode(200);
    }

    @When("I get the list of all users within every page")
    public void getAllUsers() {
        int totalUsers = response.jsonPath().getInt("total");
        int perPage = response.jsonPath().getInt("per_page");
        int expectedPages = (int) Math.ceil((double) totalUsers / perPage);
     
      
        for (int i = 1; i <= expectedPages; i++) {
            response = given().when().get(BASE_URL + "/users?page=" + i);
            userIds = response.jsonPath().getList("data.id");
            totalUserCount=totalUserCount+userIds.size();
            response.then().statusCode(200);
        }
    }

    @Then("I should see total users count equals the number of user ids")
    public void verifyUserCount() {
        int total = response.jsonPath().getInt("total");
       // List<Integer> userIds = response.jsonPath().getList("data.id");
        Assert.assertEquals(total, totalUserCount);
    }

    @Given("I make a search for user {int}")
    public void searchUser(int userId) {
        response = given().when().get(BASE_URL + "/users/" + userId);
    }

    @Then("I should see the following user data")
    public void verifyUserData(DataTable datatable) {
    	 List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
        response.then()
                .body("data.first_name", equalTo(data.get(0).get("first_name")))
                .body("data.email", equalTo(data.get(0).get("email")));
    }

    @Then("I receive error code {int} in response")
    public void verifyErrorCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Given("I create a user with following {string} {string}")
    public void createUser(String name, String job) {
        response = given().body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}")
                .header("Content-Type", "application/json")
                .when().post(BASE_URL + "/users");
    }

    @Then("response should contain the following data")
    public void verifyUserCreation(DataTable dataTable) {
    	 List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
         Map<String, Object> actualResponse = response.jsonPath().getMap("");
         // Validate each row in DataTable against JSON response
         for (Map<String, String> expectedRow : expectedData) {
             for (Map.Entry<String, String> entry : expectedRow.entrySet()) {
                 String expectedKey = entry.getKey();
                 String expectedValue = entry.getValue();
                 // Validate value if it's present
                 Object actualValue = actualResponse.get(expectedKey);
                 Assert.assertEquals(expectedKey, expectedValue, String.valueOf(actualValue));
             }
         }
    }

    @Given("I login successfully with the following data")
    public void loginUser(DataTable table) {
    	List<Map<String, String>> loginData = table.asMaps(String.class, String.class);
        response = given().body("{\"email\": \"" + loginData.get(0).get("Email") + "\", \"password\": \"" + loginData.get(0).get("Password") + "\"}")
                .header("Content-Type", "application/json")
                .when().post(BASE_URL + "/login");
    }

    @Given("I login unsuccessfully with the following data")
    public void loginUnsuccessful(DataTable table) {
        List<Map<String, String>> loginData = table.asMaps(String.class, String.class);
        System.out.println("email for unsuccessfull:"+loginData.get(0).get("Email"));
        System.out.println("passowrd for unsuccessfull:"+loginData.get(0).get("Password"));
        String passwordForUnSuccessfull= loginData.get(0).get("Password");
        if(passwordForUnSuccessfull==null) {
        	passwordForUnSuccessfull="";
        }
        response = given().body("{\"email\": \"" + loginData.get(0).get("Email") + "\", \"password\": \"" + passwordForUnSuccessfull + "\"}")
                .header("Content-Type", "application/json")
                .when().post(BASE_URL + "/login");
    }

    @Then("I should get a response code of {int}")
    public void verifyLoginResponseCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("I should see the following response message:")
    public void verifyErrorMessage(DataTable datable) {
    	 List<Map<String, String>> expectedData = datable.asMaps(String.class, String.class);
        System.out.println("error message without passowrd"+expectedData.get(0).get("error"));
        response.then().body("error",equalTo(expectedData.get(0).get("error")));
    }

    @Given("I wait for the user list to load")
    public void waitForDelayedResponse() {
        response = given().when().get(BASE_URL + "/users?delay=3");
        response.then().statusCode(200);
    }

    @Then("I should see that every user has a unique id")
    public void verifyUniqueUserIds() {
        List<Integer> userIds = response.jsonPath().getList("data.id");
        Assert.assertEquals(userIds.size(), userIds.stream().distinct().count());
    }
}

