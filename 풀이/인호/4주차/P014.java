package baekjoon;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11286
// 절댓값 힙 실버1
public class P014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(Long o1, Long o2) {
                if (Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());

        for (int N_i = 0; N_i < N; N_i++) {
            long x = Integer.parseInt(br.readLine());
            if (x != 0) { // 입력값이 0이 아니라면
                pq.offer(x);
            } else { // 입력값이 0이라면
                if (pq.isEmpty()) { // 비어있다면
                    bw.write(Long.toString(0) + "\n");
                    bw.flush();
                } else { // 비어있지 않다면
                    long output = pq.poll();
                    bw.write(Long.toString(output) + "\n");
                    bw.flush();
                }
            }
        }
    }
}
