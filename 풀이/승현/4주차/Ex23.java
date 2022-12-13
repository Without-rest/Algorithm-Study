import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_11724_DFS {
    static ArrayList<Integer> [] arr;
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        //노드와 엣지의 갯수 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //ArrayList 선언
        arr = new ArrayList[N+1];

        //방문 배열 선언
        visited = new boolean[N+1];

        //인접리스트 초기화
        for(int i = 0; i<N+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        //엣지의 개수 대로 양끝 점 u와 v 입력
        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //양방향이므로 양쪽에 add해주기
            arr[u].add(v);
            arr[v].add(u);
        }
        int count = 0;
        for (int i=1; i<N+1; i++) {
            if(!visited[i]) { //방문하지 않은 노드가 없을 때까지 반복하기 -> visited[i]가 모두 true일 때까지 반복
                count++;
                DFS(i);
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    //DFS 함수
    static void DFS(int v) {
        if(visited[v]) { //int v에는 i 값이 들어간다.
            return;
        }
        visited[v] = true;
        for (int i : arr[v]) {
            if(visited[i] == false) { //방문하지 않았던 노드만 방문
                DFS(i); //재귀함수 사용
            }
        }
    }
}
