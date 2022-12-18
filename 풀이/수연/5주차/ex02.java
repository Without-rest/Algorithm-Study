import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] connect;
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connect = new int[n][n];
        isVisited = new boolean[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int sPoint = Integer.parseInt(st.nextToken());
            int ePoint = Integer.parseInt(st.nextToken());

            connect[sPoint][ePoint] = 1;
            connect[ePoint][sPoint] = 1;
        }

        for(int j=0;j<n;j++){
            dfs(j, 0);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(0));
        bw.flush();
        bw.close();

    }

    static void dfs(int idx, int depth) throws IOException {
        if(depth == 4){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(Integer.toString(1));
            bw.flush();
            bw.close();
            System.exit(0);
        }

        isVisited[idx] = true;

        for(int i=0;i<connect[idx].length;i++){
            if(connect[idx][i]==1&&!isVisited[i]){
                isVisited[i] = true;
                dfs(i, depth+1);
                isVisited[i] = false;
            }
        }
        isVisited[idx] = false;
    }
}
