package challenge.front.screenplay.global.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Logo {
    public static Target DE_EMERGENCIAS_SALUD = Target.the("De Emergencias Salud").located(By.xpath("//span[@class='logo-image']"));
}