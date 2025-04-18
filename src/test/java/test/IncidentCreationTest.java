package test;

import java.time.Duration;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityPackage.ExtentReportManager;
import utilityPackage.ScreenshotUtil;

public class IncidentCreationTest {
	@BeforeSuite
	public void setUpSuite() {
		ScreenshotUtil.initializeScreenshotFolder();
	}
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	String ivantiurl="https://nyu-amc-stg.ivanticloud.com/Default.aspx?NoDefaultProvider=True";

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		extent = ExtentReportManager.getInstance();
	}


	@Test
	public  void testIncidentCreation() {
		test = extent.createTest("Ivanti Incident Creation Test");
		driver.get(ivantiurl);
		System.out.println("Ivanti login is opened");
		test.info("Portal is succefully opened").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Step Name"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement kid= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/form/input[1]"));
		kid.sendKeys("kumarh10");
		System.out.println("KID is enetered");
		test.info("Entered KID").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"EnterKID"));
		WebElement pwd= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/form/input[2]"));
		pwd.sendKeys("23roget&mikalphA");
		System.out.println("Password is entered");
		test.info("Password is entered").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"EnterPassword"));
		WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/form/input[4]"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		test.info("Authentication page is displayed").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Authentication Page"));
		WebElement duoConfirmation= driver.findElement(By.xpath("//*[@id=\"trust-browser-button\"]"));
		duoConfirmation.click();
		System.out.println("Application logged in and waiting for role selection");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebElement backButton=driver.findElement(By.xpath("//*[@id=\"ext-gen26\"]"));
		//test.info("Role selection page displayed succesfully").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Role selection page"));
		backButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='67%'"); // Zoom out to 80%
		test.info("Role selection page displayed succesfully").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Role selection page"));
		WebElement serviceDeskAnalyst= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/form/div[15]"));
		serviceDeskAnalyst.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		test.info("Service desk analyste role selected").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Service desk analyst"));
		WebElement submitButton= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/form/div[19]/div/button"));
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebElement incidentButton= driver.findElement(By.xpath("//*[@id=\"ext-gen42\"]"));
		incidentButton.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		//WebElement newIncident= driver.findElement(By.xpath("//*[@id=\"ext-gen140\"]"));
		//*[@id="ext-gen140"]
		//newIncident.click();
//		WebElement applicationCIeditorRole=driver.findElement(By.xpath("//*[@id=\"ext-gen36\"]/div[1]/table/tbody/tr/td/div"));
//		applicationCIeditorRole.click();
//		WebElement continueButton= driver.findElement(By.xpath("//*[@id=\"SelectRole\"]/tbody/tr[2]/td[2]/em"));
//		continueButton.click();
//		System.out.println("Role Selected");
//		System.out.println("User is inside Application CI editor Home page");
		
	
		
		
	}
	@AfterClass
	public void teardown() {
	driver.quit();
	extent.flush();
	}


}
