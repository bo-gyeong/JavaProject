import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        int count = 1;
        char userAns;
        int[] userNumArr = new int[4];
        Scanner sc = new Scanner(System.in);

        int[] rand = baseballGame();

        while (true) {
            if (count <= 20) {
                int strike = 0, ball = 0;
                System.out.println(count + "회차");
                System.out.print("4개의 숫자를 콤마로 구분하여 입력하세요(1~9): ");
                String userNumString = sc.next();
                String[] s = userNumString.split(",");
                for (int i = 0; i < s.length; i++) {
                    userNumArr[i] = Integer.parseInt(s[i]);
                }
                for (int i = 0; i < userNumArr.length; i++) {
                    if (rand[i] == userNumArr[i])
                        strike++;
                    else {
                        for (int j = 0; j < s.length; j++) {
                            if (rand[i] == userNumArr[j])
                                ball++;
                        }
                    }
                }

                System.out.println(strike + "스트라이크 " + ball + "볼");

                if (strike == 4) {
                    System.out.println("축하합니다! 총 시도 횟수: " + count);
                    System.out.print("게임을 다시 진행하시겠습니까? ");
                    userAns = sc.next().charAt(0);
                    if (userAns == 'y' || userAns == 'Y') {
                        count = 0;
                        rand = baseballGame();
                    } else {
                        break;
                    }
                }
                count++;
            } else {
                System.out.println("20번의 기회가 소진되었습니다.");
                System.out.println("정답: " + rand[0] + "," + rand[1] + "," + rand[2] + "," + rand[3]);
                System.out.print("게임을 다시 진행하시겠습니까? ");
                userAns = sc.next().charAt(0);
                if (userAns == 'y' || userAns == 'Y') {
                    count = 1;
                    rand = baseballGame();
                } else break;
            }
        }
        System.out.println("프로그램이 종료됩니다.");
    }

    static int[] baseballGame() {
        int[] rand = new int[4];

        for (int i = 0; i < 4; i++) {
            rand[i] = (int) (Math.random() * 10);

            for (int j = 0; j < i; j++) {
                if (rand[i] == rand[j]) {
                    i--;
                }
            }
        }
        return rand;
    }

}