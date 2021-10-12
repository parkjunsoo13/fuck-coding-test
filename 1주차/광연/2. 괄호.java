package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class week1_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			System.out.println(checkVPS(br.readLine()));
		}
		
	}
	
	public static String checkVPS(String str) {
		Stack<Character> s = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') s.push(str.charAt(i));
			else {
				if(s.isEmpty()) return "NO";
				s.pop();
			}
		}
		
		if(s.isEmpty()) return "YES";
		else return "NO";
	}

}
