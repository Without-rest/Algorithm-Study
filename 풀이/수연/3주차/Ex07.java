import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /* 1.입력 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m =Integer.parseInt(st.nextToken());

        int nums[] = new int[n];
        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            nums[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        /* 2.정렬*/
        Arrays.sort(nums);

        /*3. 슬라이딩 윈도우*/
        int sIdx = 0;
        int eIdx = 1;
        int sum = nums[sIdx]+nums[eIdx];
        int count = 0;
        
        while(sIdx<=eIdx){
            if(sum==m){
                count ++;
            }
            
            if(sum<m){
            	if(eIdx == n-1) {
            		 sum -= nums[sIdx++];
                     sum += nums[sIdx];
                     
                     sum -= nums[eIdx];
                     eIdx = sIdx+1;
                     if(eIdx >= n) break;
                     sum += nums[eIdx];
                     continue;
            	}
            	
            	sum -= nums[eIdx++];
            	if(eIdx >= n) break;
                sum += nums[eIdx];
            }else if(sum>=m){
                sum -= nums[sIdx++];
                sum += nums[sIdx];
                
                sum -= nums[eIdx];
                eIdx = sIdx+1;
                if(eIdx >= n) break;
                sum += nums[eIdx];
            }
                    
        }

        /*4.출력*/
        System.out.println(count);
    }
}
