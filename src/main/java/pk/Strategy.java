package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Strategy {
    Faces[] Dices2;
    Map<Faces, Integer> NumOfFaces;
    Dice myDice = new Dice();
    int mycount; //initialize mycount
    static Logger LOGGER= LogManager.getLogger(Strategy.class);
    public int[] SkullsKeep(Faces[] Dices,int[] KeptPos){
        for (int i=0;i<8;i++)
            if (Dices[i] == Faces.SKULL)
                KeptPos[i]=i+1; //change values from 0's to numbers to specify kept Faces (will not be rerolled)
        return KeptPos;
    }
    public int[] DiamondGoldKeep(Faces[] Dices,int[] KeptPos,int KeptDices){
        for (int i = 0; i < Dices.length; i++)
            if ((Dices[i] == Faces.DIAMOND || Dices[i] == Faces.GOLD) && KeptDices <6) {
                KeptPos[i] = i+1;//record Gold/Diamond Faces to be kept
                KeptDices++;
            }
        return KeptPos;
    }
    public int[] SeaBattleKeep(Faces[] Dices, int[] KeptPos, int KeptDices){
        for(int i=0; i<Dices.length;i++)
            if (Dices[i]==Faces.SABER && KeptDices<6){ //keep saber faces(first priority)
                KeptPos[i] =i+1;
                KeptDices++;
            }
        if (KeptDices<6)
            KeptPos=DiamondGoldKeep(Dices,KeptPos,KeptDices); //keep Gold/Diamonds(second priority)
        return KeptPos;
    }
    public int[] MonkeyKeep(Faces[] Dices, int[] KeptPos, int KeptDices){
        for (int z = 0; z < Dices.length; z++) {
            if ((Dices[z] == Faces.MONKEY || Dices[z] == Faces.PARROT) && KeptDices < 6) {
                KeptPos[z] = z+1;//record both monkey and parrot faces
                KeptDices++;
            }
        }
        if (KeptDices<6)
            KeptPos=DiamondGoldKeep(Dices,KeptPos,KeptDices);
        return KeptPos;
    }
    public Faces[] Sorceress(Faces[] Dices, String strategy, int count){
        Random Boolean = new Random();
        if (count==1){ //check count to roll one of the skulls only once during each turn when sorceress is drawn
            mycount=1;
            for (int i=0;i<Dices.length;i++){
                if (Dices[i]==Faces.SKULL && strategy.equals("combo")){
                    mycount=0;
                    Dices[i]=myDice.roll();
                    LOGGER.info("combo strategy :");
                    Dices2=ComboKeep(Dices,"Sorceress",i);
                    return Dices2;
                }else if(Dices[i]==Faces.SKULL && strategy.equals("random")){
                    if(Boolean.nextBoolean()){
                        mycount=0;
                        Dices[i]=myDice.roll();
                        LOGGER.info("random strategy :");
                        Dices2=RandomKeep(Dices,i);
                        return Dices2;
                    }
                }
            }
        }else
            mycount=0;
        if (strategy.equals("combo"))
            Dices2=ComboKeep(Dices,"Sorceress",-1);
        else
            Dices2=RandomKeep(Dices,-1);
        return Dices2;
    }
    public Faces[] RandomKeep(Faces[] Dices, int k) {
        int [] KeptPos=new int[8];
        KeptPos=SkullsKeep(Dices,KeptPos);
        List<Integer> Positions = new ArrayList<>();
        Random positions = new Random();
        int numofpositions = positions.nextInt(6) + 1;//randomize number of positions to keep
        if(k>=0){
            KeptPos[k] = k+1;
            numofpositions--;}
        NumOfFaces=myDice.NumOfFaces(Dices);
        if (numofpositions>=2) {
            numofpositions -= NumOfFaces.get(Faces.SKULL);
        }
        int position;
        for (int i = 1; i <= numofpositions; i++) {
            position = positions.nextInt(8);//randomize which positions to keep
            if (Positions.contains(position)||Dices[position] == Faces.SKULL)//check if position has been chosen/there is a skull in that position
                i--;
           else{
                Positions.add(position);
                KeptPos[position]=position+1;}
        }
        LOGGER.info("Dices that will be kept(will not be rerolled):");
        if(k>=0)
            KeptPos[k] = 0;
        LOGGER.debug(Arrays.toString(KeptPos));
        Dices2=myDice.rollrest(Dices,KeptPos);//reroll rest of dices
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }
    public Faces[] ComboKeep(Faces[] Dices,String card, int k) {
        int [] KeptPos=new int[8];
        int KeptDices;
        NumOfFaces=myDice.NumOfFaces(Dices);
        KeptDices= NumOfFaces.get(Faces.SKULL);
        if(k>=0){
            KeptPos[k] = k+1; //record the position of rerolled skull in case of a sorceress card
            KeptDices++;}
        KeptPos=SkullsKeep(Dices,KeptPos);
        if(card.equals("SeaBatt2") || card.equals("SeaBatt3") || card.equals("SeaBatt4")){
            KeptPos=SeaBattleKeep(Dices,KeptPos,KeptDices);
            Dices2=myDice.rollrest(Dices,KeptPos);
        } else if (card.equals("MonkeyB")){
            KeptPos=MonkeyKeep(Dices,KeptPos,KeptDices);
            Dices2=myDice.rollrest(Dices,KeptPos);
        }else {
            for (int i = 0; i < Dices.length; i++)
                if (NumOfFaces.get(Dices[i]) >= 3 && KeptDices < 6) { //keep combo of 3's or more if there exists any
                    KeptPos[i] = i+1;
                    KeptDices++;
                }
            if (KeptDices<6)
                KeptPos=DiamondGoldKeep(Dices,KeptPos,KeptDices);
            Dices2=myDice.rollrest(Dices,KeptPos);
        }
        LOGGER.info("Dices that will be kept(will not be rerolled):");
        if(k>=0)
            KeptPos[k] = 0;
        LOGGER.debug(Arrays.toString(KeptPos));
        LOGGER.debug(Arrays.toString(Dices2));
        return Dices2;
    }

    public Faces[] Select(String strategy, Faces[] Dices,String card,int count){
        Faces[] Dices2=new Faces[8];
        //select suitable subroutine
        if (card.equals("sorceress"))
            Dices2=Sorceress(Dices,strategy,count);
        else if (strategy.equals("random")){
            LOGGER.info("random strategy :");
            Dices2=RandomKeep(Dices,-1); //pass -1 if the sorceress card is not drawn
        }else if (strategy.equals("combo")){
            LOGGER.info("combo strategy :");
            Dices2 = ComboKeep(Dices, card,-1);
        }
        return Dices2;
    }
}
