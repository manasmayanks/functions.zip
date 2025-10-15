public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[Math.max(a.length, b.length)];
        for (int i = 0; i < result.length; i++) {
            double x = i < a.length ? a[i] : 0;
            double y = i < b.length ? b[i] : 0;
            result[i] = x + y;
        }
        return result;
    }

    public static double[] normalize(double[] a) {
        double max = 0;
        for (double v : a) {
            if (Math.abs(v) > max) max = Math.abs(v);
        }
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] / max;
        }
        return result;
    }

    public static double[] mix(double[] a, double[] b) {
        double[] result = new double[Math.max(a.length, b.length)];
        for (int i = 0; i < result.length; i++) {
            double x = i < a.length ? a[i] : 0;
            double y = i < b.length ? b[i] : 0;
            result[i] = (x + y) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] sample1 = StdAudio.read(args[0]);
        double[] sample2 = StdAudio.read(args[1]);

        double[] collage = normalize(mix(reverse(sample1), amplify(sample2, 0.5)));
        StdAudio.play(collage);
    }
}
