import java.sql.Driver;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hello {

	WebDriver driver = new ChromeDriver();
	
    Random rand =  new Random();
    
	@BeforeTest
	public void MySetup() {

		driver.get("https://codenboxautomationlab.com/practice/");

		driver.manage().window().maximize();

	}

	
	@Test(priority = 1 , enabled = false)
	public void autoCompleteTest() throws InterruptedException {
		
		//WebElement autoCompleteInputFeild = driver.findElement(By.className("input"));
		//WebElement autoCompleteInputFeild = driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input"));
		//WebElement autoCompleteInputFeild = driver.findElement(By.cssSelector("#autocomplete"));
		//WebElement autoCompleteInputFeild = driver.findElement(By.tagName("input"));
		//WebElement autoCompleteInputFeild = driver.findElement(By.className("input"));
		//WebElement autoCompleteInputFeild = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
//		WebElement autoCompleteInputFeild = driver.findElement(By.id("autocomplete"));
//		autoCompleteInputFeild.sendKeys("SAIF");
		
		WebElement autoCompleteInputFeild = driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input"));
		String[] countries = {"Jo","Sy","Ja","Ye"};
		int randomIndex = rand.nextInt(countries.length);
		System.out.println(randomIndex);
		autoCompleteInputFeild.sendKeys(countries[randomIndex]);
		Thread.sleep(1000);
		autoCompleteInputFeild.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));		

	}


	@Test(priority = 2)
	public void selectTag() {

		WebElement TheSelector = driver.findElement(By.id("dropdown-class-example"));

		Select myselect = new Select(TheSelector);

//		myselect.selectByVisibleText("Selenium");
//		
//		myselect.selectByIndex(1);
		
		myselect.selectByValue("option1");
		
		int NumberOfOptions = TheSelector.findElements(By.tagName("option")).size();
		//TagNames
		System.out.println(NumberOfOptions);
		
	}
	
	@Test(priority = 3)
	public void checkboxTest() {

		WebElement DivOfCheckBox = driver.findElement(By.id("checkbox-example"));

		List<WebElement> AllCheckBoxes = DivOfCheckBox.findElements(By.tagName("input"));
		int randomIndex = rand.nextInt(AllCheckBoxes.size());
		AllCheckBoxes.get(randomIndex).click();

//		AllCheckBoxes.get(0).click();
//		AllCheckBoxes.get(1).click();
//		AllCheckBoxes.get(2).click();

//		for(int i = 0 ; i < AllCheckBoxes.size();i++) {
//			AllCheckBoxes.get(i).click();
//			
//		}
		
	}
}
  