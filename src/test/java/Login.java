import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

        //NEW COMMENT
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }
    @After
    public void teardown() {
        if (driver !=null) {
            driver.quit();
        }
    }
    @Test
    public void verifyGitHubTitle(){
        driver.get("https://www.github.com");
        assertThat(driver.getTitle(), containsString("GitHub"));
    }
}
