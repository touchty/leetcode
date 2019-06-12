package test;

import java.util.HashMap;
import java.util.Map;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                if (map.get(guess.charAt(i)) == 1)
                    map.remove(guess.charAt(i));
                else map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            } else {
                if (map.containsKey(guess.charAt(i))) {
                    cow++;
                    if (map.get(guess.charAt(i)) == 1)
                        map.remove(guess.charAt(i));
                    else map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(bull).append('A').append(cow).append('B');
        return builder.toString();
    }

    public String getHintOpt(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++; // secret has the same char
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++; // guess has the same char
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        String s = "1122";
        String guess = "1222";
        BullsandCows solution = new BullsandCows();
        String res = solution.getHint(s, guess);
        System.out.println(res);
    }
}
