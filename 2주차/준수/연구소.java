import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int maxSafeArea = 0;

    static public class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void initWall(int[][] map, int wall) {

        if (wall == 3) {
            int safeCount = 0;
            int[][] copyMap = new int[map.length][map[0].length];
            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[0].length; x++) {
                    copyMap[y][x] = map[y][x];
                }
            }

            copyMap = bfs(copyMap);

            for (int i = 0; i < copyMap.length; i++) {
                for (int j = 0; j < copyMap[0].length; j++) {
                    if (copyMap[i][j] == 0) {
                        safeCount++;
                    }
                }
            }

            if (maxSafeArea < safeCount) {
                maxSafeArea = safeCount;
            }
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    initWall(map, wall + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    public static int[][] bfs(int[][] map) {
        int[][] visit = new int[map.length][map[0].length];
        int[] dirX = { 0, 1, -1, 0 };
        int[] dirY = { 1, 0, 0, -1 };
        Queue<Point> q = new LinkedList<Point>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    q.add(new Point(i, j));
                    visit[i][j] = 1;
                    map[i][j] = 2;
                }
            }
        }

        while (!q.isEmpty()) {
            Point top = q.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = top.getX() + dirX[i];
                int tempY = top.getY() + dirY[i];
                if (tempX >= 0 && tempY >= 0 && tempX < map.length && tempY < map[0].length && visit[tempX][tempY] == 0
                        && map[tempX][tempY] == 0) {
                    q.add(new Point(tempX, tempY));
                    visit[tempX][tempY] = 1;
                    map[tempX][tempY] = 2;
                }
            }
        }

        return map;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        initWall(map, 0);
        System.out.println(maxSafeArea);
    }
}
