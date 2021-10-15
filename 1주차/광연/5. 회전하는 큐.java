package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class week1_5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		int[] target = new int[M];
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < M; i++) target[i] = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++) deque.add(i);
		
		for(int i = 0; i < M; i++) {
			
			while(true) {
				if(deque.indexOf(target[i]) == 0) {
					deque.pollFirst();
					break;
				}
				else if(deque.indexOf(target[i]) > deque.size() / 2) {
					deque.addFirst(deque.removeLast());
					count++;
				}
				else {
					deque.addLast(deque.removeFirst());
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}
