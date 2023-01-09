import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_1931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //회의 개수
        int n = Integer.parseInt(st.nextToken());

        //이차원 배열
        int[][] m = new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            m[i][0] = Integer.parseInt(st.nextToken()); //시작시간
            m[i][1] = Integer.parseInt(st.nextToken()); //종료시간
        }

        int count = 0;
        int end = -1;
        //종료시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(m, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                //종료시간이 같을 경우 시작시간이 빠른순으로 정렬
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0]; //우선순위 지정
                }
                return o1[1]-o2[1];
            }
        });

        for(int i=0; i<n; i++) {
            //겹치지 않는 회의가 나올경우
            if(m[i][0] >= end) {
                end  = m[i][1];
                count ++;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
