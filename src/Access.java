import java.io.IOException;
import java.util.Scanner;

public class Access {
    public static void access() throws IOException {
        System.out.println("Please enter want to access to account number");
        Scanner keyboard = new Scanner(System.in);
        long access = keyboard.nextLong();

        if (access == Account.accountNumber) {
            System.out.println("\nAccount Number : " + Account.accountNumber + "\nName : " + Account.name +
                    "\nAddress : " + Account.address + "\nMail : " + Account.mail +
                    "\nPhone Number : " + Account.phoneNumber + "\nBirthday : " + Account.birthDay);

        } else {
            System.out.println("There isn't any customer as such as given account number.");
            Menu.menu();
        }

    }
}
