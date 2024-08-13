import java.util.ArrayList;
import java.util.List;

public class JavaExercises {

    // Task 1: makeDice
    public int[] makeDice() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    // Task 2: takeOrder
    public String[] takeOrder(String customer) {
        if (customer.equals("Ergun")) {
            return new String[]{"beyti", "pizza", "hamburger", "tea"};
        } else if (customer.equals("Erik")) {
            return new String[]{"sushi", "pasta", "avocado", "coffee"};
        } else {
            return new String[3];
        }
    }

    // Task 3: findMinMax
    public int findMinMax(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return max - min;
    }

    // Task 4: hailstone
    public List<Integer> hailstone(int n) {
        List<Integer> sequence = new ArrayList<>();
        hailstoneHelper(n, sequence);
        return sequence;
    }

    private void hailstoneHelper(int n, List<Integer> sequence) {
        sequence.add(n);
        if (n == 1) {
            return;
        } else if (n % 2 == 0) {
            hailstoneHelper(n / 2, sequence);
        } else {
            hailstoneHelper(3 * n + 1, sequence);
        }
    }
}
