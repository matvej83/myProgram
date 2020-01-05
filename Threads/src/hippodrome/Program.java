package hippodrome;

import java.util.*;
import java.util.concurrent.Semaphore;

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
    private static List<String> hasFinished = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Semaphore semaphore = new Semaphore(HORSENUMBER);
        List<String> horses = Collections.synchronizedList(new ArrayList<>());

        System.out.println("In race takes part such horses:");
        for (int i = 0; i < HORSENUMBER; i++) {
            Thread runningHorse = new Thread(new Horse(semaphore, "Horse-" + (i + 1)), "Horse #" + (i + 1));
            runningHorse.start();
            horses.add(runningHorse.getName());
            System.out.println(horses.get(i));
        }

        System.out.println("Choose the horse number to bet (enter 1..." + HORSENUMBER + "):");
        int choice = checkChoice(sc.nextInt(), sc);
        System.out.println("Race has finished with results:");
        for (String result :
                hasFinished) {
            System.out.println(result);
        }
        int finishPosition = hasFinished.lastIndexOf(horses.get(choice - 1)) + 1;
        System.out.print("Your horse is finished on the " + finishPosition + " position.");
        System.out.println(finishPosition == 1 ? " You win!" : " You lose!");
    }

    public static synchronized void addFinished(String name) {
        Program.hasFinished.add(name);
    }

    private static int checkChoice(int choice, Scanner sc) {
        int correctChoice = choice;
        while (true) {
            if (correctChoice < 1 | correctChoice > HORSENUMBER) {
                System.out.println("You entered an incorrect value!\nTry again:");
                correctChoice = sc.nextInt();
            } else break;
        }
        return correctChoice;
    }
}