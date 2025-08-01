import java.time.Duration;
import java.util.Scanner;
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

public class TA_2 extends TA_Base {
	
	 	 
	 @Test(priority=0)
		public void test_04() throws Exception {
			System.out.println("validate if user is able to Review without entering data in all fields");
			  // act.moveToElement(review_btn).doubleClick(review_btn).build().perform();
			WebElement review_btn=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/main/section/div/div/div/div/section/form/button"));
		    js.executeScript("arguments[0].scrollIntoView(true)",review_btn);
		    js.executeScript("arguments[0].click()",review_btn);
	        Thread.sleep(3000);
			  //driver.close();
			}
	 
	 @Test(priority=1)
		void test_5() throws InterruptedException {
			System.out.println("Validate if user is able to Review Premium without creating account and entering all fields");
			
			
			WebElement no=driver.findElement(By.xpath("//input[@placeholder='Enter Policy Number'  and  @class='form-control']"));
			js.executeScript("arguments[0].click()",no);
			no.sendKeys("ABC1234");
			
			WebElement name=driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
			js.executeScript("arguments[0].click()",name);
			name.sendKeys("Akash98");
			
			WebElement zip=driver.findElement(By.xpath("//input[@placeholder='Enter Zip Code']"));
			js.executeScript("arguments[0].click()",zip);
			zip.sendKeys("411411");
			
			 WebElement captchaElement = driver.findElement(By.xpath("//canvas[@id='canv']")); 
			 js.executeScript("arguments[0].scrollIntoView(true)",captchaElement);
	         String captchaText = captchaElement.getText();
	         wait.until(ExpectedConditions.visibilityOf(captchaElement));
	         WebElement captchaInput = driver.findElement(By.xpath("//input[@placeholder='Enter Captcha']"));
	         Thread.sleep(3000);
	         captchaInput.sendKeys(captchaText);
				
		}
	 
		@Test(priority=2)
		void test_06() throws InterruptedException {
		
			WebElement create_acc=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/main/section/div/div/div/div/div[3]/span/a"));
			wait.until(ExpectedConditions.visibilityOf(create_acc));
			js.executeScript("arguments[0].scrollIntoView(true)",create_acc);
			js.executeScript("arguments[0].click()",create_acc);
			System.out.println(" Check if Create Account button is clickable and diverts user to signup page");
			
			WebElement text_element = driver.findElement(By.xpath("//h3[text()='Few More Details About You']"));
	        String text=text_element.getText().toString();
			System.out.println("Instead of Create Account page, the Page displayed is: "+ text);
		}

		@Test(priority=3)
		void test_07() throws Exception {
			WebElement create_acc=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/main/section/div/div/div/div/div[3]/span/a"));
			wait.until(ExpectedConditions.visibilityOf(create_acc));
			js.executeScript("arguments[0].scrollIntoView(true)",create_acc);
			js.executeScript("arguments[0].click()",create_acc);
			
			WebElement policy_quote=driver.findElement(By.xpath("//input[@placeholder='Enter Policy Number Or Quote Number']"));
			act.click(policy_quote).sendKeys("ABC123456").build().perform();
			WebElement ZIP=driver.findElement(By.xpath("//input[@placeholder='Enter Zip Code']"));
			act.click(ZIP).sendKeys("410189").build().perform();
			WebElement continue_btn=driver.findElement(By.xpath("//button[text()='Continue']"));
			act.click(continue_btn).build().perform();
		
		}
		
		@Test(priority=4)
		void test_08() throws Exception {
			WebElement create_acc=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/main/section/div/div/div/div/div[3]/span/a"));
			wait.until(ExpectedConditions.visibilityOf(create_acc));
			js.executeScript("arguments[0].scrollIntoView(true)",create_acc);
			js.executeScript("arguments[0].click()",create_acc);
			
			WebElement policy_quote=driver.findElement(By.xpath("//input[@placeholder='Enter Policy Number Or Quote Number']"));
			act.click(policy_quote).sendKeys("ABC123456").build().perform();
			WebElement ZIP=driver.findElement(By.xpath("//input[@placeholder='Enter Zip Code']"));
			act.click(ZIP).sendKeys("410189").build().perform();
			WebElement continue_btn=driver.findElement(By.xpath("//button[text()='Continue']"));
			act.click(continue_btn).build().perform();
			
			WebElement popupTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Data not found')]")));
	        String popupText2 = popupTextElement.getText();
	        System.out.println("Pop-up appeared after entering after Wrong Policy/Quote Nunmber and pressing the Continue button is : " + popupText2);
			Thread.sleep(3000);
		}
	 
	
	 @AfterMethod(alwaysRun = true)
		void closebrowser() {
			driver.close();
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
