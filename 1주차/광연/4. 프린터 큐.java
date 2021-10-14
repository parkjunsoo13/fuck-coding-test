package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Work{
	int index, priority, count;
	public Work(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}

public class week1_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		List<Work> queue = new LinkedList<Work>();
		Work target = null;
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				Work work = new Work(j, Integer.parseInt(st.nextToken()));
				queue.add(work);
				if(work.index == M) {
					target = work;
				}
			}
			
			int cnt = 1;
			
			while(!queue.isEmpty()) {
				int curPriority = queue.get(0).priority;
				
				for(int k = 0; k < queue.size(); k++) {
					if(queue.get(k).priority > curPriority) {
						queue.add(queue.get(0));
						queue.remove(0);
						break;
					}
					
					if(k == queue.size() - 1) {
						queue.get(0).count = cnt++;
						queue.remove(0);
					}
				}
			}
			System.out.println(target.count);
			
		}
		
	}

}
