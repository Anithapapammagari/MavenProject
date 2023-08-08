package mavenproject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenProgram {

	public static void main(String[] args) throws InterruptedException {
		
		///with chromedriver browser we have new features called new incognito window its a private browser
		///there is one more headless browser that we can't see the browser but still the fuctionality will work
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--incognito");///because of cache/cookie related issues
		///options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        
        ///System.setProperty("webdriver.chrome.driver", "C:\\Users\\kesav\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver(options) ;
       
        driver.get("https://www.google.com/webhp?authuser=1");
				
		driver.navigate().to("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));///asking the browser to wait until it load
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		Thread.sleep(2000);
		
		WebElement firstNamefield= driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstNamefield.sendKeys("Anitha");
        Thread.sleep(2000);
        
		WebElement lastNamefield= driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lastNamefield.sendKeys("Papa");
		Thread.sleep(2000);
		
        WebElement emailField= driver.findElement(By.xpath("//input[@id='input-email']"));
        emailField.sendKeys("anitha@gmail.com");
		Thread.sleep(2000);

        WebElement telephone= driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("5523581040");
        Thread.sleep(2000);
        
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("anitha123");
        Thread.sleep(2000);
        WebElement passwordconfirm= driver.findElement(By.id("input-confirm"));
        passwordconfirm.sendKeys("anitha123");
        
		WebElement continuebutton= driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutton.click();
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
