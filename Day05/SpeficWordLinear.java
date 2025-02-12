public class SpeficWordLinear{
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // If no sentence contains the word
    }
    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue.",
            "Java is a powerful programming language.",
            "Machine learning is fascinating.",
            "I love playing badminton."
        };
        String word = "badminton"; // Word to search for
        String result = findSentence(sentences, word);
        System.out.println(result);
    }
}
