package someSubstances;

import java.util.*;

public class Substances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select substance from the list: 1-Water, 2-Iron, 3-Oxygen.");
        System.out.println(" To select input 1, 2 or 3 and press <Enter>:");
        int choice = sc.nextInt();
        double tempMagnitude;
        String isState = null;
        double currentTemperature = 20d;
        Water water = new Water(currentTemperature, State.LIQUID);
        Iron iron = new Iron(20d, State.SOLID);
        Oxygen oxygen = new Oxygen(20d, State.GAS);
        char continueOrNot = 0;
        while (true) {
            System.out.println("Input the magnitude of the temperature change:");
            switch (choice) {
                case 1:
                    System.out.println(water.getName());
                    tempMagnitude = sc.nextDouble();
                    if (tempMagnitude == 0) break;
                    isState = water.heatUp(tempMagnitude).toString();
                    currentTemperature = water.getTemperature();
                    break;
                case 2:
                    System.out.println(iron.getName());
                    tempMagnitude = sc.nextDouble();
                    if (tempMagnitude == 0) break;
                    isState = iron.heatUp(tempMagnitude).toString();
                    currentTemperature = iron.getTemperature();
                    break;
                case 3:
                    System.out.println(oxygen.getName());
                    tempMagnitude = sc.nextDouble();
                    if (tempMagnitude == 0) break;
                    isState = oxygen.heatUp(tempMagnitude).toString();
                    currentTemperature = oxygen.getTemperature();
                    break;
                default:
                    System.out.println("Incorrect choice!");
                    System.exit(1);
            }
            System.out.println("The state is " + isState);
            System.out.println("Current temperature is " + currentTemperature);
            System.out.println("Are you finished? Input 'y/Y' to exit or 'n/N' to continue");
            continueOrNot = sc.next(".").charAt(0);
            if (continueOrNot == 'y' || continueOrNot == 'Y') break;
        }
        sc.close();
    }
}
