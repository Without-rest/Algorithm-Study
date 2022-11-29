import java.util.HashSet;
import java.util.Scanner;

public class Main007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            hs.add(arr[i]);
        }

        for(int i=0;i<N;i++){
            int n = arr[i];
            boolean isTrue = hs.add(M-n);
            if(!isTrue){
                count++;
            }
        }
        System.out.println(count/2);
    }
}