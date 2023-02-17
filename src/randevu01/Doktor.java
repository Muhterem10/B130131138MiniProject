package randevu01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doktor {

   private int id;
   private String name;
   private String departman;

   private List<String>date=new ArrayList<>();

    public Doktor(int id, String name, String departman) {
        this.id = id;
        this.name = name;
        this.departman = departman;

        LocalDate day=LocalDate.now();//sisteme girilen tarih

        for(int i=0; i<=5; i++){
              day=day.plusDays(1);
              this.date.add(day.toString());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }
}
