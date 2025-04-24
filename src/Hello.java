import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hello {

	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
public void MySetup() {
	
		driver.get("http://127.0.0.1:5500/index.html");
	
		driver.manage().window().maximize(); 
		
}
   @Test
   public void MyTest() {
	   
	   System.out.println(driver.getTitle());
	   
	   
   }



}
