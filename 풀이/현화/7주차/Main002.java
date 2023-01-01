import java.io.*;
import java.util.*;

class Main2343 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
            if(start<A[i]) start=A[i];
            end += A[i];
        }

        while(start<=end){
            int middle = (start+end)/2;
            int sum = 0;
            int count = 0;
            for(int i=0;i<N;i++){
                if(sum+A[i] > middle){
                    count++;
                    sum=0;
                }

                sum+=A[i];
            }
            if(sum!=0)
                count++;
            if(count>M)
                start=middle+1;
            else
                end=middle-1;

        }
        System.out.println(start);
    }
}
