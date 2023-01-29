package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Cards {
    static Logger LOGGER= LogManager.getLogger(Cards.class);
    public List<Integer>cardDeck(){ //create card deck with 35 cards
        List<Integer> MyCardDeck=new ArrayList<>();
        for (int i=0;i<35;i++)
            MyCardDeck.add(i);
        return MyCardDeck;
    }
    List<Integer>MyCardDeck=cardDeck();
    public String draw(){ //associate numbers with card names when they are drawn
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
        else if(MyCardDeck.get(0)<14)
            return "sorceress";
        else
            return "nop";
    }

}
