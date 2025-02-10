import java.io.*;
public class ByteToChar{
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\\\CAPGEMINI\\\\Program Prerequisites\\\\CG Training clone\\\\WEEK 3\\\\Day04\\\\FR.txt"), "UTF-8"))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
