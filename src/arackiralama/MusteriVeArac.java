package arackiralama;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

import static java.time.LocalDate.*;

// Bu method’da alinacak sehir, teslim edilecek sehir, 
// alinacak gun ve teslim edilecek gun ve teslim saati bilgilerini aliniz.  
public class MusteriVeArac {

    public static void main(String[] args) {

 Scanner sc=new Scanner(System.in);
 System.out.println("Tarih gir");
       

        aracTalep();
    }




    static void aracTalep(){
        Scanner inp=new Scanner(System.in);
        System.out.println("Aracin Alinacagi Sehri giriniz");
        String alinacakSehir=inp.nextLine();
        System.out.println("Aracin Teslim Edilecegi Sehri giriniz");

       String teslimSehir=inp.nextLine();
        System.out.println("Aracin alis Tarihini Giriniz");

      LocalDate  alisTarih= LocalDate.parse(inp.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Aracin alis Saatini Giriniz");
     LocalTime  alisSaat= LocalTime.parse(inp.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println("Aracin Teslim Tarihini Giriniz");
      LocalDate  teslimTarih= LocalDate.parse(inp.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        boolean isBefore = alisTarih.isBefore(teslimTarih);
        if (!isBefore) {

            System.out.println("Teslim gunu, alis gününden daha once olamaz!");

            boolean isValid = true;


        } else if (isBefore) {

            System.out.println("Ayni gun icerisinde alinip teslim edilen araclar icin bir gunluk ucret alinir!");

        }
        System.out.println("Aracin Teslim Saatini Giriniz");
       LocalTime teskimSaat= LocalTime.parse(inp.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));


    }
}
