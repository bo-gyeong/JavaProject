import java.math.BigInteger;

import static java.lang.Character.getNumericValue;

public class Checksum {
    public static void main(String[] args) {
        String str="JANGBOGYEONGICHEON";
        byte[] bytes=str.getBytes();
        byte temp[][] = new byte[bytes.length/4+1][bytes.length/4];

        System.out.println("<< 4바이트로 Parsing >>");
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
        }  //이름과 주소를 16진수로 변환

        char[] ch = sb.toString().toCharArray();
        char [][]chArr = new char[bytes.length/4+1][(bytes.length/4)*2];
        int [][]ints = new int[bytes.length/4+1][(bytes.length/4)*2];

        k=0;
        for(int i=0; i<str.length()/4+1; i++){
            for(int j=0; j<(str.length()/4)*2; j++){
                if(k>=ch.length){
                    chArr[i][j]='0';
                    ints[i][j]= getNumericValue(chArr[i][j]);
                    System.out.print(chArr[i][j]);
                }  //배열의 빈 부분에 0 넣기
                else {
                    chArr[i][j]=ch[k];
                    ints[i][j]=getNumericValue(chArr[i][j]);
                    System.out.print(chArr[i][j]);
                }  //배열을 16진수로 채워 넣기
                k++;
            }
            System.out.println();
        }
        System.out.println("---------");

        int [][]ints2 = new int[bytes.length/8][(bytes.length/4)*2];
        char [][]chars = new char[bytes.length/8][(bytes.length/4)*2];
        int sum = 0;
        int tens = 0;
        int units = 0;
        int sum2 = 0;
        String str2;
        String str3;
        String sArr[];
        char c;

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
                    }  //sArr[1]에 a~f가 들어간다면 String을 char로 변환하여 chars[0][j]에 넣기
                    else {
                        chars[0][j] = sArr[1].charAt(0);
                        units=Integer.parseInt(sArr[1]);
                        ints2[1][j]=units;
                    }  //sArr[1]에 숫자만 들어있다면 int형으로 변환하여 일의자리를 ints2[1][j]에 넣기
                }  //chars[0][j]에 a~f가 들어간다면 sArr배열에 넣기
                else{
                    sum2 = Integer.parseInt(str2) + ints2[0][j+1];
                    tens = sum2/10;
                    units = sum2%10;
                    ints2[1][j] = units;
                }  //chars[0][j]에 숫자만 들어있다면 int형으로 변환하여 십의자리와 일의자리로 나누기
                ints2[0][j] = tens;
            }  //십의 자리에 들어갈 숫자는 ints2[0][j]에 넣기
            sum=0;
            sum2=0;
            tens=0;
            units=0;
        }


        for (int j=0; j< (str.length() / 4) * 2 - 1; j++) {
            if(chars[0][j]=='a'||chars[0][j]=='b'||chars[0][j]=='c'||chars[0][j]=='d'||chars[0][j]=='e'||chars[0][j]=='f'){
                System.out.print(chars[0][j]);
            }  //chars[0][j]에 a~f가 들어있다면 문자 출력
            else{
                System.out.print(ints2[1][j]);
            }  //숫자만 들어있다면 숫자 출력

        }  //Carry 첫번째 줄 출력
        System.out.print(chars[0][7]);  //Carry 첫줄의 마지막 값 출력
        System.out.println();
        for (int j=0; j< (str.length() / 4) * 2 - 1; j++) {
            System.out.print(ints2[0][j]);
        }  //Carry 두번째 줄 출력
        System.out.print(chars[1][7]);  //Carry 두번째 줄의 마지막 값 출력
        System.out.println();
        System.out.println("***************************************");
        System.out.println("<< Sum >>");

        char []chars2 = new char[(bytes.length/4)*2];

        for (int j=0; j< (str.length() / 4) * 2; j++) {
            if(j==7){
                chars2[j] = chars[0][7];
            }  //Carry 첫줄의 마지막 값은 chars2[7]에 넣기
            else {
                if(chars[0][j]=='a'||chars[0][j]=='b'||chars[0][j]=='c'||chars[0][j]=='d'||chars[0][j]=='e'||chars[0][j]=='f'){
                    chars2[j] = chars[0][j];
                }  //만약 chars[0][j]에 a~f 들어있다면 chars2[j]에 값 넣기
                else{
                    chars2[j] = Character.forDigit(ints2[1][j], 16);
                }  //만약 숫자만 들어있다면 char로 변환하여 chars2[j]에 값 넣기

            }
            System.out.print(chars2[j]);
        }
        System.out.print(" + " + ints2[0][0] + "(Carry) = ");

        char []chars3;
        int [] ints3 = new int[(str.length()/4)*2];

        str3 = Character.toString(chars2[7]);
        str3 = Integer.toHexString(Integer.parseInt(str3,16) + ints2[0][0]);
        chars3 = str3.toCharArray();
        chars2[7] = chars3[0];  //1(Carry)를 더한 값을 chars2[7]에 넣음
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
            System.out.print(str3);  //15를 뺀 값을 출력
        }
        System.out.println(" --> 체크섬");
        System.out.println("***************************************");
        System.out.println("<< Verification >>");

        StringBuilder sb2 = new StringBuilder(bytes.length*2);
        for(byte bt2:bytes){
            sb2.append(String.format("%02x", bt2));
        }

        char[] ch2 = sb2.toString().toCharArray();

        char [][]chArr2 = new char[bytes.length/4+1][(bytes.length/4)*2];
        int [][]ints4 = new int[bytes.length/4+1][(bytes.length/4)*2];

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
        }  //16진수 표 출력
        System.out.println("---------");

        int ints5[]= new int[(bytes.length/4)*2];
        int ints6[]= new int[(bytes.length/4)*2];
        String s="";
        String s2="";

        for (int j=0; j< (str.length() / 4) * 2; j++) {
            ints3[j]=Character.getNumericValue(chars2[j]);
            ints5[j]=15-ints3[j];
            ints6[j] = ints3[j] + ints5[j];  //체크섬과 sum 더함
            str3 = Integer.toHexString(ints5[j]);
            System.out.print(str3);
        }  //체크섬 출력
        System.out.println();
        for (int j=0; j< (str.length() / 4) * 2; j++) {
            s = Integer.toHexString(ints6[j]);
            s2 += Integer.toHexString(ints6[j]);
            System.out.print(s);
        }  //위에 for문에서 계산된 ints6[j]를 16진수로 변환하여 FFFFFFFF 출력
        System.out.println();
        System.out.println("---------");
        System.out.println("+       1");

        Long sum3;
        String s3;
        String s4;

        s3 = new BigInteger(s2, 16).toString(2);
        sum3=Long.parseUnsignedLong(s3, 2);
        s4 = Long.toHexString(sum3+1);
        System.out.println(s4);  //FFFFFFFF에 1 더한 값 출력
    }
}
