import java.util.ArrayList;
import java.util.Scanner;

public class Main005{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<N;i++){
            arr.add(sc.nextInt());
        }

        int result = 0;
        int idx=0;
        while(!arr.isEmpty()) {
            result+=arr.get(idx);
            if(result%M==0){
                count++;
            }
            if(idx==arr.size()-1){
                arr.remove(arr.get(0));
                idx=0;
                result=0;
            }else{
                idx++;
            }
        }

        System.out.println(count);
    }

}