import java.util.Scanner;
public class A_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		
		int n = sc.nextInt();
		int i=1;
		while(i<=n) {
			int j=1, k=2;
			while(j<=i) {
				System.out.print((i+1)-j);
				j++;
			}
			while(k<=i) {
				System.out.print(k);
				k++;
			}
			i++;
		
			System.out.println();
		

	        sc.close();

	}

}

}