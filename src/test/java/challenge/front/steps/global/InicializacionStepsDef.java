package challenge.front.steps.global;

import challenge.front.screenplay.global.tasks.Navegar;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class InicializacionStepsDef {

    //region Before
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    //endregion

    //region Dado
    @Cuando("^el (.*) se encuentra en la página Home$")
    public void elUsuarioSeEncuentraEnLaPagina(String actor) {
        theActorCalled(actor).attemptsTo(Navegar.hacia("pantalla login"));
    }
    //endregion
}
