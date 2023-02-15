import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException, SQLException {
        System.out.println("What are you want ?" +
                "\nAccess an account = 1" +
                "\nCreate an account = 2 " +
                "\nDelete an account = 3 " +
                "\nTransfer money to account = 4 " +
                "\nWithdraw money from account = 5 " +
                "\nExit the menu!!! {Temporary for SQL Connection Control = 0");
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
                DepositAndWithdraw.deposit();
            } else if (i == 5) {
                DepositAndWithdraw.withdraw();
            } else if (i == 0) {
                System.out.println();
                DBLayer.DataBase();
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
