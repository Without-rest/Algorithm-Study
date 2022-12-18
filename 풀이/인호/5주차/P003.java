package baekjoon;

import java.util.*;
import java.io.*;

public class P003 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        answer = -1; // 정답 (1번 컴퓨터는 제외하므로 초기값 -1)
        visit(1);
        dfs(1);

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    public static void visit(int n) {
        visited[n] = true;
        answer++;
    }

    public static void dfs(int n) {
        for (int nbor: A[n]) {
            if (!visited[nbor]) {
                visit(nbor);
                dfs(nbor);
            }
        }
    }
}
