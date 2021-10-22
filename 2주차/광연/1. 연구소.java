package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate {
	int x, y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class week2_1 {
	
	static int N, M;
	static int[][] map;
	static int[][] virusMap;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		for(int i = 0; i < N * M - 2; i++) {
			if(map[i / M][i % M] == 0) map[i / M][i % M] = 1;
			else continue;
			
			for(int j = i + 1; j < N * M - 1; j++) {
				if(map[j / M][j % M] == 0) map[j / M][j % M] = 1;
				else continue;
				
				for(int k = j + 1; k < N * M; k++) {
					if(map[k / M][k % M] == 0) map[k / M][k % M] = 1;
					else continue;
					
					BFS();
					max = Math.max(safetyZone(), max);
					
					map[k / M][k % M] = 0;
				}
				map[j / M][j % M] = 0;
			}
			map[i / M][i % M] = 0;
		}
		
		System.out.println(max);

	}
	
	public static void BFS() {
		virusMap = new int[N][M];
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				virusMap[i][j] = map[i][j];
			}
		}
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virusMap[i][j] == 2) {
					queue.add(new Coordinate(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Coordinate c = queue.poll();

			for(int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(virusMap[nx][ny] == 0) {
						virusMap[nx][ny] = 2;
						queue.add(new Coordinate(nx, ny));
					}
				}
				
			}
		}
		
	}
	
	public static int safetyZone() {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virusMap[i][j] == 0) count++;
			}
		}
		return count;
	}

}
