import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientBalanceException extends Exception{

    InsufficientBalanceException(String m) {
        super(m);
    }
}

class BankAccount
{
    double balance;

    BankAccount(double b) {
        this.balance = b;
    }

    void withdraw (double am) throws InsufficientBalanceException
    {
        if (am > balance){
            throw new InsufficientBalanceException("Insufficient Balance");
        }else{
            balance -= am;
            System.out.println("Updated Balance :"+balance);
        }
    }
}

public class Experiment8
{
    public static void main(String[] args) {
        
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Balance: ");
            double b = sc.nextDouble();
            BankAccount acc = new BankAccount(b);
            System.out.print("Withdrawal Amount: ");
            double am = sc.nextDouble();
            acc.withdraw(am);
        }
        catch (InsufficientBalanceException e)
        {
            System.out.println("Insufficient Balance");
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid Input");
        }
    }
}