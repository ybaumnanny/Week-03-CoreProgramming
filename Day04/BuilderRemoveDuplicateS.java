import java.util.*;
public class BuilderRemoveDuplicateS {
    public static void main(String[] args) {
        String input = "Rommanooff";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (seen.add(c)) { // Add returns true if the character is not already present
                sb.append(c);
            }
        }
        System.out.println("String with no duplicates: " + sb);
    }
}
