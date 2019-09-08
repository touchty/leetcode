package HRQuestion.iqiyi;

public class Q1 {
    long rr(int r, int b) {
        if (r <= 1)
            return 0;
        else
            return (long)r*(r-1);
    }

    long bb(int r, int b) {
        if (b <= 1)
            return 0;
        else
            return (long)b*(b-1);
    }

    long rb(int r, int b) {
        if (r <= 0 || b <= 0)
            return 0;
        else
            return (long) r*b;
    }

    long aWin(int r, int b) {
        // c-r
        long count1 = 0;
        if (r <= 1)
            count1 = 0;
        else
            count1 = r *

    }
}
