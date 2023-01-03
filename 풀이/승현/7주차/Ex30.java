import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(st.nextToken()); //레슨 수
        int M = Integer.parseInt(st.nextToken()); //블루레이 수

        int[] A = new int[N];

        int start = 0; //시작 인덱스
        int end = 0; //끝 인덱스

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            if(start < A[i]) start = A[i]; //레슨의 최대값을 시작 인덱스로
            end += A[i];
        }

        while(start <= end) {
            int mid = (start+end) /2; //중앙값 구하기
            int sum = 0;    // A배열 합 구하기
            int count = 0;  // 개수세기 -> 블루레이 개수
            for( int i=0; i<N; i++) { //mid값으로 모든 레슨 저장 가능한지
                if(sum + A[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            if( sum != 0 ) //sum이 0이 아니면 count가 더 필요 -> 증가
                count++;
            if( count > M)  //count가 블루레이 개수 넘으면
                start = mid + 1 ;
            else
                end = mid -1 ;
            }
           bw.write(Integer.toString(start));
           bw.flush();
           bw.close();
        }
    }

