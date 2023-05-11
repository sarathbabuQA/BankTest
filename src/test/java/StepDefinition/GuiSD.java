package StepDefinition;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GuiSD {
	public WebDriver driver;	

	@Given("user provide application url")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("user navigated to home page")
	public void passURL() {
		driver.get("https://reqres.in/.");
	}

	@Then("check home page information")
	public void homePageInfo() {
		List <WebElement> allApiServices = driver.findElements(By.className("endpoints"));
		for(WebElement api : allApiServices) {
			System.out.println(api.getText());
		}
	}

	@And("user close the browser")
	public void closeBrowser() {
		driver.quit();
	}
	
	@Then("click on anyone api method")
	public void selectApiMethod() {
		driver.findElement(By.xpath("//*[@data-id='users-single']")).click();
		String requestBody = driver.findElement(By.xpath("//*[@class='request']")).getText();
	    System.out.println("selected api service request body:"+ requestBody);	
	}
	
	@And("application should display api response data")
	public void apiResponseData() {
		String responseData = driver.findElement(By.xpath("//*[@data-key='output-response']")).getText();
	    String statusCode = driver.findElement(By.className("response-code")).getText();
		System.out.println("selected api service response body:"+ responseData);
		System.out.println("selected api service response code:"+ statusCode);
	}
	
	@Then("application has button to navigate support page")
	public boolean navigateButton() {
		return driver.findElement(By.xpath("//*[text()='Support ReqRes']")).isDisplayed();	
	}
	
	@And("click on SupportReqRes button")
	public void supportReqResButton() {
	    driver.findElement(By.xpath("//*[text()='Support ReqRes']")).click();	
	}
	
	@Then("application has one-time and monthly options")
	public void supportPageContent() {
		List<WebElement> supportOptions = driver.findElements(By.xpath("//*[@name='support']//following-sibling::label"));
		for(int i=0;i<supportOptions.size();i++) {
		String soption = supportOptions.get(i).getText();
	    System.out.println("list of support options:"+ soption);
		}
	}
	
	@And("click on Upgrade button")
	public void upgradeButton() {
		driver.findElement(By.id("trigger-pro")).click();
	}
	
    @Then("application display upgrade details")
    public void upgradeDetails() {
    	String upDetails = driver.findElement(By.id("pro-form")).getText();
    	System.out.println("upgrade details are :" + upDetails);
    }
}