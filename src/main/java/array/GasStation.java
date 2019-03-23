package array;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next
 * station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1.
 */
public class GasStation {
    /**
     * If car starts at A and can not reach B. Any station between A and B
     * can not reach B.(B is the first station that A can not reach.)
     * If the total number of gas is bigger than the total number of cost. There must be a solution.
     * proving: First load the car with the total amount gas. And distribute the gas to each station!
     * (Should I prove them?)
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return total + tank < 0 ? -1 : start;
    }
}
