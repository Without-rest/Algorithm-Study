import java.io.*;
import java.util.*;

class Main {
    static PriorityQueue<Integer> A[];
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        A = new PriorityQueue[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            A[i] = new PriorityQueue<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited,false);
        bfs(V);
    }

    static void dfs(int v){
        if(!visited[v]){
            System.out.print(v+" ");
            visited[v] = true;
            PriorityQueue<Integer> tmp = new PriorityQueue<>(A[v]);
            while(!tmp.isEmpty()){
                dfs(tmp.poll());
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        System.out.print(v+" ");
        while(!q.isEmpty()){
            int n = q.poll();

            PriorityQueue<Integer> tmp = new PriorityQueue<>(A[n]);
            while(!tmp.isEmpty()){
                int i = tmp.poll();
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }
}
