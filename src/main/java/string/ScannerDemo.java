package string;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        String str = "1-2+3-4+5-6+7";
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("(?=[-+])");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
