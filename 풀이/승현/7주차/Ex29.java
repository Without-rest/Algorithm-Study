import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1920 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //입력받을 자연수 개수 받기
        int N = Integer.parseInt(br.readLine());
        //자연수 배열 A선언
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        //A배열 값 받기
        for(int i =0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //A배열 정렬하기
        Arrays.sort(A);

        //찾아야 할 숫자 개수 값 받기
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            boolean find = false;
            int num = Integer.parseInt(st.nextToken());

            //이진탐색 시작
            int start = 0; //시작점
            int end = A.length -1; //끝점

            //반복
            while(start <= end) {
                int mid = (start+end) / 2 ; //중간지점
                int midV = A[mid];
                //중간지점 값이 받은 값보다 클때
                if(midV > num) {
                    end = mid-1; //끝지점 한칸 앞으로 당김
                }else if(midV < num){
                    start = mid + 1;
                }else {
                    find = true;
                    System.out.println(1);
                    break;
                }
            }
         if(!find) {
             System.out.println(0);
         }
        }
    }
  }
