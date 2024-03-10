class ArrayOperations {


    // somehow this one doesn't pas the tests
    public static void printCorners2(int[][] twoDimArray) {
        int inputLen = twoDimArray.length;
        int[] corners = new int[4];
        int firstElementLen = twoDimArray[0].length;
        int lastElementLen = twoDimArray[inputLen - 1].length;

        corners[0] = twoDimArray[0][0];
        corners[1] = twoDimArray[0][firstElementLen - 1];
        corners[2] = twoDimArray[inputLen - 1][0];
        corners[3] = twoDimArray[inputLen - 1][lastElementLen - 1];

        System.out.println(corners[0] + " " + corners[1]);
        System.out.print(corners[2] + " " + corners[3]);

    }

    public static void printCorners(int[][] twoDimArray) {
        int[] firstRow = twoDimArray[0];
        int[] lastRow = twoDimArray[twoDimArray.length - 1];
        System.out.println(firstRow[0] + " " + firstRow[firstRow.length - 1]);
        System.out.print(lastRow[0] + " " + lastRow[firstRow.length - 1]);
    }
}