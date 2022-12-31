import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Account {
    public static long accountNumber;
    public static String name;
    public static String address;
    public static String mail;
    public static String phoneNumber;
    public static String birthDay;
    public static long balance = 0;
    public static long counter = 0;

    public Account(long accountNumber, String name, String address, String mail, String phoneNumber, String birthDay,
                   long balance) throws FileNotFoundException {
        this.accountNumber = accountNumber; //start 1_000_000_000 finish 2_000_000_000
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public long getBalance() {
        return balance;
    }

    public String toString() {
        return "\n\nAccount Number : " + accountNumber + "\nName : " + name + "\nAddress : " + address + "\nMail : " + mail
                + "\nPhone Number : " + phoneNumber + "\nBirthday : " + birthDay + "\nBalance: " + balance;

    }

    public static String tostring() {
        return "\n\nAccount Number : " + accountNumber + "\nName : " + name + "\nAddress : " + address + "\nMail : " + mail
                + "\nPhone Number : " + phoneNumber + "\nBirthday : " + birthDay + "\nBalance: " + balance;

    }


    public static void withdraw() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter how much do you want to withdraw to your balance ?");
        long money = keyboard.nextLong();
        if (Account.balance >= money) {
            Account.balance = Account.balance - money;
            System.out.println("Your new balance is " + balance);
            keyboard.nextLine();
        } else {
            System.out.println("Your balance is not enough! Please enter different withdraw.");
        }
        Menu.menu();
    }

    public static void deposit() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter how much do you want to withdraw to your balance ?");
        long money = keyboard.nextLong();
        Account.balance = Account.balance + money;
        System.out.println("Your new balance is " + balance);

        Menu.menu();
    }

}

class SavingsAccount extends Account {
    private long deposit;
    private long withdraw;

    public long getDeposit() {
        return deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public SavingsAccount(long accountNumber, String name, String address, String mail, String phoneNumber, String birthDay, long balance) throws FileNotFoundException {
        super(accountNumber, name, address, mail, phoneNumber, birthDay, balance);
    }

    public static void deposit(long deposit) {
        balance += deposit;
    }

    public void withdraw(long withdraw) {
        balance -= withdraw;
    }
}

class LoanAccount extends Account {

    public LoanAccount(long accountNumber, String name, String address, String mail, String phoneNumber, String birthDay, long balance) throws FileNotFoundException {
        super(accountNumber, name, address, mail, phoneNumber, birthDay, balance);
    }
}
