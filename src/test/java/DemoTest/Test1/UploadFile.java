package DemoTest.Test1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	//public static void main(String[] args) throws AWTException   {
		// TODO Auto-generated method stub
@Test
public void Data() throws AWTException{

		//Launch chrome browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\prach\\Desktop\\DemoTestMavenProject\\Test1\\Drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		//maximise browser
		driver.manage().window().maximize();

		//open url
		driver.get("https://demoqa.com/upload-download");

		//find webelement choose file
		//driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\prach\\Desktop\\Resume.txt");

		WebElement button = driver.findElement(By.xpath("//input[@id='uploadFile']"));

		Actions act = new Actions(driver);
		act.moveToElement(button).click().perform();

		Robot rb = new Robot();
		rb.delay(2000);


		//copy file to clip board
		StringSelection ss = new StringSelection("C:\\Users\\prach\\Desktop\\Resume.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		//perform control + V action to paste file
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);


	}

}
