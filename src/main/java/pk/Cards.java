package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Collections;
public class Cards {
    static Logger LOGGER= LogManager.getLogger(Cards.class);
    public List<Integer>cardDeck(){
        List<Integer> MyCardDeck=new ArrayList<>();
        for (int i=0;i<35;i++)
            MyCardDeck.add(i);
        return MyCardDeck;
    }
    List<Integer>MyCardDeck=cardDeck();
    public String draw(){
        Collections.shuffle(MyCardDeck);
        LOGGER.debug("Card number: "+MyCardDeck.get(0));
        if(MyCardDeck.get(0)<2)
            return "SeaBatt2";
        else if(MyCardDeck.get(0)<4)
            return "SeaBatt3";
        else if(MyCardDeck.get(0)<6)
            return "SeaBatt4";
        else if(MyCardDeck.get(0)<10)
            return "MonkeyB";
        else
            return "nop";
    }
    /*public int FinalScore(String mycard, Map<Faces,Integer> NumOfFaces){
        int score;
        if (mycard!="MonkeyB"){
            score= myDice.Score(D)+ScoreAffect(mycard,NumOfFaces);
        }else{
            List<Integer> FaceCount=new ArrayList<>();
            int Bonus=1;
            for (Faces face : NumOfFaces.keySet()){
                if(face!=Faces.MONKEY && face!=Faces.PARROT){
                    FaceCount.add(NumOfFaces.get(face));
                }
                if(face==Faces.SKULL && NumOfFaces.get(face)>0){
                    Bonus=0;
                }else if(face!=Faces.DIAMOND && face!=Faces.GOLD && NumOfFaces.get(face)<3){
                    Bonus=0;
                }
            }
            FaceCount.add((NumOfFaces.get(Faces.MONKEY)+NumOfFaces.get(Faces.PARROT)));
            score= myDice.Score(FaceCount,NumOfFaces)+Bonus*500;
        }
        return score;
    }*/
    public int ScoreAffect(String mycard, Map<Faces,Integer> NumOfFaces){
        int affect=0;
        if (mycard=="SeaBatt2"){
            if (NumOfFaces.get(Faces.SABER)>=2){
                affect+=300;
            }else{
                affect-=300;
            }

        }else if(mycard=="SeaBatt3"){
            if (NumOfFaces.get(Faces.SABER)>=3){
                affect+=500;
            }else{
                affect-=500;
            }
        }else if(mycard=="SeaBatt4"){
            if (NumOfFaces.get(Faces.SABER)>=4){
                affect+=1000;
            }else{
                affect-=1000;
            }
        }

        return affect;
    }
}
