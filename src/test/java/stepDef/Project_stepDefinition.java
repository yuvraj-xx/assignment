package stepDef;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Project_stepDefinition 
{
	WebDriver driver;
	LoginPage lp;
	 String Parent_window;
	 String Child_window;
	 
	 
	 
	@Given("Chrome browser got launched")
	public void chrome_browser_got_launched()
	{ 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "E:\\seleniumdr\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();	
	       
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		
	    
	}

	@When("user hit the URL {string}")
	public void user_hit_the_url(String url)
	{
	    driver.get(url);
	}

	@When("user enters Email as {string}")
	public void user_enters_email_as(String email) 
	{
	    lp.setUserName(email);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String pass) 
	{
	   lp.setPassword(pass);
	}

	@When("user clicks on Login")
	public void user_clicks_on_login() throws InterruptedException 
	{
	   lp.clickLogin();
	   Thread.sleep(3000);
	  
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException 
	{
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	   
	}
	
	@Then("user click on help")
	public void user_click_on_help(){
	    lp.clickHelp();
	    
	}
	
	
	@Then("user click on Documentation page")
	public void user_click_on_documentation_page() throws InterruptedException {
	  lp.clickDocumentation();
	  Set<String>Handles=driver.getWindowHandles();
	  Iterator it= Handles.iterator();
	  Parent_window=(String) it.next();
	  Child_window=(String) it.next();
	  driver.switchTo().window(Child_window);
	  Thread.sleep(2000);
	  driver.close();
	}
	
	@Then("user come back to admin\\/parent window")
	public void user_come_back_to_admin_parent_window() throws InterruptedException {
	   driver.switchTo().window(Parent_window);
	   Thread.sleep(2000);
	}
	

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() 
	{
		lp.clickLogout(); 
	}

	@Then("close the browser")
	public void close_the_browser() 
	{
	  driver.quit(); 
	}
	

	

	

	   
	


}
