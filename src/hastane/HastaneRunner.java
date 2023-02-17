package hastane;

import java.util.LinkedList;

public class HastaneRunner {
    public static void main(String[] args) {
//        String hastaDurumu = "Diabet";
//        String unvan = doktorUnvan(hastaDurumu);
//        hastane1.setDoktor(doktorBul(unvan));
//        hastane1.setHasta(hastaBul(hastaDurumu));
//        System.out.println(hastane1.doktor);
//        System.out.println(hastane1.hasta);
        // HastaneService.hastaneMenu();
       // HastaneService.hastaneMenu();
        HastaService service = new HastaService();
        service.add();


    }

    private static Hastane hastane1 = new Hastane();

    public static String doktorUnvan(String aktuelDurum) {

        if (aktuelDurum.equals("Allerji")) {
            return "Allergist";
        } else if (aktuelDurum.equals("Bas agrisi")) {
            return "Norolog";
        } else if (aktuelDurum.equals("Diabet")) {
            return "Genel cerrah";
        } else if (aktuelDurum.equals("Soguk alginligi")) {
            return "Cocuk doktoru";
        } else if (aktuelDurum.equals("Migren")) {
            return "Dahiliye";
        } else if (aktuelDurum.equals("Kalp hastaliklari")) {
            return "Kardiolog";
        } else {
            return "Yanlis unvan";
        }

    }

    public static Doktor doktorBul(String unvan) {

        Doktor doktor = new Doktor();

        for (int i = 0; i < hastane1.unvanlar.length; i++) {

            if (hastane1.unvanlar[i].equals(unvan)) {
                doktor.setIsim(hastane1.doctorIsimleri[i]);

                doktor.setSoyIsim(hastane1.doctorSoyIsimleri[i]);

                doktor.setUnvan(hastane1.unvanlar[i]);


            }

        }

        return doktor;
    }

    public static Durum hastaDurumuBul(String aktuelDurum) {

        Durum hastaDurum = new Durum();

        switch (aktuelDurum) {
            case "Allerji":
                hastaDurum.setAciliyet(false);
                break;
            case "Bas agrisi":
                hastaDurum.setAciliyet(false);
                break;
            case "Diabet":
                hastaDurum.setAciliyet(false);
                break;
            case "Soguk alginligi":
                hastaDurum.setAciliyet(false);
                break;
            case "Migren":
                hastaDurum.setAciliyet(true);
                break;
            case "Kalp hastaliklari":
                hastaDurum.setAciliyet(true);
                break;
            default:
                System.out.println("Gecerli bir durum degil");

        }

        return hastaDurum;
    }

    public static Hasta hastaBul(String aktuelDurum) {
        Hasta hasta = new Hasta();

        for (int i = 0; i < hastane1.durumlar.length; i++) {
            if (hastane1.durumlar[i].equals(aktuelDurum)) {
                hasta.setHastaDurumu(hastane1.durumlar[i]);
                hasta.setHastaID(hastane1.hastaIDleri[i]);
                hasta.setIsim(hastane1.hastaIsimleri[i]);
                hasta.setSoyIsim(hastane1.hastaSoyIsimleri[i]);
            }
        }

        return hasta;
    }
}