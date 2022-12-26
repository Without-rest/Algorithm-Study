import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2178 {
    static int[][] map;
    static int N, M;
    //상하좌우
    static int[] dR = {-1,1,0,0};   //Row를 나타냄
    static int[] dC = {0,0,-1,1};   //Column
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        bw.write(Integer.toString(map[N - 1][M - 1]));
        bw.flush();
        bw.close();
    }
        public static void BFS(int i, int j) {

        //큐 자료구조에 시작노드 삽입(add)
            Queue<int[]> qu = new LinkedList<>();
            qu.add(new int[] {i, j});

            //방문 배열에 현재 노드 방문 기록
            visited[i][j] = true;

            //queue가 empty가 될 때까지
            while(!qu.isEmpty()) {
                int now [] = qu.poll();

                //상하좌우 파악
                for(int k = 0; k<4; k++) {
                    int x = now[0] + dR[k]; // 큐에서 원소 하나를 꺼내 각각 인덱스를 x,y에 저장
                    int y = now[1] + dC[k];

                    //좌표 유효성 검사하기
                    if(x >= 0 && y>=0 && x<N && y<M) {
                        if(map[x][y] != 0 && !visited[x][y]) { // 칸이 0이 아닐때(막다른 길이 아닐때), 방문하지 않은곳
                            visited[x][y]  = true;
                            //깊이 업데이트하기?(다음 탐색지점) 
                            map[x][y] = map[now[0]][now[1]] + 1;   //그 인덱스의 값을 현재 인덱스 값보다 1 큰 값으로 설정
                            qu.add(new int[] {x,y});
                        }
                    }
                }

            }

        }
    }
