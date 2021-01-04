package grade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        student stdArr[] = new student[100];
        int cnt = 0;
        int num, i;
        int choice;

        try{
            FileReader fin = new FileReader("C:\\\\Users\\\\jjjjy\\\\InJ\\\\Just\\\\src\\\\grade\\\\score.txt");
            BufferedReader br = new BufferedReader(fin);
            String line;
            System.out.println(String.format("%19s %4s %4s %3s", "학번", "중간", "기말", "총계"));
            System.out.println("     ------------------------------------");

            while ((line = br.readLine()) != null){
                stdArr[cnt] = new student();
                stdArr[cnt].setSno(line.substring(0,20).trim().toCharArray());
                stdArr[cnt].setMid(Integer.parseInt(line.substring(20,26).trim()));
                stdArr[cnt].setFin(Integer.parseInt(line.substring(26,32).trim()));
                stdArr[cnt].setTotal(Integer.parseInt(line.substring(32,38).trim()));
                System.out.println(line);

                cnt++;
            }
            System.out.println("데이터 개수 = " + cnt);
            br.close();
            fin.close();
        }catch (Exception e){
            try{
                FileWriter fout = new FileWriter("C:\\\\Users\\\\jjjjy\\\\InJ\\\\Just\\\\src\\\\grade\\\\score.txt");
                System.out.println("파일이 생성되었습니다.");
                e.printStackTrace();
                fout.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        while(true){
            System.out.println();
            System.out.println("1) 점수 추가");
            System.out.println("2) 점수 수정");
            System.out.println("3) 성적 처리");
            System.out.println("4) 파일에 저장");
            System.out.println("5) 파일 복사");
            System.out.println("6) 프로그램 종료");
            System.out.print("메뉴 선택: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            System.out.println();

            if(choice ==1){
                System.out.print("몇 명을 입력하시겠습니까? ");
                num = sc.nextInt();
                for(i=0; i<num; i++){
                    stdArr[i+cnt] = new student();
                    System.out.print("학번: ");
                    stdArr[cnt+i].setSno(sc.next().toCharArray());
                    System.out.print("중간: ");
                    stdArr[cnt+i].setMid(sc.nextInt());
                    System.out.print("기말: ");
                    stdArr[cnt+i].setFin(sc.nextInt());
                }
                cnt += num;
            }
            else if(choice == 2){
                char[] search_sno;
                int modify;
                System.out.print("수정할 학번: ");
                search_sno = sc.next().toCharArray();
                System.out.println("중간점수 수정:1, 기말점수 수정:2, 중간 및 기말점수 수정:3");
                System.out.print("==> ");
                modify = sc.nextInt();
                for(i=0; i<cnt; i++){
                    if(String.valueOf(search_sno).equals(String.valueOf(stdArr[i].sno))){
                        if(modify==1){
                            System.out.print("중간: ");
                            stdArr[i].setMid(sc.nextInt());
                            System.out.println("수정되었습니다.");
                            break;
                        }
                        else if(modify==2){
                            System.out.print("기말: ");
                            stdArr[i].setFin(sc.nextInt());
                            System.out.println("수정되었습니다.");
                            break;
                        }
                        else if(modify==3){
                            System.out.print("중간: ");
                            stdArr[i].setMid(sc.nextInt());
                            System.out.print("기말: ");
                            stdArr[i].setFin(sc.nextInt());
                            System.out.println("수정되었습니다.");
                            break;
                        }
                    }
                }
                if(i==cnt){
                    System.out.println("찾는 학번이 없습니다.");
                }
            }
            else if(choice==3){
                System.out.println(String.format("%19s %4s %4s %3s", "학번", "중간", "기말", "총계"));
                System.out.println("     ------------------------------------");
                for(i=0; i<cnt; i++){
                    stdArr[i].total = stdArr[i].mid + stdArr[i].fin;
                    System.out.println(String.format("%20s %5s %5s %5s", String.valueOf(stdArr[i].sno), stdArr[i].mid, stdArr[i].fin, stdArr[i].total));
                }
            }
            else if(choice==4){
                try{
                    FileWriter fout = new FileWriter("C:\\\\Users\\\\jjjjy\\\\InJ\\\\Just\\\\src\\\\grade\\\\score.txt");
                    for(i=0; i<cnt; i++){
                        fout.write(String.format("%20s %5s %5s %5s\n", String.valueOf(stdArr[i].sno), stdArr[i].mid, stdArr[i].fin, stdArr[i].total));
                    }
                    System.out.println("저장되었습니다.");
                    fout.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if(choice==5){
                try{
                    FileReader fin = new FileReader("C:\\\\Users\\\\jjjjy\\\\InJ\\\\Just\\\\src\\\\grade\\\\score.txt");
                    FileWriter cpy = new FileWriter("C:\\\\Users\\\\jjjjy\\\\InJ\\\\Just\\\\src\\\\grade\\\\score.txt_사본");
                    int c;
                    while((c=fin.read()) != -1) {
                        cpy.write((char)c);
                    }
                    System.out.println("복사되었습니다.");
                    fin.close();
                    cpy.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if(choice==6){
                System.out.println("--- 종료합니다 ---");
                break;
            }
            else{
                System.out.print("입력 오류입니다. 다시 입력해주세요.");
            }
        }
    }
}

class student{
    char[] sno = new char[20];
    int mid, fin, total;

    void setSno(char[] sno){
        this.sno = sno;
    }

    void setMid(int mid){
        this.mid = mid;
    }

    void setFin(int fin){
        this.fin = fin;
    }

    void setTotal(int total){
        this.total = total;
    }
}
