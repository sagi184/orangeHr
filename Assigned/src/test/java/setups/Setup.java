package setups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Setup {
 static public WebDriver driver=null;
	
	public WebDriver Browser(String Browser)
	{
	
		if(Browser.equals("Firefox"))
		{
	 System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Drivers\\geckodriver.exe");
	 driver = new FirefoxDriver();
	 driver.manage().window().maximize();
		}
	 else if(Browser.equals("Chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	 }
	
		String url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(url);
		return driver;
		
	}
//	*****************************************************Leave Assignment Paths***********************
	public By leavetap = By.id("menu_leave_viewLeaveModule");
	public By Assignleavetab = By.id("menu_leave_assignLeave");
	public By empname = By.id("assignleave_txtEmployee_empName");
	public By TxtComment = By.id("assignleave_txtComment");
	public By DatepickerFrom = By.xpath("//img[@class='ui-datepicker-trigger']/preceding::input[@id='assignleave_txtFromDate']");		
	public By month_combo_locator= By.xpath("//select[@class='ui-datepicker-month']");
	public By year_combo_locator = By.xpath("//select[@class='ui-datepicker-year']");
	public By Datepickerto = By.xpath("//img[@class='ui-datepicker-trigger']/preceding::input[@id='assignleave_txtToDate']");
	
	public By Datepickertotext = By.xpath("//input[@id='assignleave_txtToDate']");
	
	public By Submit = By.id("assignBtn");
	public By viewleave = By.id("menu_leave_viewLeaveList");
	
	public By viewleaveempname = By.id("leaveList_txtEmployee_empName");
	 public By radiobutton = By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck");
	
//	*************************************************Add Educational details************************************
	 public By Pimtab = By.id("menu_pim_viewPimModule");
	 public By Employelist = By.id("menu_pim_viewEmployeeList");
	 public By Search = By.id("searchBtn");
	public By table = By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[3]/a");
	public By Qualificationtab = By.xpath("//ul[@id=\"sidenav\"]/li[9]");
	
	public By Addeducation = By.id("addEducation");
	public By Edutable = By.xpath("//div[@id='tblEducation']/table/tbody/tr[1]/td[2]/a");
	
	
	public By education_institute = By.id("education_institute");
	public By education_major = By.id("education_major");
	public By education_year = By.id("education_year");
	public By education_gpa = By.id("education_gpa");
	public By educationsavebtn = By.id("btnEducationSave");


//*******************************************************Add Employee*************************
	 public By Addemp = By.id("menu_pim_addEmployee");
	 public By Addempfirstname = By.id("firstName");
	 public By Addempsecondname = By.id("lastName");
	 public By Savebutton = By.id("btnSave");
	//*******************************************************Add Qualification*************************	 
	 public By Admintab = By.id("menu_admin_viewAdminModule");
	 
	 public By QualificationAdmintab = By.id("menu_admin_Qualifications");
	 
	 public By QualificationEducation = By.id("menu_admin_viewEducation");
	 
	 public By AddButton = By.id("btnAdd");
	 
	 public By Education_name = By.id("education_name");
	 
	 
}



