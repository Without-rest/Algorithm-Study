import java.io.*;
import java.util.Arrays;

public class Baekjoon_1744 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //배열 정렬
        Arrays.sort(arr);

        //음수 걸러내기 위한 인덱스 값 초기화
        int minus = 0;

        //최종 답 값
        int answer = 0;

        //음수~0까지 분기
        while(minus < N && arr[minus] <1 ) {
            //음수끼리 곱해서 양수가 되면
            if(minus +1 <N && arr[minus+1]<1) {
                answer += (arr[minus]*arr[minus+1]);
                
                //첫,두번째 값 비교했으므로 -> 인덱스값+2
                minus+=2;
            }else {
                //양수가 아니라면 그냥 더한다.
                // -> 0 or 음수가 하나 남았을 때
                answer+= arr[minus++];
            }
        }

        //양수값 인덱스 -> 받은 숫자 -1
        int plus = N-1;
        //양수처리
        while(plus >= minus && arr[plus]>0) {
            //1은 곱하지 않고 큰 양수 두개 곱하기
            if(plus-1>=minus && arr[plus-1]>1) {
                answer += (arr[plus] * arr[plus-1]);
                plus -= 2;
            }else{
                //1이거나 양수 하나만 남으면 그냥 더해준다.
                answer+=arr[plus--];
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
