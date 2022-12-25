import java.util.*;
import java.io.*;

public class P027 {
    static int N, M, answer;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static int[][] map;
    static int[] dR = {-1, 1, 0 ,0};
    static int[] dC = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        bfs();
        bw.write(Integer.toString(answer));
        bw.flush();
    }
    public static void bfs() {
        if (queue.isEmpty()) return;
        int[] node = queue.poll();
        if (node[0] == N - 1 && node[1] == M - 1) { // 골인했으면
            answer = map[node[0]][node[1]];
            return;
        }
        int cost = map[node[0]][node[1]];
        for (int i = 0; i < 4; i++) {
            int[] nbr = new int[2];
            nbr[0] = node[0] + dR[i];
            nbr[1] = node[1] + dC[i];
            if (nbr[0] >= 0 && nbr[0] < N && nbr[1] >= 0 && nbr[1] < M) { // 유효한지
                if (map[nbr[0]][nbr[1]] != 0 && !visited[nbr[0]][nbr[1]]) { // 벽이 아니고 방문했는지
                    visited[nbr[0]][nbr[1]] = true;
                    queue.add(nbr);
                    map[nbr[0]][nbr[1]] = cost + 1; // 코스트 저장하기
                }
            }
        }
        bfs();
    }
}
