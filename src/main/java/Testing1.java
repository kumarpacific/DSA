import java.util.ArrayList;

public class Testing1 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(i);
        }
        System.out.println("List :: "+list);


Boolean[] bool = new Boolean[2];
//bool[0] = new Boolean(Boolean.parseBoolean("true"));
//bool[1] = new Boolean(null);

        System.out.println(bool[0]+" "+bool[1]);


        int a = 1000 << 1;

        System.out.println(a);

        int[] numbers = {1, 2, 3, 4, 5};

        // Step 2: Attempt to access an element at an out-of-bounds index
        try {
            System.out.println("Accessing element at index 10: " + numbers[10]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }
    }
}
