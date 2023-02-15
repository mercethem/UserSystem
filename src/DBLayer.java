import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DBLayer {
    public static void DataBase() {
        //TODO (Fonksiyon olarak çalıştırmayı ve SQL kodunu başka fonksiyondan alarak burdan sadece bağlantı almayı yap.
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
            Statement myStmt = myConnection.createStatement();
            //ResultSet myQuery = myStmt.executeQuery("SELECT * FROM UserSystemAccountsStock.dbo.AccountsInformations WHERE [Name-Surname]='Ethem Merç'");
          /*  while (myQuery.next()){
              System.out.println(myQuery.getString("Address"));
            }*/
        }

        catch (Exception e){
            System.out.println(e);

        }
    }
    //TODO
}