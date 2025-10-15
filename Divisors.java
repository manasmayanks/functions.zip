public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void printDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("GCD: " + gcd(a, b));
        System.out.println("Is " + a + " prime? " + isPrime(a));
        System.out.println("Divisors of " + a + ":");
        printDivisors(a);
    }
}
