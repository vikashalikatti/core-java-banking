package banking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankInfo {
	private String accno;
	private String name;
	private String acc_type;
	private long balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
}

public class Main {
	public static void main(String[] args) {
		Operation operation = new Operation();
		operation.bankinfo();
	}
}

class Operation {
	private static Map<String, BankInfo> users = new HashMap<>();
	private static BankInfo bank1 = new BankInfo();

	static {
		bank1.setAccno("854621348597");
		bank1.setName("RBL Bank");
		bank1.setAcc_type("Saving");
		bank1.setBalance(10000000);
	}

	public void bankinfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				" ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ***Banking System Application***");
		System.out.println(
				" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println(
				" 1. Create a new account  \n 2. Check Balance\n 3. Deposit the amount \n 4. Withdraw the amount  \n 5. Watch demo account \n 6. Exit  \n\nENTER YOUR CHOICE :: ");
		int key = scan.nextInt();
		operation(key);
	}

	public void operation(int key) {
		Scanner scan = new Scanner(System.in);
		procces bankprocess = new procces();
		switch (key) {
		case 1:
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			bankprocess.openAccount();
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("MAIN PAGE_:: PRESS 1 ::");
			if (scan.nextInt() == 1)
				bankinfo();
			break;
		case 2:
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			bankprocess.checkbalance();
			System.out.println();
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("MAIN PAGE_:: PRESS 1 ::");
			if (scan.nextInt() == 1)
				bankinfo();
			break;
		case 3:
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("---------WELCOME TO DEPOSIT PAGE---------------- ");
			bankprocess.deposite();
			System.out.println();
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("MAIN PAGE_:: PRESS 1 ::");
			if (scan.nextInt() == 1)
				bankinfo();
			break;
		case 4:
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			bankprocess.withdraw();
			System.out.println();
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("MAIN PAGE_:: PRESS 1 ::");
			if (scan.nextInt() == 1)
				bankinfo();
			break;
		case 5:
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			bankprocess.demoaccount();
			System.out.println();
			System.out.println(
					" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("MAIN PAGE_:: PRESS 1 ::");
			if (scan.nextInt() == 1)
				bankinfo();
			break;
		case 6:
			System.out.println("THANKS FOR USING OUR BANK APPLICATION");
			break;
		}
	}
}

class procces {
	Scanner sc = new Scanner(System.in);

	public void openAccount() {
		BankInfo bank1 = new BankInfo();
		System.out.print("Enter Account No: ");
		bank1.setAccno(sc.next());
		System.out.print("Enter Account type: ");
		bank1.setAcc_type(sc.next());
		System.out.print("Enter Name: ");
		bank1.setName(sc.next());
		System.out.print("Enter Balance: ");
		bank1.setBalance(sc.nextLong());

		System.out.println("------YOUR ACCOUNT DETAILS IS -------");
		System.out.println("Name of account holder :: " + bank1.getName());
		System.out.println("Account no             :: " + bank1.getAccno());
		System.out.println("Account type           :: " + bank1.getAcc_type());
		System.out.println("Balance                :: " + bank1.getBalance());
	}

	public void demoaccount() {
		int demobalance = 50000;
		System.out.println("Name of account holder :: " + "Demo user");
		System.out.println("Account no             :: " + "8529637412");
		System.out.println("Account type           :: " + "demo");
		System.out.println("Balance                :: " + demobalance);
	}

	public void deposite() {
		BankInfo bank1 = new BankInfo();
		System.out.println("Enter the Amount you want to deposit ::");
		int deposit = sc.nextInt();
		int amount = (int) ((bank1.getBalance()) + deposit);
		bank1.setBalance(amount);
		System.out.println(" " + deposit + " is deposited into your Account");
		System.out.println("Current Available Balance is Rs = " + bank1.getBalance());
	}

	public void withdraw() {
		BankInfo bank1 = new BankInfo();
		System.out.println("Enter the Amount you want to withdraw:");
		int withdraw = sc.nextInt();
		if (withdraw < bank1.getBalance()) {
			bank1.setBalance(bank1.getBalance() - withdraw);
			System.out.println(" " + withdraw + " is withdrawn from your Account");
			System.out.println("Current Available Balance is Rs  ::" + bank1.getBalance());
		} else {
			System.out.println("Low Balance");
			System.out.println("Current Available Balance is Rs  ::" + bank1.getBalance());
		}
	}

	public void checkbalance() {
		BankInfo bank1 = new BankInfo();
		System.out.println("Your name is           :: " + bank1.getName());
		System.out.println("Account no             :: " + bank1.getAccno());
		System.out.println("Account type           :: " + bank1.getAcc_type());
		System.out.println("Balance                :: " + bank1.getBalance());
		System.out.println("THANKS FOR BALANCE CHECKING ");
	}
}
