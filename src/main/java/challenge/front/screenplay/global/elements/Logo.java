package challenge.front.screenplay.global.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Logo {
    public static Target DE_ALIEXPRESS = Target.the("De AliExpress").located(By.xpath("(//span[text()='AliExpress'])[2]"));
}