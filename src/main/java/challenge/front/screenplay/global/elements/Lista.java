package challenge.front.screenplay.global.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Lista {
    public static Target DE_RESULTADOS = Target.the("De resultados").located(By.xpath("//div[@class='product-container']/div[2]/a"));
    public static Target EL_PAGINADO_DE_RESULTADOS = Target.the("El paginado de resultados").located(By.xpath("//div[@class='list-pagination']"));
}