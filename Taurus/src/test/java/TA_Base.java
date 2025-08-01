
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TA_Base {
	WebDriver driver;
	Actions act;
	 WebDriverWait wait;
	 SoftAssert Assert;
	 JavascriptExecutor js;
	@BeforeMethod
	void openbrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://farmers.uat.instantquote.odysseynext.com/?uuid=00002");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
		act=new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert=new SoftAssert();
		js=(JavascriptExecutor)driver;
	}
}
