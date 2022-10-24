package challenge.front.screenplay.global.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Campo {
    public static Target DE_BUSQUEDA = Target.the("De búsqueda").located(By.id("search-key"));
}