import java.util.Scanner;

public class CRC {
    public static void main(String[] args) {
        System.out.print("7자리의 Dividend를 입력: ");
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        byte n[] = new byte[7];

        for(int i=0; i<7; i++){
            String[] str = string.split("");
            n[i] = Byte.parseByte(str[i]);
        }

        byte crc[] = new byte[7];
        byte verification[] = new byte[7];
        byte result[] = new byte[3];
        System.out.print("Quotient&Remainder = ");

        for (int i = 0; i < n.length; i++) {
            if (i >= n.length-3) {
                crc[i]=(byte)0;
            }
            else if (n[i] == (byte)1) {
                if(n[i + 2] == (byte)1)
                    n[i + 2] = (byte)0;
                else if(n[i + 2] == (byte)0)
                    n[i + 2] = (byte)1;
                if(n[i + 3] == (byte)1)
                    n[i + 3] = (byte)0;
                else if(n[i + 3] == (byte)0)
                    n[i + 3] = (byte)1;
            }
            crc[i]=n[i];

            System.out.print(n[i]);
            if(i==3){
                System.out.print("&");
            }
        }
        System.out.println();
        System.out.print("CRC = ");
        for(int i=0; i<3; i++){
            System.out.print(crc[i+4]);
        }
        System.out.println();
        System.out.println("******************************");
        System.out.println("<<검증>>");
        System.out.print("Dividend = ");

        for (int i = 0; i < crc.length; i++) {
            if (i >= crc.length-3) {
                crc[i]=(byte)0;
            }
            else if (crc[i] == (byte)1) {
                if(crc[i + 2] == (byte)1)
                    crc[i + 2] = (byte)0;
                else if(crc[i + 2] == (byte)0)
                    crc[i + 2] = (byte)1;
                if(crc[i + 3] == (byte)1)
                    crc[i + 3] = (byte)0;
                else if(crc[i + 3] == (byte)0)
                    crc[i + 3] = (byte)1;
            }
            verification[i]=crc[i];

            System.out.print(crc[i]);
        }
        System.out.println();
        System.out.print("Result-> ");
        for(int i=0; i<3; i++){
            result[i] = verification[i+4];
            System.out.print(result[i]);
        }
        System.out.println();
        System.out.println("------------------");
        if(result[0]==0&&result[1]==0&&result[2]==0)
            System.out.println("검증완료");
        else
            System.out.println("실패");
    }
}