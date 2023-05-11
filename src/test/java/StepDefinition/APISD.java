package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class APISD {
	public WebDriver driver;
    Response response;
    
	@Given("user navigated to list of api endpoints")
	public void homePage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://reqres.in/");	
	}
	    
	@When("click on any Get api service")
	public void getApi() {
	    RestAssured.baseURI = "https://reqres.in/api/users/";
	    RequestSpecification httpRequest = RestAssured.given();
	    response = httpRequest.request(Method.GET,"2");
	}

	@Then("validate the get response body content")
	public void getResponseBody() {
		String bodyData = response.asString();	
		System.out.println("response status line =>" + response.getStatusLine());
		System.out.println("response data of get request =>" + bodyData);
		Assert.assertTrue(bodyData.contains("janet.weaver@reqres.in"));
		}

	@And("user close the api browser")
	public void closeBrowser() {
		driver.quit();
	}
	
	@When("click on any Post api service")
	public void postApi() {
		RequestSpecification HttpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name","morpheus");
		requestParams.put("job", "leader");
		HttpRequest.header("Content-Type","application/json");
		HttpRequest.body(requestParams.toString());
		response = HttpRequest.request(Method.POST);	
	}
	
    @Then("validate the post response body content")
    public void postResponseBody() {
    	System.out.println("response status line =>" + response.getStatusLine());
    	System.out.println("response data of post request =>" + response.asString());
    	String userName = response.path("name");
    	Assert.assertEquals(userName,"morpheus");
    	String userJob = response.path("job");
    	Assert.assertEquals(userJob,"leader");
    }
    
    @When("click on any Put api service")
    public void putApi() {
    	RequestSpecification HttpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name","SriRama");
		requestParams.put("job", "GOD");
		HttpRequest.header("Content-Type","application/json");
		HttpRequest.body(requestParams.toString());
		response = HttpRequest.request(Method.PUT);
    }
    
    @Then("validate the put response body content")
    public void putResponseBody() {
    	System.out.println("response status line =>" + response.getStatusLine());
    	System.out.println("response data of put request =>" + response.asString());
    	String userName = response.path("name");
    	Assert.assertEquals(userName,"SriRama");
    	String userJob = response.path("job");
    	Assert.assertEquals(userJob,"GOD");
    }
    
    @When("click on any Delete api service")
    public void deleteApi() {
    	RestAssured.baseURI = "https://reqres.in/api/users/";
    	RequestSpecification httpRequest = RestAssured.given();
    	response = httpRequest.request(Method.DELETE,"2");	
    }
    
    @Then("validate the delete response body content")
    public void deleteResponseBody() {	
		System.out.println("response status line =>" + response.getStatusLine());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,204);
    }
}
