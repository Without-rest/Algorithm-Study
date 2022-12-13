package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2 {

	static class Point implements Comparable<Point>{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			if(this.y == o.y)
				return this.x - o.x;
			return this.y-o.y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		int arr[] = new int[n];
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {
				if(!queue.isEmpty())
					System.out.println(queue.poll().x);
				else
					System.out.println(0);
			}else {
				queue.add(new Point(num, Math.abs(num)));
			}
		}
		
	}
}