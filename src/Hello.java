import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apple.laf.JRSUIConstants.Size;

public class Hello {

	WebDriver driver = new ChromeDriver();
	
    Random rand =  new Random();
    
	@BeforeTest
	public void MySetup() {

		driver.get("https://codenboxautomationlab.com/practice/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

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

	@Test(priority = 4,enabled = false)
	public void WindowExamble() throws InterruptedException {

		WebElement SwitchWindowButton = driver.findElement(By.id("openwindow"));
		SwitchWindowButton.click();

		Set<String> handles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handles);
		driver.switchTo().window(windowList.get(1));
		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"menu-item-9660\"]/a/span[1]"));
		driver.switchTo().window(windowList.get(0));
		System.out.println(driver.getTitle());

	}
	@Test(priority = 5)
	public void SwitchTabExample() throws InterruptedException {

		WebElement SwitchTabButton = driver.findElement(By.id("opentab"));
		SwitchTabButton.click();

		Set<String> handles = driver.getWindowHandles();
		List<String> TabList = new ArrayList<>(handles);
		driver.switchTo().window(TabList.get(1));
		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.switchTo().window(TabList.get(0));
		System.out.println(driver.getTitle());

	}
	
	@Test(priority = 6,enabled = false )
	public void AlertTest() throws InterruptedException {
		
		Thread.sleep(2000);

		WebElement InputFeildForTheName = driver.findElement(By.id("name"));
		InputFeildForTheName.sendKeys("SaifAlhaj");
		
		WebElement AlertButton = driver.findElement(By.id("alertbtn"));
		AlertButton.click();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		
	} 
	@Test(priority = 7,enabled = false )
	public void ConfirmTest() throws InterruptedException {
		
		Thread.sleep(2000);

		WebElement InputFeildForTheName = driver.findElement(By.id("name"));
		InputFeildForTheName.sendKeys("SaifAlhaj");
		
		WebElement AlertButton = driver.findElement(By.id("confirmbtn"));
		AlertButton.click();
		Thread.sleep(2000);

		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();;
	} 
	
	@Test(priority = 7)
			public void TableTest() {
		
		//to print table row 
		
		WebElement theTable = driver.findElement(By.id("product"));
		
		List<WebElement> AllRows = theTable.findElements(By.tagName("tr")); // or "th"
		
		List<WebElement> AllData = theTable.findElements(By.tagName("td"));
		
		
		// logic to print random row 
//		int randomrow = rand.nextInt(AllRows.size()); 
//		
//		System.out.println(AllRows.get(randomrow).getText());
		
		
//    to print all the rows 
		
		
//		for(int i= 0 ; i < AllRows.size(); i++) {
//			
//			System.out.println(AllRows.get(i).getText());
//			
//		}
		
		for(int i= 0 ; i < AllData.size(); i++) {
		
		System.out.println(AllData.get(i).getText());
	}
	
}
}
  