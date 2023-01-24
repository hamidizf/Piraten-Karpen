import pk.Dice;
import pk.Game;
import pk.Faces;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.Scanner;
import java.util.Arrays;

public class PiratenKarpen {
static Logger LOGGER=LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.println("Welcome to Piraten Karpen Simulator!");
        LOGGER.info("I'm rolling a dice");
        //System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        LOGGER.debug(myDice.roll());
        Faces[] test=myDice.roll8();
        System.out.println(Arrays.toString(test));
        System.out.println("That's all folks!");
        Game game= new Game();
        //System.out.println(args[0]);
        //System.out.println(args[1]);
        String hel="random";
        String hi="combo";

        try{
           /* while(((args[0]!="random" && args[0]!="combo")||(args[1]!="random" && args[1]!="combo"))){
                System.out.println("Entered Strategies are not valid");
                System.out.println("Please Enter the Strategy for Player1:");
                args[0]=input.next();
                System.out.println("Please Enter the Strategy for Player2:");
                args[1]=input.next();
            }*/
            game.start(hel,hi);
        }catch(Exception e){
            LOGGER.info("Strategy for both players is random");
            game.start("random","random");
        }
    }
}
