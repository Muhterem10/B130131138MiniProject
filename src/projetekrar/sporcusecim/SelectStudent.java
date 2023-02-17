package projetekrar.sporcusecim;

import java.util.Scanner;
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

public class SelectStudent {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.println("******  Atla Spor Merkezine Hosgeldiniz  ******");
        System.out.println("Lutfen Formu Doldurunuz");
        System.out.print("Lutfen Ogrenci Sayisini Giriniz :");
        int numStd=inp.nextInt();

        String[] students=new String [numStd];
        String[] gender=new String [numStd];
        Double[] height=new Double[numStd];
        Double[] weight=new Double[numStd];

        boolean isSucces;

        do {
              isSucces=true;
            for (int i=0; i<numStd; i++) {
                System.out.print("Isim : ");
                students[i] = inp.next();
                System.out.print("cinsiyet : ");
                String gen = inp.next().toUpperCase().substring(0,1);
                if (gen.equals("E")|| gen.equals("K")){
                    gender[i]=gen;
                }else {
                    System.out.println("Hatali Giris Yaptiniz");
                    isSucces=false;
                    break;
                }

                System.out.print("Boy : ");
                height[i]=inp.nextDouble();

                System.out.print("Kilo : ");
                weight[i]=inp.nextDouble();
            }

        }while (!isSucces);
        System.out.println();
        System.out.println("SPOR SALONUNA SECILEN OGRENCILER");
        int counter=0;

       for (int i=0; i<numStd; i++) {
           if (gender[i].equals("K")&& height[i]>1.50 && weight[i]>50 && weight[i]<70 ){
               System.out.println("Isim : " + students[i]  + " Boy : " + height[i] + " Kilo : " + weight[i] );
               counter++;
           }

           else if (gender[i].equals("E")&& height[i]>1.60 && weight[i]>70 && weight[i]<90 ){
               System.out.println("Isim : " + students[i]  + " Boy : " + height[i] + " Kilo : " + weight[i] );
               counter++;
           }

       }

       if (counter==0){
           System.out.println("Salona secilen ogrenci yoktur");
       }



    }
}
