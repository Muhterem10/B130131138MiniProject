package repeatlogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//5-User objesiyle ilgili işlemler
public class UserService {
    List<User> myList = new ArrayList<User>();
    Scanner input = new Scanner(System.in);

    private User getUser(String userNameOrMail) {
        for (User user : myList) {
            if (user.getUsername().equals(userNameOrMail)) {
                return user;
            } else if (user.getEmail().equals(userNameOrMail)) {
                return user;
            }

        }
        return null;
    }

   public  static boolean validateEmail(String email) {
       boolean isValid;
       boolean isExistSpace=email.contains(" ");
       boolean isExistAt=email.contains("@");
       if (isExistSpace){
          System.out.println("Email Bosluk icermemeli");
          isValid=false;
       } else if (!isExistAt) {
          System.out.println("Email '@' sembolu icermeli");
          isValid=false;
       }else{
     String firstPart= email =email.split("@")[0];
     String secondPart= email =email.split("@")[1];
     boolean valid=firstPart.replaceAll("[a-zA-Z_.-]","").isEmpty();
     boolean checkStart=valid&& firstPart.length()>0;
     boolean checkEnd=secondPart.equals("gmail.com")||secondPart.equals("yaho.com")||secondPart.equals("hotmail.com");
     if (!checkStart){
         System.out.println("Mailin kullanici adi bolumu en az 6 karakter olmali en az bir buyuk arf kucuk harf ve sembol olmalidir");
     }
     if (!checkEnd){
         System.out.println("email gmail.com, hotmail.com veya yahoo.com ile bitmelidir!");
     }
           isValid=checkStart && checkEnd;
       }
       if (!isValid){
           System.out.println("Tekrar deneyiniz");
       }
       return isValid;
   }
   private static boolean validatePassword(String password){
        boolean isValid;
        boolean isExistsSpace=password.contains(" ");
        boolean isLengthGtSix=password.length()>=6;
        boolean isExistUpperLetter=password.replaceAll("[^A-Z]","").length()>0;
        boolean isExistLowerLetter=password.replaceAll("[^a-z]","").length()>0;
        boolean isExistsDigit=password.replaceAll("[\\D]","").length()>0;
        boolean isExistsSymbol=password.replaceAll("[\\p{Punct}]","").length()>0;
       if(isExistsSpace){
           System.out.println("Şifre boşluk içeremez.");
       }else if(!isLengthGtSix){
           System.out.println("Şifre en az 6 karakter içermelidir.");
       } else if (!isExistUpperLetter) {
           System.out.println("Şifre en az 1 tane büyük harf içermelidir.");
       } else if (!isExistLowerLetter) {
           System.out.println("Şifre en az 1 tane küçük harf içermelidir.");
       } else if(!isExistsDigit){
           System.out.println("Şifre en az 1 tane rakam içermelidir.");
       } else if (!isExistsSymbol) {
           System.out.println("Şifre en az 1 tane sembol içermelidir.");
       }
      isValid=!isExistsSpace && isLengthGtSix && isExistUpperLetter && isExistLowerLetter && isExistsDigit && isExistsSymbol;
       if (!isValid){
           System.out.println("Gecersiz Sifre Tekrar Deneyiniz");
       }
       return isValid;
   }
 public void register(){
     System.out.println("Ad-Soyad Giriniz");
     String name=input.nextLine();

     String username=getUserName();

     String email=getEmail();

     String password=getPassword();
     User user=new User(name, username, email, password);
         this.myList.add(user);
     System.out.println("Tebrikler işleminiz başarıyla gerçekleştirildi.");
     System.out.println("Kullanıcı adı (veya email) ve şifrenizle sisteme giriş yapabilirsiniz.");

 }
 private String getUserName() {
        String username;
        boolean existsUsername;
        do {
            System.out.println("Kullanıcı adı giriniz:");
            username = input.nextLine();
            existsUsername=getUser(username)!=null;
            if (existsUsername){
                System.out.println("Bu usernname kullanilmis farkli username kullan");
            }
        }while (!existsUsername);

return username;
    }
    private String getEmail() {
        String email;
        boolean isValid;
        boolean existEmail;
        do {
            System.out.println("Emailinizi giriniz:");
            email = input.nextLine();//bu username daha önce kullanılmış mı?
            existEmail=validateEmail(email);
            isValid=getUser(email)!=null;
            if (existEmail){
                System.out.println("Bu mail kayitli farkli mail deneyiniz");
                isValid=false;
            }
        }while (!isValid);

return email;
    }
    private String getPassword() {
     String passw;
     boolean isValidPass;

     do {
         System.out.println("Passwrd u giriniz");
         passw=input.nextLine();
        isValidPass=validatePassword(passw);

     }while (!isValidPass);
        return passw;
     }

}