import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            // sum arr
            int arr[] = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum[] = new int[n];
            for(int i=0;i<n;i++){
                if(i==0) {
                    sum[i] = arr[i];
                }else {
                    sum[i] = arr[i] + sum[i - 1];
                }
            }

            int startIndex = 0;
            int endIndex = 0;
            int res = 0;

            for(int i=0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                startIndex = Integer.parseInt(st.nextToken()) - 1;
                endIndex = Integer.parseInt(st.nextToken()) - 1;

                if (startIndex == 0) {
                    res = sum[endIndex];
                } else {
                    res = sum[endIndex] - sum[startIndex - 1];
                }
                sb.append(res + "\n");
            }
            System.out.println(sb.toString());
    }
}
