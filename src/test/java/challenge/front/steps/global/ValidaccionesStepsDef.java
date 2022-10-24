package challenge.front.steps.global;

import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ValidaccionesStepsDef {

    //region Entonces
    @Entonces("el usuario visualiza el logo de AliExpress")
    public void elUsuarioVisualizaElLogoDeAliExpress() {
        getDriver().findElement(By.xpath("(//span[text()='AliExpress'])[2]")).isDisplayed();
    }

    @Entonces("el usuario visualiza la lista de resultados")
    public void elUsuarioVisualizaLaListaDeResultados() {
        getDriver().findElement(By.xpath("//div[@class='product-container']/div[2]/a")).isDisplayed();
    }

    @Entonces("el usuario puede ver en lista el paginado de resultados")
    public void elUsuarioPuedeVerEnListaElPaginadoDeResultados() {
        getDriver().findElement(By.xpath("//div[@class='list-pagination']")).isDisplayed();
    }

    @Entonces("el usuario visualiza la información del producto")
    public void elUsuarioVisualizaLaInformaciónDelProducto() {
        getDriver().findElement(By.xpath("//div[@class='product-info']")).isDisplayed();
    }

    @Entonces("el usuario visualiza la información de la cantidad de productos disponibles")
    public void elUsuarioVisualizaLaInformacionDeLaCantidadDeProductosDisponibles() {
        getDriver().findElement(By.xpath("//div[@class='product-quantity-tip']")).isDisplayed();
    }
    //endregion
}
