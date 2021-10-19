package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class week1_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int num = 1;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < n; i++) {
			int currentNum = Integer.parseInt(br.readLine());
			
			if(num <= currentNum) {
				while(num <= currentNum) {
					sb.append('+').append('\n');
					stack.push(num++);
				}
				sb.append('-').append('\n');
				stack.pop();
			}
			else {
				int popNum = stack.pop();
				if(popNum == currentNum) {
					sb.append('-').append('\n');
				}
				else {
					System.out.println("NO");
					return;
				}
			}
			
		}
		System.out.println(sb);
		br.close();		
	}

}
