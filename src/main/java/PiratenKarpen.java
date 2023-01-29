import pk.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.Scanner;
public class PiratenKarpen {
static Logger LOGGER=LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to Piraten Karpen Simulator!");
        GameSimulator Game= new GameSimulator();
        try{//checking inputs and passing them to the game simulator
            while((!args[0].equals("random") && !args[0].equals("combo"))||(!args[1].equals("random") && !args[1].equals("combo"))){
                System.out.println("Entered Strategies are not valid");
                System.out.println("Please Enter the Strategy for Player1:");
                args[0]=input.next();
                System.out.println("Please Enter the Strategy for Player2:");
                args[1]=input.next();
            }
            Game.simulate(args);
        }catch(Exception e){ //random strategy for both players when there is no inputs
            LOGGER.info("Strategy for both players is random");
            Game.simulate(new String[]{"random", "random"});
        }
    }
}
