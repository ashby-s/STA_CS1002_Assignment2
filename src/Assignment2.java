import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        //User Inputs type of block to test
        System.out.println("Enter block type:");
        String userBlockOption = userInput.nextLine();
        
        if(userBlockOption.equals("n")){
            //Creates a NumBlock object, and validates this
            NumBlock selectedBlock = new NumBlock(userInput);
            selectedBlock.initialise();
            selectedBlock.checkStructure();
        }
        else if(userBlockOption.equals("t")){
            //Creates a TextBlock object, and validates this
            TextBlock selectedBlock = new TextBlock(userInput);
            selectedBlock.initialise();
            selectedBlock.checkStructure();
        }
        else{
            //Executes if no valid input was given
            System.out.println("Invalid block type.");
        }
    }
}