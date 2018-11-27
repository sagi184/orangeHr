package testcases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import setups.Setup;

public class Addemployee extends Setup {
	public static com.relevantcodes.extentreports.ExtentReports extent;
	Setup s = new Setup();
	WebDriver driver;
	//String firstname = "Arun";
	static String alphabet = "abcd";
	//String s = RandomStringUtils.random(8, alphabet);
	static String Secondname = RandomStringUtils.random(8, alphabet);
	static String sname = Secondname; 
	static String firstname = RandomStringUtils.random(8, alphabet);
	static String fname = Secondname; 
	int m = 4;
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
	}
	
	@Test(priority = 2)
	public void AddAdminQualification() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement mousehov2 = driver.findElement(Admintab);
		Actions action = new Actions(driver);
		action.moveToElement(mousehov2).build().perform();
		//action.click();
		System.out.println("Mouse hover successfully done" );
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement mousehov3 = driver.findElement(QualificationAdmintab);
		Actions action1 = new Actions(driver);
		action.moveToElement(mousehov3).build().perform();
		System.out.println("Mouse hover 2 successfully done" );
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement quali_Education = wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(QualificationEducation)));
		quali_Education.click();
		//int i = 0;
		for(int j =0;j<4;j++)
		{
			if(j== 0)
			{
		Thread.sleep(3000);		
		driver.findElement(AddButton).click();;
		driver.findElement(Education_name).sendKeys("10th");
		driver.findElement(Savebutton).click();
        Utility.captureScreenshot(driver, "image " + m);
		//i++;
			}
		
		else if(j==1)
		{
			driver.findElement(AddButton).click();;
			driver.findElement(Education_name).sendKeys("12th");
			driver.findElement(Savebutton).click();	
            Utility.captureScreenshot(driver, "image " + m+2);
		}
		else
		{
			driver.findElement(AddButton).click();;
			driver.findElement(Education_name).sendKeys("Graduation");
			driver.findElement(Savebutton).click();	
            Utility.captureScreenshot(driver, "image " + m+3);
		}
		}
	}
	@Test(priority = 3)
	public void AddEmp()
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement mousehov1 = driver.findElement(Pimtab);
		Actions action = new Actions(driver);
		action.moveToElement(mousehov1).build().perform();
		//action.click();
		System.out.println("Mouse hover successfully done" );
		
		//click on leave assign
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement EmployeeAdd = wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(Addemp)));
		EmployeeAdd.click();
		
		driver.findElement(Addempfirstname).sendKeys(firstname);
		driver.findElement(Addempsecondname).sendKeys(Secondname);
	driver.findElement(Savebutton).click();
        Utility.captureScreenshot(driver, "image " + m+4);
		
		
	}
	
}
