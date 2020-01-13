package hippodrome;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * This program was created as a part of home task, that's given below.
 * Task:
 * To write hippodrome simulator: a few horses (every in separate thread) runs at the distance 1000 m. For one iteration
 * each horse runs 60-100 m (chooses by means randomise) and after, she sleeps for a 100 ms. Before the start user
 * chooses horse on which he bets. After all the horses has reached the finish line, display position, on which chosen
 * horse finished.
 */

public class Hippodrome {

    private static final int HORSENUMBER = 6;

    public static void main(String[] args) {
        IOtoFile iOtoFile = new IOtoFile();
        iOtoFile.clearFile(args[0]);
        CountDownLatch countDownLatch = new CountDownLatch(HORSENUMBER);
        Race race = new Race();
        System.out.println("In the race takes part such horses:");
        for (int i = 0; i < HORSENUMBER; i++) {
            try {
                Horse horse = new Horse(countDownLatch, "Horse-" + (i + 1));
                horse.setFilePath(args[0]);
                Thread runningHorse = new Thread(horse, "Horse#" + (i + 1));
                runningHorse.start();
                countDownLatch.await();
                System.out.println(runningHorse.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Choose the horse number to bet (enter 1..." + HORSENUMBER + "):");
        int choice;
        try (Scanner sc = new Scanner(System.in)) {
            while ((choice = sc.nextInt()) > HORSENUMBER || choice < 1) {
                System.out.println("You entered an incorrect value.\nTry again:");
            }
        }

        System.out.println("Race has finished with the results:");
        List<String> winners = iOtoFile.readStringsFromFile(args[0]);

        for (String tmp :
                winners) {
            race.addFinished(tmp);
        }

        for (int i = 1; i <= winners.size(); i++) {
            System.out.print("Horse#".concat(String.valueOf(i)));
            System.out.println(" finished " + race.getHasFinished().get("Horse#".concat(Integer.toString(i))));
        }

        int finishPosition = race.getHasFinished().get("Horse#".concat(String.valueOf(choice)));
        System.out.print("Your horse finished on the " + finishPosition + " position.");
        System.out.println(finishPosition == 1 ? " You win!" : " You lose!");
    }
}