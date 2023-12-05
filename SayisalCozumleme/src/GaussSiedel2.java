public class GaussSiedel2 {
    //1 -2 1
    public static void main(String[] args) {
        double[][] matrix = {
                {10, 2, 1, 7},
                {1, 5, 1, 0, -8},
                {2, 3, 10, 5, 6}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Başlangıç Matrisi:");
        printMatrix(matrix);

        //edit rows
        editArray(matrix);


        calc_x1(matrix);
        calc_x2(matrix);
        calc_x3(matrix);
        System.out.println("=========================");
        calc_x1(matrix);
        calc_x2(matrix);
        calc_x3(matrix);
        System.out.println("=========================");
        calc_x1(matrix);
        calc_x2(matrix);
        calc_x3(matrix);
        System.out.println("=========================");
        calc_x1(matrix);
        calc_x2(matrix);
        calc_x3(matrix);
        System.out.println("=========================");
        do {
            calc_x1(matrix);
            calc_x2(matrix);
            calc_x3(matrix);
        } while (checkError());


    }

    static final double epsilon = 0.001;
    static boolean error_1 = false;
    static boolean error_2 = false;
    static boolean error_3 = false;

    static float x1_value = 0;
    static float x2_value = 0;
    static float x3_value = 0;

    public static boolean checkError() {
        return !(error_1 && error_2 && error_3);
    }

    public static void calc_x1(double[][] matrix) {
        double result = matrix[0][3];
        double operation = (result - (matrix[0][1] * x2_value) - (matrix[0][2] * x3_value)) / matrix[0][0];
        if (Math.abs(operation - x1_value) < epsilon) {
            error_1 = true;
        }
        x1_value = (float) operation;
        System.out.println("current x1:" + x1_value);
    }

    static void calc_x2(double[][] matrix) {
        double result = matrix[1][3];
        double operation = (result - (matrix[1][0] * x1_value) - (matrix[1][2] * x3_value)) / matrix[1][1];
        if (Math.abs(operation - x2_value) < epsilon) {
            error_2 = true;
        }
        x2_value = (float) operation;
        System.out.println("current x2:" + x2_value);
    }

    static void calc_x3(double[][] matrix) {
        double result = matrix[2][3];
        double operation = (result - (matrix[2][0] * x1_value) - (matrix[2][1] * x2_value)) / matrix[2][2];
        if (Math.abs(operation - x3_value) < epsilon) {
            error_3 = true;
        }
        x3_value = (float) operation;
        System.out.println("current x3:" + x3_value);
    }


    static void printMatrix(double[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(String.format("%.2f", mat[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void editArray(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //columnlarda dönme
        for (int j = 0; j < cols - 1; j++) {
            double maxValue = 0;
            double currentValue = 0;
            int bigRow = 0;
            int currentRow = j;
            //satırlarda dönme
            for (int i = 0; i < rows; i++) {
                currentValue = matrix[i][j];
                if (maxValue < currentValue) {
                    maxValue = currentValue;
                    bigRow = i;
                }
            }
            if (maxValue != matrix[j][j]) {
                swapRows(matrix, bigRow, currentRow);
            }

        }
        System.out.println("Düzenlenmiş matris:");
        printMatrix(matrix);
    }

    public static void swapRows(double[][] A, int bigRow, int currentRow) {
        double[] temp = A[currentRow];
        A[currentRow] = A[bigRow];
        A[bigRow] = temp;
    }


}
