package projetekrarbiletrezervasyon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiletRezerv {
    /*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.

         Mesafe başına ücret 1 TL / km olarak alın.(Gidiş-Dönüş için *2)
         İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

       1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
       2-Yaş indirimi:
        Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
       3-Tekli Koltuk ücreti:
        Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 artırılır.

            */
    public static void main(String[] args) {
        List<String>seatNo=new ArrayList<>();
        for (int i =1; i <33 ; i++) {

            seatNo.add(String.valueOf(i));

        }
 Bilet bilet=new Bilet();
 Bus bus=new Bus("35 izm 35",seatNo );
   start(bilet,bus);

    }
public  static void start(Bilet bilet,Bus bus){
    Scanner scan=new Scanner(System.in);
    int select;
    do {
        System.out.println("Bilet REzervasyon sitemine Hosgeldiniz");
        System.out.println("Luften gidilecek mesafeyi km olarak giriniz");
       bilet.distance= scan.nextInt();
        System.out.println("Lutfen Yasinizi giriniz");
        int age=scan.nextInt();
        System.out.println("Lutfen Yolculuk tipini seciniz");
        System.out.println("1) Tek Yon \n 2) Gidis-donus");
        bilet.typNo=scan.nextInt();
        System.out.println("Lutfen Kltuk Seciniz");
        System.out.println("Tekli koltuk Fiyati %20 daha fazladir");
        System.out.println(bus.seat);
        bilet.seatNo=scan.nextInt();
        bus.seat.remove(String.valueOf(bilet.seatNo));
        boolean check=bilet.typNo==1 || bilet.typNo==2;
        if (bilet.distance>0 && age>0 && check){

        }else {
            System.out.println("Hatali Giris Yaptiniz");
        }
        System.out.println("Yeni islem icin 1, Cikis islemi icin 0 a basiniz");
        select=scan.nextInt();


    }while (select!=0);
    System.out.println("Iyi Gunler dileriz");

}

public static double getTotal(Bilet bilet,int age){
        double total=0;
        int dist=bilet.distance;
        int seatNo= bilet.seatNo;
        int type= bilet.typNo;
        switch (type){
            case 1:
                if (seatNo%3==0){
                    total=dist*1.2;
                }else {
                    total=dist*1;
                }
                break;
            case 2:
                if (seatNo%3==0){
                    total=dist*2.4;
                }else {
                    total=dist*2;
                }
                total=total*0.8;
                break;
        }

        if (age<=12){
            total=total/2;
        } else if (age>12 && age<=24) {
            total=total*0.9;
        } else if (age>65) {
            total=total*0.7;
        }


    return total;
}














}
