package test;
import utilityPackage.ScreenshotUtil;
import utilityPackage.ExtentReportManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.*;

public class IvantiLoginTest {
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
	public void testValidLogin() {
	test = extent.createTest("Ivanti Valid Login Test");
	driver.get(ivantiurl);
	System.out.println("Ivanti login is opened");
	test.info("Portal is succefully opened").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Step Name"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	WebElement duoConfirmation= driver.findElement(By.xpath("//*[@id=\"trust-browser-button\"]"));
	test.info("Authentication page is displayed").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Authentication Page"));
	duoConfirmation.click();
	System.out.println("Application logged in and waiting for role selection");
	test.info("Role selection page displayed succesfully").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Role selection page"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
	WebElement applicationCIeditorRole=driver.findElement(By.xpath("//*[@id=\"ext-gen36\"]/div[1]/table/tbody/tr/td/div"));
	//test.info("Role selection page displayed succesfully2").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Role selection page2"));
	applicationCIeditorRole.click();
	WebElement continueButton= driver.findElement(By.xpath("//*[@id=\"SelectRole\"]/tbody/tr[2]/td[2]/em"));
	continueButton.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	test.info("Home page displayed succesfully").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"Test Page"));
	System.out.println("Role Selected");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	WebElement moreOption= driver.findElement(By.xpath("//*[@id=\"ext-gen208\"]/u"));
	moreOption.click();
	test.info("More Options selected").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"More Options page"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	WebElement cilocation= driver.findElement(By.xpath("//*[@id=\"ext-gen262\"]/tbody/tr[17]/td[1]"));
	cilocation.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
	test.info("CI Location page is added").addScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver,"CI Location page"));
	//WebElement firstentry= driver.findElement(By.xpath("//a[contains(text(), '345 Park Ave South Research')]"));
	
	/*WebElement firstentry= WaitUtils.waitForElementVisible(driver, By.xpath("//div[contains(@class,'x-grid3-row') and contains(@class,'x-grid3-row-first')]"), 80);
	//firstentry.click() ;
	Actions action= new Actions(driver);
	action.moveToElement(firstentry).doubleClick().perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// 1️⃣ Locate the iframe element itself
	By frameLoc = By.cssSelector("iframe.x-managed-iframe#ext-gen214"); // ← matches what you saw
	WebElement frame = new WebDriverWait(driver, Duration.ofSeconds(10))
	.until(ExpectedConditions.presenceOfElementLocated(frameLoc));

	// 2️⃣ Switch the driver’s context to the iframe
	driver.switchTo().frame(frame);

	// 3️⃣ Now locate and click the top row inside that frame
	By rows = By.cssSelector("div.x-grid3-body div.x-grid3-row");
	new WebDriverWait(driver, Duration.ofSeconds(20))
	.until(ExpectedConditions.numberOfElementsToBeMoreThan(rows, 0));

	driver.findElements(rows).get(0).click(); // first row

	// 4️⃣ (Optional) when you’re done inside, return to the main page
	driver.switchTo().defaultContent(); */
	

	
	

	test.pass("Login test executed successfully");
	}

	@AfterClass
	public void teardown() {
	driver.quit();
	extent.flush();
	}
	

}
