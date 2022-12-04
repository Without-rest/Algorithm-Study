package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1940
// 주몽 실버4
public class P007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Boolean> map = new HashMap<>(); // 필요한 수 저장
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) { // 맵에 해당 수가 있으면 정답 카운트
                answer++;
            } else { // 필요한 수가 아니라면 맵에 M - num을 필요한 수로 저장
                map.put(M - num, false);
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
