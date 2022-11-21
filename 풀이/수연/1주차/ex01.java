import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int count = 0;
		long sum = 0; 
		String num = null;
		
		count= sc.nextInt();
		num= sc.next();
		for(int i=0;i<count;i++) {
			sum= sum+(num.charAt(i)-'0');
		}
		
		System.out.println(sum);
	}
}
