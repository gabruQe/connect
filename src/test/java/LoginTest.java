import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        //NEW COMMENT
    }
    @BeforeMethod
    public void openBrowser()
    {
        driver=new ChromeDriver();
        driver.get("https://dashboard.pickrr.com/sign-in");
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
    }

    @Test(description="This method validates the login functionality")
    public void login() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("g.mangla911@gmail.com");
        driver.findElement(By.xpath("//input[@class='ant-input']")).sendKeys("complex@1357");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(5000);

        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='dashboard.pickrr.com/menu_svg/growth.svg']")));
//            WebElement getMenu = driver.findElement(By.xpath("//img[@src='dashboard.pickrr.com/menu_svg/growth.svg']"));
//            Actions act = new Actions(driver);
//            act.moveToElement(getMenu).perform();
//            Thread.sleep(2000);
        } catch (TimeoutException e) {
            //Do nothing
        }

        /* changes to check  LoginTest.java:40*/
        WebElement getMenu = driver.findElement(By.xpath("//li/div[@role=\"menuitem\"][contains(@data-menu-id,\"growth\")]"));
        Actions act = new Actions(driver);
        act.moveToElement(getMenu).perform();
        Thread.sleep(2000);
        /* till here LoginTest.java:44*/
        WebElement clickElement = driver.findElement(By.xpath("//a[@href='dashboard.pickrr.com/pickrr-connect']"));
        act.moveToElement(clickElement).click().perform();


    }

    @AfterMethod
    public void postLogin()
    {
        System.out.println(driver.getCurrentUrl());

    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
