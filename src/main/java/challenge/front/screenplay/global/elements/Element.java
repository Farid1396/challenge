package challenge.front.screenplay.global.elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Normalizer;

public class Element {

    public static Class<? extends PageObject> getPage(String name) {
        name = normalice(name);
        name = getPageClassName(name);
        return getPageClass(name);
    }

    @NotNull
    private static String getPageClassName(String name) {
        StringBuilder camelCaseName = new StringBuilder();

        //eliminar la primera palabra (pantalla / pagina)
        name = name.replace(name.split(" ")[0] + " ", "");

        for (String s : name.split(" ")) {
            camelCaseName.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase());
        }

        return Element.class.getName().replace("Element", "pages.") + camelCaseName;
    }

    private static Class<? extends PageObject> getPageClass(String className) {
        Class<? extends PageObject> pageClass;
        try {
            pageClass = (Class<? extends PageObject>) Class.forName(className);
        } catch (ClassNotFoundException x) {
            throw new RuntimeException("No se encontró la clase: " + className + " para generar el objeto");
        } catch (Exception x) {
            throw new RuntimeException("La clase: " + className + " no extiende de pageObject");
        }
        return pageClass;
    }

    @NotNull
    private static String normalice(String name) {
        name = Normalizer.normalize(name, Normalizer.Form.NFD);
        return name.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }
}
