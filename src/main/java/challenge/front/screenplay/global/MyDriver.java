package challenge.front.screenplay.global;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.*;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        String serenityDriver = getDriver("mydriver");
        if (serenityDriver == null)
            serenityDriver = "chrome";
        serenityDriver = serenityDriver.substring(0, 1).toUpperCase() + serenityDriver.substring(1).toLowerCase();
        serenityDriver = (serenityDriver.equals("Ie")) ? "InternetExplorer" : serenityDriver;
        try {
            Method method = MyDriver.class.getMethod("get" + serenityDriver + "Driver");
            return (WebDriver) method.invoke(MyDriver.class);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("No se puede configurar el driver: '" + serenityDriver + "'");
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

    public static WebDriver getChromeDriver() {
        String driverVersion = getVersion("chrome");
        if (driverVersion == null)
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        else
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).driverVersion(driverVersion).setup();
        try {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.setAcceptInsecureCerts(true);
            options.setHeadless(headlessStatus("chrome"));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            return new ChromeDriver(options);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static WebDriver getFirefoxDriver() {
        String driverVersion = getVersion("firefox");
        if (driverVersion == null)
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        else
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).driverVersion(driverVersion).setup();
        return (WebDriver) new FirefoxDriver();
    }

    public static WebDriver getEdgeDriver() {
        String driverVersion = getVersion("edge");
        if (driverVersion == null)
            EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
        else
            EdgeDriverManager.getInstance(DriverManagerType.EDGE).driverVersion(driverVersion).setup();
        return (WebDriver) new EdgeDriver();
    }

    public static WebDriver getOperaDriver() {
        String driverVersion = getVersion("opera");
        if (driverVersion == null)
            OperaDriverManager.getInstance(DriverManagerType.OPERA).setup();
        else
            OperaDriverManager.getInstance(DriverManagerType.OPERA).driverVersion(driverVersion).setup();
        return (WebDriver) new OperaDriver();
    }

    public static WebDriver getInternetExplorerDriver() {
        String driverVersion = getVersion("ie");
        if (driverVersion == null)
            InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
        else
            InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).driverVersion(driverVersion).setup();
        return (WebDriver) new InternetExplorerDriver();
    }

    public static WebDriver getChromiumDriver() {
        String driverVersion = getVersion("chromium");
        if (driverVersion == null)
            ChromiumDriverManager.getInstance(DriverManagerType.CHROMIUM).setup();
        else
            ChromiumDriverManager.getInstance(DriverManagerType.CHROMIUM).driverVersion(driverVersion).setup();
        return (WebDriver) new ChromeDriver();
    }

    private static Boolean headlessStatus(String driver) {
        String headless = SystemEnvironmentVariables.createEnvironmentVariables().getProperty(driver + ".headless");
        if (headless == null)
            headless = "false";
        return headless.equals("true");
    }

    private static String getDriver(String driver) {
        return SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver." + driver);
    }

    private static String getVersion(String driver) {
        return SystemEnvironmentVariables.createEnvironmentVariables().getProperty(driver + ".version");
    }
}

