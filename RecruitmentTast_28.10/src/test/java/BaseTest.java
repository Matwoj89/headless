import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    private By privacyPolicyAcceptanceButton = By.cssSelector("button[data-role='accept-consent']");

    @BeforeEach
    public void setup() {
 /*       WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
       // options.addArguments("headless");
        options.setHeadless(true);*/

        // WebDriverManager downloads Edge browser executables or binaries.
        WebDriverManager.edgedriver().setup();

        // Create an object of Edge Options class
        EdgeOptions edgeOptions = new EdgeOptions();

        // pass the argument –headless to Edge Options class.
        edgeOptions.addArguments("--headless");

        // Create an object of WebDriver class and pass the Edge Options object as
        // an argument
        WebDriver driver = new EdgeDriver(edgeOptions);




       // driver = new EdgeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1300, 800));
        driver.manage().window().setPosition(new Point(10, 30));
        actions = new Actions(driver);
        driver.navigate().to("https://allegro.pl/");
        //driver.findElement(privacyPolicyAcceptanceButton).click();

        wait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }
}


