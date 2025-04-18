package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;;

public class IncidentcreationPage {
	public IncidentcreationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
	static String ivantiurl="https://nyu-amc-stg.ivanticloud.com/Default.aspx?NoDefaultProvider=True";

	public static void main(String[] args) {
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver= new EdgeDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(ivantiurl);
		System.out.println("Ivanti login is opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement kid= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/form/input[1]"));
		kid.sendKeys("kumarh10");
		System.out.println("KID is enetered");
		WebElement pwd= driver.findElement(By.xpath("//*[@id=\"wrapper\"]/form/input[2]"));
		pwd.sendKeys("23roget&mikalphA");
		System.out.println("Password is entered");
		WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/form/input[4]"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement duoConfirmation= driver.findElement(By.xpath("//*[@id=\"trust-browser-button\"]"));
		duoConfirmation.click();
		System.out.println("Application logged in and waiting for role selection");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebElement backButton=driver.findElement(By.xpath("//*[@id=\"ext-gen26\"]"));
		backButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='67%'"); // Zoom out to 80%
		WebElement serviceDeskAnalyst= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/form/div[15]"));
		serviceDeskAnalyst.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebElement submitButton= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/form/div[19]/div/button"));
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebElement incidentButton= driver.findElement(By.xpath("//*[@id=\"ext-gen42\"]"));
		incidentButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		WebElement newIncident= driver.findElement(By.xpath(""));
		//*[@id="ext-gen140"]
		newIncident.click();
//		WebElement applicationCIeditorRole=driver.findElement(By.xpath("//*[@id=\"ext-gen36\"]/div[1]/table/tbody/tr/td/div"));
//		applicationCIeditorRole.click();
//		WebElement continueButton= driver.findElement(By.xpath("//*[@id=\"SelectRole\"]/tbody/tr[2]/td[2]/em"));
//		continueButton.click();
//		System.out.println("Role Selected");
//		System.out.println("User is inside Application CI editor Home page");
		
	
		
		
	}

}
