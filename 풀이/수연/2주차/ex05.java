import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex05_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] reminder = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            sum += Integer.parseInt(st.nextToken())%m;
            reminder[sum%m]++;
        }

        long ans = reminder[0];
        for(int i=0;i<m;i++){
            int re = reminder[i];
            ans += (long)re*(re-1)/2;
        }
        System.out.println(ans);
    }
}
