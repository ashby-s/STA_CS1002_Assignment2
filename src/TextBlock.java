import java.util.Scanner;

public class TextBlock extends Block {

    //Sets values for a TextBlock instance
    public TextBlock(Scanner userInput){
        this.blockSize = 5;
        this.userInput = userInput;
        cellValues = new char[blockSize][blockSize];
    }
    
    @Override
    public void checkValsValidity(int iIndex, int jIndex){

        //Sets string-of-character to check and removes whitespaces
        String charToCheck = strCharArr[jIndex].trim();

        //Checks whether string-of-char given is the correct number of values
        if(charToCheck.length() > 1){
            //If not, print error, and exit program
            System.out.printf("Invalid format: value: %s.\n",charToCheck);
            System.exit(0);
        }

        //Converts string-of-character into a character
        char charToAdd = charToCheck.charAt(0);

        //Checks whether character is NOT in correct range
        if(charToAdd > 'Y' || charToAdd < 'A'){
            //If not, print error, and exit program
            System.out.printf("Invalid format: value: %s.\n",charToAdd);
            System.exit(0);
        }

        //If valid, adds the character to the cellvalues 2d array
        cellValues[iIndex][jIndex] = charToAdd;
    }
}
