package hastane;
import java.util.LinkedList;


import static hastane.HastaneService.scanner;
import static hastane.HastaneService.slowPrint;

public class HastaService implements Service {
  static LinkedList<Hasta> hastaListesi = new LinkedList<>();


  @Override
  public void add() {

    System.out.println("Eklemek istediginiz hastanin ismini giriniz");
    String hastaAdi = scanner.nextLine();
    System.out.println("Eklemek istediginiz hastanin soyadini giriniz");
    String hastaSoyadi = scanner.nextLine();
    System.out.println("Eklemek istediginiz hastanin soyadini giriniz");
    int hastaId = hastaListesi.getLast().getHastaID() + 111;
    System.out.println("Durumunuzu yaziniz: " + "Allerji - Bas agrisi - Diabet - Soguk alginligi - Migren - Kalp hastaliklari");
    String durum = scanner.nextLine();
    Hasta hasta=new Hasta(hastaAdi,hastaSoyadi,hastaId,durum);
    hastaListesi.add(hasta);

  }

  @Override
  public void remove() {

  }

  @Override
  public void search() {

  }

  @Override
  public void list() {

  }

  @Override
  public void menu() {
    int secim = -1;
    while (secim != 0) {
      System.out.println("=======================================");
      System.out.println("Lutfen yapmak istediginiz islemi seciniz:\n1-Hasta Ekle\n2-Hasta Listesi Yazdir\n" +
              "3-Hasta Durumu Bul\n4-Hasta Sil\n0-CIKIS");
      System.out.println("=======================================");

      try {
        secim = scanner.nextInt();
      } catch (Exception e) {
        scanner.nextLine();
        System.out.println("Lutfen size sunulan seceneklerin disinda bir veri girisi yapmayiniz!");
        continue;
      }

      switch (secim) {
        case 1:
          add();

          break;
        case 2:
          list();

          break;
        case 3:
          search();

          break;
        case 4:
          remove();

          break;
        case 0:
          slowPrint("ANA MENUYE YONLENİDİRİLİYORSUNUZ....", 25);
          break;
        default:
          System.out.println("Hatali giris tekrar deneyiniz!");

      }

    }


  }
}