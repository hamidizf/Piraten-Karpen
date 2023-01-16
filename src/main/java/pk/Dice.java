package pk;

import java.util.ArrayList;
import java.util.Random;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        //System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
        //System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }
    public String [] roll(int n){
        Dice myDice = new Dice();
        String []list=new String[n];
        for (int i=0; i<n; i++){
            list[i]= String.valueOf(myDice.roll());
            System.out.print(list[i]+" ");

        }
        return list;
    }
    public String [] Keep(String [] Dices, ArrayList <Integer> Positions){
        String [] Dices2=new String[Positions.size()];
        for (int i=0; i<Positions.size(); i++){
            Dices2[i]=Dices[Positions.get(i)];
        }

        return Dices2;
    }
    /*public String [] RollRemaining(){

        return;
    }*/
    
}
