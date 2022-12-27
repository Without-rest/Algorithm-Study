import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] maps;
    static Queue<int[]> que = new LinkedList<>();
    static int[] dR = {-1,1,0,0};
    static int[] dC = {0,0,-1,1};
    static boolean[][] visited;
    static int cnt = 1;
    static List<Integer> cntList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            String str = br.readLine();

            for(int j=0;j<n;j++){
                maps[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(maps[i][j]>=1&&!visited[i][j]){
                    que.add(new int[]{i,j});
                    visited[i][j] = true;
                    bfs();
                    cntList.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(cntList);

        sb.append(cntList.size()+"\n");
        for(int n : cntList){
            sb.append(n+"\n");
        }

        System.out.println(sb);
    }

    static void bfs(){
        if(que.isEmpty()) return;

        int[] point = que.poll();

        for(int i=0;i<4;i++){
            int nRow = point[0]+dR[i];
            int nCol = point[1]+dC[i];

            if(nRow>=0&&nRow<n&&nCol>=0&&nCol<n){
                if(maps[nRow][nCol]>=1&&!visited[nRow][nCol]){
                    visited[nRow][nCol] = true;
                    que.add(new int[]{nRow, nCol});
                    cnt++;
                }
            }
        }
        
        bfs();
        return;
    }
}
