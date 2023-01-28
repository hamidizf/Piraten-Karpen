package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Random;

public class Game {
    Dice myDice = new Dice();
    PlayerScore player = new PlayerScore();
    Random Boolean = new Random();
    static Logger LOGGER= LogManager.getLogger(PlayerScore.class);
    Cards cards=new Cards();


    public boolean EndTurn(Faces[] Dices,int count) {
        int NumOfSkulls = 0;
        for (Faces dice : Dices) {
            if (dice == Faces.SKULL) {
                NumOfSkulls++;
            }
        }
        if (NumOfSkulls >= 3+count) return true;
        return false;
    }
    public int CurrentTurn(String strategy){
        int score;
        int count=0;
        Strategy PlayerStrategy = new Strategy();
        String card=cards.draw();
        LOGGER.debug("Card:"+card);
        if(card=="sorceress")
            count=1;
        Faces [] Dices=myDice.roll8();
        LOGGER.debug(Arrays.toString(Dices));
        System.out.println("count before wile loop: " +count);
        while (!EndTurn(Dices,count)){
            System.out.println("count after wile loop: " +count);
            if (strategy=="random"&&Boolean.nextBoolean()==true){
                if (player.CardScore(card, myDice.NumOfFaces(Dices))<0){
                    score= player.CardScore(card, myDice.NumOfFaces(Dices));
                }else{
                    score = player.Score(Dices,card)+ player.CardScore(card, myDice.NumOfFaces(Dices));
                }
                LOGGER.info("end of the turn");
                LOGGER.debug("Score for this turn: "+score);
                return score;
            } else if (Boolean.nextBoolean()==true&& player.CardScore(card, myDice.NumOfFaces(Dices))>=0){
                LOGGER.info("end of the turn");
                score = player.Score(Dices,card)+ player.CardScore(card, myDice.NumOfFaces(Dices));
                LOGGER.debug("Score for this turn: "+score);
                return score;
            }else {
                Dices = PlayerStrategy.Select(strategy, Dices, card,count);
                count= PlayerStrategy.mycount;
                System.out.println("count after mycount: " +count);
            }
        }
        LOGGER.info("end of turn! You got 3 SKULLs :( ");
        if (player.CardScore(card, myDice.NumOfFaces(Dices))<=0) {
            LOGGER.info("Score for this turn: " + player.CardScore(card, myDice.NumOfFaces(Dices)));
            return player.CardScore(card, myDice.NumOfFaces(Dices));
        }else{
            LOGGER.info("Score for this turn: " + (-player.CardScore(card, myDice.NumOfFaces(Dices))));
            return -player.CardScore(card, myDice.NumOfFaces(Dices));
        }
    }
    public String play(boolean player1, String[]  Strategies) {
        int score1 = 0, score2 = 0;
        String winner = " ";
        while ((score1 < 6000 && score2 < 6000) || (score1 == score2 && score1 >= 6000)) {
            if (player1) {
                LOGGER.info("Player 1 is playing...");
                score1 += CurrentTurn(Strategies[0]);
                player1 = false;
                LOGGER.info("Total Score: "+score1);
            } else {
                LOGGER.info("Player 2 is playing...");
                score2 += CurrentTurn(Strategies[1]);
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
