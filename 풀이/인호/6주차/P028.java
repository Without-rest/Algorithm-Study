package baekjoon;

import java.util.*;
import java.io.*;

public class P028 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> answers = new ArrayList<>();
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int g_answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int n = str.charAt(j) - '0';
                map[i][j] = n;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    g_answer = 1;
                    visited[i][j] = true;
                    dfs(new int[]{i, j});
                    answers.add(g_answer);
                }
            }
        }
        Collections.sort(answers);
        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append('\n');
        for (int answer : answers) {
            sb.append(answer).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int[] node) {
        for (int i = 0; i < 4; i++) {
            int[] nbr = new int[2];
            nbr[0] = node[0] + dR[i];
            nbr[1] = node[1] + dC[i];
            if (nbr[0] >= 0 && nbr[1] >= 0 && nbr[0] < N && nbr[1] < N) { // 유효하다면
                if (map[nbr[0]][nbr[1]] == 1 && !visited[nbr[0]][nbr[1]]) { // 1이고 방문하지 않았다면
                    g_answer++;
                    visited[nbr[0]][nbr[1]] = true;
                    dfs(nbr);
                }
            }
        }
    }
}
