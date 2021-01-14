import java.util.Scanner;

public class A_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		
		int a = sc.nextInt();
		
		for(int i=1; i<=a; i++) {
			for(int n=1; n<=a-i; n++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print((i+1)-j);
			}
			for(int j=2; j<=i; j++) {
				System.out.print(j);
			}

			System.out.println();
			
			sc.close();
		}

	}

}
