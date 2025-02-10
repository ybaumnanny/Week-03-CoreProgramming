public class BuilderReverseS {
    public static String reverseUsingStringBuilder(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);                     // object of StringBuilder created
        return sb.reverse().toString();// reverse method of string builder to reverse the string and again converted to string
    }
    public static void main(String[] args) {// main method
        String input = "hello";
        String reversed = reverseUsingStringBuilder(input);// method call
        System.out.println("Reversed String: " + reversed);
    }
}
