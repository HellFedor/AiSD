package DoborAisd;

public class EuclideanAlgorithm {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else if (a == 0) {
            return b;
        } else if (a < b) {
            return gcd(b, a);
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 36;
        int result = gcd(a, b);
        System.out.println("НОД(" + a + ", " + b + ") = " + result);
    }
}