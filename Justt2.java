/*
    학번: 201858135
    이름: 장보경
 */
import java.math.BigInteger;

import static java.lang.Character.getNumericValue;

public class Justt2 {
    public static void main(String[] args) {
        String str="JEONGJONGJINICHEON";  //"JANGBOGYEONGICHEON""HONGKILDONGYONGIN"
        byte[] bytes=str.getBytes();
        byte temp[][] = new byte[bytes.length/4+1][bytes.length/4];
        int [][]ints = new int[bytes.length/4+1][(bytes.length/4)*2];
        int [][]ints2 = new int[bytes.length/8][(bytes.length/4)*2];
        int [] ints3 = new int[(str.length()/4)*2];
        int [][]ints4 = new int[bytes.length/4+1][(bytes.length/4)*2];
        int ints5[]= new int[(bytes.length/4)*2];
        int ints6[]= new int[(bytes.length/4)*2];
        char [][]chArr = new char[bytes.length/4+1][(bytes.length/4)*2];
        char [][]chArr2 = new char[bytes.length/4+1][(bytes.length/4)*2];
        char [][]chars = new char[bytes.length/8][(bytes.length/4)*2];
        char []chars2 = new char[(bytes.length/4)*2];
        char []chars3;
        int sum = 0;
        int sum2 = 0;
        int tens = 0;
        int units = 0;
        Long sum3;
        String s="";
        String s2="";
        String s3;
        String s4;
        String str2;
        String str3;
        String sArr[];
        char c;

        int k=0;
        for(int i=0; i<str.length()/4+1; i++){
            for(int j=0; j<str.length()/4; j++){
                if(k>=bytes.length){
                    temp[i][j]='0';
                    System.out.print((char)temp[i][j]);
                }
                else {
                    temp[i][j]=bytes[k];
                    System.out.print((char)temp[i][j]);
                }
                k++;
            }
            System.out.println();
        }
        System.out.println("***************************************");
        System.out.println("<< 16진수로 변환 >>");

        StringBuilder sb = new StringBuilder(bytes.length*2);
        for(byte bt:bytes){
            sb.append(String.format("%02x", bt));
        }

        char[] ch = sb.toString().toCharArray();

        k=0;
        for(int i=0; i<str.length()/4+1; i++){
            for(int j=0; j<(str.length()/4)*2; j++){
                if(k>=ch.length){
                    chArr[i][j]='0';
                    ints[i][j]= getNumericValue(chArr[i][j]);
                    System.out.print(chArr[i][j]);
                }
                else {
                    chArr[i][j]=ch[k];
                    ints[i][j]=getNumericValue(chArr[i][j]);
                    System.out.print(chArr[i][j]);
                }
                k++;
            }
            System.out.println();
        }
        System.out.println("---------");

        for(int j=(str.length()/4)*2-1; j>=0; j--){
            for(int i=0; i<str.length()/4+1; i++){
                sum += ints[i][j];
            }
            str2 = Integer.toHexString(sum);
            ch = str2.toCharArray();
            chars[0][j]=ch[1];
            chars[1][j]=ch[0];
            ints2[0][j]=getNumericValue(ch[1]);
            ints2[1][j]=getNumericValue(ch[0]);
            if((str.length()/4)*2-1-1==j){
                sum2 = Integer.parseInt(str2) + ints2[1][j+1];
                tens = sum2/10;
                units = sum2%10;
                ints2[0][j] = tens;
                ints2[1][j] = units;
            }
            if((str.length()/4)*2-1-1>j){
                c = chars[0][j];
                if(c=='a'||c=='b'||c=='c'||c=='d'||c=='e'||c=='f'){
                    str3 = Integer.toHexString(Integer.parseInt(str2,16) + ints2[0][j+1]);
                    sArr = str3.split("");
                    tens=Integer.parseInt(sArr[0]);
                    if(sArr[1].equals("a")||sArr[1].equals("b")||sArr[1].equals("c")||sArr[1].equals("d")||sArr[1].equals("e")||sArr[1].equals("f")){
                        chars[0][j] = sArr[1].charAt(0);
                    }
                    else {
                        chars[0][j] = sArr[1].charAt(0);
                        units=Integer.parseInt(sArr[1]);
                        ints2[1][j]=units;
                    }
                }
                else{
                    sum2 = Integer.parseInt(str2) + ints2[0][j+1];
                    tens = sum2/10;
                    units = sum2%10;
                    ints2[1][j] = units;
                }
                ints2[0][j] = tens;
            }
            sum=0;
            sum2=0;
            tens=0;
            units=0;
        }


        for (int j=0; j< (str.length() / 4) * 2 - 1; j++) {
            if(chars[0][j]=='a'||chars[0][j]=='b'||chars[0][j]=='c'||chars[0][j]=='d'||chars[0][j]=='e'||chars[0][j]=='f'){
                System.out.print(chars[0][j]);
            }
            else{
                System.out.print(ints2[1][j]);
            }

        }
        System.out.print(chars[0][7]);
        System.out.println();
        for (int j=0; j< (str.length() / 4) * 2 - 1; j++) {
            System.out.print(ints2[0][j]);
        }
        System.out.print(chars[1][7]);
        System.out.println();
        System.out.println("***************************************");
        System.out.println("<< Sum >>");

        for (int j=0; j< (str.length() / 4) * 2; j++) {
            if(j==7){
                chars2[j] = chars[0][7];
            }
            else {
                if(chars[0][j]=='a'||chars[0][j]=='b'||chars[0][j]=='c'||chars[0][j]=='d'||chars[0][j]=='e'||chars[0][j]=='f'){
                    chars2[j] = chars[0][j];
                }
                else{
                    chars2[j] = Character.forDigit(ints2[1][j], 16);
                }

            }
            System.out.print(chars2[j]);
        }
        System.out.print(" + " + ints2[0][0] + "(Carry) = ");

        str3 = Character.toString(chars2[7]);
        str3 = Integer.toHexString(Integer.parseInt(str3,16) + ints2[0][0]);
        chars3 = str3.toCharArray();
        chars2[7] = chars3[0];
        for (int j=0; j< (str.length() / 4) * 2; j++) {
            System.out.print(chars2[j]);
        }
        System.out.println();
        System.out.println("***************************************");
        System.out.println("<< Checksum >>");
        System.out.print("~(");
        for (int j=0; j< (str.length() / 4) * 2; j++) {
            System.out.print(chars2[j]);
        }
        System.out.print(") = ");
        for (int j=0; j< (str.length() / 4) * 2; j++) {
            ints3[j]=Character.getNumericValue(chars2[j]);
            str3 = Integer.toHexString(15-ints3[j]);
            System.out.print(str3);
        }
        System.out.println(" --> 체크섬");
        System.out.println("***************************************");
        System.out.println("<< Verification >>");

        StringBuilder sb2 = new StringBuilder(bytes.length*2);
        for(byte bt2:bytes){
            sb2.append(String.format("%02x", bt2));
        }
        char[] ch2 = sb2.toString().toCharArray();

        k=0;
        for(int i=0; i<str.length()/4+1; i++){
            for(int j=0; j<(str.length()/4)*2; j++){
                if(k>=ch2.length){
                    chArr2[i][j]='0';
                    ints4[i][j]= getNumericValue(chArr2[i][j]);
                    System.out.print(chArr2[i][j]);
                }
                else {
                    chArr2[i][j]=ch2[k];
                    ints4[i][j]=getNumericValue(chArr2[i][j]);
                    System.out.print(chArr2[i][j]);
                }
                k++;
            }
            System.out.println();
        }
        System.out.println("---------");

        for (int j=0; j< (str.length() / 4) * 2; j++) {
            ints3[j]=Character.getNumericValue(chars2[j]);
            ints5[j]=15-ints3[j];
            ints6[j] = ints3[j] + ints5[j];
            str3 = Integer.toHexString(ints5[j]);
            System.out.print(str3);
        }
        System.out.println();
        for (int j=0; j< (str.length() / 4) * 2; j++) {
            s = Integer.toHexString(ints6[j]);
            s2 += Integer.toHexString(ints6[j]);
            System.out.print(s);
        }

        System.out.println();
        System.out.println("---------");
        System.out.println("+       1");

        s3 = new BigInteger(s2, 16).toString(2);
        sum3=Long.parseUnsignedLong(s3, 2);
        //s4 = Long.toHexString(0xffffffffL+1);
        s4 = Long.toHexString(sum3+1);
        System.out.println(s4);

    }
}
