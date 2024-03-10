import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        boolean isAsc = true;

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
            isAsc = i == 0 || arr[i] >= arr[i - 1];
            if (!isAsc) {
                break;
            }
        }



        System.out.println(isAsc);
    }
}