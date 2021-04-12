import java.io.*;

public class IODemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\Users\\Devour\\Desktop\\test\\a.txt");
        FileWriter writer = new FileWriter("C:\\Users\\Devour\\Desktop\\test\\b.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String str = null;
        while((str = bufferedReader.readLine()) != null) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
