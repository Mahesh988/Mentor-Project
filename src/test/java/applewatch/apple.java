package applewatch;

	import java.time.Duration;
	import java.util.List;
	 
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class apple {
		public static boolean checkForSplash(String s) {
			return s.contains("Splash resistant35");
		}
		public static boolean checkForCapacity(String s) {
			return s.contains("8GB capacity");
		}
		public static void main(String args[]) {
			WebDriver driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(25));
			driver.get("https://www.apple.com/in/");
			driver.manage().window().maximize();
			//WebElement watch = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Watch']")));
			WebElement watch = driver.findElement(By.xpath("//span[text() = 'Watch']"));
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			Actions act = new Actions(driver);
			act.moveToElement(watch).perform();
			driver.findElement(By.xpath("//a[text()='Compare Watch']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='See all models']")).click();
			List<WebElement> models = driver.findElements(By.xpath("//div[@class='device-list']/div/div//h3"));
			boolean c=false;
			boolean s=false;
			for(int i=0;i<models.size();i++) {
				List<WebElement> details = driver.findElements(By.xpath("//div[@class='device-list']/div["+(i+1)+"]//li"));
				for(WebElement d : details) {
					if(checkForSplash(d.getText())) {
						c=true;
					}
					if(s = checkForCapacity(d.getText())) {
						s=true;
					}
				}
				if(c==true&&s==true) {
//					act.moveToElement(models.get(i)).build().perform();
//					WebElement n = myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='device-list']/div/div["+(i+1)+"]//h3")));
//					String name=n.getText();
					System.out.println(models.get(i).getText());
				}
				c=false;
				s=false;
//				
		}
	}
}
	