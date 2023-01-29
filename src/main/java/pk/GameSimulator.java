package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
public class GameSimulator {
    Game game=new Game();
    Random Boolean = new Random();
    static Logger LOGGER= LogManager.getLogger(GameSimulator.class);
    public void simulate(String [] Strategies){

        String winner="";
        int player1=0;
        int player2=0;
        double percentage1, percentage2;

        for(int i=0; i<42;i++){ //play 42 games
            LOGGER.info("New Game Started. Round "+(i+1)+"!");
            if (i==0){
                winner=game.play(Boolean.nextBoolean(), Strategies);
            }else{
                if (winner.equals("Player1")){

                    winner= game.play(true,Strategies); //start next round with the winner
                }else{
                    winner= game.play(false,Strategies);
                }
            }
            if (winner.equals("Player1")){   //get number of rounds they win
                player1++;
            }else {
                player2++;
            }
        }
        percentage1=(player1/42.0)*100; //calculate percentage of win
        percentage2=(player2/42.0)*100;
        System.out.printf("The percentage of win for player1 is %.2f%% and the percentage of win for player2 is %.2f%%.\n",percentage1,percentage2 );
    }
}
