package projetekrar.minibook;

import java.util.Scanner;

public class MiniBookStore {
    public static void main(String[] args) {
        enter();
    }
public static void enter() {
    Scanner inp=new Scanner(System.in);
    System.out.println("--------Mini Book Store--------");
    int select=-1;
    while(select!=0){
        System.out.println("Urun Yonetim Panali");
        System.out.println("1-Kitaplar");
        System.out.println("2-Defterler");
        System.out.println("0-Cikis");
        System.out.println("Seciminiz");
        select=inp.nextInt();
        ProductService service=select==1 ? new BookService() : new NotebookService();
        if(select==1 || select==2){
            service.prosesMenu();
        }else if(select==0){
            System.out.println("İyi günler...");
        }else{
            System.out.println("Hatalı giriş.");
        }

    }
}

}
