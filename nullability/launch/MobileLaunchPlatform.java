package nullability.launch;

import nullability.Coordinates;
import nullability.Rocket;

public interface MobileLaunchPlatform extends LaunchPlatform {
    Launch launch(Rocket rocket);
    void move (Coordinates location);
}