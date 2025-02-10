import java.io.*;
public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "D:\\\\CAPGEMINI\\\\Program Prerequisites\\\\CG Training clone\\\\WEEK 3\\\\Day04\\\\FR.txt"; // Specify the file path
        String targetWord = "Hi"; // Word to count (case-sensitive)
        int count = 0;
// Read the file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) { // Read file line by line
                String[] words = line.split("\\s+"); // Split line into words by whitespace
                for (String word : words) {
                    if (word.equals(targetWord)) { // Compare with target word
                        count++;
                    }
                }
            }
            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
