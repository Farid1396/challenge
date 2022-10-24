package challenge.front.screenplay.global.questions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class VentanaEmergente implements Question<Boolean> {
    public static VentanaEmergente existe() {
        return Instrumented.instanceOf(VentanaEmergente.class).withProperties();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultado;

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        String actual = driver.getWindowHandle();
        Set<String> ventanas = driver.getWindowHandles();
        if (ventanas.size()>1) {
            resultado=true;
        } else {
            resultado=false;
        }

        return resultado;
    }
}