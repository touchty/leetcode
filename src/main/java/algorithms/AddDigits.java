package algorithms;

class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = 0;
            while (num >= 10) {
                temp += num % 10;
                num /= 10;
            }
            temp += num;
            num = temp;
        }
        return num;
    }

    public int addDigitsOpt(int num) {

        if (num < 10) {
            return num;
        }

        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return addDigitsOpt(sum);
    }
}