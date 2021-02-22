package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjectClass {
	
	public WebDriver driver;
	
	By Email = By.xpath("//*[@name='email']");
	By Password = By.xpath("//*[@name=' password']");
	By LogIn=By.xpath("//*[@name='commit']");
	
	//A, constructor will execute when this class call. 
	public LoginPageObjectClass(WebDriver driver ) {
		this.driver=driver;
	}

	public WebElement getEmail() {
		
		return driver.findElement(Email);
	}
	
    public WebElement getPassword() {
		
		return driver.findElement(Password);
	}
    
    public WebElement getLogIn() {
		
		return driver.findElement(LogIn);
	}
}
