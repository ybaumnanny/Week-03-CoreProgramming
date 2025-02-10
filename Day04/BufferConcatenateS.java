public class BufferConcatenateS {
    public static void main(String[]args){
        String[]characters = {"My " , "name ", "is ", "Tony ", "Stark ","and ", "I ","am ", "Ironman ."};// array of strings
        StringBuffer sb =new StringBuffer();// object of StringBuffer created
        for(String character:characters){// iterating through the array
            sb.append(character);
        }
        System.out.println("String concatenated: "+sb.toString());
    }        
}
