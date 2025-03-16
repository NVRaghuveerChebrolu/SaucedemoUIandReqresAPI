package qumu;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import pom.HomePagePOM;

public class HomePage extends BasePage {

    public static void homePage() {
    	driver= new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.manage().window().maximize();
    	System.out.println("url from property file:"+LoadProp.getproperty("url"));
        driver.get(LoadProp.getproperty("url"));
    }
    
    public static void loginToSauceDemo(DataTable credentials) {
        List<Map<String, String>> data = credentials.asMaps(String.class, String.class);
        String username = data.get(0).get("userName");
        String password = data.get(0).get("Password");
        HomePagePOM loginPage = new HomePagePOM(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}
