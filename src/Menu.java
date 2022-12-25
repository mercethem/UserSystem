import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        System.out.println("What are you want ?" +
                "\nAccess an account = 1" +
                "\nCreate an account = 2 " +
                "\nDelete an account = 3 " +
                "\nTransfer money to account = 4 " +
                "\nWithdraw money from account = 5 " +
                "\nExit the menu!!! = 0");
        Scanner keyboard = new Scanner(System.in);
        byte i = keyboard.nextByte();
        options:
        do {
            if (i == 1) {
                Access.access();
            } else if (i == 2) {
                OpenAndClose.openAccount();
            } else if (i == 3) {
                OpenAndClose.closeAccount();
                break;
            } else if (i == 4) {
                System.out.println("Please enter how much money deposit to your account : ");
                Account.deposit();
            } else if (i == 5) {
                System.out.println("Please enter how much money withdraw to your account : ");
                Account.withdraw();
            } else if (i == 0) {
                break options;
            } else {
                System.out.println("Please enter upper options.");
                keyboard.next();
                Menu.menu();
            }
        } while (i != 0);
        {
        }
    }

}
