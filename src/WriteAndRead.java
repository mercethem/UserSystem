import java.io.*;


public class WriteAndRead {
    public static void Write() throws IOException {
       /** File file = new File("E:\\UserSystem\\src\\Data\\AccountsInformation.txt");
        if (!file.exists()) {
            file.createNewFile();
        } This section if there isn't any file about for your data create for file*/
        FileWriter filewriter = new FileWriter("E:\\UserSystem\\src\\Data\\AccountsInformation.txt", true);
        filewriter.write(Account.tostring());
        filewriter.close();
    }
    public static void Read() throws IOException {
        FileReader filereader = new FileReader("E:\\UserSystem\\src\\Data\\AccountsInformation.txt");
        // BufferedReader bufferedReader =new BufferedReader(new FileReader("kod.txt"));
        filereader.read(Account.tostring().toCharArray());
        filereader.close();
    }
}
