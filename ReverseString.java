
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
* A program to reverse a string from an input file.
*
* @author  Keiden B
* @version 1.0
* @since   2023-03-02
*/

public final class ReverseString {
    /**
    * Necessary to prevent HideUtilityClass Error.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * The recursion function to reverse a string.
    *
    * @param someString the string to take the first letter of
    *                   and send to the back.
    * @return the first letter from the inputted string
    */
    public static String reverse(String someString) {
        String returnString = "";

        if (someString.length() <= 1) {
            returnString = someString;
        } else {
            returnString = reverse(someString.substring(1))
                           + someString.charAt(0);
        }
        return returnString;
    }

    /**
    * Main lines of code.
    *
    * @param args a placeholder value when making the main function
    * @throws Exception thrown when making scanner for the input file.
    */
    public static void main(String[] args) throws Exception {
        // Making file path and scanner objects.
        final File filePath = new File("./Unit2-01-Input.txt");
        final FileWriter fileOut = new FileWriter("./Unit2-01-Output.txt");
        final Scanner scanIn = new Scanner(filePath);

        System.out.println("\nReversing all strings...\n");
        fileOut.write("\nReversing all strings...\n");

        // Repeats for all lines in the text file.
        while (scanIn.hasNextLine()) {
            final String normText = scanIn.nextLine();
            final String reverseText = reverse(normText);

            // Printing to the Console and Output file.
            System.out.println("The original string is:\n" + normText);
            System.out.println("The reversed is:\n" + reverseText + "\n");
            fileOut.write("\nThe original string is:\n" + normText);
            fileOut.write("\nThe reversed is:\n" + reverseText + "\n");
        }
        fileOut.close();
        scanIn.close();
    }
}
