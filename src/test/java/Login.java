import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Login {
    private WebDriver driver;
    static String baseURL;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        baseURL = "http://automationpractice.com/index.php?";
    }

    @Test
    public void login() {
        driver.get(baseURL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign in')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("challeng@email.com");
        driver.findElement(By.id("passwd")).sendKeys("challenge12345");
        driver.findElement(By.id("SubmitLogin")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText(), "Authentication failed.");
        System.out.println("<--- Falló el login --->");
        System.out.println("<---------------------->");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("challenge@email.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("challenge1234");
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println("<--- Login exitoso --->");
        System.out.println("<---------------------->");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My account']")));


        driver.findElement(By.xpath("(//a[text()='Dresses'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@style='background: #F1C40F;']")));
        driver.findElement(By.xpath("//input[@style='background: #F1C40F;']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dresses > Color Yellow']")));
        assertEquals(driver.findElement(By.xpath("//*[@id='center_column']/h1/span[1]")).getText(), "DRESSES > COLOR YELLOW");
        List<WebElement> totalProductos = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
        for(int i = 1; i < totalProductos.size()+1; i++) {
            System.out.println("Producto: "+ i);
        }
        System.out.println("Total de productos: "+ totalProductos.size());
        driver.close();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}