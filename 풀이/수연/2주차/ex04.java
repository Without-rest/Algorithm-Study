import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nmInput = br.readLine();
        StringTokenizer st = new StringTokenizer(nmInput);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            st = new StringTokenizer(s);
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumArr = new int[n][n];
        for(int i=0; i<n; i++){
            int arrSum = 0;
            for(int j=0; j<n; j++) {
                if (i==0) {
                    if(j==0) {
                        sumArr[i][j] = arr[i][j];
                    }else{
                        sumArr[i][j] = sumArr[i][j-1]+arr[i][j];
                    }
                } else {
                    arrSum += arr[i][j];
                    sumArr[i][j] = sumArr[i-1][j]+arrSum;
                }
            }
            arrSum = 0;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            String str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;

            int rlt = 0;
            if(a==0&&b==0){
                rlt = sumArr[c][d];
            }else if(a==0){
                rlt = sumArr[c][d]-sumArr[c][b-1];
            }else if(b==0){
                rlt = sumArr[c][d]-sumArr[a-1][d];
            }else{
                rlt = sumArr[c][d]-sumArr[c][b-1]-sumArr[a-1][d]+sumArr[a-1][b-1];
            }
            sb.append(rlt+"\n");
        }
        System.out.print(sb);
    }
}
