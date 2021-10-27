import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static class Pair {
        private int x;
        private int y;
        private int wall;

        Pair(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWall() {
            return wall;
        }
    }

    public static void bfs(int[][] map) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int[][] result = new int[map.length][map[0].length];
        int[][][] visit = new int[map.length][map[0].length][2];
        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(0, 0, 0));
        visit[0][0][0] = 1;
        visit[0][0][1] = 1;
        result[0][0] = 1;

        while (!q.isEmpty()) {
            Pair top = q.poll();
            int wall = top.getWall();
            for (int i = 0; i < 4; i++) {
                int tempX = top.getX() + dx[i];
                int tempY = top.getY() + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < map.length && tempY < map[0].length) {

                    if (map[tempX][tempY] == 1 && wall == 0 && visit[tempX][tempY][wall + 1] == 0) {
                        visit[tempX][tempY][wall + 1] = 1;
                        result[tempX][tempY] = result[top.getX()][top.getY()] + 1;
                        q.add(new Pair(tempX, tempY, wall + 1));
                    }

                    if (map[tempX][tempY] != 1 && visit[tempX][tempY][wall] == 0) {
                        visit[tempX][tempY][wall] = 1;
                        result[tempX][tempY] = result[top.getX()][top.getY()] + 1;
                        q.add(new Pair(tempX, tempY, wall));
                    }

                    if (tempX == map.length - 1 && tempY == map[0].length - 1) {
                        System.out.println(result[tempX][tempY]);
                        return;
                    }
                }
            }
        }
        System.out.println("-1");
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        if (n == 1 && m == 1) {
            System.out.println("1");
            return;
        }

        bfs(map);
    }
}
