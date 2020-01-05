package hippodrome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * This program was created as a part of home task, that's given below.
 * Task:
 * To write hippodrome simulator: some horses (every in separate thread) runs at the distance 1000 m. For one iteration
 * each horse runs 60-100 m (chooses by means randomise) and after, she sleeps for a 100 ms. Before the start user
 * chooses horse on which he bets. After all the horses has reached the finish line, display position, on which chosen
 * horse finished.
 */

public class Program {

    private static final int HORSENUMBER = 4;
    public static long start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Semaphore semaphore = new Semaphore(HORSENUMBER);

        start = System.currentTimeMillis();

        List<Horse> horses = new ArrayList<>();
        List<Horse> hasFinished = new ArrayList<>();

        System.out.println("In race takes part such horses:");
        for (int i = 0; i < HORSENUMBER; i++) {
            Horse horse = new Horse(semaphore, "Horse #" + (i + 1));
            horses.add(horse);
            System.out.println(horse.getName() + " speed: " + horse.getSpeed());
        }
        System.out.println("Choose the horse number to bet (enter 1...4):");
        int choice = sc.nextInt();
        for (Horse tmp :
                horses) {
            tmp.run();
            System.out.println(tmp.getName() + " speed: " + tmp.getSpeed());
            if (tmp.isFinished()) {
                hasFinished.add(tmp);
            }
        }
        System.out.println("Your horse is finished on the " + (hasFinished.lastIndexOf(horses.get(choice - 1)) + 1) + " position");
    }
}