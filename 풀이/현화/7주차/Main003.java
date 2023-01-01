import java.io.*;
import java.util.*;

class Main1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long lo = 1;
        long hi = M;

        while(lo<hi){
            long mid = (lo+hi)/2;
            long count=0;

            for(int i=1;i<=N;i++){
                count+=Math.min(mid/i,N);
            }

            if(M<=count){
                hi=mid;
            }else{
                lo = mid+1;
            }
        }

        System.out.println(lo);
    }
}
