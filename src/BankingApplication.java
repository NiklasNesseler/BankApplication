import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount obj = new BankAccount("Niklas Nesseler", "420");
        obj.showMenu();
    }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname , String cid) {
        customerName = cname;
        customerId = cid;
    }

    void Deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " +Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occurred");
        }
    }
    void showMenu() {

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID: " + customerId);
        System.out.println("\n");

        System.out.println("A : Check your Balance");
        System.out.println("B : Deposit");
        System.out.println("C : Withdraw");
        System.out.println("D : Previous Transaction");
        System.out.println("E : Exit the system");

        do {
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("Enter your Option");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            option = scanner.next().charAt(0);
            System.out.println("\n");


            switch (option) {
                case 'A' -> {
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Balance " + balance);
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("\n");
                }
                case 'B' -> {
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("-------------------------------------------------------------------------");
                    int amount = scanner.nextInt();
                    Deposit(amount);
                    System.out.println("\n");
                }
                case 'C' -> {
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("-------------------------------------------------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                }
                case 'D' -> {
                    System.out.println("------------------------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("\n");
                }
                case 'E' ->
                        System.out.println("==============================================================================");
                default -> System.out.println("Invalid option!! Please enter Correct Option.");
            }

        } while (option != 'E');
            System.out.println("Thank you for using our services!");
    }
}
