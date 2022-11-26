import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int rlt = 1; //자기자신
        int[] sum = new int[n+1];
        for(int i=0; i<=(n/2+1); i++){
            if(i==0)
                sum[i] = i;
            else
                sum[i] = sum[i-1] + i;
        }

        for(int i=0; i<=(n/2+1); i++){
            if(sum[i]<n) continue;
            for(int j=0; j<i; j++){
                int cha = sum[i]-sum[j];
                if(cha==n) {
                    rlt++;
                    break;
                }else if(cha<n){
                    break;
                }
            }
        }

        System.out.println(rlt);
    }
}
