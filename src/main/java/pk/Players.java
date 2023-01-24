package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Players {
    Scanner input=new Scanner(System.in);
    Dice myDice = new Dice();
    Random Boolean = new Random();
    static Logger LOGGER= LogManager.getLogger(Players.class);

    public int CurrentTurn(String strategy){
        int score;
        Strategy PlayerStrategy = new Strategy();
        Faces [] Dices=myDice.roll8();
        LOGGER.debug(Arrays.toString(Dices));
        while (!myDice.EndTurn(Dices)){
            if (Boolean.nextBoolean()==true){
                LOGGER.info("end of the turn");
                score=myDice.Score(myDice.NumOfFaces(Dices));
                return score;
            }else {
                Dices=PlayerStrategy.Select(strategy,Dices);
            }
        }
        LOGGER.info("end of turn!");
        LOGGER.info("Score for this turn: 0");
        return 0;
    }

    public String play(boolean player1, String strategy1, String strategy2) {
        int score1 = 0, score2 = 0;
        String winner = " ";
        while ((score1 < 6000 && score2 < 6000) || (score1 == score2 && score1 >= 6000)) {
            if (player1) {
                LOGGER.info("Player 1 is playing...");
                score1 += CurrentTurn(strategy1);
                player1 = false;
                LOGGER.info("Total Score: "+score1);
            } else {
                LOGGER.info("Player 2 is playing...");
                score2 += CurrentTurn(strategy2);
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