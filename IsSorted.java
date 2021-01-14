import java.util.Scanner;

public class IsSorted {
    public static void main(String[] args) {
        System.out.print("몇 개의 정수를 입력하시겠습니까? ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.print("정수를 입력하세요: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        make_nonnegative(arr, n);
        System.out.print("make_nonnegative(arr): ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.print("is_sorted(arr): ");
        is_sorted(arr, n);

    }

    static void make_nonnegative(int arr[], int n){
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
    }

    static void is_sorted(int arr[], int n) {
        int i;
        int sotred = 0;

        for (i = 0; i < n-1; i++) {
            if (arr[i] <= arr[i + 1]) {
                sotred = 1;
            }
            else {
                System.out.println("Not Sorted");
                sotred = 0;
                break;
            }
        }

        if (sotred == 1) {
            System.out.println("Sorted");
        }
    }
}
