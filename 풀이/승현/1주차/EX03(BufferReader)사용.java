import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11659_BR {

    public static void main(String[] args) throws IOException {

    //BufferReader 사용 -> 효율
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int num = Integer.parseInt(stringTokenizer.nextToken());
    int m = Integer.parseInt(stringTokenizer.nextToken());

    long[] S = new long[num+1];

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for( int i=0; i<num; i++) {
        S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
    }

    for ( int q = 0; q < m ; q++) {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int i = Integer.parseInt(stringTokenizer.nextToken());
        int j = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(S[j]-S[i-1]);
    }
}

}
