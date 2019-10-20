package myarraylist;

public class Application {
    public static void main(String[] args) {
        MyArrayList<Integer> newArray = new MyArrayList<>();
        //add(element e) method test
        //testing with default size
        for (int i = 0; i < newArray.size(); i++) {
            newArray.add(i * 10);
        }
        //expand array and check it
        for (int i = 0; i < 50; i++) {
            newArray.add((i + 1) * 10);
            System.out.println(newArray.get(i));
        }
        //add() method test
        System.out.println("add() method test");
        MyArrayList<Integer> newArray1 = new MyArrayList<>();
        for (int i = 0; i < newArray1.size(); i++) {
            newArray1.add(i);
            System.out.println(newArray1.get(i));
        }
        System.out.println();
        newArray1.add(8, 100);
        for (int i = 0; i < newArray1.size(); i++) {
            System.out.println(newArray1.get(i));
        }
        //remove() method test
        System.out.println("remove() method test");
        MyArrayList<Integer> newArray2 = new MyArrayList<>();
        for (int i = 0; i < newArray2.size(); i++) {
            newArray2.add(i + 1);
            System.out.println(newArray2.get(i));
        }
        int hasDeleted = newArray2.remove(4);
        System.out.println("result of remove() testing");
        for (int i = 0; i < newArray2.size(); i++) {
            System.out.println(newArray2.get(i));
        }
        System.out.println("Has deleted: " + hasDeleted);
        //clear() method test
        System.out.println("clear() method test");
        MyArrayList<Integer> newArray3 = new MyArrayList<>();
        for (int i = 0; i < newArray3.size(); i++) {
            newArray3.add(i);
            System.out.println(newArray3.get(i));
        }
        System.out.println("clear() method test");
        newArray3.clear();
        System.out.println("A new array size is: " + newArray3.size());
    }
}
