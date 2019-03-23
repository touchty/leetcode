package array;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int cows = 0;
        int bulls = 0;
        int[] counts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (counts[secret.charAt(i) - '0']++ < 0) cows++;
                if (counts[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }


    public static void main(String[] args) {
        String secret = "1123", guess = "0111";
        System.out.println(getHint(secret, guess));
    }
}
