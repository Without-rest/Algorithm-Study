import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        int rlt = 0;

        String numStr = br.readLine();
        st = new StringTokenizer(numStr);
        for(int i=0;i<n;i++){
           a[i] = Integer.parseInt(st.nextToken());
        }


        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=1; i<n+1; i++){
            if(i==1)
                sum[i] = a[i-1];
            else
                sum[i] = sum[i-1] + a[i-1];
        }

        for(int i=0; i<n+1; i++){
            for(int j=0; j<=i; j++){
                if(i!=j) {
                    int cha = sum[i] - sum[j];
                    if (cha % m == 0) {
                        rlt++;
                    }
                }
            }
        }

        System.out.println(rlt);
    }
}
