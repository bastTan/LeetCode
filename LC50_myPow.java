
// implement x^n
// -x^n => n is even, +; n is odd, -
// n < 0 => result = 1 / result;
// n is even: half * half
// n is odd: half * half * x
//
// time: O(logn) since we divide the problem to its half each time with O(1)
public static double myPow(double x, int n) {
    if (x == 0 ) throw new IllegalArgumentException();
    if (n == 0) return 1;

    double half = myPow(x, n/2);
    double result;

    // only need to check n < 0 at base case: n == 1 is enough
    if (n % 2 == 0) {
        return half * half;
    }
    else {
        return n < 0? 1/x * half * half : x * half * half;
    }
}

