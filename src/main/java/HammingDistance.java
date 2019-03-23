public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        while (x != 0 || y != 0) {
            if ((x + y) != 1 && (x + y) % 2 == 0) {
                x /= 2;
                y /= 2;
                continue;
            }
            hammingDistance++;
            x /= 2;
            y /= 2;
        }

        return hammingDistance;
    }

    public int hammingDistanceOpt(int x, int y) {
        int hammingDistance = 0;
        int sum = x + y;
        while (sum != 0) {
            if (sum % 2 == 0) {
                x /= 2;
                y /= 2;
                sum = x + y;
                continue;
            }
            hammingDistance++;
            x /= 2;
            y /= 2;
            sum = x + y;
        }

        return hammingDistance;
    }

    public static void main(String[] args) {
        int i = HammingDistance.hammingDistance(1, 4);
    }
}
