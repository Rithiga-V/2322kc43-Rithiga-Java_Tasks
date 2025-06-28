package Task1;

public class BankAccount {
private String accountHolderName;
private double balance;

public BankAccount(String accountHolderName, double initialBalance)
{
	this.accountHolderName = accountHolderName;
	this.balance = initialBalance;
}
public void deposit(double amount) {
	if(amount>0) {
		balance+=amount;
		System.out.println("Deposited: $" +amount);
	}
	else {
		System.out.println("Deposit amount must be positive");
	}
}
public void withdraw(double amount) {
	if(amount>0) {
		if(amount<=balance) {
			balance-= amount;
			System.out.println("Withdraw: $" + amount);
		}
		else {
			System.out.println("Insufficient balance");
		}
	}
		else {
			System.out.println("Withdrawal amount must be positive");
		}
	}
	public double getBalance() {
		return balance;
	}
	public void displayAccountInfo() {
		System.out.println("AccountHolder: "+accountHolderName);
		System.out.println("Current Balance: $"+balance);
	}
	public static void main(String args[]) {
		BankAccount myAccount =  new BankAccount("Rithu",2000.0);
		myAccount.displayAccountInfo();
		myAccount.deposit(1000.0);
		myAccount.withdraw(100.0);
		myAccount.withdraw(500.0);
		myAccount.displayAccountInfo();
	
}
}
