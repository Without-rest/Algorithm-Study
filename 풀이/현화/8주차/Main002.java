import java.io.*;
import java.util.*;


class Main1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> arr = new ArrayList<>();

        int v=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr.add(i,new int[]{start,end});
        }

        Collections.sort(arr, new Comparator<int[]>() { //정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]) return 1;   //종료 시각 오름차순
                else if(o1[1]<o2[1]) return -1;
                else{                       //종료시각이 같으면 내림차순
                    if(o1[0]>o2[0]) return 1;
                    else return -1;
                }
            }
        });

        v = arr.get(0)[1];  //정렬한 배열의 첫번째 종료 시각 기준으로 함
        arr.remove(0);  //그럼 첫번째의 시작시간은 무조건 v 보다 같거나 작으니 빼줌
        int count=1;    //빼줬으니 카운트는 1부터
        for(int[] nums : arr){
            if(nums[0]<v)   //정렬한거에서 시작시각이 기준으로 한 종료시각보다 작으면 반복문 지나감
                continue;
            v=nums[1];  //반복문에 걸리면 기준 v 바꿔줌
            count++;
        }
        System.out.println(count);
    }
}
/*
* 5
6 7
6 6
5 6
5 5
7 7
* */