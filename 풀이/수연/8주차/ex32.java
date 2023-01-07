import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int all = 0;
        for(int j=n-1;j>=0;j--){
            int count = k/arr[j];
            all+=count;

            k%=arr[j];
            if(k<=0) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(all);
        System.out.println(sb);
    }
}
