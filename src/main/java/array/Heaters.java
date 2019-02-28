package array;

import java.util.Arrays;

/*
475. Heaters
Easy

440

462

Favorite

Share
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all
the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all
houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum
radius standard of heaters.
 */
public class Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for (int house : houses) {
            // house is closer to heater[i]
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3};
        int[] heaters = {2, 5};
        int radius = findRadius(houses, heaters);
        System.out.println(radius);
    }
}
