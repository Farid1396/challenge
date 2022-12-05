package challenge.front.steps.global;

import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AccionesStepsDef {

    //region Cuando
    @Cuando("el usuario hace click en el botón con el texto '(.*)'$")
    public void elUsuarioHaceClickEnElBotonConElTexto(String texto) {
        theActorInTheSpotlight().attemptsTo(Click.on("//button[text()='" + texto + "']|//span[text()='" + texto + "']"));
    }

    @Cuando("el usuario ingresa '(.*)' en el campo '(.*)'$")
    public void elUsuarioIngresaStringEnElCampo(String texto, String campo) {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the("//*[@id='" + campo + "']", isVisible()).forNoMoreThan(30).seconds());
        theActorInTheSpotlight().attemptsTo(Enter.theValue(texto).into("//*[@id='" + campo + "']"));
    }

    @Cuando("el usuario hace click en el combo '(.*)' y selecciona la opción '(.*)'$")
    public void elUsuarioHaceClickEnElYSeleccionaLaOpcion(String combo, String opcion) {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the("//*[@id='" + combo + "']", isVisible()).forNoMoreThan(30).seconds());
        new Select(getDriver().findElement(By.id("" + combo + ""))).selectByVisibleText(opcion);
    }

    @Cuando("el usuario scrollea hasta el elemento '(.*)'$")
    public void elUsuarioScrolleaHastaElElemento(String texto) {
        theActorInTheSpotlight().attemptsTo(Scroll.to(By.xpath("//span[text()='" + texto + "']")));
    }
    //endregion
}
