import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DepositAndWithdraw {

    public static void deposit() throws IOException, SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter account number for deposit : ");
        long accountNumber = keyboard.nextLong();
        System.out.println("Please enter how much do you want to deposit to your balance ?");
        long deposit = keyboard.nextLong();
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
            Statement myStmt = myConnection.createStatement();
            //ResultSet myQuery = myStmt.executeQuery("SELECT * FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE AccountNumber LIKE '"+ accountNumber + "' SELECT Balance FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE Balance");
            //long result = myQuery + deposit;
            //ResultSet myQuery = myStmt.executeQuery("SELECT*FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE AccountNumber = '"+ accountNumber +"' " +
            //       "SELECT SUM(UserSystemAccountsStock.dbo.AccountsInformations.Balance + '"+ deposit +"') FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE Balance" );
            ResultSet myQuery = myStmt.executeQuery("IF EXISTS (SELECT Balance FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE AccountNumber = '" + accountNumber + "')" +
                    "BEGIN UPDATE UserSystemAccountsStock.dbo.AccountsInformations SET Balance =  Balance + '" + deposit + "' WHERE AccountNumber = '" + accountNumber + "' END");
            myConnection.close();
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
        }
        Menu.menu();
    }

    public static void withdraw() throws IOException, SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter account number for withdraw : ");
        long accountNumber = keyboard.nextLong();
        System.out.println("Please enter how much do you want to withdraw to your balance ?");
        long withdraw = keyboard.nextLong();

        try {
            Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
            Statement myStmt = myConnection.createStatement();
            ResultSet myQuery = myStmt.executeQuery("IF EXISTS (SELECT Balance FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE AccountNumber = '" + accountNumber + "')" +
                    "BEGIN UPDATE UserSystemAccountsStock.dbo.AccountsInformations SET Balance =  Balance - '" + withdraw + "' WHERE AccountNumber = '" + accountNumber + "' END");
            myConnection.close();
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
        }
        Menu.menu();
    }
}
