package TA;
	import java.time.Duration;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TA_03 {
		WebDriver driver;
		Actions act;
		 WebDriverWait wait;
		 SoftAssert Assert;
		 JavascriptExecutor js;
		 
		 @BeforeMethod
			void openbrowser() {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.get("https://farmers.uat.mypolicy.odysseynext.com/?uuid=00002");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
				act=new Actions(driver);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				Assert=new SoftAssert();
				js=(JavascriptExecutor)driver;
			}
		
		
		@Test(priority=0)
		void test_09() throws InterruptedException {
			WebElement file_claim = driver.findElement(By.xpath("//i[@class='bi bi-list-check']"));
			if(file_claim.isEnabled()) {
			js.executeScript("arguments[0].click()",file_claim);
			System.out.println("File claim button is enabled");
			}else {
				System.out.println("File claim button is disabled");
			}
			
			WebElement claim_btn=driver.findElement(By.xpath("//button[text()='Continue with Claim']"));
			if(claim_btn.isEnabled()) {
			js.executeScript("arguments[0].click()",claim_btn);
			System.out.println("Claim Button is enabled");
			}else {
				System.out.println("Claim Button is disabled");
			}
			WebElement popupTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'captcha not matched, please fill the captcha')]")));
	        String popupText3 = popupTextElement.getText();
	        System.out.println("Pop-up appeared after entering after clickling  Continue with Clan button is : " + popupText3);
			Thread.sleep(3000);	
		}
		
		
		@Test(priority=1)
		void test_10() throws InterruptedException {
			WebElement policy=driver.findElement(By.xpath("//input[@placeholder='Enter Policy Number']"));
			js.executeScript("arguments[0].click()",policy);
			policy.sendKeys("MNH456");
			
			WebElement holder_name=driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
			js.executeScript("arguments[0].click()",holder_name);
			holder_name.sendKeys("Valiv");
			
			WebElement zip1=driver.findElement(By.xpath("//input[@placeholder='Enter Zip Code']"));
			js.executeScript("arguments[0].click()",zip1);
			zip1.sendKeys("98745");
			
			 WebElement captchaElement2 = driver.findElement(By.xpath("//canvas[@id='canv']")); 
			 js.executeScript("arguments[0].scrollIntoView(true)",captchaElement2);
	         String captchaText2 = captchaElement2.getText();
	         wait.until(ExpectedConditions.visibilityOf(captchaElement2));
	         WebElement captchaInput2 = driver.findElement(By.xpath("//input[@placeholder='Enter Captcha']"));
	         Thread.sleep(3000);
	         captchaInput2.sendKeys(captchaText2);
	       
		}
		
		@Test(priority=2)
		void test_11() throws Exception {
		WebElement Acces_policy=driver.findElement(By.xpath("//div[text()='Access Policy']"));
		if(Acces_policy.isEnabled()) {
			js.executeScript("arguments[0].click()",Acces_policy);
		System.out.println("Acces_policy is enabled");
		}else {
			System.out.println("Acces_policy is disbaled");
		}
		
		WebElement username1=driver.findElement(By.xpath("//input[@placeholder='Your Username']"));
		js.executeScript("arguments[0].click()",username1);
		username1.sendKeys("Mark02@gmail.com");
		
		
		WebElement pass1=driver.findElement(By.xpath("//input[@placeholder='Your Password' and @type='password']"));
		js.executeScript("arguments[0].click()",pass1);
		pass1.sendKeys("XYZ");
		
		Thread.sleep(3000);
		WebElement button1=driver.findElement(By.xpath("//button[@type='button' and text()='Login']"));
		wait.until(ExpectedConditions.visibilityOf(button1));
		js.executeScript("arguments[0].click()",button1);
		
		
		WebElement popupTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Invalid Credential')]")));
	    String popupText4 = popupTextElement1.getText();
	    System.out.println("After entering invalid credentials Pop-up appeared on clicking Login button is : " + popupText4);
		Thread.sleep(3000);
		}
		
		 @AfterMethod(alwaysRun = true)
			void closebrowser() {
				driver.close();
			}	 
	}
