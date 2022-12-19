// DFS로 할 때 정확성은 모두 다 맞았지만 효율성에서 모두 시간초과
class Solution {
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static boolean[][] visited;
    static int cnt = 1;
    static int N, M; // 가로 세로
    static int answer = -1;
    static int[][] g_maps;
    public int solution(int[][] maps) {
        g_maps = maps;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        // 시작지점 방문
        visited[0][0] = true;
        
        dfs(new int[]{0, 0});
        
        return answer;
    }
    
    public void dfs(int[] tgt) {
        // 이웃 탐색
        for (int i = 0; i < 4; i++) {
            int nbr_i = tgt[0] + dR[i];
            int nbr_j = tgt[1] + dC[i];
            if (nbr_i >= 0 && nbr_i < N && nbr_j >= 0 && nbr_j < M) { // 유효한 범위라면
                if (g_maps[nbr_i][nbr_j] == 1 && !visited[nbr_i][nbr_j]) { // 벽이 아니고 방문하지 않았다면
                    // 방문하기
                    cnt++;
                    visited[nbr_i][nbr_j] = true;
                    
                    if (nbr_i == N - 1 && nbr_j == M - 1) { // 도착했으면 해당 라인은 return
                        if (cnt < answer || answer < 0) {
                            answer = cnt;
                        }
                    } else { // 도착하지 않았으면 계속 dfs
                        dfs(new int[]{nbr_i, nbr_j});    
                    }
                    
                    // 방문 취소하기
                    cnt--;
                    visited[nbr_i][nbr_j] = false;
                }
            }
        }
        return;
    }
}

////////////////////////////////////////////////////////////////////////////

import java.util.*;

// BFS로 풀이
class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N, M; // 가로 세로
    static int answer = -1;
    static int[][] g_maps;
    public int solution(int[][] maps) {
        g_maps = maps;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        // 시작지점 방문
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});
        
        // bfs
        bfs();
        
        return answer;
    }
    
    public void bfs() {
        if (queue.isEmpty()) return;
        int[] tgt = queue.poll();
        int cnt = g_maps[tgt[0]][tgt[1]]; // 타겟까지의 카운트
        
        // 이웃 탐색
        for (int i = 0; i < 4; i++) {
            int nbr_i = tgt[0] + dR[i];
            int nbr_j = tgt[1] + dC[i];
            if (nbr_i >= 0 && nbr_i < N && nbr_j >= 0 && nbr_j < M) { // 유효한 범위라면
                if (g_maps[nbr_i][nbr_j] >= 1 && !visited[nbr_i][nbr_j]) { // 벽이 아니고 방문하지 않았다면
                    // 방문하기
                    visited[nbr_i][nbr_j] = true;
                    queue.offer(new int[]{nbr_i, nbr_j});
                    g_maps[nbr_i][nbr_j] = cnt + 1; // 이웃까지의 카운트
                    
                    if (nbr_i == N - 1 && nbr_j == M - 1) { // 도착했으면 해당 라인은 return
                        answer = g_maps[nbr_i][nbr_j];
                        return;
                    }
                }
            }
        }
        
        // bfs 
        bfs();
        return;
    }
}
