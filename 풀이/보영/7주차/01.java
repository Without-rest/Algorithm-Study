import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 K번째 수
 이분탐색
public class p1300 {
	static int n, k;
	static long result = 0;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		long low = 1;
		long high = k;	 n  n은 안되고 k는 되는 이유  - 무조건 내가 찾으려는 값은 K보다 작기 때문
		 만약 n  n을 사용하기 위해서는 Math.min()으로 mid들 중 최솟값을 찾아야 한다.
		
		while(low = high) {
			long mid = (low + high)  2;
			long count = getPossibleCount(mid);
			if(count = k) {	 K 개수 초과하면 숫자를 낮춰보자. (낮아야지 개수가 작아지므로)
				result = mid;
				high = mid - 1;
			}
			else {	 미달인 경우
				low = mid + 1;	
			}
			
		}
		System.out.println(result);
	}
	
	static long getPossibleCount(long mid) {
		long count = 0;
		for(int i = 1; i = n; i++) {
			 만약 나눈 몫이 n보다 크면 행의 모든 원소가 같거나 작다라는 뜻이므로 모든 원소의 개수인 n을 더해준다.
			count += Math.min(n, mid  i);
		}
		
		return count;
	}
}