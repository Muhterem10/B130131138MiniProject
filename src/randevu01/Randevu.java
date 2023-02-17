package randevu01;

public class Randevu {
    public static int count=0;
    private  int id;

    private String name;
    private Doktor doktor;
    private String date;

    public Randevu( String name, Doktor doktor, String date) {
        count++;
        this.id=count;
        this.name = name;
        this.doktor = doktor;
        this.date = date;
    }

    public int getId() {
        return id;
    }
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
