public class GaussSiedel_4 {
    static double errVal = 0.001;
    static double[][] array = {{0, 0, 0}, {0, 0, 0}};

    public static void main(String[] args) {
        GaussSiedel_4 gaussSiedel = new GaussSiedel_4();
        double[][] arr = gaussSiedel.getArr2DimensionData();
        double[] arrResult = gaussSiedel.getArrResultData();
        gaussSiedel.pivotlama(arr, arrResult);
        gaussSiedel.solve(arr, arrResult, array);
        gaussSiedel.printXArrValue(array);
    }

    void solve(double arr[][], double arrResult[], double xArr[][]) {
        for (int i = 0; i < arr.length; i++) {
            double minusVal = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    minusVal += arr[i][j] * xArr[1][j];
                }

            }
            xArr[1][i] = (arrResult[i] - minusVal) / arr[i][i];
            boolean result = isAllXValuesSmallerThenErrVal(xArr);
            printXArrValue(xArr);
            if (result) {
                System.exit(0);
            }
        }
        cloneNewValuesToOldOne(xArr);
        solve(arr, arrResult, xArr);
    }

    void cloneNewValuesToOldOne(double xArr[][]) {
        xArr[0][0] = xArr[1][0];
        xArr[0][1] = xArr[1][1];
        xArr[0][2] = xArr[1][2];

    }

    static boolean isAllXValuesSmallerThenErrVal(double xArr[][]) {
        for (int i = 0; i < xArr.length; i++) {
            if (!isSmallerThenErrVal(xArr[0][i], xArr[1][i])) {
                return false;
            }
        }
        return true;
    }

    static boolean isSmallerThenErrVal(double a, double b) {
        if (errVal >= Math.abs((a - b))) {
            return true;
        }
        return false;
    }

    double[][] getArr2DimensionData() {
        double[][] arr2D = {
                {10, 2, 1},
                {1, 5, 1},
                {2, 3, 10}
        };
        return arr2D;
    }

    double[] getArrResultData() {
        double arr[] = {7, -8, 6};
        return arr;
    }

    public void pivotlama(double arr[][], double arrResult[]) {
        for (int j = 0; j < arr.length; j++) {
            int newI = j, newJ = j;

            for (int i = j; i < arr.length; i++) {
                if (arr[i][j] > arr[newI][newJ]) {
                    newI = i;
                    newJ = j;
                }
            }
            if (j != newI) {
                changeArrIndex(arr, arrResult, j, newI);
            }
        }
    }

    public void changeArrIndex(double arr[][], double arrResult[], int firstIndex, int secondIndex) {
        double[] arrTempRow = new double[arr[0].length];
        for (int i = firstIndex; i <= firstIndex; i++) {
            try {
                throw new Exception("\nPivotlamam islemi simdilik atlanildi. ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    static void printXArrValue(double xArr[][]) {
        System.out.println("-----------------");
        for (int i = 0; i < xArr[0].length; i++) {
            System.out.println("Degerler" + (i + 1) + " : " + xArr[1][i]);
        }
    }

}