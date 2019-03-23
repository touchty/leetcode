package array;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            // If the current assteroid is positive, add to the stack and
            // start the next loop
            if (stack.isEmpty() || a[i] > 0) {
                stack.push(a[i]);
                continue;
            }

            // notice the always true loop
            // asteroid travel to the left
            while (true) {
                int prev = stack.peek();
                // the same directions, just push it
                if (prev < 0) {
                    stack.push(a[i]);
                    break;
                }

                // both are eliminated
                if (prev == -a[i]) {
                    stack.pop();
                    break;
                }
                // only the current asteroid is eliminated
                if (prev > -a[i]) {
                    break;
                }
                // prev is is eliminated, and then keep going left.
                // keep peek the stack and check the prev in the same manner.
                stack.pop();
                // if there is no asteroid in the left, add the current negative asteroid
                if (stack.isEmpty()) {
                    stack.push(a[i]);
                    break;
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] asteroids = {-5, 10, -25};
        int[] expected = {-5, -25};
        int[] result = asteroidCollision.asteroidCollision(asteroids);
        Assert.assertArrayEquals(expected, result);
    }
}
