public class GaussEleme2 {
    public static void main(String[] args) {
        double[][] matrix = {
                {2, 1, -1, 8},
                {3, 2, 1, 11},
                {1, 1, 1, 4}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Başlangıç Matrisi:");
        printMatrix(matrix);

        for (int i = 0; i < rows; i++) {
            // Pivot elemanı 1 yapma
            double pivot = matrix[i][i];
            for (int j = i; j < cols; j++) {
                matrix[i][j] /= pivot;
            }
            System.out.println("Pivot elemanı 1 yapılıyor (Satır " + i + "):");
            printMatrix(matrix);

            // Diğer satırlardan pivot sütununu çıkart
            for (int k = i + 1; k < rows; k++) {
                    double factor = matrix[k][i];
                    for (int j = i; j < cols; j++) {
                        matrix[k][j] -= factor * matrix[i][j];

                }
            }
            System.out.println("Diğer satırlardan pivot sütununu çıkartma (Satır " + i + " hariç):");
            printMatrix(matrix);
        }

        System.out.println("Sonuç (Tersine Çevrilen Matris):");
        printMatrix(matrix);

        double x3 = matrix[2][3];
        double x2 = (matrix[1][3] - (matrix[1][2] * x3));
        double x1 = (matrix[0][3] - (matrix[0][1] * x2) - (matrix[0][2] * x3));

        System.out.print(String.format("X3 = " + "%.2f", x3));
        System.out.println();
        System.out.print(String.format("X2 = " + "%.2f", x2));
        System.out.println();
        System.out.print(String.format("X1 = " + "%.2f", x1));


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
}

