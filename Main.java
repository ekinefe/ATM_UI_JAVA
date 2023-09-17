import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int userPassword = 1234;
    public static float userMoney= 500;
    public static int userSeletion;
    public static int withdrawalAmount;
    public static int depositAmount;
    public static String separator = "--------------------------";

    public static void main(String[] args) {
        System.out.println("\n\tATM_UI_JAVA");
        Main.passwordCheck();
    }
    public static void  passwordCheck(){
        System.out.println(separator);
        System.out.print("\nPleas enter your  password:\t");
        int password = scanner.nextInt();
        System.out.println("\n\tVerifying yor identity");

//Password checking.
        if(userPassword == password){
            System.out.println("\n\tIdentity verification is successful.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (java.lang.InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Main.labels();
        }
        else{
            System.out.println("\n\tYour password is WRONG !!!");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (java.lang.InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Main.passwordCheck();
        }
    }
    public static void labels (){
        System.out.println(separator);
        System.out.println("""
                Please choose an option:
                Withdraw.................1
                Deposit..................2
                Check Balance............3
                Exit.....................4
                """);
        userSeletion = scanner.nextInt();
        switch (userSeletion){
            case 1:
                Main.withdraw();
            case 2:
                Main.deposit();
            case 3:
                Main.checkBalance();
            case 4:
                System.exit(0);
        }
    }
    public static void withdraw() {
        System.out.println(separator);
        System.out.print("\nPleas enter your amount:");
        withdrawalAmount = scanner.nextInt();

        if (withdrawalAmount > userMoney){
            try {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (java.lang.InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("Not enough money");
        }
        else{
            System.out.println("Your request is being processed...");
            try {
                TimeUnit.SECONDS.sleep(withdrawalAmount/75);
            }
            catch (java.lang.InterruptedException e){
                Thread.currentThread().interrupt();
            }
            userMoney=userMoney-withdrawalAmount;
            System.out.println("Remaining amount on your bank account: " + userMoney + "\n" + "Please take your card." + "\n");
            try{
                TimeUnit.SECONDS.sleep(2);
            }
            catch (java.lang.InterruptedException e){
                Thread.currentThread().interrupt();
            }
            Main.labels();
        }
    }
    public static void deposit(){
        System.out.println(separator);
        System.out.print("Pleas enter the amount to deposit:");
        depositAmount= scanner.nextInt();
        try{
            TimeUnit.SECONDS.sleep(depositAmount/75);
        }
        catch (java.lang.InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        userMoney=userMoney+depositAmount;
        System.out.println("New amount on your bank account:\t"+userMoney);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (java.lang.InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Main.labels();
    }
    public static void checkBalance(){
        System.out.println(separator);
        System.out.println("The amount on your account:\t"+userMoney);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (java.lang.InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Main.labels();
    }
    public static void exit(){
        System.out.println(separator);
        System.out.println("\n\tPROGRAM IS OVER");
        System.exit(0);
    }
}