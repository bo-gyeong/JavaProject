import java.util.Scanner;

public class ArtistManagement {
    public static void main(String[] args) {
        int i, num;
        String searchName;
        artist[] artistArr = new artist[20];

        System.out.println("<입력>");
        System.out.print("몇 명의 아티스트를 입력하시겠습니까?(최대 20명): ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        while(num>20){
            System.out.print("다시 입력해주세요: ");
            num = sc.nextInt();
        }
        sc.nextLine();

        for(i=0; i<num; i++){
            artistArr[i] = new artist();
            System.out.print("아티스트 이름을 입력하세요: ");
            artistArr[i].setName((sc.nextLine()).toCharArray());
            System.out.print("아티스트 소속을 입력하세요: ");
            artistArr[i].setAgency((sc.nextLine()).toCharArray());
            System.out.print("아티스트 데뷔년도를 입력하세요: ");
            artistArr[i].setYear(Integer.parseInt(sc.nextLine()));
            System.out.print("아티스트 대표곡을 입력하세요: ");
            artistArr[i].setBestSong((sc.nextLine()).toCharArray());
        }

        System.out.println("<출력>");
        System.out.println(String.format("%10s %15s %10s %15s", "이름", "소속", "데뷔년도", "대표곡") );
        System.out.println("---------------------------------------------------------------------");
        for (i=0; i<num; i++){
            artistArr[i].printName();
            artistArr[i].printAgency();
            artistArr[i].printYear();
            artistArr[i].printBestSong();
            System.out.println();
        }

        System.out.println();
        System.out.println("<검색>");
        System.out.print("검색할 아티스트명을 쓰세요: ");
        searchName = (sc.nextLine());
        for(i=0; i<num; i++){
            if(String.valueOf(artistArr[i].name).equals(searchName)){
                System.out.print("아티스트명: " + String.valueOf(artistArr[i].name) + ",\t소속: " + String.valueOf(artistArr[i].agency) +
                        ",\t데뷔년도: " + artistArr[i].year + ",\t대표곡: " + String.valueOf(artistArr[i].bestSong));
                break;
            }
        }
        if(i==num){
            System.out.println("검색 결과가 없습니다.");
        }
    }
}

class artist{
    char name[] = new char[20];
    char agency[] = new char[20];
    int year;
    char bestSong[] = new char[20];

    void setName(char name[]){
        this.name = name;
    }
    void printName(){
        System.out.format("%10s", String.valueOf(name));
    }

    void setAgency(char agency[]){
        this.agency = agency;
    }
    void printAgency(){
        System.out.format("%15s", String.valueOf(agency));
    }

    void setYear(int year){
        this.year = year;
    }
    void printYear(){
        System.out.format("%10d",year);
    }

    void setBestSong(char bestSong[]){
        this.bestSong = bestSong;
    }
    void printBestSong(){
        System.out.format("%15s",String.valueOf(bestSong));
    }

}
