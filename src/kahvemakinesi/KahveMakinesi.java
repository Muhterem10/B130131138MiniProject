package kahvemakinesi;


import java.util.Scanner;

public class KahveMakinesi {
    public static void main(String[] args) {
        kahveSiparis();

    }
    public static void kahveSiparis(){
        System.out.println("******Kahve Memlekine Hosgeldiniz******");
        System.out.println("Hangi Kahveyi Istersiniz? \n 1- Turk Kahvesi \n 2-Filtre Kahve \n 3- Expresso Kahve" );
        System.out.print("Siparisiniz: ");
        Scanner inp=new Scanner(System.in);
        String kahveTercih= inp.nextLine().toLowerCase();
        System.out.println("Kahvenize Sut Ister misiniz?");
        String sutTercih= inp.next().toLowerCase();
        if (sutTercih.equals("evet")) {
            System.out.println(" Siparisiniz : " + kahveTercih + "\n Sut Tercihiniz : " + "(" + sutTercih + ")");
        }else {
            System.out.println(" Siparisiniz : " + kahveTercih + "\n Kahvenize Sut Ilave Edilmiyor");
        }
        System.out.println("*****");
        System.out.println("Kahveniz Hangi Boyutta olsun ");
        System.out.print("Kahve Boyutu: ");
        String kahveBoyut= inp.nextLine().toLowerCase();
        if (kahveBoyut.equals("kucuk boy")){
            System.out.println("Kahveniz " +kahveBoyut + "hazirlaniyor");
        }



    }
}
