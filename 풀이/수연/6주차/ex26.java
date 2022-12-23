import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util. ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util. Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] conn;
    static boolean visited[];
    static StringBuilder sb;
    static Queue<Integer> queue;
    static boolean visited_bfs[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());           /*정점 수*/
        int m = Integer.parseInt(st.nextToken());           /*간선 수*/
        int sidx = Integer.parseInt(st.nextToken());        /*시작 정점*/

        conn = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            conn[i] = new ArrayList<Integer>();
        }

        visited = new boolean[n + 1];
        visited_bfs = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            conn[start].add(end);   /*출발지점*/
            conn[end].add(start);     /*도착지점*/
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(conn[i]);
        }

        sb = new StringBuilder();
        dfs(sidx);
        System.out.println(sb);

        sb = new StringBuilder();
        queue = new LinkedList<Integer>();
        queue.add(sidx);
        bfs();
        System.out.println(sb);
    }
        static void dfs(int node) {
            visited[node] = true;
            sb.append(node+" ");

            for(int i : conn[node]) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
        }

        static void bfs(){
            if(queue.isEmpty()) return;

            int idx = queue.poll();
            sb.append(idx+" ");
            visited_bfs[idx] = true;

            for(int i : conn[idx]) {
                if(!visited_bfs[i]) {
                    queue.add(i);
                    visited_bfs[i] = true;
                }
            }

            bfs();

    }
}
