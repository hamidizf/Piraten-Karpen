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
    public ArrayList<String> Keep(String [] Dices, ArrayList <Integer> Positions){
        ArrayList<String> KeptDices = new ArrayList<>();
        for (int i=0; i<Positions.size(); i++){
            if (!(Dices[Positions.get(i)]=="SKULL")){
                KeptDices.add(Dices[Positions.get(i)]);
            }
        }
        for (int i=0; i<Dices.length; i++){
            if (Dices[i]=="SKULL"){
                KeptDices.add(Dices[i]);
            }
        }

        return KeptDices;
    }
    public boolean EndTurn(String [] Dices){
        int j=0;
        for (int i=0; i<Dices.length; i++){
            if (Dices[i]=="SKULL"){
                j++;
            }
        }
        if (j>=3) return true;
        return false;
    }
    
}
