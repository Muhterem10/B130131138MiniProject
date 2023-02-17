package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pinNumber;
    private double checkingBalance;
    private double savingBalance;


    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }


    public void setInput(Scanner input) {
        this.input = input;
    }

    private double calculateCheckingBalanceAfterWithDraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }


    private double calculateCheckingBalanceAfterDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    private double calculateSavigBalanceAfterWithDraw(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    private double calculateSavingBalanceAfterDeposit(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }

    public void getCheckingWithdraw() {
        System.out.println("Your Checking Balance is :" + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you would like to withdraw!");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Negative or zero amount is not acceptable!");
            getCheckingWithdraw();
        } else if (checkingBalance >= amount) {
            calculateCheckingBalanceAfterWithDraw(amount);

            System.out.println("Your Checking Balance is :" + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("You do not have enough money your account!");


        }

    }

    //interact with customer to deposit money to checking account
    public void getCheckingDeposit() {
        System.out.println("Your checking balance is :" + moneyFormat.format(checkingBalance));

        System.out.println("Enter the amount you would like to deposite!");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or zero amount is not acceptable!");
            getCheckingDeposit();
        } else {
            calculateCheckingBalanceAfterDeposit(amount);

            System.out.println("Your checking Balance is :" + moneyFormat.format(checkingBalance));
        }

        //Interact with customer to withdraw from saving account


    }

    public void getSavingWithDraw() {
        System.out.println("Your saving balance is :" + moneyFormat.format(savingBalance));

        System.out.println("Enter the amount you would like to withdraw");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or zero amount is not acceptable!");
            getSavingWithDraw();
        } else if (savingBalance >= amount) {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println("Your saving balance is :" + moneyFormat.format(savingBalance));


        }


    }

    public void getSavingDeposit() {
        //before transaction, we user their current balance for saving acoount
        System.out.println("Your saving balance is :" + moneyFormat.format(savingBalance));

        System.out.println("Enter the amount you would like to deposit!");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or zero amount is not acceptable!");
            getSavingDeposit();
        } else {
            calculateSavigBalanceAfterWithDraw(amount);
            System.out.println();
            System.out.println("Your saving balance is :" + moneyFormat.format(savingBalance));
        }


    }


    public void getCheckingWithDraw() {
        System.out.println("Enter the amount withdraw : " + moneyFormat.format(getCheckingBalance()));

        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("invalid value");
        } else if (checkingBalance <= amount) {
            System.out.println("you do not have enough money!");

        } else {
            calculateCheckingBalanceAfterWithDraw(amount);
            input.nextInt();
            System.out.println("Your saving balance is : " + moneyFormat.format(getCheckingBalance()));
        }

    }

}
