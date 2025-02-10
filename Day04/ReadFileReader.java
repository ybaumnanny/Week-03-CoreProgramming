import java.io.*;
public class ReadFileReader {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 3\\Day04\\FR.txt"; // Fixed path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {// Open the file using FileReader
            String line;// Read the file using BufferedReader
            while ((line = br.readLine()) != null) { // Read each line until EOF
                System.out.println(line); // Print the line
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
