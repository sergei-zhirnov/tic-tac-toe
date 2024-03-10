import java.util.Scanner;
import java.util.Arrays;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        // steps = 1
        int len = arr.length;
        int[] arrCopy = new int[len];

        for (int i = 0; i < steps; i++) {

            System.arraycopy(arr, 0, arrCopy, 0, len);

            int lastElement = arr[len - 1];

            for (int j = 0; j < len - 1; j++) {
                arr[j + 1] = arrCopy[j];
            }
            arr[0] = lastElement;
        }
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}