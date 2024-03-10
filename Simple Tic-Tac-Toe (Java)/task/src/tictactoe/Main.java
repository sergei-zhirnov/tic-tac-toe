package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String inputLine = "_________";
        char[][] arr = makeCharArr(inputLine);
        printField(arr);

        boolean xTurn = true;
        while (findResult(arr).equals("Game not finished")) {
            int[] alterField = processMove(xTurn, arr);
            arr[alterField[0] - 1][alterField[1] - 1] = alterField[2] == 0 ? 'O' : 'X';
            xTurn = !xTurn;
            printField(arr);
        }
        System.out.println(findResult(arr));


    }


    public static char[][] makeCharArr(String inputLine) {

        char[] inputChars = inputLine.toCharArray();
        char[][] result = { {inputChars[0], inputChars[1], inputChars[2]},
                {inputChars[3], inputChars[4], inputChars[5]},
                {inputChars[6], inputChars[7], inputChars[8]}};

        return result;

    }

    public static void printLine(char[] arr) {
        char[] mergedChars = new char[]{ '|', ' ', '1', ' ', '1', ' ', '1', ' ', '|'};
        mergedChars[2] = arr[0];
        mergedChars[4] = arr[1];
        mergedChars[6] = arr[2];

        String line = new String(mergedChars);
        System.out.println(line);
    }


    public static boolean hasEmptyCells(char[][] inputArr) {
        boolean hasEmptyCells = false;

        for (char[] ch: inputArr) {
            for (char el: ch) {
                if (el == '_') {
                    hasEmptyCells = true;
                    break;
                }
            }
        }
        return hasEmptyCells;
    }

    public static boolean symbolWins(char symbol, char[][] inputArr) {

        boolean hasRow = symbol == inputArr[0][0] && (inputArr[0][0] == inputArr[0][1] && inputArr[0][0] == inputArr[0][2]) ||
                symbol == inputArr[1][0] && (inputArr[1][0] == inputArr[1][1] && inputArr[1][0] == inputArr[1][2]) ||
                symbol == inputArr[2][0] && (inputArr[2][0] == inputArr[2][1] && inputArr[2][0] == inputArr[2][2]);
        boolean hasColumn = symbol == inputArr[0][0] && (inputArr[0][0] == inputArr[1][0] && inputArr[0][0] == inputArr[2][0]) ||
                symbol == inputArr[0][1] && inputArr[0][1] == inputArr[1][1] && inputArr[0][1] == inputArr[2][1] ||
                symbol == inputArr[0][2] && inputArr[0][2] == inputArr[1][2] && inputArr[0][2] == inputArr[2][2];
        boolean hasMainDiagonal = symbol == inputArr[0][0] && (inputArr[0][0] == inputArr[1][1] && inputArr[0][0] == inputArr[2][2]);
        boolean hasAddDiagonal = symbol == inputArr[0][2] && (inputArr[0][2] == inputArr[1][1] && inputArr[0][2] == inputArr[2][0]);

        return (hasRow || hasColumn || hasMainDiagonal || hasAddDiagonal);
    }

    public static boolean isDiffPossible(char[][] inputArr) {
        int xCount = 0;
        int oCount = 0;
        for (char[] arr : inputArr) {
            for (char ch : arr) {
                if (ch == 'X') {
                    xCount++;
                } else if (ch == 'O') {
                    oCount++;
                }
            }
        }
        return Math.abs(xCount - oCount) < 2;
    }

    public static int[] getCoordinates(String str, char[][] inputArr) {
        int[] result = {-1, -1};
        char[] arr = str.toCharArray();

        if (arr.length == 3 && arr[0] > 47 && arr[0] < 58 && arr[2] > 47 && arr[2] < 58) {
            result[0] = arr[0] - '0';
            result[1] = arr[2] - '0';
        }

        if (result[0] != -1 && (result[0] < 1 || result[0] > 3 || result[1] < 1 || result[1] > 3)) {
            result[0] = -2;
            result[1] = -2;
        }

        if (result[0] > 0) {
            boolean isCellBusy = isCellBusy(result[0] - 1, result[1] - 1, inputArr);
            if (isCellBusy) {
                result[0] = -3;
                result[1] = -3;
            }
        }

        return result;

    }

    public static boolean isCellBusy(int x, int y, char[][] arr){
        return !(arr[x][y] == '_');
    }

    public static void printField(char[][] arr) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            printLine(arr[i]);
        }
        System.out.println("---------");
    }

    public static String findResult(char[][] arr) {
        String gameResult;

        if (isDiffPossible(arr) && !symbolWins('X', arr) && !symbolWins('O', arr) && hasEmptyCells(arr)) {
            gameResult = "Game not finished";
        } else if (isDiffPossible(arr) && !symbolWins('X', arr) && !symbolWins('O', arr) && !hasEmptyCells(arr)) {
            gameResult = "Draw";
        } else if (isDiffPossible((arr)) && symbolWins('X', arr) && !symbolWins('O', arr)) {
            gameResult = "X wins";
        } else if (isDiffPossible((arr)) && !symbolWins('X', arr) && symbolWins('O', arr)) {
            gameResult = "O wins";
        } else {
            gameResult = "Impossible";
        }

        return gameResult;
    }

    public static int[] processMove(boolean xTurn, char[][] arr){
        Scanner scanner = new Scanner(System.in);
        String inputCoordinates = scanner.nextLine();
        int[] coordinates = getCoordinates(inputCoordinates, arr);

        while (coordinates[0] < 0) {
            if (coordinates[0] == -1) {
                System.out.println("You should enter numbers!");
            } else if (coordinates[0] == -2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (coordinates[0] == -3) {
                System.out.println("This cell is occupied! Choose another one!");
            }
            inputCoordinates = scanner.nextLine();
            coordinates = getCoordinates(inputCoordinates, arr);
        }

        int[] preCoords = new int[3];
        preCoords[0] = coordinates[0];
        preCoords[1] = coordinates[1];
        preCoords[2] = xTurn ? 1 : 0;

        return preCoords;
    }

}
