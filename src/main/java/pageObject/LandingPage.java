package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By Login = By.xpath("//*[contains(text(),'Login')]");
	By featured = By.xpath("//*[contains(text(),'Featured Courses')]");
	By contact = By.xpath("//*[contains(text(),'Contact')]");
	
	//A, constructor will execute when this class call. 
	public LandingPage(WebDriver driver ) {
		this.driver=driver;
	}

	public WebElement getLogin() {
		
		return driver.findElement(Login);
	}
	
    public WebElement getTitle() {
		
		return driver.findElement(featured);
	}
    
    public WebElement getContact() {
		
  		return driver.findElement(contact);
  	}
    
    
    public void ClickPOPUP() {
    	try {
    		
    		driver.findElement(By.xpath("//*[contains(text(),'NO THANKS')]")).click();
    	}
    	catch(Exception e )
    	{
    		
    	}
    }
    
    public void  ClickError() {
    	String element = driver.findElement(By.xpath("//*[contains(text(),'NO THANKS')]")).getAttribute("NO THANKS");
    	System.out.println(element);
    	if(element.contains("NO THANKS")) {
    		driver.findElement(By.xpath("//*[contains(text(),'NO THANKS')]")).click();
    	}
    	else {
    		
    	}
    	
    }
      
    
    
}
