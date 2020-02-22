package nullability.launch;

import nullability.Coordinates;

public interface MobileLaunchPlatform extends LaunchPlatform {
    void move (Coordinates location);
}