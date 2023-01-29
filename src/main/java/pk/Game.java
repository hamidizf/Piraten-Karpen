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


    public boolean EndTurn(Faces[] Dices,int count) { //check if player is dead receiving 3 skulls(or 4 in case of sorceress when no skull is rerolled)
        int NumOfSkulls = 0;
        for (Faces dice : Dices) {
            if (dice == Faces.SKULL) {
                NumOfSkulls++;
            }
        }
        return NumOfSkulls >= (3 + count);
    }
    public int CurrentTurn(String strategy){ //play each turn until the player decides to stop or is dead
        int score;
        int count=0;
        Strategy PlayerStrategy = new Strategy();
        String card=cards.draw();
        LOGGER.debug("Card:"+card);
        if(card.equals("sorceress")) //change count to let the player reroll one of the skulls
            count=1;
        Faces [] Dices=myDice.roll8();
        LOGGER.debug(Arrays.toString(Dices));
        while (!EndTurn(Dices,count)){
            if (strategy.equals("random") && Boolean.nextBoolean()){ //choose randomly if the player ends the turn
                if (player.CardScore(card, myDice.NumOfFaces(Dices))<0){
                    score= player.CardScore(card, myDice.NumOfFaces(Dices)); //calculate score for the turn
                }else{
                    score = player.Score(Dices,card)+ player.CardScore(card, myDice.NumOfFaces(Dices));
                }
                LOGGER.info("end of the turn");
                LOGGER.debug("Score for this turn: "+score);
                return score;
            } else if (Boolean.nextBoolean() && player.CardScore(card, myDice.NumOfFaces(Dices))>=0){
                LOGGER.info("end of the turn");
                score = player.Score(Dices,card)+ player.CardScore(card, myDice.NumOfFaces(Dices));
                LOGGER.debug("Score for this turn: "+score);
                return score;
            }else {
                Dices = PlayerStrategy.Select(strategy, Dices, card,count); //reroll dices when the turn has not ended
                count= PlayerStrategy.mycount;
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
    public String play(boolean player1, String[]  Strategies) { //play the game for 1 round
        int score1 = 0, score2 = 0;
        String winner = " ";
        while (((score1 < 6000) && (score2 < 6000)) || (score1 == score2)) { //play the game until a player gains score above 6000 while higher than the other player
            if (player1) {
                LOGGER.info("Player 1 is playing...");
                score1 += CurrentTurn(Strategies[0]);
                player1 = false; //change the boolean value of player1 to change turns
                LOGGER.info("Total Score: "+score1);
            } else {
                LOGGER.info("Player 2 is playing...");
                score2 += CurrentTurn(Strategies[1]);
                player1 = true;
                LOGGER.info("TotalScore: "+score2);
            }
        }
        LOGGER.info("Player1 score: "+score1+"\nPlayer2 score: "+score2);
        if (score1 > score2) {
            winner = "Player1";
            LOGGER.info("Player1 won!");
        } else if (score2 > score1) {
            winner = "Player2";
            LOGGER.info("Player2 won!");
        }
        return winner;
    }

}
