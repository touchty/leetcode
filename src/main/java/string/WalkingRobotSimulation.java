package string;

import java.util.*;

/**
 * 874. Walking Robot Simulation
 * Easy
 *
 * 57
 *
 * 337
 *
 * Favorite
 *
 * Share
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 *
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 *
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 *
 * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
 *
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 *
 *
 *
 * Example 1:
 *
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * Example 2:
 *
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 */

/*
Logical Thinking
The robot starts at point (0, 0) and faces north. Which edge of grid is to the north?
Since it will go to point (3, 4) with commands = [4,-1,3], obstacles = [], we know that the right edge is to the North.

     W
  S -|- N
     E
How do we represent absolute orientations given only relative turning directions(i.e., left or right)? We define
direction indicates the absolute orientation as below:

North, direction = 0, directions[direction] = {0, 1}
East,  direction = 1, directions[direction] = {1, 0}
South, direction = 2, directions[direction] = {0, -1}
West,  direction = 3, directions[direction] = {-1, 0}

direction will increase by one when we turn right,
and will decrease by one when we turn left.
In this way, if the robot faces South, i.e., its direction is 2, when it moves forward by one step, x += 0, y += -1 for
directions[2] = {0, -1}.
 */
public class WalkingRobotSimulation {
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> obstaclesRowToCols = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesRowToCols.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0, y = 0, direction = 1, maxDistSquare = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                direction--;
                if (direction < 0) {
                    direction += 4;
                }
            } else if (commands[i] == -1) {
                direction++;
                direction %= 4;
            } else {
                int step = 0;
                while (step < commands[i] && (!obstaclesRowToCols.contains((x + directions[direction][0]) + " " + (y + directions[direction][1])))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
        }
        return maxDistSquare;
    }
}
