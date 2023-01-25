package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.List;

public class Players {
    Scanner input=new Scanner(System.in);
    Dice myDice = new Dice();
    Random Boolean = new Random();
    static Logger LOGGER= LogManager.getLogger(Players.class);
    Cards cards=new Cards();

    public int CurrentTurn(String strategy, List<Integer> CardDeck){
        int score;
        Strategy PlayerStrategy = new Strategy();
        String card=cards.draw(CardDeck);
        LOGGER.debug("Card:"+card);
        Faces [] Dices=myDice.roll8();
        LOGGER.debug(Arrays.toString(Dices));
        while (!myDice.EndTurn(Dices)){
            if (Boolean.nextBoolean()==true&& cards.ScoreAffect(card, myDice.NumOfFaces(Dices))>=0){
                LOGGER.info("end of the turn");
                score = myDice.Score(myDice.NumOfFaces(Dices)) + cards.ScoreAffect(card, myDice.NumOfFaces(Dices));
                LOGGER.debug("Score for this turn: "+score);
                return score;
            }else {
                if (card=="nop"){
                    Dices=PlayerStrategy.Select(strategy,Dices,card);
                }else{
                    Dices=PlayerStrategy.Select("card",Dices,card);
                }
            }
        }
        score= cards.ScoreAffect(card,myDice.NumOfFaces(Dices));
        LOGGER.info("end of turn!");
        LOGGER.info("Score for this turn: "+score);
        return score;
    }

    public String play(boolean player1, String[]  Strategies, List<Integer> CardDeck) {
        int score1 = 0, score2 = 0;
        String winner = " ";
        while ((score1 < 6000 && score2 < 6000) || (score1 == score2 && score1 >= 6000)) {
            if (player1) {
                LOGGER.info("Player 1 is playing...");
                score1 += CurrentTurn(Strategies[0],CardDeck);
                player1 = false;
                LOGGER.info("Total Score: "+score1);
            } else {
                LOGGER.info("Player 2 is playing...");
                score2 += CurrentTurn(Strategies[1],CardDeck);
                player1 = true;
                LOGGER.info("TotalScore: "+score2);
            }
        }
        LOGGER.info("Player1 score: "+score1+"\nPlayer2 score: "+score2);
        if (score1 >= 6000 && score1 > score2) {
            winner = "Player1";
            LOGGER.info("Player1 won!");
        } else if (score2 >= 6000 && score2 > score1) {
            winner = "Player2";
            LOGGER.info("Player2 won!");
        }
        return winner;
    }
}