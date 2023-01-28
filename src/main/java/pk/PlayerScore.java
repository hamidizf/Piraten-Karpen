package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class PlayerScore {
    static Logger LOGGER= LogManager.getLogger(PlayerScore.class);
    Dice dice=new Dice();
    public int Score(Faces[] Dices, String card) {
        int score = 0;
        int Bonus = 1;
        if (card == "MonkeyB") {
            for (int i = 0; i < Dices.length; i++)
                if (Dices[i] == Faces.MONKEY)
                    Dices[i] = Faces.PARROT;
        }
        Map<Faces, Integer> NumofFaces = dice.NumOfFaces(Dices);
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
            } else if (face != Faces.DIAMOND && face != Faces.GOLD && NumofFaces.get(face) < 3 && NumofFaces.get(face) > 0) {
                Bonus = 0;
            }
        }
        if (Bonus==1){
            LOGGER.info("You achieved 500 bonus points!");
        }
        score += (NumofFaces.get(Faces.DIAMOND) + NumofFaces.get(Faces.GOLD)) * 100 + Bonus * 500;
        return score;
    }
    public int CardScore(String mycard, Map<Faces,Integer> NumOfFaces){
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