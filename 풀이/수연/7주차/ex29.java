import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); //정렬!

        int m = Integer.parseInt(br.readLine());
        str = br.readLine();
        st = new StringTokenizer(str);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num)+"\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int num){
        int start = 0;
        int end = arr.length-1;
        int mid ;

        while(start<=end){
            mid = (start+end)/2;

            if(num == arr[mid]) return 1;
            else if(num < arr[mid]) end = mid-1;
            else if(num > arr[mid]) start = mid+1;
            else return 0;
        }

        return 0;
    }
}
