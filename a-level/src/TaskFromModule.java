import java.util.*;
//unique numbers counting
public class TaskFromModule {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 4, 4, 8, 2, 2, 2};
        int counter = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                counter++;
            }
        }
        System.out.println(arr.length - counter);
    }
}
