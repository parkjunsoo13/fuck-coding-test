package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week2_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int min = 0;
		boolean[] button = new boolean[10];
		
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) {
				button[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		if(N == 100) System.out.println(0);
		else {
			min = Math.abs(N - 100);
			for(int i = 0; i < 1000000; i++) {
				String str = String.valueOf(i);
				boolean flag = true;
				
				for(int j = 0; j < str.length(); j++) {
					if(button[str.charAt(j) - '0']) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					int count = str.length() + Math.abs(N - i);
					min = Math.min(min, count);
				}
			}
			
			System.out.println(min);
		}

	}

}
