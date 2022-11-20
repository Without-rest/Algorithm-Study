import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        for(int i=0;i<m;i++){
            start = sc.nextInt();
            end = sc.nextInt();
            int cnt = end-start;

            if(cnt==0){
                sum = arr[end-1];
            }else if(cnt==1){
                sum = arr[start-1] + arr[end-1];
            }else if(cnt%2==0){
                sum = arr[(end+start)/2-1]*(cnt+1);
            }else{
                sum = (arr[start-1]+arr[end-1])*(cnt-1);
            }

            System.out.println(sum);
        }
    }
}
