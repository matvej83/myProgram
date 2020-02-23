package nullability.launch;

import nullability.Coordinates;
import nullability.Rocket;

import java.util.Date;

public class Submarine implements MobileLaunchPlatform {
    private Coordinates location;

    public Submarine(Coordinates location) {
        this.location = location;
    }

    @Override
    public Launch launch(Rocket rocket) {
        Launch launch = new Launch(location, rocket, new Date());

        Coordinates target = rocket.getTarget();

        System.out.println(rocket.getWarhead() +
                " rocket has been launched from the submarine at {" +
                location.getLatitude() + ", " +
                location.getLongitude() + "} at " +
                launch.getDate() + ", targeting coordinates {" +
                target.getLatitude() + ", " +
                target.getLongitude() + "}"
        );

        return launch;
    }

    @Override
    public void move(Coordinates location) {
        this.location = location;
        System.out.println("Submarine is moved to position {" + location.getLatitude() + ", " + location.getLongitude() + "}");
    }
}
