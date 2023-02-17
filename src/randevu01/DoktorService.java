package randevu01;

import java.util.ArrayList;
import java.util.List;

public class DoktorService {

    List<Doktor>doktorList = new ArrayList<>();


    public DoktorService() {
        Doktor doktor1=new Doktor(11,"Emine","Beyin Cerrahi");
        Doktor doktor2=new Doktor(22,"Seyma","Goz");
        Doktor doktor3=new Doktor(33,"Ali","KBB");
        Doktor doktor4=new Doktor(44,"Sevde","Ortopedi");
        Doktor doktor5=new Doktor(55,"Muhterem","Psikiyatri");
        this.doktorList.add(doktor1);
        this.doktorList.add(doktor2);
        this.doktorList.add(doktor3);
        this.doktorList.add(doktor4);
        this.doktorList.add(doktor5);
    }

    public void printDoktor(){

        System.out.println("===================  Doktorlarimiz  ===================");

        for (Doktor doktor :doktorList){
            System.out.println("Dr No: " + doktor.getId()+ " Doktor Adi : "+doktor.getName()+ " Departman :"+ doktor.getDepartman());
            System.out.println("Takvim");
            for (String date : doktor.getDate()){
                System.out.println(date);
            }
        }
        System.out.println("==========================================================");

    }

    public Doktor doktorBul(int id){
        for (Doktor dr :this.doktorList){
            if (dr.getId() == id){
                return dr;
            }
        }
        return null;
    }
}
