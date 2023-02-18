import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DBLayer {
    public static void DataBase() {
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
            Statement myStmt = myConnection.createStatement();
        }

        catch (Exception e){
            System.out.println(e);

        }
    }
}