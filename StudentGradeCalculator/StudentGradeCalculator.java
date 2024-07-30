/*  Task 3   ATM MACHINE */

import java.util.*;

class ATM {
    float Balance = 0;
    int PIN = 4880;

    public void pincheck() {
        System.out.println("Enter your pin:");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if (enteredpin == PIN) {
            menu();
        } else {
            System.out.println("Invalid Pin: Please check your pin:");
            menu();
        }

    }

    public void menu() {
        System.out.println("Enter your choices:");
        System.out.println("1. Check Balance:");
        System.out.println("2. Withdraw Balance:");
        System.out.println("3. Deposit Amount:");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            WithdrawBalance();
        } else if (opt == 3) {
            DepositAmount();
        } else if (opt == 4) {
            return;
        } else {
            System.out.println("Please choose valid choices:");
        }
    }

    public void checkBalance() {
        System.out.println("Balance:" + Balance);
        menu();
    }

    public void WithdrawBalance() {
        System.out.println("enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > Balance) {
            System.out.println("Insufficient Balance:");
        } else {
            Balance = Balance - amount;
            System.out.println("Balance withdrawl Sucessfully:");
        }
        menu();

    }

    public void DepositAmount() {
        System.out.println("Enter amout to Deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Amount deposited sucessfully:");
        menu();

    }

}

public class AtmMachine {
    public static void main(String[] args) {

        ATM obj = new ATM();
        obj.pincheck();
    }

}
