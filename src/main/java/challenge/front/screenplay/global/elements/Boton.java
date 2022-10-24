package challenge.front.screenplay.global.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Boton {

    public static Target DE_LA_SEGUNDA_PAGINA = Target.the("De la segunda página").located(By.xpath("//div[@class='list-pagination']//button[text()='2']"));
}