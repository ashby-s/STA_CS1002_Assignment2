import java.util.Scanner;

public class NumBlock extends Block {

    //Sets values for a NumBlock instance
    public NumBlock(Scanner userInput){
        this.blockSize = 3;
        this.userInput = userInput;
        cellValues = new char[blockSize][blockSize];
    }

    @Override
    public void checkValsValidity(int iIndex, int jIndex){
        //Sets integer to check and removes whitespaces
        int intToAdd = Integer.parseInt(strCharArr[jIndex].trim());

        //Checks whether integer is NOT in correct range
        if(intToAdd > 9 || intToAdd < 1){
            //If not, print error, and exit program
            System.out.printf("Invalid format: value: %d.\n",intToAdd);
            System.exit(0);
        }

        //If valid, adds the number (converted to character) to the cellvalues 2d array
        cellValues[iIndex][jIndex] = (char)(intToAdd + '0');
    }

}
