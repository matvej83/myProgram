package nullability.storage;

import nullability.OptionalRocket;
import nullability.Rocket;


public interface RocketStorage {
    Rocket get(int index) throws RocketNotFoundException;

    OptionalRocket tryToGet(int index);
}