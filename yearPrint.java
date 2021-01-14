import java.util.Scanner;

public class yearPrint {
    public static void main(String[] args) {
        System.out.print("년도(1000~9999)를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.print("=>");
        int first, second, third, fourth;
        first = year / 1000;
        second = year % 1000 / 100;
        third = year % 100 / 10;
        fourth = year % 10;

        if (first == 1) {
            System.out.print("천");
        }
        else if(first == 0){
            System.out.print("");
        }
        else
            System.out.print(first + "천");

        if (second == 1) {
            System.out.print("백");
        }
        else if (second == 0) {
            System.out.print("");
        }
        else
            System.out.print(second + "백");

        if (third == 1) {
            System.out.print("십");
        }
        else if (third == 0) {
            System.out.print("");
        }
        else
            System.out.print(third + "십");

        if (fourth == 0) {
            System.out.print("");
        }
        else
            System.out.print(fourth);

        System.out.println("년");
    }
}
