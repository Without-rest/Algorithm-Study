package baekjoon;

import java.util.*;
import java.io.*;

public class P002 {
    static int N, M, answer;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // visited = new boolean [N];
        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        answer = 0;

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            dfs(i, 1, visited);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    public static void dfs(int n, int cnt, boolean[] visited) {
        if (answer == 1) return; // 이미 정답 나왔으면 return
        if (cnt >= 5) { // 이미 5명 나왔으면 return
            answer = 1;
            return;
        }
        for (int nbr : A[n]) {
            if (!visited[nbr]) {
                // 배열 복사
                boolean[] new_visited = new boolean[N];
                for (int i = 0; i < N; i++) {
                    new_visited[i] = visited[i];
                }

                // 방문
                new_visited[nbr] = true;

                // dfs
                dfs(nbr, cnt + 1, new_visited);
            }
        }
    }
}
