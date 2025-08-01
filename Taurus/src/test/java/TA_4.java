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

	public class TA_4 {
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
		void test_12() throws InterruptedException {
				WebElement Acces_policy=driver.findElement(By.xpath("//div[text()='Access Policy']"));
				js.executeScript("arguments[0].click()",Acces_policy);
				
				WebElement forget_pass=driver.findElement(By.xpath("//a[@href='/forgotPassword']"));
				if(forget_pass.isEnabled()) {
					js.executeScript("arguments[0].click()",forget_pass);
					System.out.println("Forget Password link is clickable");
				}else {
					System.out.println("Forget Password link is not clickable");
				}
				
				WebElement email2=driver.findElement(By.xpath("//input[@placeholder='Your Email Address']"));
				js.executeScript("arguments[0].click()",email2);
				email2.sendKeys("clark@gmail.com");
				
				WebElement reset=driver.findElement(By.xpath("//button[text()='Reset Password']"));
				js.executeScript("arguments[0].click()",reset);
				
				WebElement popupTextElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Please Try again')]")));
			    String popupText5 = popupTextElement2.getText();
			    System.out.println("After entering invalid credentials Pop-up appeared on clicking Login button is : " + popupText5);
				Thread.sleep(3000);
				

		}
		@Test(priority=1)
		void test_13()  {
			WebElement saved_quote=driver.findElement(By.xpath("//div[text()='Saved Quote']"));
			if(saved_quote.isEnabled()) {
				System.out.println("Saved Quote is Enabled");
				js.executeScript("arguments[0].click()",saved_quote);
			}else {
				System.out.println("Saved Quote is disabled");
			}
		}
		
		 @AfterMethod(alwaysRun = true)
			void closebrowser() {
				driver.close();
			}
		 
		
		
	}


