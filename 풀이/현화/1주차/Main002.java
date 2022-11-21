import java.util.*;

public class Main002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double result = 0; //결과 double형으로 받음
        int N = sc.nextInt();
        int[] arr = new int[N]; //입력값을 받을 배열 생성

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();//입력된 값들을 배열에 초기화
        }
        Arrays.sort(arr); //배열 오름차순으로 sort

        int max = arr[N-1];//정렬된 배열 맨 뒤의 값이 최대값

        for(double tmp : arr){  //나눌 값을 double 형으로 받아야함 -> int형으로 받으면 몫만 계산하고 소수점 계산 안하기 때문에 결과 틀려짐
            double i = tmp/max*100;
            result+=i;
        }

        result=result/N; //최종적으로 평균을 구한다.

        System.out.println(result);
    }
}