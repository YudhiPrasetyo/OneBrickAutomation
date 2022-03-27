import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TS_Register_001 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Faker faker = new Faker();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://brick-qa-assignment.herokuapp.com/");

        WebElement inputFirstName = driver.findElement(By.cssSelector("input[id*=firstName"));
        inputFirstName.sendKeys(faker.name().firstName());

        WebElement inputLastName = driver.findElement(By.cssSelector("input[id*=lastName"));
        inputLastName.sendKeys(faker.name().lastName());

        WebElement inputEmail = driver.findElement(By.cssSelector("input[id*=email"));
        inputEmail.sendKeys("yudhi@gmail.com");

        WebElement inputPhoneNumber = driver.findElement(By.cssSelector("input[id*=phoneNumber"));
        inputPhoneNumber.sendKeys("8" + faker.phoneNumber().cellPhone());

        WebElement inputAddress = driver.findElement(By.cssSelector("input[id*=address"));
        inputAddress.sendKeys( faker.address().fullAddress());

        WebElement inputPassword = driver.findElement(By.cssSelector("input[id*=password"));
        inputPassword.sendKeys("123456");

        WebElement inputConfirmPassword = driver.findElement(By.cssSelector("input[id*=confirm_password"));
        inputConfirmPassword.sendKeys("123456");

        WebElement clickBtnRegister = driver.findElement(By.cssSelector("input[class*=register"));
        clickBtnRegister.click();

        WebElement labelSuccess = driver.findElement(By.cssSelector("h2[id*=swal2-title]"));
        Assert.assertEquals(labelSuccess.getText(), "Success");

        WebElement labelContent = driver.findElement(By.cssSelector("div[id*=swal2-content]"));
        Assert.assertEquals(labelContent.getText(), "Check your email to confirm your registration");

        Thread.sleep(3000);
        driver.quit();

    }
}
