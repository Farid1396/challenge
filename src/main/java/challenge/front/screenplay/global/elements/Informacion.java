package challenge.front.screenplay.global.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Informacion {

    public static Target DEL_PRODUCTO = Target.the("Del producto").located(By.xpath("//div[@class='product-info']"));
    public static Target DE_LA_CANTIDAD_DE_PRODUCTOS_DISPONIBLES = Target.the("Del producto").located(By.xpath("//div[@class='product-quantity-tip']"));
}