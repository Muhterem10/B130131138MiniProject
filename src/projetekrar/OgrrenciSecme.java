package projetekrar;

import java.util.Scanner;

public class OgrrenciSecme {
    /*
Proje: Spor kursu için seçilecek öğrencileri belirleyen
       bir uygulama yazınız.

       kurs gereklilikleri:
            erkekler: boy: 1.60 ve üstü
                      kilo:70-90 kg
            kızlar: boy: 1.50 ve üstü
                    kilo:50-70 kg

       kullanıcıdan öğrenci sayısı ve herbir öğrenci
       için isim , cinsiyet, kilo ve boy bilgilerini girmesini
       isteyiniz.
 */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("****Spor Salonu Ogrenci Secme*****");
        System.out.print("Girilecek Ogrenci Sayisi :");
        int ogreciSayisi=scan.nextInt();

        String[] name=new String[ogreciSayisi];
        String[] gender=new String[ogreciSayisi];
        double[] heigth=new double[ogreciSayisi];
        double[] weigth=new double[ogreciSayisi];
        boolean isSucces=true;


        do {
            isSucces=true;
            for (int i = 0; i <ogreciSayisi ; i++) {
                System.out.print("isim:");
                name[i]= scan.next();

                System.out.println("cinsiyete Kadin icin K Erkek icin E harfi giriniz");
                System.out.print("cinsiyet: ");
                String gen= scan.next().toUpperCase().substring(0,1);
                if (gen.equals("K")||gen.equals("E")){
                    gender[i]=gen;
                }else {
                    System.out.println("hatali giris");
                    isSucces=false;
                    break;
                }

                System.out.print("boy: ");
                heigth[i]=scan.nextDouble();


                System.out.print("Kilo: ");

                weigth[i]=scan.nextDouble();

            }

        }while (!isSucces);
        System.out.println();
        int counter=0;

        System.out.println("****Kursa Secilen Ogrenciler****");
        for (int i = 0; i <ogreciSayisi ; i++) {
            if(gender[i].equals("K") && weigth[i]>=50 && weigth[i]<=70 && heigth[i]>=1.50){
                System.out.println("isim: "+name[i]+" cinsiyet: "+gender[i]+" boy: "+heigth[i]+" kilo: "+weigth[i]);
                counter++;
            }else if(gender[i].equals("E") && weigth[i]>=70 && weigth[i]<=90 && heigth[i]>=1.60){
                System.out.println("isim: "+name[i]+" cinsiyet: "+gender[i]+" boy: "+heigth[i]+" kilo: "+weigth[i]);
                counter++;
            }

        }
        if (counter==0){
            System.out.println("kursa secilen ogrenci yok");
        }






    }
}
