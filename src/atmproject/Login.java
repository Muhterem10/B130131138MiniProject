package atmproject;

import java.util.HashMap;
import java.util.Map;

public class Login extends Account{
    Map<Integer, Integer> data = new HashMap<>();
    Options options = new Options();

    boolean flag = false;
    int count=0;
    public void login(){
        System.out.println("Welcome to my ATM..");
        int counter=0;
        do {

            data.put(12345,1234);// Person A
            data.put(23456,2345);//Person B
            data.put(34567,3456);//Person C
            data.put(45678,4567);//Person D

            try{

                System.out.println("Enter the account number: ");
                setAccountNumber(input.nextInt());
                System.out.println("Enter the pin number: ");
                setPinNumber(input.nextInt());

            }catch (Exception e){
                System.out.println("you entred an invalid chacter(s)!");
                System.out.println("Please provide and integer to proceed or press Q the system");
                String exit =input.nextLine();
                if(exit.equalsIgnoreCase("q")){
                    flag=false;
                }
                System.out.println("Lutfen gecerli bir karakter giriniz");
            }
            count=0;
            for(Map.Entry<Integer, Integer> w : data.entrySet()){
                if (w.getKey().equals(getAccountNumber())&& w.getValue().equals(getPinNumber())){
                    options.getAccountTypes();//you can start actions with any account
                }
                else{
                    count++;
                }


            }



            if (count==data.size()) {
                counter++;

                System.out.println("Account number or pin number is invalid");

                System.out.println("Press any integer proceed or press q to quit");

                String exit =input.nextLine();
                if(exit.equalsIgnoreCase("q")){
                    flag=false;
                }
            }
            if (counter==3){
                System.out.println("Your account has been blocked!!");
                flag=false;
            }

        }while (flag);
    }
}
