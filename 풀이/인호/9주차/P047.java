package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1325
 * 효율적인 해킹
 * 실버1
 *
 * 재귀 -> 스택으로 바꿔도 시간초과나는데 여기서 한번 간선 위치 바꿔보기. 그래서 만약 된다면 스택이냐 재귀냐는 크게 안중요하다는 결론이 나옴
 * 
 * 결과 => 통과함
 */
public class P1325_5_4_230129 {
    static int N, M;
    static ArrayList<Integer>[] E;
    static boolean[] V;
    static int[] answers = new int [10001];
    static int answer = 0;
    static int cnt = 0;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            E[i] = new ArrayList<>();
        }
        // answers = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            E[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            // 방문 초기화
            V = new boolean[N+1];
            V[i] = true;
            stack.push(i);
            dfs();
//            dfs(i);
//            answers[i] = answer;
//            answer = 0;
        }

        int max_ansVal = 0;
        for (int i = 1; i <= N; i++) {
            if (answers[i] > max_ansVal) {
                max_ansVal = answers[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (answers[i] == max_ansVal) {
                sb.append(i).append(' ');
            }
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }

    static void dfs() {
//    static void dfs(int node) { // 재귀방식
//        for (int n_node : E[node]) {
//            if (!V[n_node]) {
//                V[n_node] = true;
//                answer++;
//                dfs(n_node);
//            }
//        }
        while(!stack.isEmpty()) {
            int node = stack.pop();
            for (int n_node : E[node]) {
                if (!V[n_node]) {
                    V[n_node] = true;
                    stack.push(n_node);
                    answers[n_node]++;
                }
            }
        }
    }
}
