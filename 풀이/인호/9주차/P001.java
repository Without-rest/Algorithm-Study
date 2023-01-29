package baekjoon;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/7576
 * 토마토 골드5
 *
 * 아이디어:
 * -> bfs로 풀이
 * 고려사항:
 * -> 토마토 없는 거 고려
 * -> 요일 고려
 * -> 이미 다익은 상태나 아예 다못익는 상황 고려
 *
 */
public class P7576_230129 {
    static int M, N;
    static boolean[][] isVisited;
    static int[][] tomatoArr;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int cnt_1 = 0;
    static int cnt_tomato = 0;
    static String answer = "-1";

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N][M];
        tomatoArr = new int[N][M];

        // 토마토 배열에 값 넣기
        cnt_tomato = N * M; // -1 만날 때마다 빼주기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoArr[i][j] = Integer.parseInt(st.nextToken());
                // 1일 경우 방문 처리
                if (tomatoArr[i][j] == 1) {
                    isVisited[i][j] = true;
                    queue.add(new int[] {i, j});
                    cnt_1++;
                }
                // -1일 경우 총 토마토 개수 빼주기
                if (tomatoArr[i][j] == -1) {
                    cnt_tomato--;
                }
            }
        }

        // 이미 다 익었으면 종료
        if (cnt_tomato == cnt_1) {
            bw.write("0");
            bw.flush();
            return;
        }

        // bfs 탐색
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int day = tomatoArr[node[0]][node[1]];
            // 이웃 방문
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dR[i];
                int y = node[1] + dC[i];
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (tomatoArr[x][y] != -1 && !isVisited[x][y]) {
                        isVisited[x][y] = true;
                        queue.add(new int[] {x, y});
                        tomatoArr[x][y] = day + 1;
                        cnt_1++;
                    }
                }
            }

            // 토마토 모두 익었는지 체크
            if (cnt_tomato == cnt_1) {
                answer = Integer.toString(day);
                break;
            }
        }

        // 정답 출력
        bw.write(answer);
        bw.flush();
    }
}
