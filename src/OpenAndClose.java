import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class OpenAndClose {
    public static void openAccount() throws IOException, SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter Account Number for your new customer : ");
        long accountNumber = keyboard.nextLong();
        System.out.println("Please enter Name-Surname : ");
        keyboard.nextLine();
        String nameSurname = keyboard.nextLine();
        System.out.println("Please enter Adress : ");
        String address = keyboard.nextLine();
        System.out.println("Please enter e-mail : ");
        String mail = keyboard.next();
        System.out.println("Please enter Phone Number : ");
        long phoneNumber = keyboard.nextLong();
        System.out.println("Please enter Birthday : ");
        String birthday = keyboard.next();
        System.out.println("Please enter balance : ");
        long balance = keyboard.nextLong();
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
            Statement myStmt = myConnection.createStatement();
            ResultSet myQuery = myStmt.executeQuery("INSERT INTO UserSystemAccountsStock.dbo.AccountsInformations(AccountNumber, [Name-Surname], [Address], [Mail], [PhoneNumber], [Birthday],[Balance]) " +
                    "VALUES ('" + accountNumber + "' ,'" + nameSurname + "','" + address + "','" + mail + "','" + phoneNumber + "','" + birthday + "', '"+balance+"')");
        }
        //TODO eğer aynı accountNumber'de biri varsa if else kullanarak aktifleşmesini engelle
        catch (Exception e){
            System.out.println(e);
        }
        Menu.menu();
    }

    public static void closeAccount() throws IOException, SQLException {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter account number want to delete : ");
        long deleteAccountNumber = keyboard.nextLong();
        System.out.println("ARE YOU SURE WANT TO DELETE ??? \n NO : 0 \n YES : 1 ");
        byte questionDelete = keyboard.nextByte();

        try {
            if (questionDelete == 1) {
                Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
                Statement myStmt = myConnection.createStatement();
                ResultSet myQuery = myStmt.executeQuery(" DELETE FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE AccountNumber =  '" + deleteAccountNumber + "' ");
            } else if (questionDelete == 0) {
                Menu.menu();
            } else {
                OpenAndClose.closeAccount();
            }
        }catch (Exception e){
            System.out.println(e);
        }
        Menu.menu();
    }
}
