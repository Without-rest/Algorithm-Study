// https://www.acmicpc.net/problem/10986
// 나머지합
// 골드3
// 앞에서(_221129) 틀려서 다시 해보자..
// N과 M을 int에서 long으로 바꾸니까 맞았다.
public class Ex006 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] nums = new long[Long.valueOf(N).intValue()];
        long[] sums = new long[Long.valueOf(N).intValue()];
        long[] rcnts = new long[Long.valueOf(M).intValue()];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        sums[0] = nums[0] % M;
        rcnts[Long.valueOf(sums[0]).intValue()]++;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + (nums[i] % M);
            sums[i] %= M;
            rcnts[Long.valueOf(sums[i]).intValue()]++;
        }

        long answer = 0;
        answer += rcnts[0];
        for (int i = 0; i < rcnts.length; i++) {
            if (rcnts[i] > 1) {
                answer += (rcnts[i] * (rcnts[i] - 1)) / 2;
            }
        }
        System.out.println(answer);
    }
}
