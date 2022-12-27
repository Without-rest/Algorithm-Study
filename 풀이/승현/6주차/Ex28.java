import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/* 틀림 -> 수정해야함 */
public class Baekjoon_2667 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static int N;
    static boolean[][] visited;
    static int [][] map;
    static int dR[] = {1,-1,0,0};
    static int dC[] = {0,0,-1,1};
    //단지번호
    static int Num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N*N 정사각형
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        //방문배열
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(i) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Num = 1;
                    DFS(i, j);
                    arr.add(Num);
                }
            }
        }

        Collections.sort(arr);
        System.out.println(arr.size());
        for (int num : arr) System.out.println(num);
    }
        public static void DFS(int x, int y) {
            visited[x][y] = true;
            for(int i=0; i<4; i++) {
                int nx = x+dR[i];
                int ny = y+dC[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        DFS(nx,ny);
                        Num++;
                    }
                }
            }
        }
    }

