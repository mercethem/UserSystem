import java.io.*;
import java.util.*;
public class OpenAndClose {
    public static void openAccount() throws IOException {
        Account[] account = new Account[7];
        account[1] = new Account(Account.accountNumber, Account.name, Account.address, Account.mail, Account.phoneNumber,
                Account.birthDay, Account.balance);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter Account Number : ");
        Account.accountNumber = keyboard.nextLong();
        keyboard.nextLine();
        System.out.println("Please enter name_surname (George_Sunshine) : ");
        Account.name = keyboard.nextLine();
        System.out.println("Please enter address : ");
        Account.address = keyboard.nextLine();
        System.out.println("Please enter mail : ");
        Account.mail = keyboard.nextLine();
        System.out.println("Please enter phone number (987_654_32_10) : ");
        Account.phoneNumber = keyboard.nextLine();
        System.out.println("Please enter your birth day (26_12_1990");
        Account.birthDay = keyboard.nextLine();
        Account.counter++;
        Account.balance = 0;
        WriteAndRead.Write();
        Menu.menu();

    }

    public static void closeAccount() throws IOException {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter account number want to delete : ");
        long deleteAccountNumber = keyboard.nextLong();
        if (Account.accountNumber == deleteAccountNumber) {
            System.out.println("Are you sure want do DELETE the account ??? \nYes = 2 \nNo = 1 ");
            byte answer = keyboard.nextByte();
            switch (answer) {
                case 1: {
                    Menu.menu();

                }
                case 2: {
                    Account.accountNumber = Long.parseLong("Closed");
                    Account.name = "Closed";
                    Account.address = "Closed";
                    Account.mail = "Closed";
                    Account.phoneNumber = "Closed";
                    Account.birthDay = "Closed";
                    Account.balance = Long.parseLong("Closed");
                    Account.counter--;

                    break;
                }
            }
        }
        Menu.menu();
    }
}
