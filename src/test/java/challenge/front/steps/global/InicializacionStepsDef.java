package challenge.front.steps.global;

import challenge.front.screenplay.global.abilities.Identificarse;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class InicializacionStepsDef {

    //region Before
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    //endregion

    //region Dado
    @Dado("que el usuario tiene la habilidad de loguearse como {string}")
    public void queElUsuarioTieneLaHabilidadDeLoguearseComo(String actor) {
        theActorCalled(actor).can(Identificarse.como(actor));
    }

    @Cuando("^el usuario se encuentra en la página AliExpress")
    public void elUsuarioSeEncuentraEnLaPaginaAliExpress() {
        getDriver().get("https://www.aliexpress.com/");
    }
    //endregion
}
