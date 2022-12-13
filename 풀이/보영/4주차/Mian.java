package Algorithm;

import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main3 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while(q.size() > 1) {
			q.poll();
			q.offer(q.poll());	
		}
		System.out.println(q.poll());	
	}
}