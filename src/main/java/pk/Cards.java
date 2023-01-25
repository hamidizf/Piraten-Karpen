package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Collections;
public class Cards {
    static Logger LOGGER= LogManager.getLogger(Cards.class);

    public String draw(List<Integer> CardDeck){
        Collections.shuffle(CardDeck);
        String mycard;
        LOGGER.debug("Card number: "+CardDeck.get(0));
        switch (CardDeck.get(0)) {
            case 1:
            case 2:mycard="SeaBattle 2Swords";break;
            case 3:
            case 4:mycard="SeaBattle 3Swords";break;
            case 5:
            case 6:mycard="SeaBattle 4Swords";break;
            default:mycard="nop";break;
        }
        return mycard;
    }
    public int ScoreAffect(String mycard, HashMap<Faces,Integer> NumOfFaces){
        int affect=0;
        if (mycard=="SeaBattle 2Swords"){
            if (NumOfFaces.get(Faces.SABER)>=2){
                affect+=300;
            }else{
                affect-=300;
            }

        }else if(mycard=="SeaBattle 3Swords"){
            if (NumOfFaces.get(Faces.SABER)>=3){
                affect+=500;
            }else{
                affect-=500;
            }
        }else if(mycard=="SeaBattle 4Swords"){
            if (NumOfFaces.get(Faces.SABER)>=4){
                affect+=1000;
            }else{
                affect-=1000;
            }
        }
        return affect;
    }
}
