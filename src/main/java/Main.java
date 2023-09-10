import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Set the system property to use EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\nirma\\IdeaProjects\\selenium_nsp\\msedgedriver.exe");

        // Create EdgeOptions
        EdgeOptions edgeOptions = new EdgeOptions();

        // Initialize the WebDriver with EdgeOptions
        WebDriver driver = new EdgeDriver(edgeOptions);

        // Navigate to the URL
        String siteUrl = "https://www.trukky.com/door-to-door-goods-delivery";
        driver.get(siteUrl);

        // Pause for 10 seconds using TimeUnit.SECONDS.sleep()
        TimeUnit.SECONDS.sleep(10);

        // Check if the page title matches the expected title
        String expectedTitle = "Goods Delivery, Door to Door Goods Transport Service @ Trukky";
        String actualTitle = driver.getTitle();
        System.out.println("Site url : " + siteUrl);
        System.out.println("Site Title : " + actualTitle);

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Successfully landed on the expected page.");
            WebElement pickupCityInput = driver.findElement(By.xpath("//div[@class='locationBox inputBox '][1]//input[@class='inputField']"));
            WebElement dropCityInput = driver.findElement(By.xpath("//div[@class='locationBox inputBox '][2]//input[@class='inputField']"));

            // Enter the pickup and drop cities
            pickupCityInput.sendKeys("Hyderabad, Telangana, India");
            WebElement firstSuggestion = driver.findElement(By.xpath("//div[@class='recentSearch']//li[1]"));
            firstSuggestion.click();
            dropCityInput.sendKeys("New Delhi, Delhi, India");

            // Click on the first suggestion in the list
            firstSuggestion = driver.findElement(By.xpath("//div[@class='recentSearch']//li[1]"));
            firstSuggestion.click();

            // Locate and click the "Submit" button
            WebElement submitButton = driver.findElement(By.xpath("//button[@class='submitBtn']"));
            submitButton.click();
            TimeUnit.SECONDS.sleep(4);
            WebElement personalOption = driver.findElement(By.xpath("//span[text()='Personal']"));
            personalOption.click();
            TimeUnit.SECONDS.sleep(3);
            WebElement firstLiElement = driver.findElement(By.cssSelector("ul.jsx-665002787 li.jsx-665002787"));
            firstLiElement.click();
            TimeUnit.SECONDS.sleep(3);
            WebElement addButton = driver.findElement(By.cssSelector(".jsx-1905266029.btn.primary"));
            addButton.click();
            TimeUnit.SECONDS.sleep(2);
            WebElement selectElement = driver.findElement(By.cssSelector("select.jsx-1905266029"));
            selectElement.click();
            TimeUnit.SECONDS.sleep(2);
            WebElement windowACOption = driver.findElement(By.xpath("//option[text()='Window AC']"));
            windowACOption.click();
            WebElement inputElement = driver.findElement(By.cssSelector("input.jsx-3306650702.inputField"));
            inputElement.sendKeys("2");
            WebElement buttonElement = driver.findElement(By.cssSelector("button.jsx-1905266029.nextBtn"));
            TimeUnit.SECONDS.sleep(1);
            buttonElement.click();
            TimeUnit.SECONDS.sleep(1);
            WebElement buttonElement2 = driver.findElement(By.xpath("//button[@class='btn ghost']"));
            buttonElement2.click();
            TimeUnit.SECONDS.sleep(3);


//            WebElement addMaterial2Button = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[4]/img"));
//            addMaterial2Button.click();
//            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20)); // 20 seconds timeout

// Wait for the element to be clickable and then click it
            WebElement button = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn primary')]"));
            button.click();
            TimeUnit.SECONDS.sleep(2);

            WebElement buttondate = driver.findElement(By.xpath("//button[@class='react-calendar__tile react-calendar__month-view__days__day'][19]"));
            buttondate.click();

            WebElement nxtbutton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn primary')]"));
            nxtbutton.click();
            TimeUnit.SECONDS.sleep(2);
            WebElement inputField = driver.findElement(By.xpath("//input[@type='tel' and contains(@class, 'jsx-3306650702 inputField')]"));
            inputField.clear();
            inputField.sendKeys("8396038122");
            WebElement getprice = driver.findElement(By.xpath("(//button[@type='submit' and contains(@class, 'btn primary')])[2]"));
            getprice.click();
            TimeUnit.SECONDS.sleep(15);
            WebElement otpnxt = driver.findElement(By.xpath("//button[contains(@class, 'jsx-1905266029 nextBtn')]"));
            otpnxt.click();
        } else {
            System.out.println("Landing on the wrong page. Actual title: " + actualTitle);
        }

        TimeUnit.SECONDS.sleep(20);
        driver.quit();
    }
}
