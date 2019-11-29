import java.lang.annotation.*;

class PropertyKeys {

    @Target(value = ElementType.FIELD)
    @Retention(value = RetentionPolicy.RUNTIME)

    public @interface PropertyKey {
        String value();
    }
}
