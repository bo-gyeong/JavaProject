import java.util.Scanner;

//날짜 => 요일
//서기 1년 1월 1일은 월요일!!!
//서기 1년 1월 1일로부터 경과한 날짜의 수를 7로 나눈 나머지 =>0:일, 1:월, 2:화,...,6:토
public class WhatDay {
    static int days_month[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static char day[] = {'일', '월', '화', '수', '목', '금', '토'};

    public static void main(String[] args) {
        int y, m, d;

        Scanner sc = new Scanner(System.in);
        System.out.print("날짜를 입력해주세요(ex. 2000 01 01): ");
        y = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();

        int day_code = total_days(y, m, d)%7;

        System.out.println(y + "년 " + m + "월 " + d + "일은 [" + day[day_code] + "요일]입니다.");
    }

    static boolean is_leap(int y){
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0);
    }

    //(1,1,1)로부터 경과한 일 수
    static int total_days(int y, int m, int d) {
        int total = 0;
        int i;

        for (i = 1; i < y; i++) {
            if (is_leap(i)) {
                total += 366;
            }
            else {
                total += 365;
            }
        }

        for (i = 0; i < m; i++) {
            if (i == 2 && is_leap(y)) {
                total += 29;
            }
            else {
                total += days_month[i];
            }
        }
        return (total + d);
    }
}
