import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int num = scanner.nextInt();
        int countNum = 0;

        for (int i : arr) {
            countNum += i == num ? 1 : 0;
        }

        System.out.println(countNum);

    }
}