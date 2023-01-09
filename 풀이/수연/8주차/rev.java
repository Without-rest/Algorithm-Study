import java.util.Scanner;

public class Main {

	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int K = sc.nextInt();
	        long N = sc.nextLong();
	        long[] arr = new long[K];
	        long max = 0;
	        for (int i = 0; i < K; i++) {
	            arr[i] = sc.nextLong();
	            max = Math.max(max, arr[i]);
	        }
	        //이분탐색
	        long left = 1; //랜선길이는 자연수므로  최솟값 1로 세팅해야함
	        long right = max;
	        while (left <= right) {
	            long mid = (left + right) / 2;
	            long sum = 0;
	            for (int i = 0; i < K; i++) { // 자른 개수 합
	                sum += (arr[i] / mid);
	            }
	            if (sum >= N) { //더 많은 랜선 나온 경우 더 크게 잘라줘야함
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        System.out.println(right);
	    }
}
