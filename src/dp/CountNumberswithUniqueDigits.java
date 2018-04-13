package dp;

public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

    public int countNumbersWithUniqueDigitsRe(int n) {
        if(n == 0)
            return 1;

        int result = 10;

        int range = 9;
        int tmp = 9;
        while ( n-- > 1 && range > 0){
            tmp *= range;
            result += tmp;
            range--;
        }

        return result;
    }
}
