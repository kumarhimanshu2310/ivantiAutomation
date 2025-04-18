package utilityPackage;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public static boolean waitForTextPresent(WebDriver driver, By locator, String text, int timeoutInSeconds) {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
}

public static boolean waitForElementInvisible(WebDriver driver, By locator, int timeoutInSeconds) {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
}
}
