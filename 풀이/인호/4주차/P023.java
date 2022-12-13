package baekjoon;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수 실버2
public class P023 {
    static int N, M;
    static Stack<Integer> g_stack = new Stack<>();
    static boolean[][] g_connectMap; // 연결 맵
    static boolean[] g_visitMap; // 방문 맵
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g_connectMap = new boolean[N + 1][N + 1];
        g_visitMap = new boolean[N + 1];

        for (int M_i = 0; M_i < M; M_i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g_connectMap[a][b] = g_connectMap[b][a] = true;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (g_visitMap[i]) {
                continue;
            }
            answer++;
            visit(i);
            dfs();
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    public static void visit(int n) {
        g_stack.push(n);
        g_visitMap[n] = true;
        dfs();
    }

    public static void dfs() {
        if (g_stack.isEmpty()) {
            return;
        }
        int tgt = g_stack.peek();

        for (int i = 1; i <= N; i++) {
            if (!g_visitMap[i] && g_connectMap[tgt][i]) {
                visit(i);
            }
        }
        g_stack.pop();
    }
}
