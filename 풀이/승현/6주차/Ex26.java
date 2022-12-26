import java.io.*;
import java.util.*;

public class Baekjoon_1260 {

    static ArrayList<Integer>[] arr;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        //데이터 저장하기
        for( int i=1; i<=N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        //방문할 수 있는 노드가 여러개일 경우 번호가 작은 것을 먼저 방문시킴
        for(int i = 1; i<=N; i++) {
            Collections.sort(arr[i]);
        }
        //방문배열 초기화
        visited = new boolean[N+1];
        DFS(start);
        System.out.println("");
        visited = new boolean[N+1];
        BFS(start);
    }
        //DFS구현하기
        public static void DFS(int v) {
            System.out.print(v + " ");
            visited[v] = true;
            for(int i : arr[v]) {
                if(!visited[i]) {
                    DFS(i);
                }
            }
        }

        //BFS 구현
        public static void BFS(int v) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);
            visited[v] = true;
            
            //큐가 없어질때까지 계속 반복
            while(!queue.isEmpty()) {
                //방문한 노드 큐 출력
                int v_node = queue.poll();
                System.out.print(v_node + " ");

                for( int i : arr[v_node]) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            
        }

    }
