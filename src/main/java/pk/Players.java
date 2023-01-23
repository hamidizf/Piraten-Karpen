package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.Random;

public class Players {
    Scanner input=new Scanner(System.in);
    Dice myDice = new Dice();
    Random Boolean = new Random();
    static Logger LOGGER= LogManager.getLogger(Players.class);

    public int CurrentTurn(){
        int score;
        String [] Dices=myDice.roll8();
        myDice.print(Dices);
        while (!myDice.EndTurn(Dices)){
            //System.out.println("If you want to end the turn enter Y/y, otherwise Enter N/n");
            //String answer = input.next();
            //if (answer.equals("Y")||answer.equals("y"))
            //else if (answer.equals("N")||answer.equals("n"))
            if (Boolean.nextBoolean()==true){
                LOGGER.info("end of the turn");
                score=myDice.Score(Dices);
                return score;
            }else {
                Dices=myDice.KeepnReroll(Dices);
            }
        }
        return 0;
    }

    public String play(boolean player1) {
        int score1 = 0, score2 = 0;
        String winner = " ";
        while ((score1 < 6000 && score2 < 6000) || (score1 == score2 && score1 >= 6000)) {
            if (player1) {
                LOGGER.info("Player 1 is playing...");
                score1 += CurrentTurn();
                player1 = false;
                LOGGER.info("Score: "+score1);
            } else {
                LOGGER.info("Player 2 is playing...");
                score2 += CurrentTurn();
                player1 = true;
                LOGGER.info("Score: "+score2);
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
