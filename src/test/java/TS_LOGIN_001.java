import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TS_LOGIN_001 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://brick-qa-assignment.herokuapp.com/");

        WebElement linkLogin = driver.findElement(By.xpath("//a[contains(text(), 'Login')]"));
        linkLogin.click();

        WebElement inputLoginEmail = driver.findElement(By.cssSelector("input[id*=your_email"));
        inputLoginEmail.sendKeys("yudhi@gmail.com");

        WebElement inputLoginPassword = driver.findElement(By.cssSelector("input[id*=password"));
        inputLoginPassword.sendKeys("123456");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[class*=register"));
        btnLogin.click();

        WebElement labelSuccess = driver.findElement(By.cssSelector("h2[id*=swal2-title]"));
        Assert.assertEquals(labelSuccess.getText(), "Success");

        Thread.sleep(3000);
        driver.quit();

    }
}
