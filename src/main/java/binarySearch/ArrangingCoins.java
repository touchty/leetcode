package binarySearch;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int l = 0, h = n;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            long count = mid * (mid + 1L) / 2;
            if (count == n) {
                return mid;
            }
            if (count < n) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h;
    }
}
