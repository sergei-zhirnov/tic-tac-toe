import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        final int steps = 1;

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }



    private static void rotate(int[] arr, int steps) {
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
}