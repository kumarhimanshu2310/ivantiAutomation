package utilityPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

private static String screenshotFolder;

// This will be initialized fresh on every run
public static void initializeScreenshotFolder() {
String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
screenshotFolder = "screenshots/Run_" + timestamp + "/";
}

public static String captureScreenshot(WebDriver driver, String stepName){
	// ensure run‑folder is initialized elsewhere
	String folder = screenshotFolder;
	// create a truly unique filename
	String ts = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
	String safeName = stepName.replaceAll("[^a-zA-Z0-9]", "_");
	String fullPath = folder + safeName + "_" + ts + ".png";

	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File(fullPath);

	try {
	Files.createDirectories(dest.getParentFile().toPath());
	Files.copy(src.toPath(), dest.toPath());
	} catch (IOException e) {
	e.printStackTrace();
	}
	return dest.getAbsolutePath();
	}
}