package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[10]/a[1]")
	@CacheLookup
	WebElement btnhelp;
	
	@FindBy(xpath= "/html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[10]/ul[1]/li[2]/a[1]/p[1]")
	@CacheLookup
	WebElement btnDocumentation;
	
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	
	
	
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);

	}
	
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	public void clickHelp() {
		btnhelp.click();
	}
	
	public void clickDocumentation() {
		btnDocumentation.click();
		
	}
	
	
}
