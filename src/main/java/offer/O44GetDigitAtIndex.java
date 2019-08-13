package offer;

public class O44GetDigitAtIndex {
    /**
     * place 位数的起始数字
     * 0, 10, 100, ...
     */
    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }

    /**
     * place 位数的数字组成的字符串长度
     * 10, 90, 900, ...
     */
    private int getAmountOfPlace(int place) {
        // 0..9 10位
        // 10...99 90位
        if (place == 1)
            return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }

    /**
     * 在 place 位数组成的字符串中，第 index 个数
     * place = 3: 100 101 102 ... 999
     * index = 4
     * return 1
     */
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }


    // 0 1 2 3 ... 9 10 11 12 ..99 100
    // 字符串中第index位的值，第一位是0，第11位是1，第十二位是0
    public int getDigitAtIndex(int index) {
        if (index < 0)
            return -1;
        int place = 1;  // 1 表示个位，2 表示 十位...
        while (true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount * place;
            if (index < totalAmount)
                return getDigitAtIndex(index, place);
            index -= totalAmount;
            place++;
        }
    }

    public static void main(String[] args) {
        O44GetDigitAtIndex solution = new O44GetDigitAtIndex();
        int[] digits = new int[300];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = solution.getDigitAtIndex(i);
            System.out.print(digits[i]);
        }

    }

}
