package nullability;

import nullability.launch.*;
import nullability.storage.MobileRocketStorage;
import nullability.storage.RocketStorage;
import nullability.storage.UndergroundRocketStorage;

import java.util.NoSuchElementException;
import java.util.Scanner;

/***
 * This programm has written by Michael Horbunov (GitHub: voidAspect) and suplemented by Vladimir Matveenko
 * (GitHub: matvej83) in a part of:
 * 1. Create submarine by means realization MobileLaunchPlatform interface. Method move change start point.
 * 2. Realize interactive logic: user has choose rocket from the list (if he gives a wrong index - retry input attempt),
 * after he has choose the start method (the silo or the submarine) and start point, after that a launch starts.
 */

public class RocketLaunchApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choice the type of launch platform from the list:\n " +
                "1-Submarine; 2-Silo");
        int choice = tryToGet(sc.nextInt());
        RocketStorage newRocketStorage = null;
        LaunchPlatform lP001 = null;
        System.out.println("Enter the target coordinates.\n enter latitude:");
        double targetLatitude = sc.nextDouble();
        System.out.println("enter longitude:");
        double targetLongitude = sc.nextDouble();
        Coordinates target = new Coordinates(targetLatitude, targetLongitude);
        Rocket newRocket = new Rocket(Warhead.NUCLEAR, target);
        System.out.println("Enter the rocket index");
        int index = sc.nextInt();
        switch (choice) {
            case 1:
                newRocketStorage = new MobileRocketStorage(newRocket);
                lP001 = new Submarine(new Coordinates(69.076631, 33.417814));
                System.out.println("Enter new start position:\n enter latitude:");
                double startLatitude = sc.nextDouble();
                System.out.println("enter longitude:");
                double startLongitude = sc.nextDouble();
                Coordinates newStartPosition = new Coordinates(startLatitude, startLongitude);
                ((Submarine) lP001).move(newStartPosition);
                break;
            case 2:
                newRocketStorage = new UndergroundRocketStorage(newRocket);
                lP001 = new Silo(new Coordinates(0.0, 0.0));
                break;
        }

        OptionalRocket r0 = newRocketStorage.tryToGet(0);

        if (r0.isPresent()) {
            Rocket rocket = r0.get();
            Launch launch = lP001.launch(rocket);
            System.out.println("Verifying launch: " + launch);
        }
        sc.close();
    }

    private static int tryToGet(int choice) {
        if (choice <= 0 || choice > 2) {
            throw new NoSuchElementException();
        }
        return choice;
    }
}
