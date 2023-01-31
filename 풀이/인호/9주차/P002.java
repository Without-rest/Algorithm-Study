package algorithm.baekjoon;

import java.util.*;
import java.io.*;

/**
 * 14502번 골드4
 * 연구소
 *
 * 아이디어
 * - 벽을 만들 수 있는 모든 경우에 대해서 벽을 만들고 BFS로 탐색한다.
 * - 벽이 3개 밖에 없으므로 그냥 중복 for문 3개로 만든다.
 */
public class P14502_1_230131 {
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int N, M, SIZE;
    static int[][] virusArr;
    static List<int[]> startingList = new ArrayList<>(); // dfs 시작점(바이러스 위치)
    static boolean[][] isVisited;
    static int beginningZeroCnt = -3;
    static int zeroCnt;
    static int max_zeroCnt = 0;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        SIZE = N * M;
        virusArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                virusArr[i][j] = Integer.parseInt(st.nextToken());
                if (virusArr[i][j] == 2) {
                    startingList.add(new int[] {i, j});
                } else if (virusArr[i][j] == 0) {
                    beginningZeroCnt++;
                }
            }
        }
        int w1_beforeValue, w2_beforeValue, w3_beforeValue;
        for (int w1_i = 0; w1_i < SIZE; w1_i++) {
            int w1_x = w1_i / M; // 벽 가로 좌표
            int w1_y = w1_i % M; // 벽 세로 좌표
            if (virusArr[w1_x][w1_y] == 0) { // 0일 때만 벽 세우기
                w1_beforeValue = virusArr[w1_x][w1_y];
                virusArr[w1_x][w1_y] = 1;
            } else {
                continue;
            }
            for (int w2_i = 0; w2_i < SIZE; w2_i++) {
                int w2_x = w2_i / M;
                int w2_y = w2_i % M;
                if (virusArr[w2_x][w2_y] == 0) {
                    w2_beforeValue = virusArr[w2_x][w2_y];
                    virusArr[w2_x][w2_y] = 1;
                } else {
                    continue;
                }
                for (int w3_i = 0; w3_i < SIZE; w3_i++) {
                    int w3_x = w3_i / M; // 벽 세울 세로 좌표
                    int w3_y = w3_i % M; // 벽 세울 가로 좌표
                    if (virusArr[w3_x][w3_y] == 0) { // 0일 때만 벽 세우기
                        w3_beforeValue = virusArr[w3_x][w3_y]; // 벽 세우기 전 값 저장하기
                        virusArr[w3_x][w3_y] = 1;
                    } else {
                        continue;
                    }
                    // 초기화
                    isVisited = new boolean[N][M]; // 방문여부 초기화
                    zeroCnt = beginningZeroCnt; // 안전영역(0인 곳) 초기값으로 초기화

                    // dfs
                    for (int[] startingNode : startingList) { // 초기 바이러스 위치마다 dfs 탐색
                        isVisited[startingNode[0]][startingNode[1]] = true;
                        queue.add(startingNode);
                        bfs();
                    }
                    if (zeroCnt > max_zeroCnt) { // 현재 케이스의 안전영역의 수가 정답일 가능성이 있을 때
                        max_zeroCnt = zeroCnt;
                    }

                    /* 디버깅용
                    System.out.println("wall======");
                    System.out.println("zeroCnt: " + zeroCnt);
                    System.out.println(w1_x + " " + w1_y);
                    System.out.println(w2_x + " " + w2_y);
                    System.out.println(w3_x + " " + w3_y);
                    for (int[] arr : virusArr) {
                        System.out.println(Arrays.toString(arr));
                    }
                    for (boolean[] arr : isVisited) {
                        System.out.println(Arrays.toString(arr));
                    }
                    */

                    virusArr[w3_x][w3_y] = w3_beforeValue; // 벽 다시 제거하기
                }
                virusArr[w2_x][w2_y] = w2_beforeValue; // 벽 다시 제거하기
            }
            virusArr[w1_x][w1_y] = w1_beforeValue; // 벽 다시 제거하기
        }
        bw.write(Integer.toString(max_zeroCnt));
        bw.flush();
    } // main

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nbr_x = node[0] + dR[i];
                int nbr_y = node[1] + dC[i];
                if (nbr_x >= 0 && nbr_x < N && nbr_y >= 0 && nbr_y < M) {
                    if (!isVisited[nbr_x][nbr_y] && virusArr[nbr_x][nbr_y] == 0) { // 방문안했고 0이라면
                        isVisited[nbr_x][nbr_y] = true;
                        queue.add(new int[] {nbr_x, nbr_y});
                        zeroCnt--; // 안전영역 수 감소
                        if (zeroCnt < max_zeroCnt) { // 현재 안전영역 수가 더 작아지면 더이상 방문할 필요가 없음.
                            queue.clear();
                            return;
                        }
                    }
                }
            }
        }
    }
}
