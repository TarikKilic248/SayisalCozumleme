import java.lang.Math;

public class Main {
    
    public static void main(String[] args) {
        findRoot(3, 5, 0.008);
    }

    public static double f(double x) {
        return Math.pow(x, 3) - (20 * x) + 16;
    }

    public static boolean isRootsOk(double a1, double a2) {
        if ((f(a1) * f(a2)) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static double nextRoot(double x0, double x1, double y0, double y1) {
        return x0 - ((x1 - x0) / (y1 - y0)) * y0;
    }

    public static void findRoot(double x0, double x1, double e) {
        double y0 = f(x0);
        double y1 = f(x1);
        if (isRootsOk(x0, x1)) {
            double xn = nextRoot(x0, x1, y0, y1);
            double yn = f(xn);
            double result = Math.abs(xn - x1);
            while (result > e) {
                double xn_new = nextRoot(x0, xn, y0, yn);
                double yn_new = f(xn_new);
                result = Math.abs(xn_new - xn);
                xn = xn_new;
                yn = yn_new;
            }
            System.out.println(xn);

        } else if (isRootsOk(x1, x0)) {
            double xn = nextRoot(x0, x1, y0, y1);
            double yn = f(xn);
            double result = Math.abs(xn - x1);
            while (result > e) {
                double xn_new = nextRoot(x0, xn, y0, yn);
                double yn_new = f(xn_new);
                result = Math.abs(xn_new - xn);
                xn = xn_new;
                yn = yn_new;
            }
            System.out.println(xn);

        } else {
            System.out.println("Hata");
        }
    }
}
