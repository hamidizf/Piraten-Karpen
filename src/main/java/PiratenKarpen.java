import pk.Dice;
import java.util.Scanner;
import java.util.ArrayList;

public class PiratenKarpen {
    public int Play(String [] list){
        int score=0;


        return score;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");
        String[] list=myDice.roll(8);
        ArrayList<Integer> Positions = new ArrayList<>();
        Scanner input=new Scanner(System.in);
        System.out.print("\nEnter the positions of dices that you want to keep starting from 0(the position of the dice on the left is 0 & count from there to the right)\n" +
                "After each entered position hit the 'Enter' button and When you are done enter 'end'\n"+ "Positions:");
        while(Positions.size()<8){ //while loop to add each number that user enters to the array until the key word 'end' is found
            String array = input.next(); //accept user's inout as a string
            if(array.equals("end")){
                break; //if user enters 'end' no further inputs will be taken
            }
            else if (Integer.parseInt(array)<0 | Integer.parseInt(array)>7){
                System.out.println("Your entered position "+Integer.parseInt(array)+" is not covered by the list.");
            }
             else{
                Positions.add(Integer.parseInt(array)); //add user's input to the array
            }
        }
        ArrayList<String> liist= myDice.Keep(list, Positions);
        for (int i=0; i<liist.size();i++){
            System.out.print(liist.get(i)+" ");
        }
        /*int n,i, Player1, Player2, skulls;
        Player1=0;
        Player2=0;
        skulls=0;
        String [] Dices=new String[8];
        for (int j=0; j<42; j++){
            while (Player1<6000 && Player2<6000){
                Dices = myDice.roll(8);

            }
        }*/
    }
}
