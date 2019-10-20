package myarraylist;

public class Application {
    public static void main(String[] args) {
        MyArrayList<Integer> newArray = new MyArrayList<>();
        //add method test
        for (int i = 0; i < newArray.size(); i++) {
            newArray.add(i * 10);
            System.out.println(newArray.get(i));
        }
        newArray.add(100);
        System.out.println("element: " + newArray.get(10) + "size: " + newArray.size());
    }
}
