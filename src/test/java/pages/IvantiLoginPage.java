package pages;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class IvantiLoginPage {
	public IvantiLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
	static String ivantiurl="https://nyu-amc-stg.ivanticloud.com/Default.aspx?NoDefaultProvider=True";

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ivantiurl);
		System.out.println("Ivanti login is opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		By KID= By.xpath("//*[@id=\"wrapper\"]/form/input[1]");
		By password=By.xpath("//*[@id=\\\"wrapper\\\"]/form/input[2]");
		By loginbutton=By.xpath("//*[@id=\"wrapper\"]/form/input[4]");
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
		WebElement applicationCIeditorRole=driver.findElement(By.xpath("//*[@id=\"ext-gen36\"]/div[1]/table/tbody/tr/td/div"));
		applicationCIeditorRole.click();
		WebElement continueButton= driver.findElement(By.xpath("//*[@id=\"SelectRole\"]/tbody/tr[2]/td[2]/em"));
		continueButton.click();
		System.out.println("Role Selected");
		System.out.println("User is inside Application CI editor Home page");
		
	
		
		
	}

}
