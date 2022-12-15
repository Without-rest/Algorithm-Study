import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_2606 {

    static ArrayList<Integer> arr[];
    static boolean visited[];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);

        }
        //변수 1을 넣어서 1부터 탐색한다.(1과 인접한 것만 count++)
        DFS(1);
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }

        static void DFS(int v) {
            visited[v] = true;
//            for(int i : arr[v]) {
            for(int i=0; i< arr[v].size(); i++){
                int c = arr[v].get(i); //인접한 노드
                if(!visited[c]) { // 인접한 노드가 false일때
                    count ++;
                    DFS(c);
                }
             }
        }

    }
