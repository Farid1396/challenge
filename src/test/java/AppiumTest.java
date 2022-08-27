import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppiumTest {

    static AppiumDriver<MobileElement> driverAppium;

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("resetKeyboard", "true");
        cap.setCapability("appPackage", "com.android.chrome");
        cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        String appiumServerUrl = "http://127.0.0.1:4723/wd/hub";
        driverAppium = new AppiumDriver<MobileElement>(new URL(appiumServerUrl), cap);
        openChrome();
    }

    public static void openChrome() {
        System.out.println("<--------Automated Application Started-------->");
        System.out.println("<------------------ Chrome ------------------->");
        driverAppium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement terminosYCondiciones = driverAppium.findElementById("com.android.chrome:id/send_report_checkbox");
        terminosYCondiciones.click();

        driverAppium.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement aceptarTerminos = driverAppium.findElementById("com.android.chrome:id/terms_accept");
        aceptarTerminos.click();

        driverAppium.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement botonNegativo = driverAppium.findElementById("com.android.chrome:id/negative_button");
        botonNegativo.click();

        driverAppium.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement campoBusquedaGoogle = driverAppium.findElementById("com.android.chrome:id/search_box_text");
        campoBusquedaGoogle.click();

        driverAppium.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement barraNavegacion = driverAppium.findElementById("com.android.chrome:id/url_bar");
        barraNavegacion.sendKeys("https://www.ebay.com/");

        driverAppium.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement resultadoBusqueda = driverAppium.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.ListView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout");
        resultadoBusqueda.click();

        driverAppium.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        MobileElement campoBusquedaEbay = driverAppium.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText");
        campoBusquedaEbay.click();

        driverAppium.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        MobileElement textoEnCampoBusqueda = driverAppium.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText");
        textoEnCampoBusqueda.sendKeys("Pilas");

        driverAppium.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        MobileElement lupa = driverAppium.findElementByXPath("//android.widget.Button[@text='Buscar']");
        lupa.click();

        driverAppium.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Dimension windowSize = driverAppium.manage().window().getSize();
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = xStartPoint;
        int yStartPoint = 90 * screenHeight / 100;
        int yEndPoint = 10 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(driverAppium);

        int swipeTime = 0;
        while (swipeTime < 9) {
                boolean isTarget = driverAppium.findElementByXPath("//android.view.View[2]/android.widget.ListView/android.view.View[2]").isDisplayed();
                if (isTarget)
                    touchAction
                        .press(startPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                        .moveTo(endPoint).release()
                        .perform();

            swipeTime++;
        }

        int numeroItems = (swipeTime * 3) + 1;

        System.out.println("Cantidad de ítems: " + numeroItems);
        System.out.println("");
        System.out.println("<--------Automated Application Finished-------->");
    }
}