import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        // Process input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] inputArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                inputArr[i][j] = scanner.nextInt();
            }
        }

        // Rotate input and print
        int[][] res = rotateRectangle(n, m, inputArr);
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print(res[k][l] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] rotateRectangle(int n, int m, int[][] rectangle) {
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = rectangle[i][j];
            }
        }
        return result;
    }
}
