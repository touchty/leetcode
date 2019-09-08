package HRQuestion.iqiyi;

public class Q2 {
    long rr(int r, int b) {
        if (r <= 1)
            return 0;
        else
            return (long) r * (r - 1);
    }

    long bb(int r, int b) {
        if (b <= 1)
            return 0;
        else
            return (long) b * (b - 1);
    }

    long rb(int r, int b) {
        if (r <= 0 || b <= 0)
            return 0;
        else
            return (long) r * b;
    }

    double aWin(int r, int b) {
        // c-r
        long count1 = 0;
        if (r == 0)
            count1 = 0;
        else {
            if (r + b - 2 > 0)
                count1 += r * b * (r + b - 2);
        }

        // c-b
        long count2 = 0;
        if (b == 0)
            count2 = 0;
        else if (b == 1) {
            count2 += 0;
        } else {
            if (r + b - 2 > 0)
                count2 += b * (b - 1) * (r + b - 2);
        }

        long total = (r + b) * (r + b - 1) * (r + b - 2);
        double lose = (double) (count1 + count2 + 0.0) / total;
        double win = 1 - lose;
        return win;
    }

    public static void main(String[] args) {
        int r = 3;
        int b = 4;
        Q2 s = new Q2();
        System.out.println(s.aWin(r, b));
    }
}
