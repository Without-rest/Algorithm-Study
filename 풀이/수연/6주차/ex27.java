import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] gMaps;
    static Queue<int[]> que;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n, m;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gMaps = new int[n][m];
        que = new LinkedList<>();
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<s.length(); j++){
                gMaps[i][j] = s.charAt(j)-'0';
            }
        }

        visited[0][0] = true;
        que.add(new int[]{0,0});

        bfs();

        System.out.println(answer);
    }

     static void bfs(){
        if(que.isEmpty()) return;
        int[] tgt = que.poll();
        int cnt = gMaps[tgt[0]][tgt[1]];

        for(int i=0; i<4; i++){
            int row = tgt[0] + dR[i];
            int col = tgt[1] + dC[i];

            if(row>=0&&row<n&&col>=0&&col<m){
                if(gMaps[row][col]>=1 && !visited[row][col]){
                    visited[row][col] = true;
                    que.add(new int[]{row,col});
                    gMaps[row][col] = cnt + 1;

                    if(row == n-1 && col == m-1){
                        answer = gMaps[row][col];
                        return;
                    }
                }
            }
        }

        bfs();
        return;
    }
}
