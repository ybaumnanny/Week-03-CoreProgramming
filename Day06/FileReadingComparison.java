import java.io.*;

 public class FileReadingComparison {
 
     // FileReader - Character Stream (Slower for Large Files)
     public static long readWithFileReader(String filePath) throws IOException {
         long startTime = System.nanoTime();
         try (FileReader reader = new FileReader(filePath)) {
             while (reader.read() != -1) {}  // Read character by character
         }
         return (System.nanoTime() - startTime) / 1_000_000; // Convert to ms
     }
 
     // InputStreamReader - Byte Stream (Faster for Large Files)
     public static long readWithInputStreamReader(String filePath) throws IOException {
         long startTime = System.nanoTime();
         try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
             while (reader.read() != -1) {}  // Read character by character
         }
         return (System.nanoTime() - startTime) / 1_000_000; // Convert to ms
     }
 
     public static void main(String[] args) {
         String[] filePaths = {"FileReadingComparison.java", "SortingComparison.java", "StringConcatenationAnalysis.java"}; // Ensure these files exist before running
 
         System.out.println("File Size  | FileReader Time (ms) | InputStreamReader Time (ms)");
         System.out.println("--------------------------------------------------------------");
 
         for (String filePath : filePaths) {
             try {
                 long fileReaderTime = readWithFileReader(filePath);
                 long inputStreamReaderTime = readWithInputStreamReader(filePath);
 
                 System.out.println(filePath + "   | " + fileReaderTime + " ms         | " + inputStreamReaderTime + " ms");
             } catch (IOException e) {
                 System.err.println("Error reading " + filePath + ": " + e.getMessage());
             }
         }
     }
 }