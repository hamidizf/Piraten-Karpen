package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
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

    public Map NumOfFaces(Faces[] Dices) {
        Map<Faces, Integer> NumOfFaces = new HashMap<>();
        Faces DiceFaces[] = Faces.values();
        for (Faces DiceFace : DiceFaces) {
            NumOfFaces.put(DiceFace, 0);
        }
        for (Faces DiceFace : Dices) {
            NumOfFaces.put(DiceFace, NumOfFaces.get(DiceFace) + 1);
        }
        return NumOfFaces;
    }

    public int Score(Faces[] Dices, String card) {
        int score = 0;
        int Bonus = 1;
        if (card == "MonkeyB") {
            for (int i = 0; i < Dices.length; i++)
                if (Dices[i] == Faces.PARROT)
                    Dices[i] = Faces.MONKEY;
        }
        Map<Faces, Integer> NumofFaces = NumOfFaces(Dices);
        for (Faces face : NumofFaces.keySet()) {
            switch (NumofFaces.get(face)) {
                case 3: score += 100;break;
                case 4: score += 200;break;
                case 5: score += 500;break;
                case 6: score += 1000;break;
                case 7: score += 2000;break;
                case 8: score += 4000;break;
                default: score += 0;break;
            }
            if (face == Faces.SKULL && NumofFaces.get(face) > 0) {
                Bonus = 0;
            } else if (face != Faces.DIAMOND && face != Faces.GOLD && NumofFaces.get(face) < 3) {
                Bonus = 0;
            }
        }
        score += (NumofFaces.get(Faces.DIAMOND) + NumofFaces.get(Faces.GOLD)) * 100 + Bonus * 500;
        return score;
    }
}