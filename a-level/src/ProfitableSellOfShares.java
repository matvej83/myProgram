import java.util.Arrays;

/***
 * THis program is a part of home task.
 * Given an array (double), that contains the Tesla shares prices within a week (7 days). Find such one buying day and
 * one sell day when you'll have a maximum benefit.
 */
public class ProfitableSellOfShares {

    public static void main(String[] args) {
        //searching for maximum benefits
        int[][] sharesOfTesla = {
                {1, 2, 3, 4, 5, 6, 7},
                {450, 150, 400, 500, 300, 200, 600}
        };
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println("Searching for maximum benefits" + System.lineSeparator() + "Prices of Tesla shares: ");
        for (int i = 0; i < sharesOfTesla.length; i++) {
            for (int j = 0; j < sharesOfTesla[0].length; j++) {
                System.out.print(sharesOfTesla[i][j] + "\t");
            }
            System.out.println();
        }
        //define max and min price of shares:
        //make a temporary one-dimensional array for prices storing
        int tempArray[] = Arrays.copyOf(sharesOfTesla[1], sharesOfTesla[1].length);
        //sorting temporary array
        Arrays.sort(tempArray);
        //define the indexes of max and min prices in initial array sharesOfTesla
        //and display the day of buying and the day of sale, when maximum benefits takes place
        int minPosition = 0;
        int maxPosition = 0;
        for (int i = 0; i < sharesOfTesla[1].length; i++) {
            minPosition = IndexOfArrayElement(sharesOfTesla[1], tempArray[i]);
            maxPosition = IndexOfArrayElement(sharesOfTesla[1], tempArray[tempArray.length - 1 - i]);
            if (maxPosition > minPosition) {
                System.out.print("The day of buying is " + weekDays[minPosition] + ", the day of sale is " + weekDays[maxPosition]);
                System.out.println(". Maximum benefits is " + (sharesOfTesla[1][maxPosition] - sharesOfTesla[1][minPosition]));
                break;
            }
        }
    }

    static int IndexOfArrayElement(int arr[], int element) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }
}
