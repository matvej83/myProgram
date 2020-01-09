package hippodrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * This program was created as a part of home task, that's given below.
 * Task:
 * To write hippodrome simulator: a few horses (every in separate thread) runs at the distance 1000 m. For one iteration
 * each horse runs 60-100 m (chooses by means randomise) and after, she sleeps for a 100 ms. Before the start user
 * chooses horse on which he bets. After all the horses has reached the finish line, display position, on which chosen
 * horse finished.
 */

public class Program {

    private static final int HORSENUMBER = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountDownLatch countDownLatch = new CountDownLatch(HORSENUMBER);

        ConcurrentHashMap<String, Integer> theyHasFinished = new Race().getHasFinished();

        System.out.println("In the race takes part such horses:");
        for (int i = 0; i < HORSENUMBER; i++) {
            try {
                Thread runningHorse = new Thread(new Horse(countDownLatch, "Horse-" + (i + 1)),
                        "Horse #" + (i + 1));
                runningHorse.start();
                countDownLatch.await();
                System.out.println(runningHorse.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Choose the horse number to bet (enter 1..." + HORSENUMBER + "):");
        int choice = sc.nextInt();
        while (true) {
            if (choice < 1 | choice > HORSENUMBER) {
                System.out.println("You enter an incorrect value.\nTry again:");
                choice = sc.nextInt();
            } else break;
        }

        System.out.println("Race has finished with the results:");

        for (int i = 1; i <= theyHasFinished.size(); i++) {
            System.out.print("Horse #".concat(String.valueOf(i)));
            System.out.println(" finished " + theyHasFinished.get("Horse #".concat(String.valueOf(i))));
        }

        int finishPosition = theyHasFinished.get("Horse #".concat(String.valueOf(choice)));
        System.out.print("Your horse finished on the " + finishPosition + " position.");
        System.out.println(finishPosition == 1 ? " You win!" : " You lose!");
    }
}