public class GaussEleme3 {
    static final double[][] arr = {
            {10, 2, 1, 7},
            {1, 5, 1, -8},
            {2, 3, 10, 6}
    };
    static final double epsilon = 0.001;
    static boolean error_1 = false;
    static boolean error_2 = false;
    static boolean error_3 = false;

    static float x1_value = 0;
    static float x2_value = 0;
    static float x3_value = 0;

    static boolean checkError() {
        return !(error_1 && error_2 && error_3);
    }

    static void calc_x1() {
        System.out.println(x2_value);
        System.out.println(x3_value);
        double result = arr[0][3];
        double operation = (result - (arr[0][1] * x2_value) - (arr[0][2] * x3_value)) / arr[0][0];
        if (Math.abs(operation - x1_value) < epsilon) {
            error_1 = true;
        }
        x1_value = (float) operation;
        System.out.println("current x1:" + x1_value);
    }

    static void calc_x2() {
        System.out.println(x1_value);
        System.out.println(x3_value);
        double result = arr[1][3];
        double operation = (result - (arr[1][0] * x1_value) - (arr[1][2] * x3_value)) / arr[1][1];
        if (Math.abs(operation - x2_value) < epsilon) {
            error_2 = true;
        }
        x2_value = (float) operation;
        System.out.println("current x2:" + x2_value);
    }

    static void calc_x3() {
        System.out.println(x1_value);
        System.out.println(x2_value);
        double result = arr[2][3];
        double operation = (result - (arr[2][0] * x1_value) - (arr[2][1] * x2_value)) / arr[2][2];
        if (Math.abs(operation - x3_value) < epsilon) {
            error_3 = true;
        }
        x3_value = (float) operation;
        System.out.println("current x3:" + x3_value);
    }

    public static void main(String[] args) {
        System.out.println(arr[0][3]);
        System.out.println(arr[1][3]);
        System.out.println(arr[2][3]);
        calc_x1();
        calc_x2();
        calc_x3();
        System.out.println("=========================");
        calc_x1();
        calc_x2();
        calc_x3();
        System.out.println("=========================");
        calc_x1();
        calc_x2();
        calc_x3();
        System.out.println("=========================");
        calc_x1();
        calc_x2();
        calc_x3();
        System.out.println("=========================");
        do {
            calc_x1();
            calc_x2();
            calc_x3();
        } while (checkError());
    }
}

