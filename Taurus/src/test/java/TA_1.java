
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

public class TA_1 extends TA_Base{
	
	
	
	@Test(priority=0,alwaysRun = true)
	void test_1() throws Exception {
		System.out.println("Validate if address filed is clickable and takes the user input");
		Thread.sleep(3000);
		WebElement address = driver.findElement(By.xpath("//div[text()='Enter Your Address']"));
		act.click().sendKeys(address,"Islampur Maharashtra India").build().perform();
		Thread.sleep(3000);
		WebElement btn=driver.findElement(By.xpath("//span[text()='Get Instant Quote']"));
		btn.click();
		
		WebElement popupTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Please enter address!')]")));
        String popupText = popupTextElement.getText();
        System.out.println("Pop-up appeared after entering the addres and pressing the enter button is : " + popupText);
		Thread.sleep(3000);
		
	}
	
	@Test(priority=1)
	void test_2() {
		System.out.println("Validate if Privacy policy and Terms and Condition links are clickable and divERT the the user to its page when clicked");
		String main_window=driver.getWindowHandle();
		WebElement privacy_policy=driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		privacy_policy.click();
		driver.switchTo().window(main_window);
		WebElement terms_cond=driver.findElement(By.xpath("//a[text()='Terms & Conditions']"));
		terms_cond.click();
		
	}
	
	@Test(priority=2)
	void test_3() throws Exception {
		System.out.println("Validate user is able to click on Login button and is user diverted to login page");
		Thread.sleep(3000);
		WebElement Login_btn=driver.findElement(By.xpath("//button[text()='Login' and @type='button']"));
		if(Login_btn.isEnabled()) {
			js.executeScript("arguments[0].click()",Login_btn);
		}else{
			System.out.println("Login button is not clickable");
		}	
	}
	
	@AfterMethod()
	void closebrowser() {
		driver.quit();
	}
	
}
