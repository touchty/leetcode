package meituan0423;

import java.util.*;

/*
Test2 格子染色
无限大的二维网格, 给出 n 对起始点和终点的坐标
染色两个坐标区间内的格子(含起始点终点), 交叉部分算一次, 求共染色多少个格子
给出的坐标如果横坐标相等, 是一条横线; 如果纵坐标相等, 是一条竖线

构造线段存储结构 Interval 包含起点和终点 start end
构造一个直线(横或者纵)上的存储结构 Line 包含横坐标或纵坐标 index 以及 不重合的线段区间 list , 表示 x(或者y) = index 这条直线上有几个不重合的线段
对每一条横线段或者竖线段, 都放入到对应的直线的 list 中去, 此时每个线段可能有重合
对每一条直线上的线段集合进行合并(参见leetcode 56 区间合并), 构造内部线段不重合且排好序的直线存储, 此时所有水平与水平重合的点, 竖直与竖直重合的点全部去重完毕
对所有的横直线按照 index 排序, 同时对所有的竖直线按照 index 排序
计算横直线和竖直线中的每条线段包含的点的总数, 因为对线段进行了合并操作, 所以此时所有的交叉点只会重复计算了两次
计算交叉点的个数, 计算方法如下:
对每一条横直线, 求出该横直线与所有的的竖直线有多少个交叉点
对一条横直线的所有线段(内部线段已经排好序)和所有的竖直线, 如果竖直线的 index 在某条线段的起点和终点之间, 则可能存在交叉(如果交叉, 只有一个交叉点), 否则不可能
所有线段从起点最小的开始, 所有竖直线从 index 最小的开始
如果当前竖直线 index 小于当前线段起点, 竖直线后移
如果当前竖直线 index 大于当前线段终点, 线段后移
当前竖直线 index 在当前线段起点和终点之前, 判断当前线段与当前竖直线中的线段是否相交, 相交则交叉点个数加 1, 同时无论是否相交, 竖直线都要后移
点的总数减去交叉点总数
 */
public class ColorGrid {
    static class Line {
        int index;
        List<Interval> list = null;

        Line(int index, List<Interval> list) {
            this.index = index;
            this.list = list;
        }
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{start: " + start + ", end: " + end + "}";
        }
    }

    private static void addInterval(Map<Integer, List<Interval>> map, int key, int t1, int t2) {
        if (!map.containsKey(key)) {
            List<Interval> list = new ArrayList<>();
            list.add(new Interval(Math.min(t1, t2), Math.max(t1, t2)));
            map.put(key, list);
        } else {
            map.get(key).add(new Interval(Math.min(t1, t2), Math.max(t1, t2)));
        }
    }

    private static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for (Interval now : intervals) {
            if (prev == null || now.start > prev.end) {
                res.add(now);
                prev = now;
            } else if (now.end > prev.end) {
                prev.end = now.end;
            }
        }
        return res;
    }

    private static List<Line> generateLine(Map<Integer, List<Interval>> map) {
        List<Line> lines = new ArrayList<>();
        for (Map.Entry<Integer, List<Interval>> e : map.entrySet()) {
            lines.add(new Line(e.getKey(), merge(e.getValue())));
        }
        Collections.sort(lines, (o1, o2) -> (o1.index - o2.index));
        return lines;
    }

    private static int getPointCount(List<Line> lines) {
        int cnt = 0;
        for (Line line : lines) {
            for (Interval item : line.list) {
                cnt += item.end - item.start + 1;
            }
        }
        return cnt;
    }

    private static int getCrossPointCount(List<Line> rowLines, List<Line> colLines) {
        int cnt = 0;
        for (Line rowLine : rowLines) {
            int i = 0, j = 0;
            List<Interval> list = rowLine.list;
            while (i < list.size() && j < colLines.size()) {
                int colIndex = colLines.get(j).index;
                int rowStart = list.get(i).start, rowEnd = list.get(i).end;
                if (colIndex >= rowStart && colIndex <= rowEnd) {
                    if (isCross(rowLine.index, colLines.get(j).list)) {
                        cnt++;
                    }
                    j++;
                } else if (colIndex < rowStart) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return cnt;
    }

    private static boolean isCross(int index, List<Interval> list) {
        int s = 0, e = list.size() - 1;
        while (s < e) {
            int m = (s + e) >> 1;
            Interval interval = list.get(m);
            if (index >= interval.start && index <= interval.end) return true;
            if (index < interval.start) e = m - 1;
            else s = m + 1;
        }
        return (index >= list.get(s).start && index <= list.get(s).end);
    }

    public static void main(String[] args) {

        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Interval>> rowMap = new HashMap<>();
        Map<Integer, List<Interval>> colMap = new HashMap<>();
        while (n-- > 0) {
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();
            if (x1 == x2) {
                addInterval(rowMap, x1, y1, y2);
            } else if (y1 == y2) {
                addInterval(colMap, y1, x1, x2);
            }
        }*/
        Map<Integer, List<Interval>> rowMap = new HashMap<>();
        Map<Integer, List<Interval>> colMap = new HashMap<>();
        int n = 4;
        int[][][] points = {{{1, 2}, {2, 2}}, {{2, 2}, {3, 2}}, {{3, 1}, {3, 2}}, {{3, 2}, {3, 3}}};
        for (int[][] p2 : points) {
            int[] n1 = p2[0];
            int[] n2 = p2[1];
            int x1 = n1[0];
            int y1 = n1[1];
            int x2 = n2[0];
            int y2 = n2[1];
            if (x1 == x2) {
                addInterval(rowMap, x1, y1, y2);
            } else if (y1 == y2) {
                addInterval(colMap, y1, x1, x2);
            }
        }

        System.out.println(rowMap);
        System.out.println(colMap);
        List<Line> rowLines = generateLine(rowMap);
        List<Line> colLines = generateLine(colMap);

        int pointCount = getPointCount(rowLines) + getPointCount(colLines);

        int crossPointCount = getCrossPointCount(rowLines, colLines);

//        System.out.println(pointCount);
//        System.out.println(crossPointCount);
        System.out.println(pointCount - crossPointCount);
    }
}
