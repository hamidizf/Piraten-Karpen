package pk;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
public class Dice {

    public Faces roll() { //reroll 1 dice
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public Faces[] roll8() { //reroll 8 dices
        Faces[] Dices = new Faces[8];
        for (int i = 0; i < 8; i++) {
            Dices[i] = roll();
        }
        return Dices;
    }
    public Faces[] rollrest(Faces[] Dices, int[] Keptpos) { //reroll dices that are not going to be kept
        for (int i = 0; i < 8; i++)
            if (Keptpos[i]==0)
                Dices[i] = roll();
        return Dices;
    }

    public Map<Faces,Integer> NumOfFaces(Faces[] Dices) { //count how many of each face exists in 8 dices
        Map<Faces, Integer> NumOfFaces = new HashMap<>();
        Faces[] DiceFaces = Faces.values();
        for (Faces DiceFace : DiceFaces) {
            NumOfFaces.put(DiceFace, 0);
        }
        for (Faces DiceFace : Dices) {
            NumOfFaces.put(DiceFace, NumOfFaces.get(DiceFace) + 1);
        }
        return NumOfFaces;
    }
}