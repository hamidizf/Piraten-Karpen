package pk;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        //System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
        //System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }
    public String [] roll8(){
        Dice myDice = new Dice();
        String [] Dices=new String[8];
        for (int i=0; i<8; i++){
            Dices[i]= String.valueOf(myDice.roll());
        }
        return Dices;
    }
    public void print(String [] Dices){
        for (int i=0; i<8; i++){
            System.out.print(Dices[i]+" ");
        }
        System.out.println();
    }
    public String [] KeepnReroll(String [] Dices, Scanner input){
        String [] Dices2;
        Dice myDice = new Dice();
        Dices2=myDice.roll8();
        ArrayList<Integer> Positions = new ArrayList<>();
        Random positions = new Random();
        int numofpositions=positions.nextInt(8)+1;
        for (int i=0; i<numofpositions;i++){
            Positions.add(positions.nextInt(8));
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

        for (int i=0; i<Positions.size(); i++){
            if (!(Dices[Positions.get(i)]=="SKULL")){
                Dices2[Positions.get(i)]=Dices[Positions.get(i)];
            }
        }
        for (int i=0; i<Dices.length; i++){
            if (Dices[i]=="SKULL"){
                Dices2[i]=Dices[i];
            }
        }
        myDice.print(Dices2);
        return Dices2;
    }
    public boolean EndTurn(String []  Dices){
        int NumOfSkulls=0;
        for (int i=0; i<Dices.length; i++){
            if (Dices[i]=="SKULL"){
                NumOfSkulls++;
            }
        }
        if (NumOfSkulls>=3) return true;
        return false;
    }
    public int Score(String []  Dices){
        int score=0;
        for (int i=0; i<Dices.length; i++){
            if ((Dices[i]=="DIAMOND")||(Dices[i]=="GOLD")){
                score++;
            }
        }
        score=score*100;
        return score;

    }
    
}
