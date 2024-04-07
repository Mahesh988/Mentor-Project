package carmodels;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class volkswagen {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ChromeOptions opt = new ChromeOptions();
			
			opt.addArguments("--start-maximized");
			WebDriver driver = new ChromeDriver(opt);		
			String baseUrl = "https://www.volkswagen.co.in/";
			driver.get(baseUrl);
//			driver.manage().deleteAllCookies();
			
			try {
				driver.findElement(By.id("ensCloseBanner")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[contains(@class,'StyledTopBar')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Models']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Service Cost Calculator']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='GTI']")).click();
				Thread.sleep(4000);
				driver.findElement(By.xpath("//span[contains(text(),'variant')]")).click();
				Thread.sleep(800);
				driver.findElement(By.xpath("//li[@data-value='GTI 1.8L']")).click();
				driver.findElement(By.xpath("//span[contains(text(),'location')]")).click();
				List<WebElement> elem = driver.findElements(By.xpath("//*[@class='mar mar-city']/div/ul/li"));
				for (WebElement w : elem) {
					if(w.getText().equals("Chennai")){
						w.click();
						break;
					}
				}
				driver.findElement(By.xpath("//img[@id='btnNext']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Select service interval']")).click();
				List<WebElement> interval = driver.findElements(By.xpath("//div[@id='divKms']/div/div/ul/li"));
				for (WebElement w : interval) {
					if(w.getText().contains("9 years")){
						w.click();
						break;
					}
				}
				driver.findElement(By.xpath("//span[text()='Select parts']")).click();
				Thread.sleep(1000);
//				Actions move = new Actions(driver);
//				WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'checbox')]/div/div[2]/div/div"));
				List<WebElement> parts = driver.findElements(By.xpath("//div[@id='divParts']/label"));
				for (WebElement w : parts) {
//					System.out.println(w.getText());
					if(w.getText().contains("BRAKE PADS") || w.getText().contains("BRAKE DRUM") || w.getText().contains("COOLANT")){
						w.click();
//						Action action = (Action) move.dragAndDropBy(ele, 0, -7).build();
//				        action.perform();
						Thread.sleep(1000);
					}
				}
				driver.findElement(By.xpath("//img[@id='btnSubmit']")).click();
				Thread.sleep(2000);
				List<WebElement> repairsCosts = driver.findElements(By.xpath("//ul[@id='ulRepairCost']/li/div"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//ul[@id='ulRepairCost']/li/div")));
//				for (WebElement w : repairsCosts) {
//					System.out.println(w.getText());
//				}
				System.out.println(repairsCosts.get(0).getText());
				
				for (int i=1; i < repairsCosts.size(); i+=3) {
					System.out.println(String.format("%-50s",repairsCosts.get(i).getText()) + "\t" + String.format("%-10s",repairsCosts.get(i+1).getText()) + "\t" + repairsCosts.get(i+2).getText());
				}
		
				driver.quit();
			}catch(Exception e) {
				e.printStackTrace();
			}

		}

	}


