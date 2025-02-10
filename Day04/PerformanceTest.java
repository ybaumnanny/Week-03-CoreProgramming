import java.io.*;
import java.nio.charset.StandardCharsets;
public class PerformanceTest {
    private static final int ITERATIONS = 1_000_000;
    private static final String TEST_STRING = "hello";    
    public static void main(String[] args) {
        // Test string concatenation
        testStringConcatenation();
    
        // Test file reading
        String filePath = "D:\\\\CAPGEMINI\\\\Program Prerequisites\\\\CG Training clone\\\\WEEK 3\\\\Day04\\\\largefile.txt"; // Replace with your file path
        testFileReading(filePath);
    }

    private static void testStringConcatenation() {
        System.out.println("String Concatenation Performance Test:");
        // StringBuilder test
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuilder.append(TEST_STRING);
        }
        long stringBuilderTime = System.currentTimeMillis() - startTime;
        // StringBuffer test
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuffer.append(TEST_STRING);
        }
        long stringBufferTime = System.currentTimeMillis() - startTime;        
        System.out.printf("StringBuilder time: %d ms%n", stringBuilderTime);
        System.out.printf("StringBuffer time: %d ms%n", stringBufferTime);
        System.out.printf("Difference: %d ms%n", Math.abs(stringBuilderTime - stringBufferTime));
        System.out.println();
    }
    private static void testFileReading(String filePath) {
        System.out.println("File Reading Performance Test:");        
        // Test FileReader
        try {
            long startTime = System.currentTimeMillis();
            int wordCount = countWordsWithFileReader(filePath);
            long fileReaderTime = System.currentTimeMillis() - startTime;
            System.out.printf("FileReader:%n");
            System.out.printf("Time taken: %d ms%n", fileReaderTime);
            System.out.printf("Word count: %d%n%n", wordCount);
        } catch (IOException e) {
            System.err.println("Error reading with FileReader: " + e.getMessage());
        }
        // Test InputStreamReader
        try {
            long startTime = System.currentTimeMillis();
            int wordCount = countWordsWithInputStreamReader(filePath);
            long inputStreamReaderTime = System.currentTimeMillis() - startTime;
            
            System.out.printf("InputStreamReader:%n");
            System.out.printf("Time taken: %d ms%n", inputStreamReaderTime);
            System.out.printf("Word count: %d%n", wordCount);
        } catch (IOException e) {
            System.err.println("Error reading with InputStreamReader: " + e.getMessage());
        }
    }
    private static int countWordsWithFileReader(String filePath) throws IOException {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!words[0].isEmpty()) {
                    wordCount += words.length;
                }
            }
        }
        return wordCount;
    }
    private static int countWordsWithInputStreamReader(String filePath) throws IOException {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!words[0].isEmpty()) {
                    wordCount += words.length;
                }
            }
        }
        return wordCount;
    }
}