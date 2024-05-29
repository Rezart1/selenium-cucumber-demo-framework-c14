package practice;

import io.Yoll.Main;

public class SpreadOperator {

    // if i put three dots ... it means int is an array
    public static void addNumbers(int... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);

        }

    }

    public static void main(String[] args) {
      addNumbers (1,2,4,5,653,58);
    }
}