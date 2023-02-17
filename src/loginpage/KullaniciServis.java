package loginpage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KullaniciServis {
    List<String> kullaniciadi = new ArrayList<>();

    List<String> mails = new ArrayList<>();

    List<String> sifre = new ArrayList<>();


    public KullaniciServis(List<String> kullaniciadi, List<String> mails, List<String> sifre) {
        this.kullaniciadi = kullaniciadi;
        this.mails = mails;
        this.sifre = sifre;
    }

    public void register(){
        Scanner inp=new Scanner(System.in);

        System.out.println("Ad-Soyad :");
        String name=inp.nextLine();

        String username;
        boolean existsUsername;
        do {
            System.out.println("Kullanici Adi Giriniz");
            username=inp.nextLine();
            existsUsername=this.kullaniciadi.contains(username);
            if (existsUsername){
                System.out.println("Bu username kullanilmis farkli bir usename giriniz");
            }


        }while (existsUsername);
        String email;
        boolean existsEmail;
        boolean isValid;
        do {
            System.out.println("Lutfen Email giriniz");
            email=inp.nextLine().trim();
            isValid=validateEmail(email);
            existsEmail=this.mails.contains(email);
            if (existsEmail){
                System.out.println("Bu email zaten kayıtlı, farklı bir email deneyiniz!");

                isValid = false;
            }

        }while (!isValid);

        String password;
        boolean isValidPwd;

        do {

            System.out.println("Lutfen password giriniz");
            password=inp.next().trim();
            isValidPwd=validatePassword(password);

        }while (!isValidPwd);



    }

    public void Login(){

        Scanner inp = new Scanner(System.in);

        System.out.println("Kullanıcı adı veya email giriniz:");

        String usernameOrEmail = inp.nextLine();//sparrow

        //kullanıcının girdiği değer email mi username mi?

        boolean isMail = this.mails.contains(usernameOrEmail);

        boolean isUsername = this.kullaniciadi.contains(usernameOrEmail); //sparrow kayıtlı ise true

        if (isUsername || isMail) {

            boolean isWrong = true;

            while (isWrong) {

                System.out.println("Şifrenizi giriniz: ");

                String password = inp.next();

                //username/email ile şifre aynı indexte olmalı

                int index;

                if (isUsername) {

                    index = this.kullaniciadi.indexOf(usernameOrEmail);

                } else {

                    index = this.mails.indexOf(usernameOrEmail);

                }

                if (this.sifre.get(index).equals(password)) {

                    System.out.println("Sisteme giriş yaptınız.");

                    isWrong = false;

                } else {

                    System.out.println("Şifreniz yanlış, tekrar deneyiniz!");

                }

            }

        } else {

            System.out.println("Sisteme kayıtlı kullanıcı bulunamadı.");

            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz lütfen üye olunuz.");

        }

    }

    public static boolean  validateEmail(String email){
        boolean isValid;

        boolean space = email.contains(" ");

        boolean isContainAt = email.contains("@");

        if (space) {

            System.out.println("Email boşluk içeremez!");

            isValid = false;

        } else if (!isContainAt) {

            System.out.println("Email @ içermelidir!");

            isValid = false;

        } else {//asd123-._@gmail.com split->[asd123-._,gmail.com]

            String firstPart = email.split("@")[0];

            String secondPart = email.split("@")[1];

            int notValid = firstPart.replaceAll("[a-zA-Z0-9_.-]", "").length(); //Asd12-._*=>*

            boolean checkStart = notValid == 0;


            boolean checkEnd = secondPart.equals("gmail.com") ||

                    secondPart.equals("hotmail.com") ||

                    secondPart.equals("yahoo.com");

            if (!checkStart) {

                System.out.println("email küçük harf, büyük harf, rakam ve -._ dışında karakter içeremez!");

            } else if (!checkEnd) {

                System.out.println("email gmail.com, hotmail.com veya yahoo.com ile bitmelidir!");

            }

            isValid = checkStart && checkEnd;

        }

        if (!isValid) {

            System.out.println("Geçersiz email, tekrar deneyiniz.");

        }

        return isValid;

    }

    public static boolean validatePassword(String password){
        boolean isValid;

        String upperLetter = password.replaceAll("[^A-Z]", "");//asDF123->DF

        String lowerLetter = password.replaceAll("[^a-z]", "");

        String digit = password.replaceAll("[\\D]", "");

        String symbol = password.replaceAll("[\\P{Punct}]", "");

        boolean space = password.contains(" ");

        boolean lengthGt6 = password.length() >= 6;

        boolean existsUpper = upperLetter.length() > 0;

        boolean existsLower = lowerLetter.length() > 0;

        boolean existsDigit = digit.length() > 0;

        boolean existsSymbol = symbol.length() > 0;

        if (space) {

            System.out.println("Şifre boşluk içeremez!");

        } else if (!lengthGt6) {

            System.out.println("Şifre en az 6 karakter olmalıdır!");

        } else if (!existsUpper) {

            System.out.println("Şifre en az bir tane büyük harf içermelidir!");

        } else if (!existsLower) {

            System.out.println("Şifre en az bir tane küçük harf içermelidir!");

        } else if (!existsDigit) {

            System.out.println("Şifre en az bir tane rakam içermelidir!");

        } else if (!existsSymbol) {

            System.out.println("Şifre en az bir tane sembol içermelidir!");

        }

        isValid = !space && lengthGt6 && existsUpper && existsLower && existsDigit && existsSymbol;

        if (!isValid) {

            System.out.println("Tekrar deneyiniz!");

        }

        return isValid;


    }
        }