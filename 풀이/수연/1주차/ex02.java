import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num= sc.nextInt();
		int[] score= new int[num];
		double[] re_score= new double[num];
		int max= 0;
		double sum= 0;
		
		for(int i=0; i<score.length; i++) {
			score[i]= sc.nextInt();
			if(max < score[i]) max= score[i];
		}
		
		for(int i=0; i<score.length; i++) {
			re_score[i]= ((double)score[i]*100)/max;
			sum+= re_score[i];
		}
		System.out.println(sum/num);
	}
}
