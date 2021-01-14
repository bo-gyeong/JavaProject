import java.util.Scanner;

public class ParkingFee {
    static int inH, inM, outH, outM;
    static int pTime;
    static int pFee = 2500;

    public static void main(String[] args) {
        System.out.println("<<< 입력 >>>");
        System.out.print("입차시각<hh:mm> ");
        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        String[] HM = time.split(":");
        inH = Integer.parseInt(HM[0]);
        inM = Integer.parseInt(HM[1]);

        System.out.print("출차시각<hh:mm> ");
        time = sc.next();
        HM = time.split(":");
        outH = Integer.parseInt(HM[0]);
        outM = Integer.parseInt(HM[1]);

        pTime =  parkingTime(inM, outM);
        pFee *= (pTime / 30) + 1;

        System.out.println();
        System.out.println("<<< 결과 >>>");
        if(pTime>=0){
            System.out.println("주차시간<분> : " + pTime);
            System.out.println("주차요금<원> : " + pFee);
        }
        else {
            System.out.println("시간 입력 오류!");
        }
    }

    static int parkingTime(int inM, int outM){
        if (inM <= outM) {
            pTime = (outH - inH) * 60 + (outM - inM);
        }
        else {
            pTime = (outH - inH - 1) * 60 + (outM - inM + 60);
        }
        return pTime;
    }
}
