package array;

public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] edges = new int[6][2];
        edges[0] = new int[]{p1[0] - p2[0], p1[1] - p2[1]};
        edges[1] = new int[]{p1[0] - p3[0], p1[1] - p3[1]};
        edges[2] = new int[]{p1[0] - p4[0], p1[1] - p4[1]};
        edges[3] = new int[]{p2[0] - p3[0], p2[1] - p3[1]};
        edges[4] = new int[]{p2[0] - p4[0], p2[1] - p4[1]};
        edges[5] = new int[]{p3[0] - p4[0], p3[1] - p4[1]};

        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (edges[i][0] == 0 && edges[i][0] == edges[i][1])
                return false;
            for (int j = i + 1; j < 6; j++) {
                if (edges[i][0] * edges[j][0] + edges[i][1] * edges[j][1] == 0)
                    count++;
            }

        }

        return count == 5;
    }

    public static void main(String[] args) {
        /*int[]p1 = {0,0};
        int[]p2 = {1,1};
        int[]p3 = {1,1};
        int[]p4 = {0,1};*/

        int[] p1 = {6, 0};
        int[] p2 = {2, 4};
        int[] p3 = {9, 8};
        int[] p4 = {2, 4};

        System.out.println(validSquare(p1, p2, p3, p4));
        System.out.println(validSquare(p4, p2, p3, p1));
        System.out.println(validSquare(p1, p3, p2, p4));
        System.out.println(validSquare(p3, p2, p1, p4));
    }
}
// 98%
