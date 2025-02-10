import java.io.*;
public class ConsoleToFileWriter {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Input saved to output.txt");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
