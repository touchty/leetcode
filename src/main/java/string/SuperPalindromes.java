package string;

public class SuperPalindromes {
    public int superpalindromesInRange(String L, String R) {
        Long l = Long.valueOf(L), r = Long.valueOf(R);
        int result = 0;
        for (long i = (long) Math.sqrt(l); i * i <= r; ) {
            long p = nextP(i);
            if (p * p <= r && isP(p * p)) {
                result++;
            }
            i = p + 1;
        }
        return result;
    }

    private long nextP(long l) {
        String s = Long.toString(l);
        int N = s.length();
        String half = s.substring(0, (N + 1) / 2);
        String reverse = new StringBuilder(half.substring(0, N / 2)).reverse().toString();
        long first = Long.valueOf(half + reverse);
        if (first >= l) return first;
        String nexthalf = Long.toString(Long.valueOf(half) + 1);
        String reverseNextHalf = new StringBuilder(nexthalf.substring(0, N / 2)).reverse().toString();
        long second = Long.valueOf(nexthalf + reverseNextHalf);
        return second;

    }

    private boolean isP(long l) {
        String s = "" + l;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
