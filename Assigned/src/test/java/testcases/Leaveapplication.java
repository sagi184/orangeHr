package testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import setups.Setup;

public class Leaveapplication extends Setup {
	public static com.relevantcodes.extentreports.ExtentReports extent;
	Setup s = new Setup();
	WebDriver driver;
	public static ExtentTest test;
	
	boolean path;
	
	@BeforeTest
	public void start() {

	driver = s.Browser("Chrome");
	extent = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\advancereport.html",
			Boolean.valueOf(true));
	extent.addSystemInfo("HostName", "Sagar");	
	}
	
	/*@AfterTest
	public void endReport() {
		extent.flush();
		//SendEmail.SendMailWithAttachment();
		extent.close();
	}*/
@Test(priority = 1)
public void login() {
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
}

@Test(priority = 2)
public void Leaveassign() throws InterruptedException
{
	//Hover On Leave tab 
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement mousehov = driver.findElement(leavetap);
	Actions action = new Actions(driver);
	action.moveToElement(mousehov).build().perform();
	System.out.println("Mouse hover successfully done" );
	
	//click on leave assign
	WebElement Assignleavetabb = driver.findElement(Assignleavetab);
	Assignleavetabb.click();	
	 
	//Fill the Leave application form
	//********************Enter Name*****************
	WebElement Emp_name = driver.findElement(empname);
	Emp_name.sendKeys("Jasmine Morgan");
	
	//*************************Select Type of leave from dropdown**************************
	
	WebElement mySelectElement = driver.findElement(By.id("assignleave_txtLeaveType"));
	Select dropdown= new Select(mySelectElement);
	dropdown.selectByValue("1");;
	WebElement option = dropdown.getFirstSelectedOption();
	System.out.println("Value selected is: " +option.getText());
	
	//*********************************Date Picker From Date*******************************
	WebElement Fromdatepick = driver.findElement(DatepickerFrom);
	Fromdatepick.click();
	
	WebElement month = driver.findElement(month_combo_locator);
	Select monthCombo = new Select(month);
	monthCombo.selectByVisibleText("Dec");

	WebElement year = driver.findElement(year_combo_locator);
	Select yearCombo = new Select(year);
	yearCombo.selectByVisibleText("2018");

	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[2]")).click();
	
	Thread.sleep(3000);
	
	//***************************Date Picker To date**********************************************
	/*WebElement Todatepick = driver.findElement(Datepickerto);
	Todatepick.click();
	
	WebElement month1 = driver.findElement(month_combo_locator);
	Select monthCombo1 = new Select(month1);
	monthCombo1.selectByVisibleText("Dec");

	WebElement year1 = driver.findElement(year_combo_locator);
	Select yearCombo1 = new Select(year);
	yearCombo1.selectByVisibleText("2018");

	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[3]")).click();
	*/
	WebElement Todatepicktext = driver.findElement(Datepickertotext);
	Todatepicktext.clear();
	Todatepicktext.sendKeys("2018-12-11");
	Todatepicktext.sendKeys(Keys.ENTER);
	
	
	//***************************Enter comment For leaves********************
	
	WebElement Comment = driver.findElement(TxtComment);
	Comment.sendKeys("Leave for Family Function");
	
	/*WebElement datecal= driver.findElement(By.xpath("//div[text()='25.00']"));
	
	System.out.println(datecal.getText());
	*/
	WebElement Assign = driver.findElement(Submit);
    Assign.click();
}
@Test(priority = 3)
public void leavereport()
{
	WebElement leaveviewtab = driver.findElement(viewleave);
	leaveviewtab.click();
	WebElement Radio =  driver.findElement(radiobutton);
	Radio.click();
	WebElement Search_Emp_name = driver.findElement(viewleaveempname);
	Search_Emp_name.sendKeys("Jasmine Morgan");
	driver.findElement(By.id("btnSearch")).click();
	//Leaveapplication.captureScreenshot(driver, "Img1");
	Utility.captureScreenshot(driver, "image one");


}
/*public static void captureScreenshot(WebDriver driver, String screenshotname) {
	try {
		TakesScreenshot e = (TakesScreenshot) driver;
		File source = e.getScreenshotAs(OutputType.FILE);
		String imageName = screenshotname + ".png";
		String scrnstpath = System.getProperty("user.dir") + "/" + "Screenshots" + "/" + imageName;
		FileUtils.copyFile(source, new File(scrnstpath));
		System.out.println("Screenshot taken");
		test.log(LogStatus.INFO, "Screenshot captured");
		test.log(LogStatus.FAIL, "Test case is Failed");
		test.log(LogStatus.FAIL, "Screenshot below: " + test.addScreenCapture(scrnstpath));
		//driver.quit();
		//extent.endTest(test);
	} catch (Exception arg1) {
		System.out.println("Exception while taking screenshot " + arg1.getMessage());
	}*/
}
/*@AfterTest
public void teardown()
{
  driver.quit();	

}*/

