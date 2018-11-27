package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import setups.Setup;

public class Education_information extends Setup {
	public static com.relevantcodes.extentreports.ExtentReports extent;
	Setup s = new Setup();
	WebDriver driver;
	int k = 0;
	public static ExtentTest test;
	
	boolean path;
	
	@BeforeTest
	public void start() {

	driver = s.Browser("Chrome");
	extent = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\advancereport.html",
			Boolean.valueOf(true));
	extent.addSystemInfo("HostName", "Sagar");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
	}
	@Test(priority = 1)
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Utility.captureScreenshot(driver, "image " +k);
	}

	@Test(priority = 2)
	public void Pimtab1()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement mousehov1 = driver.findElement(Pimtab);
		Actions action = new Actions(driver);
		action.moveToElement(mousehov1).build().perform();
		//action.click();
		System.out.println("Mouse hover successfully done" );
		
		//click on leave assign
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement Employeelist = wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(Employelist)));
		Employeelist.click();
	}
	@Test(priority = 3)
	public void SearchEmp() throws InterruptedException
	{
		
		Thread.sleep(3000);
		WebElement Empname  = driver.findElement(By.id("empsearch_employee_name_empName"));
		Empname.sendKeys(Addemployee.fname);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']/ul/li")));
		//div[@class='ac_results']/ul/li
	//	Thread.sleep(10000)
		
		// reading all available names in drop-down in a list
		List <WebElement> empName = (ArrayList<WebElement>)driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
	
			System.out.println(empName.size());
		/*Actions act = new Actions(driver);
		int size = empName.size();*/
		
		// selecting Robert Craig
		for (WebElement webElement : empName) 
		{
			System.out.println(webElement.getText());
			if(webElement.getText().equals(Addemployee.fname))
			{
				webElement.click();
				break;
				
			}
			
		} 
		Thread.sleep(3000); 
		driver.findElement(Search).click();
		Thread.sleep(3000); 
		Utility.captureScreenshot(driver, "image " + k+1);
		
		WebElement tabledata = driver.findElement(table);
		tabledata.click();
		
		/*String name = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
	    Assert.assertEquals(name, "Arun kumar");	*/
		
	}
	
	@Test(priority=4)
	public void AddQualification()
	{
		 int i = 1;
		WebElement qualification1 = driver.findElement(Qualificationtab);
		qualification1.click();
		
		List <WebElement> Courselist = (ArrayList<WebElement>)driver.findElements(By.xpath("//select[@id='education_code']/option"));
		int length = Courselist.size() -1;
		for(int j =0 ;j<length;j++)
		{
			
		WebElement Addeducationbutton = driver.findElement(Addeducation);
		Addeducationbutton.click();
		 
		WebElement mySelectElement = driver.findElement(By.id("education_code"));
		Select dropdown= new Select(mySelectElement);
		//Select course = new Select(driver.findElement(By.id("selecttype")));
		
		 
			mySelectElement.click();
			
			dropdown.selectByIndex(i);
			
			WebElement option = dropdown.getFirstSelectedOption();
			System.out.println("Value selected is: " +option.getText());
			
			WebElement Editinstitude = driver.findElement(education_institute);
			Editinstitude.clear();
			Editinstitude.sendKeys("highschool");
			
			//********************************Edit Specialization*******************************
				WebElement Editspecialization = driver.findElement(education_major);
				Editspecialization.clear();
				Editspecialization.sendKeys("Secondary school");
			
				//********************************Edit CGPA*******************************
						WebElement EditCGPA = driver.findElement(education_gpa);
						EditCGPA.clear();
						EditCGPA.sendKeys("75");
			//*************************************Save Changed Data*****************
						driver.findElement(educationsavebtn).click();
		                i++;
		                Utility.captureScreenshot(driver, "image " + k+2);
		} 	
	}
	
	@Test(priority=5)
public void EditQualification()
{
	
	
	WebElement educationtable = driver.findElement(Edutable);
	educationtable.click();
	//********************************Edit School*******************************
	WebElement Editinstitude = driver.findElement(education_institute);
	Editinstitude.clear();
	Editinstitude.sendKeys("New Highschool");
	
	//********************************Edit Specialization*******************************
		WebElement Editspecialization = driver.findElement(education_major);
		Editspecialization.clear();
		Editspecialization.sendKeys("New Secondary school");
	
		//********************************Edit CGPA*******************************
				WebElement EditCGPA = driver.findElement(education_gpa);
				EditCGPA.clear();
				EditCGPA.sendKeys("84");
	//*************************************Save Changed Data*****************
				driver.findElement(educationsavebtn).click();
				
				Utility.captureScreenshot(driver, "image " +k+3);
				
				
}

}

