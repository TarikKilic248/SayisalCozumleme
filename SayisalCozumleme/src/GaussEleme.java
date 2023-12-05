import java.util.Scanner;

public class GaussEleme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] A = new double[3][3];
        double[] B = new double[3];
        System.out.println("Enter the coefficients of the 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Enter the constants of the equations:");
        for (int i = 0; i < 3; i++) {
            B[i] = sc.nextDouble();
        }
        sc.close();
        solve(A, B);
    }

    public static void solve(double[][] A, double[] B) {
        int N = B.length;
        for (int k = 0; k < N; k++) {
            int max = k;
            for (int i = k + 1; i < N; i++) {
                if (Math.abs(A[i][k]) > Math.abs(A[max][k])) {
                    max = i;
                }
            }
            double[] temp = A[k];
            A[k] = A[max];
            A[max] = temp;
            double t = B[k];
            B[k] = B[max];
            B[max] = t;
            for (int i = k + 1; i < N; i++) {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++) {
                    A[i][j] -= factor * A[k][j];
                }
            }
        }
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * solution[j];
            }
            solution[i] = (B[i] - sum) / A[i][i];
        }
        System.out.println("The solution is:");
        for (int i = 0; i < N; i++) {
            System.out.println(solution[i]);
        }
    }
}
