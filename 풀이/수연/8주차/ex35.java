import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[n][2];
         for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, (o1,o2)-> {
            if(o1[1]==o2[1]){
                return Integer.compare(o1[0],o2[0]);
            }else{
                return Integer.compare(o1[1],o2[1]);
            }
        });

         int count = 1;
         int start = arr[0][0];
         int end = arr[0][1];

         for(int i=1;i<n;i++){
             if(end <= arr[i][0]){
                 count++;
                 start = arr[i][0];
                 end = arr[i][1];
             }
         }

         StringBuilder sb = new StringBuilder();
         sb.append(count);
         System.out.println(sb);
    }
}
