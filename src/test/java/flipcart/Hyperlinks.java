package flipcart;

import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Hyperlinks {
	static WebDriver driver;
	JavascriptExecutor jse;
	Actions action; 
	List<WebElement> linkList;
	WebDriverWait wait;
	@Parameters({"browser"})
	@BeforeClass
	public void browserSetup(String browser)
	{
		switch (browser.toLowerCase())
    	{
    	case "chrome": driver = new ChromeDriver(); break;
    	case "edge": driver = new EdgeDriver(); break;
    	default: System.out.println("No matching browser found"); break;
    	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Parameters ({"url"})
	@Test(priority = 10)
    public void getUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

	 public void loginHandle()
		{
			try
			{
				driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
			}
			catch(NoSuchElementException e)
			{
			}
		}
	 @Parameters({"section"})
	 @Test(priority=20)
	 public void getLinksBySection(String section)
	 {
		 linkList = driver.findElements(By.xpath("//div[@class='_3I5N7v' and text()='"+section.toUpperCase()+"']/following-sibling::a"));
	 }
	 @Parameters({"section"})
	 @Test(priority=30)
	 public void navigateLinks(String section) 
		{
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));

			for(int i=1;i<=linkList.size();i++)
			{
				jse = (JavascriptExecutor)driver;
				WebElement link = driver.findElement(By.xpath("//div[@class='_3I5N7v' and text()='"+section.toUpperCase()+"']/following-sibling::a["+i+"]"));
				jse.executeScript("arguments[0].scrollIntoView();",link);
				String linkName = link.getText();
				link.click();
				loginHandle();
				System.out.println(driver.getTitle());

	            System.out.println(linkName+": Link working successfully");

	            System.out.print("\n \n \n");
				driver.navigate().back();
				loginHandle();
			}
		}


	 @AfterClass
	 public void tearDown()
	 {
		 driver.quit();
	 }

}
