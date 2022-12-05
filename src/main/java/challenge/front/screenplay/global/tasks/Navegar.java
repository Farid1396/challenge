package challenge.front.screenplay.global.tasks;

import challenge.front.screenplay.global.elements.Element;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Navegar implements Task {
    private final String page;

    public Navegar(String page) {
        this.page = page;
    }

    public static Navegar hacia(String page) {
        return Instrumented.instanceOf(Navegar.class).withProperties(page);
    }

    @Step("El {0} navega hacia la pagina '#page'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(Element.getPage(page)));

    }
}
