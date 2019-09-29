package someSubstances;

import java.util.*;

public class Substances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select substance from the list: 1-Water, 2-Iron, 3-Oxygen.");
        System.out.println(" To select input 1, 2 or 3 and press <Enter>:");
        int choice = sc.nextInt();
        Substance theSubstance = null;
        switch (choice) {
            case 1:
                theSubstance = new Water(20d, State.LIQUID);
                break;
            case 2:
                theSubstance = new Iron(20d, State.SOLID);
                break;
            case 3:
                theSubstance = new Oxygen(20d, State.GAS);
                break;
            default:
                System.out.println("Incorrect choice!");
                System.exit(1);
        }
        System.out.println(theSubstance.getName());
        while (true) {
            System.out.println("Input the magnitude of the temperature change:");
            double tempMagnitude = sc.nextDouble();
            if (tempMagnitude == 0) break;
            System.out.println("The state is " + theSubstance.heatUp(tempMagnitude).toString());
            System.out.println("Current temperature is " + theSubstance.getTemperature());
            System.out.println("Are you finished? Input 'y/Y' to exit or 'n/N' to continue");
            char continueOrNot = sc.next(".").charAt(0);
            if (continueOrNot == 'y' || continueOrNot == 'Y') break;
        }
        sc.close();
    }
}
