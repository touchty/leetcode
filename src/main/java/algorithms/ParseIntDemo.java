package algorithms;

/*
"multi" return values
 */
public class ParseIntDemo {
    public static void main(String[] args) {
        //int res = Integer.parseInt("12");
        //System.out.println(res);
        int[] result = foo("a12");
        if (result[1] == -1)
            System.out.println("parsing unsuccessful");
        else {
            System.out.println("parsing result is " + result[0]);
        }
    }

    static int[] foo(String digits) {
        int[] parsingResult = new int[2];
        try {
            parsingResult[0] = Integer.parseInt(digits);
        } catch (NumberFormatException e) {
            parsingResult[1] = -1;
        }

        return parsingResult;
    }
}
