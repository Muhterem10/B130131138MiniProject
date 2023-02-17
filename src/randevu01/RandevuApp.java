package randevu01;

import java.util.Scanner;

public class RandevuApp {
    public static void main(String[] args) {
        start();

    }
    public static void start(){
        Scanner scan=new Scanner(System.in);

        RandevuService randevuApp=new RandevuService();
        DoktorService drService=new DoktorService();
        System.out.println("====Hastane Randavu Sayfamiza Hasgeldiniz===");

        int select;

       do {
           System.out.println("1- Randevu Al");
           System.out.println("2- Randevu Goruntule");
           System.out.println("3- Randevu Randevu Sil");
           System.out.println("0- Cikis");
           System.out.println("Seciminiz");
           select= scan.nextInt();

           switch (select){
               case 1:
                  randevuApp.getRandevu(drService);
                   break;
               case 2:
                   //randevu goruntule
                   break;
               case 3:
                   //Randevu Randevu Sil
                   break;
               case 0:
                   //Cikis
                   break;
               default:
                   System.out.println("Hatali Giris");

           }



       }while (select!=0);



    }
}
