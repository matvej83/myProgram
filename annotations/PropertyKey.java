package annotations;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface PropertyKey {
    String cargo();
    double weight();
    double length();
    double width();
    double height();

}
