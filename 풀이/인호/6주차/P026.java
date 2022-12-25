package baekjoon;

import java.io.*;
import java.util.*;

public class P026 {
    static int N, M, V;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        // 이웃 리스트 정렬 (낮은 번호 먼저 방문하도록)
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        // DFS
        visit(V);
        dfs(V);
        sb.deleteCharAt(sb.length() - 1); // 마지막 공백 지우기

        // 방문 초기화
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }

        // 정답문자열 줄바꿈
        sb.append('\n');

        // BFS
        visit(V);
        queue.add(V);
        bfs();
        sb.deleteCharAt(sb.length() - 1); // 마지막 공백 지우기

        // 출력
        bw.write(sb.toString());
        bw.flush();

    }

    public static void visit(int node) {
        visited[node] = true;
        sb.append(node).append(' ');
    }
    public static void dfs(int node) {
        for (int nbr : A[node]) {
            if (!visited[nbr]) {
                visit(nbr);
                dfs(nbr);
            }
        }
    }

    public static void bfs() {
        if (queue.isEmpty()) return;
        int node = queue.poll();
        for (int nbr : A[node]) {
            if(!visited[nbr]) {
                visit(nbr);
                queue.add(nbr);
            }
        }
        bfs();
    }
}
