package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
public class Dice {
    static Logger LOGGER = LogManager.getLogger(Dice.class);

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        //System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
        //System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public Faces[] roll8() {
        Dice myDice = new Dice();
        Faces[] Dices = new Faces[8];
        for (int i = 0; i < 8; i++) {
            Dices[i] = myDice.roll();
        }
        return Dices;
    }

    public boolean EndTurn(Faces[] Dices) {
        int NumOfSkulls = 0;
        for (int i = 0; i < Dices.length; i++) {
            if (Dices[i] == Faces.SKULL) {
                NumOfSkulls++;
            }
        }
        if (NumOfSkulls >= 3) return true;
        return false;
    }
    public HashMap NumOfFaces(Faces[] Dices){
        HashMap<Faces, Integer> NumOfFaces = new HashMap<>();
        Faces DiceFaces[] = Faces.values();
        for (Faces DiceFace : DiceFaces) {
            NumOfFaces.put(DiceFace, 0);
        }
        for (Faces DiceFace : Dices) {
            NumOfFaces.put(DiceFace, NumOfFaces.get(DiceFace) + 1);
        }
        return NumOfFaces;
    }
    public int Score(HashMap<Faces,Integer> NumOfFaces) {
        int score = 0;
        for (Faces face : NumOfFaces.keySet()) {
                switch (NumOfFaces.get(face)) {
                    case 3: score+=100;break;
                    case 4:score+=200;break;
                    case 5:score+=500;break;
                    case 6:score+=1000;break;
                    case 7:score+=2000;break;
                    case 8:score+=4000;break;
                    default:score+=0;break;
                }
            }
        score+=(NumOfFaces.get(Faces.DIAMOND)+NumOfFaces.get(Faces.GOLD))*100;
        return score;
    }
}