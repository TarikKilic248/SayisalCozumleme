public class IkiyeBolme {
    static double f(double x){
        return ((Math.exp(-x)) - Math.sin(((Math.PI)/2)*x));
    }

    static boolean is_roots_ok(float a1, float a2){
        if ((f(a1) * f(a2)) < 0){
            return true;
        }else{
            return false;
        }
    }

    static void find_root(float a1, float a2){
        double e = 0.001;
        float xy = (a1 + a2) / 2;
        if (is_roots_ok(a1,xy)){
            float result = Math.abs(a1 - xy);
            if (result > e){
                find_root(a1, xy);
            }
            else{
                System.out.println(xy);;
            }
        }
        if (is_roots_ok(xy, a2)){
            float result = Math.abs(xy - a2);
            if (result > e){
                find_root(xy, a2);
            }
            else{
                System.out.println(xy);;
            }
        }
    }

    public static void main(String[] args) {
        find_root(0, 1);
    }

}
