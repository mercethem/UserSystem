import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Access {
    public static void access() throws IOException, SQLException {
        Scanner keyboard = new Scanner(System.in);

        Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
        Statement myStmt = myConnection.createStatement();
        long accountNumber = 0;
        String nameSurname = null;

        System.out.println("How can you want to view ? \nAccount Number : 0 Name Surname : 1 ");
        byte choose = keyboard.nextByte();
        if (choose == 0) {
            System.out.println("Please enter want to access to account number: ");
            accountNumber = keyboard.nextLong();
            ResultSet myQuery = myStmt.executeQuery("SELECT * FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE AccountNumber = '" + accountNumber + "'");
            while (myQuery.next()) {
                System.out.printf("\nAccount Number: %s\nName Surname: %s\nAdress: %s\ne-mail: %s\nPhone Number: %s\nBirthday: %s\nBalance: %s \n", myQuery.getString("AccountNumber"), myQuery.getString("Name-Surname"),
                        myQuery.getString("Address"), myQuery.getString("Mail"), myQuery.getString("PhoneNumber")
                        , myQuery.getString("Birthday"), myQuery.getString("Balance"));

            }
            Menu.menu();

        } else if (choose == 1) {
            System.out.println("Please enter want to access to Name Surname: ");
            nameSurname = keyboard.next();
            ResultSet myQuery2 = myStmt.executeQuery("SELECT * FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE [Name-Surname] LIKE '%" + nameSurname + "%'");
            while (myQuery2.next()) {
                System.out.printf("\nAccount Number: %s\nName Surname: %s\nAdress: %s\ne-mail: %s\nPhone Number: %s\nBirthday: %s\nBalance: %s \n", myQuery2.getString("AccountNumber"), myQuery2.getString("Name-Surname"),
                        myQuery2.getString("Address"), myQuery2.getString("Mail"), myQuery2.getString("PhoneNumber")
                        , myQuery2.getString("Birthday"), myQuery2.getString("Balance"));
                myConnection.close();
            }
            Menu.menu();

        } else {
            System.out.println("Please enter true data");
            myConnection.close();
            Menu.menu();
        }
    }
}

