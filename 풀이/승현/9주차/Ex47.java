import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1325 {

    static int N,M;
    static boolean visited[];
    static ArrayList<Integer> com[];
    static  int[] answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //노드 개수 받기
        N = Integer.parseInt(st.nextToken());
        //엣지 받기
        M = Integer.parseInt(st.nextToken());
        answer = new int[N+1];

        //리스트
        com = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            com[i] = new ArrayList<>();
        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            com[A].add(B);
        }
        //BFS 탐색 알고리즘을 이용하여 탐색을 수행
        for(int i=1; i<=M; i++) {
            visited = new boolean[N+1];
            BFS(i);
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, answer[i]); //최대값과 같은 값을 가진 idx 정답으로 출력
        }

        for(int i=1; i<=N; i++) {
            if(answer[i] == max) {
                //최대값과 같은 idx 출력
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }


    public static void BFS(int v) {
        //BFS -> Queue 사용
        Queue<Integer> qu = new LinkedList<>();
        qu.add(v); //v값 add해주기
        visited[v] = true; //방문배열 =>true로
        while(!qu.isEmpty()) {
            //큐가 empty가 되지않을때까지 반복
            int new_node = qu.poll();
            for(int i : com[new_node]) {
                if(visited[i] == false ) {
                    visited[i] = true;
                    answer[i]++;
                    qu.add(i);
                }
            }
        }
    }
}

