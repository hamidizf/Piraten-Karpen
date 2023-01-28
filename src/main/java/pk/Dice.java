package pk;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public Faces[] roll8() {
        Faces[] Dices = new Faces[8];
        for (int i = 0; i < 8; i++) {
            Dices[i] = roll();
        }
        return Dices;
    }
    public Faces[] rollrest(Faces[] Dices, int[] Keptpos) {
        for (int i = 0; i < 8; i++)
            if (Keptpos[i]==0)
                Dices[i] = roll();
        return Dices;
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


}