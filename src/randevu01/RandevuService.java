package randevu01;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Scanner;

public class RandevuService {

    Scanner scan = new Scanner(System.in);

    List<Randevu> randevular = new ArrayList<>();

    public void getRandevu(DoktorService doktorService) {

        doktorService.printDoktor();
        System.out.println("Randevu Almak Istediginiz Dr. nosunu Giriniz");
        int selectDoktor = scan.nextInt();
        if (doktorService.doktorBul(selectDoktor) != null) {
            Doktor doktor=doktorService.doktorBul(selectDoktor);

            if (!doktor.getDate().isEmpty()){
                System.out.println("Lutfen Isminizi Giriniz");
                String name=scan.nextLine();
                name=scan.nextLine();
                System.out.println("Sayın "+name+" randevu alabileceğiniz tarihler: ");
                for(int i=0; i<doktor.getDate().size(); i++){
                    System.out.println(i+1 +" - "+doktor.getDate().get(i));
                }
                System.out.println("Randevu Almaka istediginiz Tarih Numarasini giriniz");
                int select=scan.nextInt();

                if(select>0 && select<=doktor.getDate().size()){
                    Randevu randevu=new Randevu(name,doktor,doktor.getDate().get(select-1));
                    this.randevular.add(randevu);
                    System.out.println("Sayin "  +name+",Randevu Tarihiniz :" + doktor.getDate().get(select) );
                    System.out.println("Randevu no: "+randevu.getId()+" ile randevu bilgilerinizi görüntüleyebilirsiniz.");
                    doktor.getDate().remove(select-1);
                }else{
                    System.out.println("Hatali Giris");
                }
            }else {
                System.out.println(doktor.getName()+" nun bu hafta tüm randevuları dolmuştur, daha sonra tekrar deneyiniz.");
            }

        } else {
            System.out.println("Hatali Giris");
        }
    }
}