package ngram;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ngram {
    static String[] uniArr = new String[200];
    String[] biArr = new String[200];
    String[] triArr = new String[200];

    int[] uniCount  = new int[200];
    int[] biCount   = new int[200];
    int[] triCount  = new int[200];

    public static void main(String[] args) {
        try{
            FileReader fin = new FileReader("C:\\\\Users\\\\jjjjy\\\\InJ\\\\Just\\\\src\\\\ngram\\\\ngramData.txt");
            int c, cnt=0, max=-1;
            while ((c=fin.read())!=-1){
                //uniArr[cnt] = String.valueOf((char) c);
                uniArr[cnt] = String.valueOf((char) c);

                int i=0, cnt2=0;
                while ((c=fin.read())!=-1) {
                    if(uniArr[cnt].equals(uniArr[cnt2])){
                        i++;
                    }
                    if(i>max) max=i;
                    cnt2++;
                   // System.out.print(max);
                }
                System.out.println(uniArr[cnt]);
                cnt++;
            }fin.close();
            try{
                FileWriter fout = new FileWriter("C:\\Users\\jjjjy\\InJ\\Just\\src\\ngram\\ngramOut");
                fout.write('걍');
                fout.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    void mostFreqUni(char c){

    }
}

