package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Strategy {
    Faces[] Dices2;
    Map<Faces, Integer> NumOfFaces;
    Dice myDice = new Dice();
    static Logger LOGGER= LogManager.getLogger(Strategy.class);
    public Faces[] SkullsKeep(Faces[] Dices2,Faces[] Dices){
        for (int i = 0; i < Dices.length; i++) {
            if (Dices[i] == Faces.SKULL) {
                Dices2[i] = Dices[i];
            }
        }
        return Dices2;
    }
    public Faces[] RandomKeep(Faces[] Dices) {
        Dices2 = myDice.roll8();
        List<Integer> Positions = new ArrayList<>();
        Random positions = new Random();
        int numofpositions = positions.nextInt(6) + 1;
        NumOfFaces=myDice.NumOfFaces(Dices);
        if (numofpositions>=2) {
            numofpositions -= NumOfFaces.get(Faces.SKULL);
        }
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
        Dices2=SkullsKeep(Dices2,Dices);
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }
    public Faces[] ComboKeep(Faces[] Dices) {
        Dices2 = myDice.roll8();
        NumOfFaces=myDice.NumOfFaces(Dices);
        int KeptDices= NumOfFaces.get(Faces.SKULL);
        for (int z = 0; z < Dices.length; z++) {
            if (NumOfFaces.get(Dices[z]) >= 4 && KeptDices < 6) {
                Dices2[z] = Dices[z];
                KeptDices ++;
            }
        }
        for (int i = 0; i < Dices.length; i++) {
            if((NumOfFaces.get(Dices[i])>=2&&(Dices[i]==Faces.DIAMOND||Dices[i]==Faces.GOLD))&&KeptDices<6){
                Dices2[i] = Dices[i];
                KeptDices++;
            }
        }
        Dices2=SkullsKeep(Dices2,Dices);
        LOGGER.debug("Num of kept dices: "+KeptDices);
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }
    public Faces[] SeaBattleKeep(Faces[] Dices, String card){
        Dices2 = myDice.roll8();
        int NumOfSeaBattleCards=0;
        NumOfFaces=myDice.NumOfFaces(Dices);
        int KeptDices= NumOfFaces.get(Faces.SKULL);
        for(int i=0; i<Dices.length;i++){
            if (NumOfFaces.get(Faces.SABER)>4 && KeptDices<6){
                if(Dices[i]==Faces.SABER){
                    Dices2[i]=Dices[i];
                    NumOfSeaBattleCards++;
                    KeptDices++;
                }
            }else if (card=="SeaBattle 2Swords" && NumOfSeaBattleCards<2 && KeptDices<6){
                if(Dices[i]==Faces.SABER){
                    Dices2[i]=Dices[i];
                    NumOfSeaBattleCards++;
                    KeptDices++;
                }
            } else if (card=="SeaBattle 3Swords" && NumOfSeaBattleCards<3 && KeptDices<6){
                if(Dices[i]==Faces.SABER){
                    Dices2[i]=Dices[i];
                    NumOfSeaBattleCards++;
                    KeptDices++;
                }
            }else if (card=="SeaBattle 4Swords" && NumOfSeaBattleCards<4 && KeptDices<6){
                if(Dices[i]==Faces.SABER){
                    Dices2[i]=Dices[i];
                    NumOfSeaBattleCards++;
                    KeptDices++;
                }
            }
        }
        for (int i = 0; i < Dices.length; i++) {
            if((Dices[i]==Faces.DIAMOND||Dices[i]==Faces.GOLD)&&KeptDices<6){
                Dices2[i] = Dices[i];
                KeptDices++;
            }
        }
        Dices2=SkullsKeep(Dices2,Dices);
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }
    public Faces[] MonkeyKeep(Faces[] Dices){
        Dices2 = myDice.roll8();
        NumOfFaces=myDice.NumOfFaces(Dices);
        int KeptDices= NumOfFaces.get(Faces.SKULL);
        for (int i = 0; i < Dices.length; i++) {
            if((NumOfFaces.get(Dices[i])>=2&&(Dices[i]==Faces.DIAMOND||Dices[i]==Faces.GOLD))&&KeptDices<6){
                Dices2[i] = Dices[i];
                KeptDices++;
            }
        }
        for (int z = 0; z < Dices.length; z++) {
            if ((Dices[z]==Faces.MONKEY ||Dices[z]==Faces.PARROT) && KeptDices < 6) {
                Dices2[z] = Dices[z];
                KeptDices ++;
            }
        }
        Dices2=SkullsKeep(Dices2,Dices);
        LOGGER.debug("Num of kept dices: "+KeptDices);
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }

    public Faces[] Select(String strategy, Faces[] Dices,String card){
        Faces[] Dices2=new Faces[8];
        if (strategy.equals("random")){
            LOGGER.info("random strategy :");
            Dices2=RandomKeep(Dices);
        }else if (strategy.equals("combo")){
            LOGGER.info("combo strategy :");
            Dices2=ComboKeep(Dices);
        }else if (strategy.equals("card")){
            LOGGER.info("card strategy :");
            if(card=="SeaBattle 2Swords"||card=="SeaBattle 3Swords"||card=="SeaBattle 4Swords"){
                Dices2=SeaBattleKeep(Dices,card);
            } else{
                Dices2=MonkeyKeep(Dices);
            }
        }
        return Dices2;
    }
}
