package nullability;

import nullability.launch.Launch;
import nullability.launch.LaunchPlatform;
import nullability.launch.Silo;
import nullability.storage.RocketStorage;
import nullability.storage.UndergroundRocketStorage;

public class RocketLaunchApplication {
    public static void main(String[] args) {
        Coordinates london = new Coordinates(-51.50853, 0.12574);

        Rocket londonNuke = new Rocket(Warhead.NUCLEAR, london);

        RocketStorage storage = new UndergroundRocketStorage(londonNuke);

        LaunchPlatform site000 = new Silo(new Coordinates(0.0, 0.0));

        OptionalRocket r0 = storage.tryToGet(0);

        if (r0.isPresent()) {
            Rocket rocket = r0.get();
            Launch launch = site000.launch(rocket);
            System.out.println("Verifying launch: " + launch);
        }
    }
}
