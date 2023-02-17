package projetekrarbiletrezervasyon;

public class Bilet {
    public  int typNo;

    public  int distance;

    public int price;

    public  int seatNo;

    public void printbilet(){
        System.out.println("Toplam tutar " +price);
        System.out.println("-----Bilet Detay--- " );
        System.out.println("Mesafe " +distance);
        System.out.println("Yolculuk tipi " +(typNo==1 ? "Tek Yon": "Gidis=donus"));
        System.out.println("Koltuk no: " +seatNo);
        System.out.println("Keyifli yolculuklar");
    }
















}
