package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Strategy {
    static Logger LOGGER= LogManager.getLogger(Strategy.class);
    public Faces[] RandomKeep(Faces[] Dices) {
        Faces[] Dices2;
        Dice myDice = new Dice();
        Dices2 = myDice.roll8();
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
        LOGGER.info("Positions of dices that will be kept(will not be rerolled):");
        LOGGER.debug(Arrays.toString(Positions.toArray()));
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
        int KeptDices=0;
        Dice myDice = new Dice();
        Dices2 = myDice.roll8();
        HashMap<Faces, Integer> NumOfFaces;
        NumOfFaces=myDice.NumOfFaces(Dices);
        for (int j=0;j<Dices.length;j++){
            if (Dices[j] == Faces.SKULL) {
                Dices2[j] = Dices[j];
                KeptDices += 1;
            }
        }
        for (int i = 0; i < Dices.length; i++) {
            if((NumOfFaces.get(Dices[i])>=2&&(Dices[i]==Faces.DIAMOND||Dices[i]==Faces.GOLD))&&KeptDices<6){
                Dices2[i] = Dices[i];
                KeptDices+=1;
            }else if(NumOfFaces.get(Dices[i])>=4 && KeptDices<6){
                Dices2[i] = Dices[i];
                KeptDices+=1;
            }
        }
        LOGGER.debug("Num of kept dices: "+KeptDices);
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }
    public Faces[] Select(String strategy, Faces[] Dices){
        Faces[] Dices2=new Faces[8];
        if (strategy.equals("random")){
            LOGGER.info("random strategy :");
            Dices2=RandomKeep(Dices);
        }else if (strategy.equals("combo")){
            LOGGER.info("combo strategy :");
            Dices2=ComboKeep(Dices);
        }
        return Dices2;
    }
}
