package com.rmlowe.maxrect;

public class MaxRect {
    public static void main(String[] args) {
//        int[] result = findLargestRectangle(new int[]{1, 3, 5, 3, 0, 2, 6, 6, 1, 0, 3, 6});
//        int[] result = findLargestRectangle(new int[]{1, 3, 5, 3, 2, 2, 3, 3, 1, 0, 3, 6});
//        int[] result = findLargestRectangle(new int[]{1, 3, 2, 1, 2});
        int[] result = findLargestRectangle(new int[]{1, 2, 1, 3, 2, 0, 1});
        System.out.println("Start: " + result[0]);
        System.out.println("End: " + result[1]);
        System.out.println("Area: " + result[2]);
    }

    private static int[] findLargestRectangle(int[] hist) {
        int[][] heights = computeHeights(hist);
        int largestStart = -1;
        int largestEnd = -1;
        int largestArea = -1;

        for (int end = 0; end < hist.length; end++) {
            for (int start = 0; start <= end; start++) {
                int area = (end + 1 - start) * heights[end][start];
                if (area > largestArea) {
                    largestArea = area;
                    largestStart = start;
                    largestEnd = end;
                }
            }
        }

        return new int[]{largestStart, largestEnd, largestArea};
    }

    private static int[][] computeHeights(int[] hist) {
        int[][] result = new int[hist.length][];

        for (int end = 0; end < hist.length; end++) {
            int[] heights = new int[end + 1];

            for (int start = 0; start < end; start++) {
                heights[start] = Math.min(result[end - 1][start], hist[end]);
            }

            heights[end] = hist[end];
            result[end] = heights;
        }

        return result;
    }
}
