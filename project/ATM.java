package project;

import java.util.HashMap;
import java.util.Scanner;

class Data{
    float balance;
}
class ATMop{
    Scanner sc=new Scanner(System.in);
   // float balance;
    HashMap<Integer , Data> map=new HashMap<>();
    ATMop(){
        System.out.println("**********************************************");
        System.out.println("Welcome to our ATM!");
        checkAnotherAccount();
    }
    public void checkAnotherAccount(){
        System.out.println("**********************************************");
        System.out.println("Enter your Pin code:-");
        int pinCode=sc.nextInt();

        if(map.containsKey(pinCode) == true){
            Data obj= map.get(pinCode);
            menu(obj);
        }
        else {
            System.out.println("**********************************************");
            System.out.println("Please create your account first");
            System.out.println("Set your Pin-code:-");
            int pin=sc.nextInt();
            Data obj=new Data();
            map.put(pin,obj);
            menu(obj);

        }

    }
    public void menu(Data obj){
        Scanner sc=new Scanner(System.in);
        System.out.println("**********************************************");
        System.out.println("Please enter valid no");
        System.out.println("1:-Check Balance");
        System.out.println("2:-Deposit Money");
        System.out.println("3:-Withdraw money");
        System.out.println("4:-Check another account");
        System.out.println("5:-Exit");

        int x=sc.nextInt();
        if(x == 1){
            checkBalance(obj);
        }
        else if (x==2) {
            deposit(obj);
        }
        else if(x == 3){
            withdraw(obj);
        }
        else if(x == 4){
            checkAnotherAccount();
        }
        else if(x == 5){
            System.out.println("Thank you!");
        }
        else {
            System.out.println("Please enter the valid number");
            menu(obj);
        }
    }
    public void checkBalance(Data obj){
        System.out.println("**********************************************");
        System.out.println("Your Balance"+obj.balance);
        System.out.println("**********************************************");
        menu(obj);
    }
    public void deposit(Data obj){
        System.out.println("Enter your amount:-");
        float a=sc.nextFloat();

        obj.balance=obj.balance+a;
        System.out.println("Amount Deposited Successfully!");
        System.out.println("**********************************************");
        menu(obj);
    }
    public void withdraw(Data obj){
        System.out.println("Enter your Amount:-");
        float a=sc.nextFloat();
        if(obj.balance>=a) {
            obj.balance = obj.balance - a;
            System.out.println("Balance Withdraw Successfully!");
        }
        else {
            System.out.println("Insufficient Balance!");
        }
        System.out.println("**********************************************");
        menu(obj);
    }
}
public class ATM {
    public static void main(String[] args) {
        ATMop obj=new ATMop();
    }
}