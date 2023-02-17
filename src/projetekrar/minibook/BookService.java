package projetekrar.minibook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService implements ProductService{

    List<Book>bookList=new ArrayList<Book>();

    public BookService() {
        Book book1=new Book(1,"Vadideki Zambak","150 Lira",15,"Balzac","Penguin");
        Book book2=new Book(2,"Suç Ve Ceza","150 Lira",25,"Dostoyevski","Penguin");
        Book book3=new Book(3,"Sefiller","125 Lira",10,"V.Hugo","Dream");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }
    @Override
    public void prosesMenu() {
        Scanner inp = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitap ekle");
            System.out.println("3-Kitap sil");
            System.out.println("4-Yayınevine göre filtrele");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz:");
            choice = inp.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Ana Menuye Yonlendiriliyorsunuz...");
                    break;
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                case 4:
                    System.out.println("Yayınevi: ");
                    String pub = inp.next();
                    filterProduct(pub);
                default:
                    System.out.println("Hatali Giris!");


            }


        }
    }

    @Override
    public void listProduct() {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.printf("%-2s | %-15s | %-15s | %-10s | %-7s | %-5s \n","ID","Kitap Adı","Yazar Adı","Yayınevi","Birim Fiyat","Stok");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            for(Book book : this.bookList){
                System.out.printf("%-2s | %-15s | %-15s | %-10s | %-7s | %-5s \n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStok());

            }
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }




    @Override
    public void addProduct() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Kitap adı: ");
        String bookName=inp.nextLine();
        System.out.println("Yazar adı :");
        String authorName=inp.nextLine();
        System.out.println("Yayınevi: ");
        String pub=inp.nextLine();
        System.out.println("Birim Fiyat");
        String unitPrice=inp.nextLine();
        System.out.println("Stok :");
        int stock=inp.nextInt();
        Book newbook=new Book(this.bookList.get(bookList.size()-1).getId()+1,bookName,unitPrice,stock,authorName,pub);
        this.bookList.add(newbook);
        listProduct();


    }

    @Override
    public void removeProduct() {
        Scanner inp=new Scanner(System.in);
        boolean isExist=true;
        System.out.println("Kitap id:");
        int id=inp.nextInt();
        for(Book book:this.bookList){
            if (book.getId()==id){
                isExist=true;
                this.bookList.remove(book);
                System.out.println("Kitap silindi.");
                break;
            }else {
                isExist=false;
            }
        }
        if (!isExist){
            System.out.println("Kitap bulunamadı.");
        }
    }

    @Override
    public void filterProduct(String filter) {
        for(Book book:this.bookList){
            if (book.getPublisher().equalsIgnoreCase(filter)){//Penguin-penguin

                System.out.printf("%-2s | %-15s | %-15s | %-10s | %-7s | %-5s \n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getPrice(),book.getStok());

            }
        }


    }
}
