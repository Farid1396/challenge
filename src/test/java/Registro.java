import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registro {
    private WebDriver driver;
    static String baseURL;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        baseURL = "http://automationpractice.com/index.php?";
    }

    @Test
    public void registro() {
        driver.get(baseURL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign in')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        driver.findElement(By.id("email_create")).sendKeys("challengepp@email.com");
        driver.findElement(By.id("SubmitCreate")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("FNameP");
        driver.findElement(By.id("customer_lastname")).sendKeys("LNameP");
        driver.findElement(By.id("passwd")).sendKeys("challenge1234");
        driver.findElement(By.id("days")).click();
        driver.findElement(By.xpath("//*[@id='days']/option[@value='1']")).click();
        driver.findElement(By.id("months")).click();
        driver.findElement(By.xpath("//*[@id='months']/option[@value='12']")).click();
        driver.findElement(By.id("years")).click();
        driver.findElement(By.xpath("//*[@id='years']/option[@value='2000']")).click();
        driver.findElement(By.id("firstname")).sendKeys("FNameP");
        driver.findElement(By.id("lastname")).sendKeys("LNameP");
        driver.findElement(By.id("address1")).sendKeys("Street 11556");
        driver.findElement(By.id("city")).sendKeys("CityP");
        driver.findElement(By.id("id_state")).click();
        driver.findElement(By.xpath("//option[text()='Alabama']")).click();
        driver.findElement(By.id("postcode")).sendKeys("56645");
        driver.findElement(By.id("phone_mobile")).sendKeys("1234566450");
        driver.findElement(By.id("submitAccount")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My account']")));

        driver.close();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}