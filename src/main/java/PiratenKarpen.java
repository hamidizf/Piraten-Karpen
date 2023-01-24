import pk.Dice;
import pk.Game;
import pk.Faces;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;

public class PiratenKarpen {
static Logger LOGGER=LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {


        System.out.println("Welcome to Piraten Karpen Simulator!");
        LOGGER.info("I'm rolling a dice");
        //System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        LOGGER.debug(myDice.roll());
        Faces[] test=myDice.roll8();
        System.out.println(Arrays.toString(test));
        System.out.println("That's all folks!");
        Game game= new Game();
        game.start();

    }
}
