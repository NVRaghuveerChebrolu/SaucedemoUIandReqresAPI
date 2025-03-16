package qumu;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinition {

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        HomePage.homePage();
    }
    
    @When("^I login in with the following details$")
    public void iLoginWithFollowingDetails(DataTable credentials) {
        HomePage.loginToSauceDemo(credentials);
    }
    
    @Given("^I add the following items to the basket$")
    public void i_add_the_following_items_to_the_basket(DataTable dataTable) {
    	 ProductDetailsPage.AddingItemsToCart(dataTable);
       
    }
    @Given("I  should see {int} items added to the shopping cart")
    public void i_should_see_items_added_to_the_shopping_cart(Integer itemsCount) {
    	ProductDetailsPage.ItemsCountInCart(itemsCount);
    
    }
    
    @Given("I click on the shopping cart")
    public void i_click_on_the_shopping_cart() {
    	ProductDetailsPage.ClickOnShoppingcart();
    }
    
    @Given("I verify that the QTY count for each item should be {int}")
    public void i_verify_that_the_qty_count_for_each_item_should_be(Integer QTYcount ) 
    {
    	ProductDetailsPage.CheckQTYCount(QTYcount);
    }
    
    @Given("I remove the following item:")
    public void i_remove_the_following_item(DataTable dataTable) 
    {
    	ProductDetailsPage.RemoveJacket(dataTable);
    }
    
    @Given("I should see updated {int} items in the shopping cart")
    public void i_should_see_items_after_removing_to_the_shopping_cart(Integer ItemsCountAfterRemovingJacket) {
    	
    	ProductDetailsPage.ValidateCartAfterRemovingJacket(ItemsCountAfterRemovingJacket);  
    }
    
    @Given("I click on the CHECKOUT button")
    public void i_click_on_the_checkout_button() {
    	ProductDetailsPage.ClickOnCheckBoxButton();
    }

    @Given("I type {string} for First Name")
    public void i_type_for_first_name(String Fname) {
    	ProductDetailsPage.EnterFirstName(Fname);
    }
    
    @Given("I type {string} for Last Name")
    public void i_type_for_last_name(String Lname) {
    	ProductDetailsPage.EnterLnametName(Lname);
    }

    @Given("I type {string} for ZIP\\/Postal Code")
    public void i_type_for_zip_postal_code(String zipcode) {
    	ProductDetailsPage.EnterZipcode(zipcode);
    }
    
    @When("I click on the CONTINUE button")
    public void i_click_on_the_continue_button() 
    {
    	ProductDetailsPage.ContinueButton();
    	
    }
    
    @Then("Item total will be equal to the total of items on the list")
    public void item_total_will_be_equal_to_the_total_of_items_on_the_list() {
    	ProductDetailsPage.TotalItemsCountInCheckout();
    }
    
    @Then("a Tax rate of {int} % is applied to the total")
    public void a_tax_rate_of_is_applied_to_the_total(Integer taxRate) 
    {
    	ProductDetailsPage.TotalTaxRate();
    }
    
//
//    @Given("^I get the default list of users for on 1st page$")
//    public void iGetTheDefaultListofusers() {
//    }
//
//    @When("I get the list of all users within every page")
//    public void iGetTheListOfAllUsers() {
//    }
//
//    @Then("I should see total users count equals the number of user ids")
//    public void iShouldMatchTotalCount() {
//
//    }
//
//    @Given("I make a search for user (.*)")
//    public void iMakeASearchForUser(String sUserID) {
//
//    }
//
//    @Then("I should see the following user data")
//    public void IShouldSeeFollowingUserData(DataTable dt) {
//    }
//
//    @Then("I receive error code (.*) in response")
//    public void iReceiveErrorCodeInResponse(int responseCode) {
//
//    }
//
//    @Given("I create a user with following (.*) (.*)")
//    public void iCreateUserWithFollowing(String sUsername, String sJob) {
//    }
//
//    @Then("response should contain the following data")
//    public void iReceiveErrorCodeInResponse(DataTable dt) {
//
//    }
//
//    @Given("I login unsuccessfully with the following data")
//    public void iLoginSuccesfullyWithFollowingData(DataTable dt) {
//
//    }
//
//    @Given("^I wait for the user list to load$")
//    public void iWaitForUserListToLoad() {
//
//    }
//
//    @Then("I should see that every user has a unique id")
//    public void iShouldSeeThatEveryUserHasAUniqueID() {
//
//        // Please not that we need to check all values are unique in the list.
//    }
//
//    @Then("^I should get a response code of (\\d+)$")
//    public void iShouldGetAResponseCodeOf(int responseCode) {
//    }
//
//    @And("^I should see the following response message:$")
//    public void iShouldSeeTheFollowingResponseMessage() {
//    }
}
