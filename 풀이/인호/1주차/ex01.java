// 구간 합 구하기 4 (실버3)
// https://www.acmicpc.net/problem/11659
// 처음 풀 때에는 하나하나 계산하도록 짰는데 시간초과 발생. 그래서 S_i - S_(j-1) 이용해서 풀이 (S_n은 0에서 n번째까지의 합, i는 구간 끝 인덱스, j는 구간 시작 인덱스) 
public class ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];

        // n번째 인덱스까지의 합 배열 만들기
        int[] sums = new int[N];
        sums[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i-1] + sc.nextInt();
        }

        // 각 구간에 대한 합 구하기
        for (int MIdx = 0; MIdx < M; MIdx++) {
            int sIdx = sc.nextInt() - 1; // 구간 처음 인덱스
            int eIdx = sc.nextInt() - 1; // 구간 끝 인덱스
            int sum = 0;
            if (sIdx == 0) {
                sum = sums[eIdx];
            } else {
                sum = sums[eIdx] - sums[sIdx - 1];
            }
            System.out.println(sum);
        }
    }
}
