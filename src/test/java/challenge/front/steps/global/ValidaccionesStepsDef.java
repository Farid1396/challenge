package challenge.front.steps.global;

import challenge.front.screenplay.global.elements.Logo;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidaccionesStepsDef {

    //region Entonces
    @Entonces("el usuario visualiza el logo")
    public void elUsuarioVisualizaElLogo() {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(Logo.DE_EMERGENCIAS_SALUD, isVisible()).forNoMoreThan(10).seconds());
    }

    @Entonces("el usuario observa el mensaje en pantalla '(.*)'$")
    public void elUsuarioObservaElMensajeEnPantalla(String texto) {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the("//*[text()='" + texto + "']", isVisible()).forNoMoreThan(10).seconds());
    }

    @Entonces("el usuario observa el título en pantalla '(.*)'$")
    public void elUsuarioObservaElTituloEnPantalla(String texto) {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the("//*[contains(text(),'" + texto + "')]", isVisible()).forNoMoreThan(10).seconds());
    }
    //endregion
}
