package nullability.storage;
public class RocketNotFoundException extends Exception{
    public RocketNotFoundException(int index) {
        super("Rocket with index " + index + " not found");
    }
}