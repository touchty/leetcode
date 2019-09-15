package HRQuestion.wangyileihuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q3 {
    static int delays(int[] currTask, List<int[]> preTasks, int start) {
        if (preTasks.size() == 0)
            return 0;

        int sum = 0;

        for (int[] task : preTasks) {
            sum += task[1];
        }
        int[] newLast = preTasks.remove(preTasks.size() - 1);
        int delayPre = delays(newLast, preTasks, start);

        if (sum <= currTask[0] - start) {
            return delayPre;
        } else {
            return delayPre + sum - (currTask[0] - start);
        }
    }

    static int delaysDP(int[][] tasks) {
        int[][] dp = new int[tasks.length][tasks.length];
        return 0;

    }

    public static void main(String[] args) {
        /*int[][] tasks = {{3, 3}, {8, 1}, {3, 2}};
        Arrays.sort(tasks, ((o1, o2) -> o1[0] - o2[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] a : tasks) {
            list.add(a);
        }
        list.remove(list.size() - 1);
        int delay = delays(tasks[0], list, 0);
        System.out.println(delay);*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int[][] tasks = new int[N][2];
            for (int i = 0; i < N; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }
            Arrays.sort(tasks, ((o1, o2) -> o1[0] - o2[0]));
            List<int[]> list = new ArrayList<>();
            for (int[] a : tasks) {
                list.add(a);
            }
            list.remove(list.size() - 1);
            int delay = delays(tasks[0], list, 0);
            System.out.println(delay);
        }
    }
}
