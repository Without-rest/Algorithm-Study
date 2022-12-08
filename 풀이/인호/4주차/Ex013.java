package baekjoon;

import java.util.*;
import java.io.*;

public class Ex013 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            // 버리기
            queue.poll();

            // 밑으로 옮기기
            queue.offer(queue.poll());
        }

        int answer = queue.poll();
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
