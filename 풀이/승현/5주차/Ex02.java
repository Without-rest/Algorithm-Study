import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_13023 {

    static ArrayList<Integer> [] arr;
    static boolean visited[];
    static int check = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken()); //노드
        int M = Integer.parseInt(st.nextToken()); //엣지

        arr = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //양방향
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (check == 0) {
                dfs(i, 1); //depth 1부터 시작
            }

            bw.write(Integer.toString(check));
            bw.flush();
        }
    }
        static void dfs(int start, int depth) {
            if(depth == 5) {
                 check = 1;
                 return;
            }
            visited[start] = true;
            for(int i : arr[start]) {
                if(visited[i] == false) { //방문하지 않았던 노드만 방문
                    dfs(i, depth+1); //재귀함수 사용
                }
            }
            visited[start] = false;
        }
    }

