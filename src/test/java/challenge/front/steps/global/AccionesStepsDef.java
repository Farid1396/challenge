package challenge.front.steps.global;

import io.cucumber.java.es.Cuando;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AccionesStepsDef {

    //region Cuando
    @Cuando("el usuario ingresa {string} en el campo de búsqueda y da enter")
    public void elUsuarioIngresaEnElCampoDeBusquedaYDaEnter(String valor) {
        getDriver().findElement(By.id("search-key")).sendKeys(valor);
        getDriver().findElement(By.id("search-key")).sendKeys(Keys.ENTER);
    }

    @Cuando("el usuario scrollea hasta el final de la página")
    public void elUsuarioScrolleaHastaElFinalDeLaPagina() {
        ((JavascriptExecutor) getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Cuando("el usuario hace click en el botón de la segunda página")
    public void elUsuarioHaceClickEnElBotonDeLaSegundaPagina() {
        getDriver().findElement(By.xpath("//div[@class='list-pagination']//button[text()='2']")).click();
    }

    @Cuando("el usuario hace click en la tarjeta del segundo producto")
    public void elUsuarioHaceClickEnLaTarjetaDelSegundoProducto() {
        getDriver().findElement(By.xpath("//div[@class='product-container']/div[2]/a[2]")).click();
    }

    @Cuando("el usuario cambia a la nueva ventana")
    public void elUsuarioCambiaALaNuevaVentana() {
        WebDriver driver = getDriver();

        String actual = driver.getWindowHandle();
        Set<String> ventanas = driver.getWindowHandles();

        for (String ventana : ventanas) {
            if (!ventana.contentEquals(actual)) {
                driver.switchTo().window(ventana);
                break;
            }
        }
    }

    @Cuando("^el usuario espera '(.*)' (?:segundo|segundos)$")
    public void elUsuarioEspera(Integer segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (Exception e) {
            //tiempo de espera
        }
    }
    //endregion
}
