import java.io.*;
import java.util.*;

class Main11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int result = 0;

        int N = Integer.parseInt(st.nextToken());
        int coin = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            int coinNum = Integer.parseInt(br.readLine());
            pq.offer(coinNum);
        }

        while(coin!=0){
            int num = pq.poll();

            result += (coin/num);
            coin = (coin%num);
        }

        System.out.println(result);
    }
}
