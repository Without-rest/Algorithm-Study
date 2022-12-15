import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited ;
    static int[][] connect;
    public static int birusCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        connect = new int[node+1][node+1];
        visited = new boolean[node+1];
        StringTokenizer st;

        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            connect[start][end] = 1;
            connect[end][start] = 1;
        }

        dfs(1);

        System.out.print(birusCnt);
    }

    public static void dfs(int nodeIdx){
        visited[nodeIdx] = true;
        if(nodeIdx!=1) birusCnt++;

        for(int i=1; i<connect.length; i++){
            //인접노드 방문
            if(connect[nodeIdx][i]==1&&!visited[i]){
                dfs(i);
            }
        }
    }
}
