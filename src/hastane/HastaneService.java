package hastane;

import java.util.Scanner;

public class HastaneService {
    static Scanner scanner = new Scanner(System.in);

    public static void hastaneMenu() {


        slowPrint("\033[32m  ***** **** *** ** * DEV TEAM 03 HASTANESINE HOSGELDİNİZ * ** *** **** ***** \033[0m\n", 25);
        System.out.println("SAGLIGINIZ BİZİM ICIN ONEMLIDIR....");
        int secim=-1;
        do {
            System.out.println("Lutfen yapmak istediginiz islemi seciniz:\n1-Doktor Menusu:\n2-Hasta Menusu:\n" +
                    "3-Rezervasyon Menusu: \n0-CIKIS");
            try {
                secim=scanner.nextInt();
            }catch (Exception e){
                scanner.nextLine();
                System.out.println("Lutfen size sunulan seceneklerin disinda bir veri girisi yapmayiniz!");
                continue;
            }

            switch (secim) {
                case 1:
                    //Doktor Menu
                    break;
                case 2:
                    //Hasta Menu
                    break;
                case 3:
                    //Rezervasyon Menu
                    break;
                case 0:
                    slowPrint("Bizi tercih ettiginiz icin tesekkur eder saglikli gunler dileriz...",50);
                    break;
                default:
                    System.out.println("Hatali giris tekrar deneyiniz!");

            }

        }while (secim!=0);


    }


    public static void slowPrint(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
