
class ArrayOperations {

    public static int[][][] createCube() {
        final int i = 3;
        final int j = 3;
        final int k = 3;

        int[][][] result = new int[i][j][k];

        for (int l = 0; l < i; l++) {
            int r = 0;
            for (int m = 0; m < j; m++) {
                for (int n = 0; n < k; n++) {
                    result[l][m][n] = r;
                    r += 1;
                }
            }
        }

        return result;
    }
}