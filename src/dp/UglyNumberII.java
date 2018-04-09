package dp;

public class UglyNumberII {
    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];

        //  definition ugly[0] = 1
        ugly[0] = 1;

        //  L_2: 1x2 2x2 3x2 4x2 5 6 8 9 10 12
        //  L_3: 1x3 2x3 3x3 4x3 5 6 8 9 10 12
        //  L_5: 1x5 2x5 3x5 4x5 5 6 8 9 10 12
        //
        int index2 = 0, index3 = 0, index5 = 0;

        //  update factor(i) to the next higher number
        //  familiar to merge sort
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            //  3 if clauses, in case encountering the same num in different line
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }

    public int nthUglyNumberRewrite(int n){
        int[] ugly = new int[n];

        ugly[0] = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);

            ugly[i] = min;

            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];

        }
        return ugly[n - 1];
    }

}
