package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// LC 	296	 Best Meeting Point
// 对水平位置和垂直位置进行排序， 取中间值
// 两个中间值做为中间位置
// 再计算总距离
public class BestMeetingPoint {
    public static int minTotalDistance(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;

        List<Integer> horizonal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    horizonal.add(i);
                    vertical.add(j);
                }
            }
        }
        Collections.sort(horizonal);
        Collections.sort(vertical);

        int posX = horizonal.get(horizonal.size() / 2);
        int posY = vertical.get(vertical.size() / 2);

        int path = 0;
        for (int x : horizonal) {
            path += Math.abs(x - posX);
        }

        for (int y : vertical) {
            path += Math.abs(y - posY);
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};

        int[][] grid2 = {{1, 0, 1, 0, 1},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0}};
        BestMeetingPoint s = new BestMeetingPoint();
        int path = s.minTotalDistance(grid);
        int path2 = s.minTotalDistance(grid2);
        System.out.println(path);
        System.out.println(path2);
    }
}
