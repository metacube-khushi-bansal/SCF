import java.util.Scanner;

public class StringOperations {

    /**
     * To compare if two strings str1, str2 are equal or not
     * 
     * @param String string1 - First string that is to be compared
     * @param String string2 - Second string that is to be compared
     * @return int - returns 1 if both strings are equal otherwise 0
     */
    public int compareStrings(String string1, String string2) {
        int length1 = string1.length();
        int length2 = string2.length();
        
        if(length1 == 0 || length2 == 0 )
        {
            throw new IllegalArgumentException("Empty String ! Enter valid");
        }

        if (length1 > length2 || length1 < length2)
            return 0;

        else {
            for (int i = 0; i < length1; i++) {
                if (string1.charAt(i) != string2.charAt(i))
                    return 0;
            }
            return 1;
        }
    }

    /**
     * To reverse a string
     * 
     * @param String string - String that is to be reversed
     * @return String- returns the reverse of the given string
     */
    public String ReverseString(String string) {
        String reverse = "";
        if(string.length() == 0 )
        {
            throw new IllegalArgumentException("Empty String ! Enter valid");
        }
        char currentChar;
        for (int i = 0; i < string.length(); i++) {
            currentChar = string.charAt(i);
            reverse = currentChar + reverse;
        }

        return reverse;
    }

    /**
     * To replace lowercase characters present in a string with UpperCase and
     * vice-versa
     * 
     * @param String string - string that is to be computed to interchange the
     *               lowercase letter to uppercase and vice versa
     * @return String- returns the required string
     */
    public String replaceLowerCaseCharacters(String string) {
        if(string.length() == 0 )
        {
            throw new IllegalArgumentException("Empty String ! Enter valid");
        }
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                currentChar -= 32;
                result = result + currentChar;
                continue;
            } else if (currentChar >= 'A' && currentChar <= 'Z')
                currentChar += 32;
            result = result + currentChar;
        }
        return result;
    }

    /**
     * To find the largest word present in a string
     * 
     * @param String string- input String from which the largest word is ro be find
     * @return String - returns the largest word present in the string
     */
    public String calcLargestWordInString(String string) {
        int length = string.length();
        if(length == 0 )
        {
            throw new IllegalArgumentException("Empty String ! Enter valid");
        }
        String largest = "";
        String currentWord = "";
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) != ' ')
                currentWord += string.charAt(i);
            else if (string.charAt(i) == ' ' && currentWord.length() >= largest.length()) {
                largest = currentWord;
                currentWord = "";
            }
        }

        if (currentWord.length() >= largest.length())
            largest = currentWord;
        return largest;
    }

    public static void main(String[] args) {

        StringOperations operations = new StringOperations();
        Scanner scanner = new Scanner(System.in);
        String S1="",S2 = "";
        try {
            System.out.println("Enter any string S1: ");
            S1 = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
      
        try {
            System.out.println("Enter any string S2: ");
            S2 = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        

        
        scanner.close();
        int result = operations.compareStrings(S1, S2);
        if (result == 1)
            System.out.println("If S1 and S2 are Equal : true");
        else
            System.out.println("If S1 and S2 are Equal: false");

        System.out.println("Reverse of " + S1 + " is : " + operations.ReverseString(S1));
        System.out.println("Reverse of " + S2 + " is : " + operations.ReverseString(S2));

        System.out.println("Replacing lower case with upper case letters and vice versa of word: " + S1 + " is : "
                + operations.replaceLowerCaseCharacters(S1));
        System.out.println("Replacing lower case with upper case letters and vice versa of word: " + S2 + " is : "
                + operations.replaceLowerCaseCharacters(S2));

        System.out.println("Largest word present in string " + S1 + " is: " + operations.calcLargestWordInString(S1));
        System.out.println("Largest word present in string " + S2 + " is: " + operations.calcLargestWordInString(S2));
    }
}
