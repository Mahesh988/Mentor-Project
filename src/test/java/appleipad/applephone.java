package appleipad;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class applephone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.apple.com/in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Watch']")));
		WebElement watch = driver.findElement(By.xpath(""
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		Actions act = new Actions(driver);
		act.moveToElement(watch).perform();
	}

}
