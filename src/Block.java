import java.util.Scanner;

//Set as abstract, so cannot be instantiated
public abstract class Block {

    protected char[][] cellValues;
    protected int blockSize;
    protected Scanner userInput;
    protected String[] strCharArr;

    public void initialise(){
        strCharArr = new String[blockSize];

        //Gathers the UserInput for validation
        System.out.println("Enter cell values:");
        for(int i = 0; i < blockSize; i++){

            //Checks whether the amount of rows is sufficient
            while (!(userInput.hasNextLine())) {
                //If not, print error statement and halt program
                System.out.println("Invalid format: number of rows.");
                System.exit(0);
            }

            //Splits the line of values from the input, and saves this to array.
            strCharArr = ((userInput.nextLine().split(",")));
            

            //Checks if the amount of given values in a row is the correct amount.
            if(strCharArr.length != blockSize){
                //If not, print error statement and halt program
                System.out.println("Invalid format: number of cells in row.");
                System.exit(0);
            }

            //Checks whether the value given is in correct range (calls overriding method in subclass)
            for(int j = 0; j < strCharArr.length;j++){
                checkValsValidity(i,j);
            }
        }

        //Prints if all syntax of input is correct
        System.out.print("Valid format, ");
    }

    public void checkStructure(){

        //Creates and intialises variables for use within the check structure process

        int rowCharRepeats = 0;
        int columnCharRepeats = 0;

        boolean columnRepeated = false;
        char valuecolumnRepeated = 0;
        int indexColumnRepeated = -1;

        char[] block1dArr = new char[blockSize*blockSize];
        int Index1d = 0;

        int minKVal = 0;

        //Checks through all values to ensure that there are no duplicates
        for(int i = 0; i < blockSize; i++){
            for (int j = 0; j < blockSize; j++){
                for (int k = minKVal; k < blockSize; k++){
                       
                    //Checks whether rows is valid 
                    //Compares whether the row characters are the same
                    if(cellValues[i][j] == cellValues[i][k]){
                        rowCharRepeats++;
                    }
                    //If Row is not valid, print error, and exit program
                    if (rowCharRepeats == 2){
                        System.out.println("invalid structure: " + cellValues[i][j] + " repeated in row "+ (i+1) +".");
                        return;
                    }

                   //Checks whether columns have already been determined invalid
                   if (!columnRepeated){
                        //Checks whether column characters are same
                        if(cellValues[j][i] == cellValues[k][i]){
                            columnCharRepeats++;
                        }
                        //If found not valid, save the character and column number of invalidity
                        if (columnCharRepeats == 2){
                            valuecolumnRepeated = cellValues[j][i];
                            indexColumnRepeated = i + 1;
                            columnRepeated = true;
                        }
                   }
                }

                //Resets all variables to be checked again in the next iteration
                rowCharRepeats = 0;
                columnCharRepeats = 0;
                //Increases the number of the k index (no need to recheck values already checked)
                minKVal++;

                //Places all the 2D array values in a 1D array, to check for later
                if(!columnRepeated){
                    block1dArr[Index1d] = cellValues[i][j];
                    Index1d++;
                }

            }
            //Resets the number if the k index back to 0
            minKVal = 0;
        }

        //If column is invalid (and rows are valid) print error, and exit program
        if (columnRepeated){
            System.out.println("invalid structure: " + valuecolumnRepeated + " repeated in column " + indexColumnRepeated + ".");
            return;
        }

        //Checks whether there are any repeating characters in the entire block
        for(int i = 0; i < blockSize*blockSize; i++){
            for (int j = i+1; j < blockSize*blockSize; j++){

                //Compares the characters between two locations of entire array
                if(block1dArr[i] == block1dArr[j]){
                    //If same characters found, print error, and exit program
                    System.out.println("invalid structure: " + block1dArr[j] + " repeated in block.");
                    return;
                }
            }
        }

        //If completely valid then print valid structure
        System.out.println("valid structure.");;
    }
    
    //Abstract method for inheritance in subclasses
    abstract void checkValsValidity(int iIndex, int jIndex);
}
