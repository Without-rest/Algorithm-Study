import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] coin = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        //가치가 큰 것부터 역순으로
        for(int i = n-1; i>=0; i--) {
            if(coin[i] <= money) { //현재 동전의 가치가 money보다 작으면
               count+=( money / coin[i]);
               money = money % coin[i]; //남은 금액으로 갱신한다.
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
}
