public class BuilderBufferCompareConcatenateS{
    public static void main(String[] args) {
        int millions = 1000000; // 1 million iterations
        String text = "hello";
        // Measure time for StringBuffer
        StringBuffer sbf = new StringBuffer();// object of StringBuffer created
        long startTime1 = System.nanoTime();
        for (int i = 0; i < millions; i++) {
            sbf.append(text);
        }
        long endTime1 = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime1 - startTime1) / 1000000 + " ms");
        // Measure time for StringBuilder
        StringBuilder sbd = new StringBuilder();
        long startTime2 = System.nanoTime();
        for (int i = 0; i < millions; i++) {
            sbd.append(text);
        }
        long endTime2 = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime2 - startTime2) / 1000000 + " ms");
    }
}
