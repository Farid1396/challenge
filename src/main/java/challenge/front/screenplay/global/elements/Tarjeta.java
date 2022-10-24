package challenge.front.screenplay.global.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Tarjeta {

    public static Target DEL_SEGUNDO_PRODUCTO = Target.the("Del segundo producto").located(By.xpath("//div[@class='product-container']/div[2]/a[2]"));
}