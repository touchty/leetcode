package array;

import java.util.*;

class TheSkylineProblem {
    public static List<int[]> getSkyline(int[][] buildings) {
        Set<Integer> criticalPoints = new HashSet<>();
        List<int[]> list = new ArrayList<>();

        for (int[] arr : buildings){
            criticalPoints.add(arr[0]);
            criticalPoints.add(arr[1]);
        }

        int[] xArray = new int[criticalPoints.size()];
        int pos = 0;
        for (int i : criticalPoints){
            xArray[pos++] = i;
        }

        Arrays.sort(xArray);
        int[] yArray = new int[xArray.length];

        for (int i = 0; i < buildings.length; i++) {
            for (int j = 0; j < xArray.length; j++) {
                if (buildings[i][0] <= xArray[j] && xArray[j] < buildings[i][1]){
                    yArray[j] = Math.max(yArray[j], buildings[i][2]);
                }
            }
        }

        int[][]xy = new int[xArray.length][2];
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < xArray.length; i++) {
            if (yArray[i] != prev){
                list.add(new int[]{xArray[i],yArray[i]});
            }
            /*xy[i][0] = xArray[i];
            xy[i][1] = yArray[i];*/
            prev = yArray[i];
        }
        //return xy;
        return list;
    }

    public static List<int[]> getSkylineOpt(int[][] buildings) {
        Set<Integer> criticalPoints = new HashSet<>();
        List<int[]> list = new ArrayList<>();

        for (int[] arr : buildings){
            criticalPoints.add(arr[0]);
            criticalPoints.add(arr[1]);
        }

        int[] xArray = new int[criticalPoints.size()];
        int pos = 0;
        for (int i : criticalPoints){
            xArray[pos++] = i;
        }

        Arrays.sort(xArray);
        int[] yArray = new int[xArray.length];

        for (int i = 0; i < buildings.length; i++) {
            // binary search
            int lo = Arrays.binarySearch(xArray, buildings[i][0]);
            int hi = Arrays.binarySearch(xArray, buildings[i][1]);

            if (lo < 0) lo = -1 * (lo + 1);

            if (hi < 0) hi = -1 * (hi + 1);
            else hi = hi - 1;

            for (int j = lo; j <= hi; j++){
                yArray[j] = Math.max(yArray[j], buildings[i][2]);
            }
        }

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < xArray.length; i++) {
            if (yArray[i] != prev){
                list.add(new int[]{xArray[i],yArray[i]});
            }
            prev = yArray[i];
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] buildings  = new int[][]{ {2, 9 ,10}, {3, 7, 15},
                {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};

        //int[][] res = TheSkylineProblem.getSkyline(buildings);
        List<int[]> list = TheSkylineProblem.getSkyline(buildings);
        for (int[] point : list){
            System.out.println(point[0] + "--" + point[1]);
        }
    }
}