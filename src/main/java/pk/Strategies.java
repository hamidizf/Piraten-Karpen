package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Strategies {
    static Logger LOGGER= LogManager.getLogger(Strategies.class);
    public Faces[] RandomKeep(Faces[] Dices) {
        Faces[] Dices2;
        Dice myDice = new Dice();
        Dices2 = myDice.roll8();
        //System.out.println("new faces");
        //myDice.print(Dices2);
        List<Integer> Positions = new ArrayList<>();
        Random positions = new Random();
        int numofpositions = positions.nextInt(6) + 1;
        int position;
        for (int i = 1; i <= numofpositions; i++) {
            position = positions.nextInt(8);
            if (i > 0 && Positions.contains(position)) {
                i--;
            } else if (Dices[position] == Faces.SKULL) {
                i--;

            } else {
                Positions.add(position);
                Dices2[position] = Dices[position];
            }
        }
        /*System.out.print("\nEnter the positions of dices that you want to keep starting from 0(the position of the dice on the left is 0 & count from there to the right)\n" +
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
        }*/
        LOGGER.info("Positions of dices that will be kept(will not be rerolled):");
        LOGGER.debug(Arrays.toString(Positions.toArray()));
        /*for (int i=0; i<Positions.size(); i++){
            LOGGER.debug(Positions.get(i)+" ");
            if (!(Dices[Positions.get(i)]==Faces.SKULL)){
                Dices2[Positions.get(i)]=Dices[Positions.get(i)];
            }
        }*/
        //System.out.println();
        for (int i = 0; i < Dices.length; i++) {
            if (Dices[i] == Faces.SKULL) {
                Dices2[i] = Dices[i];
            }
        }
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }
    public Faces[] ComboKeep(Faces[] Dices) {
        Faces[] Dices2;
        Dice myDice = new Dice();
        Dices2 = myDice.roll8();
        HashMap<Faces, Integer> NumOfFaces;
        NumOfFaces=myDice.NumOfFaces(Dices);
        for (int i = 0; i < Dices.length; i++) {
            if (Dices[i] == Faces.SKULL) {
                Dices2[i] = Dices[i];
            }
        }
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }
}
