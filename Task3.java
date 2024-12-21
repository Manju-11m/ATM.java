import java.util.Scanner;
class Bankaccount{
    private double balance;

    public Bankaccount(double initialbalance){
        if(initialbalance<0){
            throw new  IllegalArgumentException("Initial balance cannot be negative.");
            
        }
        this.balance=initialbalance;
    }

public void deposit(double amount){
    if(amount<=0){
        throw new IllegalArgumentException("Deposit amount must be positive.");
   }
   balance +=amount;
   System.out.println("Deposit successfully.New balance:"+balance);
}
public void withdraw(double amount){
    if(amount<=0){
        throw new IllegalArgumentException("withdraw amount must be positive.");
   }
   if(amount>balance){
    System.out.println("Insufficient balance.");
   }
   else{
    balance-=amount;
    System.out.println("Withdrawl successfully.New balance:"+balance);    
   }

}
public double checkbalance(){
    return balance;
}
}
class ATM{
    private Bankaccount account;

    public ATM(Bankaccount account){
        this.account=account; 

    }
    public void displaymenu(){
        System.out.println("\nWelcome to ATM!");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit");
    }
    public void handleuserinput(int choice){
Scanner sc=new Scanner(System.in);

switch(choice)
{
    case 1:System.out.println("Enter amount to withdraw:");
    double withdrawamount =sc.nextDouble();
    account.withdraw(withdrawamount);
    break;

    case 2:System.out.println("ENter amount to deposit:");
    double depositamount =sc.nextDouble();
    account.deposit(depositamount);
    break;

    case 3:System.out.println("Current balance:"+account.checkbalance());
    break;

    case 4:
    System.out.println("Thank you to using ATM.Goodbye!");
    System.exit(0);
    break;

    default:
    System.out.println("Invalid choice.Please try again.");

}
}
public void run(){
    Scanner sc=new Scanner(System.in);
    while(true){
        displaymenu();
        System.out.println("Select an opction:");
        int choice=sc.nextInt();
        handleuserinput(choice);
    }
    
}
}

public class Task3 {
public static void main(String[] args) {
    Bankaccount myaccount=new Bankaccount(1000.0);
    ATM atm=new ATM(myaccount);
    atm.run();
}
    
}