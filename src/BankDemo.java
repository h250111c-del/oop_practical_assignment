import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args){
        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("C001", 1000, 100, 0.02));
        accounts.add(new CurrentAccount("S001", 500, 500, 10.00));

        System.out.println("---Initial Balance---");

        for (Account account : accounts){
            System.out.println(account.accountNumber + " Balance: $" + account.getBalance());
        }

        System.out.println("\nNormal transactions");
        accounts.get(0).withdraw(200);
        accounts.get(1).withdraw(700);

        System.out.println("\n EDGE CASE 1: SAVINGS WITHDRAWAL REJECTED");
        accounts.get(0).withdraw(750);

        System.out.println("\n EDGE CASE 2: CURRENT WITHDRAWAL REJECTED");
        accounts.get(1).withdraw(200);

        System.out.println("\n Enf of Month");

        for (Account account : accounts){
            System.out.println("\nProcessing account: " + account.accountNumber);

            account.endOfMonth();
            System.out.println("Final balance: $" + account.getBalance());
        }
    }
}
