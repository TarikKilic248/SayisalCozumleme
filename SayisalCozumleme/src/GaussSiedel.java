public class GaussSiedel {
    public static void main(String[] args) {
        double[][] mat = {
                {1, 4, 0, 3, 8},
                {3, 2, 1, 0, 6},
                {1, 1, 1, 5, 8},
                {1, 0, 2, 1, 4},
        };
        GaussSiedel gaussSiedel = new GaussSiedel(mat);
        gaussSiedel.Pivotlama();
        gaussSiedel.solve(0.04);
    }

    public double[][] mat;

    public GaussSiedel(double[][] mat) {
        this.mat = mat;
    }

    public void solve(double errorMargin) {
        // Printing Table header
        System.out.printf("%-8s", "N");
        for (int i = 0; i < mat.length; i++) {
            System.out.printf("%-25s", "X" + (i + 1));
        }
        System.out.println();
        System.out.println("-".repeat(25 * mat.length));
        int n = 1;

        int tempIndex = 0;
        double[] oldAnswers = new double[mat.length];
        boolean[] correctAnswers = new boolean[mat.length];
        while (true) {
            double temp = mat[tempIndex][mat.length];
            // Loop over current row's columns
            for (int i = 0; i < mat.length; i++) {
                // Check if the current loop is on the current variable
                if (i == tempIndex) {
                    continue;
                }
                // Adding the other variables
                temp = temp - (mat[tempIndex][i] * oldAnswers[i]);
            }

            double x = temp / mat[tempIndex][tempIndex];

            // Check if the error margin is below the allowed error margin
            if (Math.abs(x - oldAnswers[tempIndex]) < errorMargin) {
                correctAnswers[tempIndex] = true;
            }

            // Assign the variable new value to the oldAnswers array
            oldAnswers[tempIndex] = x;

            // Check if all answers are under the allowed error margin
            if (isAllItemsAreTrue(correctAnswers)) {
                break;
            }

            // Print current Answers if a full loop occur
            if ((tempIndex + 1) == 4) {
                printArray(oldAnswers, n);
                n++;
            }

            // Increase the index but keep it under 4
            tempIndex = (tempIndex + 1) % 4;
        }
    }

    public void Pivotlama() {
        for (int i = 0; i < mat.length; i++) {
            int currentVariableBiggestElementIndex = i;

            // Check for bigger element in order to sort our Matrix
            for (int j = i; j < mat.length; j++) {
                if (mat[i][currentVariableBiggestElementIndex] < mat[j][i]) {
                    currentVariableBiggestElementIndex = j;
                }
            }

            // Swap rows if sort is needed
            if (currentVariableBiggestElementIndex != i) {
                swapRows(currentVariableBiggestElementIndex, i);
            }
        }
        // Print array after pivotlama
        print2DArray();
    }


    private void swapRows(int fromIndex, int toIndex) {
        for (int i = 0; i < mat.length + 1; i++) {
            double temp = mat[toIndex][i];
            mat[toIndex][i] = mat[fromIndex][i];
            mat[fromIndex][i] = temp;
        }
    }

    private boolean isAllItemsAreTrue(boolean[] answers) {
        boolean temp = true;
        for (boolean answer : answers) {
            temp = temp && answer;
        }
        return temp;
    }

    private void print2DArray() {
        System.out.println("The 2D array is: ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length + 1; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void printArray(double[] mat, int n) {
        System.out.printf("%-8s", n);
        for (double v : mat) {
            System.out.printf("%-25s", v + " , ");
        }
        System.out.println();
    }

}
