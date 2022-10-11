package leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class Flood_Fill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {


        int oldColor = image[sr][sc];

        if (oldColor == color)
            return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});


        while (!queue.isEmpty()) {
            int[] pixel = queue.remove();
            sr = pixel[0];
            sc = pixel[1];


            if (isValid(image, sr, sc) && image[sr][sc] == oldColor) {
                image[sr][sc] = color;
                queue.add(new int[]{sr - 1, sc});
                queue.add(new int[]{sr + 1, sc});
                queue.add(new int[]{sr, sc - 1});
                queue.add(new int[]{sr, sc + 1});
            }
        }

        return image;
    }

    private static boolean isValid(int[][] image, int sr, int sc) {
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[sr].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        grid = floodFill(grid, 1, 1, 2);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}
